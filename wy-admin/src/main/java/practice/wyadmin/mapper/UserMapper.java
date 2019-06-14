package practice.wyadmin.mapper;

import org.apache.ibatis.annotations.Select;
import practice.wyadmin.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    @Select("select * from u_user where nickname=#{name}")
    User selectByName(String name);
}