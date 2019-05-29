package practice.wyadmin.user;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.junit.Test;
import practice.wyadmin.bean.TodaySign;
import practice.wyadmin.util.ExcelUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * usertest
 *
 * @author
 * @create 2019-05-17 11:28
 */
public class UserTest {
    @Test
    public void addInvestors() {
        String url = "http://localhost:9501/admin/investor/v1/batchRegister";
        Map<String, String> data = new HashMap<String, String>();
        data.put("investors", "15388156366,15388156361,15388156362,15388156363,15388156363,15388156364,15388156365,12345678912,56789");
        data.put("extension_id", "1");
        data.put("orgUserId", "1");
        Map<String, String> header = new HashMap<String, String>();
        header.put("content-type", "application/json");
        //生成设备ids
        System.out.println();
    }
    public void signTest() {

    }
    @Test
    public void test1() throws FileNotFoundException {
        List<TodaySign> list = new ArrayList<>();
        TodaySign todaySign = new TodaySign();
        todaySign.setAdd_active_time(12);
        todaySign.setAlias("1232");
        TodaySign todaySign1 = new TodaySign();
        todaySign1.setAdd_active_time(12);
        todaySign1.setAlias("1232");
        list.add(todaySign);
        list.add(todaySign1);
        Map<String,Object> map = new HashMap<>();
        map.put("TodaySign_当日签到记录", list);
        map.put("TodaySign_连续签到签到奖励", list);
        ExcelUtil.getSignExcel(map, "2019-5-27",false,false);
    }
}
