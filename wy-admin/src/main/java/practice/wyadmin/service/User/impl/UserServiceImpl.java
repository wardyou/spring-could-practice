package practice.wyadmin.service.User.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import practice.wyadmin.bean.User;
import practice.wyadmin.mapper.UserMapper;
import practice.wyadmin.service.User.UserService;

import javax.annotation.Resource;

/**
 * 用户业务类
 *
 * @author
 * @create 2019-06-11 17:41
 */
@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        User user = userMapper.selectByName(name);
        return user;
    }
}
