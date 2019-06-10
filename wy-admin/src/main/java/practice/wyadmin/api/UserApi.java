package practice.wyadmin.api;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.wyadmin.bean.ChatResp;
import practice.wyadmin.config.PeopleConfig;
import practice.wyadmin.mapper.SignMapper;
import practice.wyadmin.util.HttpUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户api
 *
 * @author
 * @create 2019-05-15 15:26
 */
@Controller
public class UserApi {
    Logger logger = LoggerFactory.getLogger(UserApi.class);
    @Resource
    SignMapper signMapper;
    @Autowired
    PeopleConfig peopleConfig;

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> registerUser(HttpServletRequest request) {
        Map map = new HashMap();
        JSONObject jsonObject = HttpUtils.getJSONObject(request);
        if (jsonObject == null) {
            map.put("msg", "jsonObject=null");
            map.put("errCode", 60000);
            return map;
        }
        map.put("hello", signMapper.getTodaySign(1554739200000L, 1554739200000L, 1554739200000L, 1554652800000L));
//        Map map1 = new HashMap();
//        map1.put("TodaySign_当日签到记录", map.get("hello"));
//        map1.put("AddSignGift_连续签到奖励", signMapper.getAddGift());
        try {
//            ExcelUtil.getSignExcel(map1  ,"2017-05-29" ,false,false );
        } catch (Exception e) {
            logger.error("生成excel异常", e);
        }
        map.put("people", peopleConfig.allPeople());
        return map;
    }

    public Map<String, Object> loginUser(HttpServletRequest request) {
        Map map = new HashMap();
        JSONObject jsonObject = HttpUtils.getJSONObject(request);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        boolean remember = jsonObject.getBoolean("rememberMe");
        //得到设置token
        UsernamePasswordToken token = new UsernamePasswordToken( username, password );
        token.setRememberMe(remember);
        //得到
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        if (jsonObject == null) {
            map.put("msg", "jsonObject=null");
            map.put("errCode", 60000);
            return map;
        }
        String name = jsonObject.getString("name");
        String pass = jsonObject.getString("pass");

        return null;
    }
}
