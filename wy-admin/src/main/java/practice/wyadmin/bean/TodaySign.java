package practice.wyadmin.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * 当天签到记录
 *
 * @author
 * @create 2019-05-23 15:31
 */
public class TodaySign extends BaseRowModel {
    @ExcelProperty(value = "签到时间",index = 0)
    private String sign_time;
    @ExcelProperty(value = "会员名",index = 0)
    private String alias;
    @ExcelProperty(value = "真实姓名",index = 0)
    private String true_name;
    @ExcelProperty(value = "累计签到次数",index = 0)
    private int add_sign_time;
    @ExcelProperty(value = "历史累计签到次数",index = 0)
    private int add_sign_times;
    @ExcelProperty(value = "活动连续签到次数",index = 0)
    private int add_active_time;
    @ExcelProperty(value = "活动累计签到次数",index = 0)
    private int add_active_times;
    @ExcelProperty(value = "客服",index = 0)
    private String epm_name;

    public String getSign_time() {
        return sign_time;
    }

    public void setSign_time(String sign_time) {
        this.sign_time = sign_time;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTrue_name() {
        return true_name;
    }

    public void setTrue_name(String true_name) {
        this.true_name = true_name;
    }

    public int getAdd_sign_time() {
        return add_sign_time;
    }

    public void setAdd_sign_time(int add_sign_time) {
        this.add_sign_time = add_sign_time;
    }

    public int getAdd_sign_times() {
        return add_sign_times;
    }

    public void setAdd_sign_times(int add_sign_times) {
        this.add_sign_times = add_sign_times;
    }

    public int getAdd_active_time() {
        return add_active_time;
    }

    public void setAdd_active_time(int add_active_time) {
        this.add_active_time = add_active_time;
    }

    public int getAdd_active_times() {
        return add_active_times;
    }

    public void setAdd_active_times(int add_active_times) {
        this.add_active_times = add_active_times;
    }

    public String getEpm_name() {
        return epm_name;
    }

    public void setEpm_name(String epm_name) {
        this.epm_name = epm_name;
    }
}
