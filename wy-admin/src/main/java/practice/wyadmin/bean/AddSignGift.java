package practice.wyadmin.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * 连续签到奖励
 *
 * @author
 * @create 2019-05-27 16:33
 */
public class AddSignGift extends BaseRowModel {
    @ExcelProperty(value = "会员名",index = 0)
    private String alias;
    @ExcelProperty(value = "真实姓名",index = 0)
    private String true_name;
    @ExcelProperty(value = "奖品名称",index = 0)
    private String prize_name;
    @ExcelProperty(value = "奖励名称",index = 0)
    private String reward_name;
    @ExcelProperty(value = "投资人电话",index = 0)
    private String investor_tel;
    @ExcelProperty(value = "奖品类型",index = 0)
    private String prize_type;
    @ExcelProperty(value = "奖品数量",index = 0)
    private int prize_num;
    @ExcelProperty(value = "中奖时间",index = 0)
    private String prize_time;
    @ExcelProperty(value = "领奖时间",index = 0)
    private String get_time;
    @ExcelProperty(value = "发货时间",index = 0)
    private String send_time;
    @ExcelProperty(value = "领取状态",index = 0)
    private int get_state;
    @ExcelProperty(value = "发货状态",index = 0)
    private int send_state;
    @ExcelProperty(value = "客服",index = 0)
    private String epm_name;

    public int getPrize_num() {
        return prize_num;
    }

    public void setPrize_num(int prize_num) {
        this.prize_num = prize_num;
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

    public String getPrize_name() {
        return prize_name;
    }

    public void setPrize_name(String prize_name) {
        this.prize_name = prize_name;
    }

    public String getReward_name() {
        return reward_name;
    }

    public void setReward_name(String reward_name) {
        this.reward_name = reward_name;
    }

    public String getInvestor_tel() {
        return investor_tel;
    }

    public void setInvestor_tel(String investor_tel) {
        this.investor_tel = investor_tel;
    }

    public String getPrize_type() {
        return prize_type;
    }

    public void setPrize_type(String prize_type) {
        this.prize_type = prize_type;
    }

    public String getPrize_time() {
        return prize_time;
    }

    public void setPrize_time(String prize_time) {
        this.prize_time = prize_time;
    }

    public String getGet_time() {
        return get_time;
    }

    public void setGet_time(String get_time) {
        this.get_time = get_time;
    }

    public String getSend_time() {
        return send_time;
    }

    public void setSend_time(String send_time) {
        this.send_time = send_time;
    }

    public int getGet_state() {
        return get_state;
    }

    public void setGet_state(int get_state) {
        this.get_state = get_state;
    }

    public int getSend_state() {
        return send_state;
    }

    public void setSend_state(int send_state) {
        this.send_state = send_state;
    }

    public String getEpm_name() {
        return epm_name;
    }

    public void setEpm_name(String epm_name) {
        this.epm_name = epm_name;
    }
}
