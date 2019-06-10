package practice.wyadmin.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义场所
 *
 * @author wy
 * @create 2019-06-10 15:52
 */
public class SelfRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(SelfRealm.class);
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
        //数据库中对比

        return null;
    }
}
