package practice.wyadmin.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

/**
 * @author
 * @create 2019-05-31 16:26
 */
@Component
public class SendMsg {
    @Autowired
    MyHandler myHandler;
    @Scheduled(fixedRate = 5000)
    public void sendMsg(){
        System.out.println("定时发送----开始");
        boolean b = myHandler.sendMessageToAllUsers(new TextMessage("系统群发"));
        System.out.println("推送结果："+b);
        System.out.println("定时发送----结束");
    }
}
