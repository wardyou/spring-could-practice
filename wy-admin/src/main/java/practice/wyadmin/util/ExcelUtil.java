package practice.wyadmin.util;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * excel导出
 *
 * @author
 * @create 2019-05-23 17:37
 */
public class ExcelUtil {
    Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    public static void getSignExcel(Map<String, Object> map, String excelName, boolean isWeek, boolean isWednesday) throws FileNotFoundException {
        OutputStream out = new FileOutputStream("C:/Users/CLD/Desktop/poi/" + excelName + ".xlsx");
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLS);
            int count = 1;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (null == entry.getValue()) {
                    continue;
                }
                String className = entry.getKey();
                String[] arry = className.split("_");
                if (!isWeek && arry[1].contains("周末红包")) {
                    continue;
                }
                if (!isWednesday && arry[1].contains("每周统计")) {
                    continue;
                }
                Class self = Class.forName("practice.wyadmin.bean." + arry[0]);
                Sheet sheet1 = new Sheet(count, 0, self);
                sheet1.setSheetName(arry[1]);
                writer.write((List<? extends BaseRowModel>) entry.getValue(), sheet1);
                count++;
            }
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
