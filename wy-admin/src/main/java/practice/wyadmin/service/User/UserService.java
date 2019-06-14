package practice.wyadmin.service.User;

import practice.wyadmin.bean.User;

/**
 * 用户业务层
 *
 * @author
 * @create 2019-06-11 17:38
 */
public interface UserService {
    /**
    * 根据姓名得到
    * @author      wangyu
     * @param name
    * @return
    * @exception
    * @date        2019/6/11 17:40
    */
    User getUserByName(String name);
}
