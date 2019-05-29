package practice.wyadmin.mapper;

import org.apache.ibatis.annotations.Select;
import practice.wyadmin.bean.AddSignGift;
import practice.wyadmin.bean.TodaySign;

import java.util.List;

/**
 * 签到相关mapper
 *
 * @author
 * @create 2019-05-23 15:50
 */
public interface SignMapper {
    //当天签到记录
    public List<TodaySign> getTodaySign(long endTime,long endTime1,long endTime2,long beginTime);
    //一段时间签到记录
    public List<TodaySign> getTodaySigns();
    //连续签到奖励
    public List<AddSignGift> getAddGift();
}
