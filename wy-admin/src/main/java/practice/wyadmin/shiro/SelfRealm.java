package practice.wyadmin.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import practice.wyadmin.bean.User;
import practice.wyadmin.service.User.UserService;

/**
 * 自定义场所
 *
 * @author wy
 * @create 2019-06-10 15:52
 */
public class SelfRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(SelfRealm.class);
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-----SelfRealm.doGetAuthenticationInfo----");
        //获取用户的输入的账号.
        String userName = (String) authenticationToken.getPrincipal();
        System.out.println("userName="+userName);
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.getUserByName(userName);
        if (null == user){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();

        return authenticationInfo;
    }
}
