package practice.wyadmin.websocket;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author
 * @create 2019-05-30 17:54
 */

@Service
public class MyHandler implements WebSocketHandler {
    Logger logger = LoggerFactory.getLogger(MyHandler.class);
    //在线用户列表
    private static final Map<String, WebSocketSession> users;
    static {
        users = new HashMap<String, WebSocketSession>();
    }
    @Override
    //新增socket链接
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("成功建立连接");
        String ID = session.getUri().toString().split("ID=")[1];
        System.out.println(ID);
        if (ID != null) {
            users.put(ID, session);
            session.sendMessage(new TextMessage("成功建立socket连接"));
            System.out.println(ID);
            System.out.println(session);
        }
        System.out.println("当前在线人数："+users.size());
    }

    @Override
    //接收message信息
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
            try {
                JSONObject jsonobject = JSONObject.parseObject((String) webSocketMessage.getPayload());
                int id= jsonobject.getIntValue("id");
                String msg = jsonobject.getString("message");
                System.out.println(id+":"+msg);
                sendMessageToUser(jsonobject.get("id")+"",new TextMessage(id+":"+msg));
            }catch (Exception e){
            logger.error("接收message异常",e);
            }

    }
    /**
     * 发送信息给指定用户
     * @param clientId
     * @param message
     * @return
     */
    public boolean sendMessageToUser(String clientId, TextMessage message) {
        if (users.get(clientId) == null) return false;
        WebSocketSession session = users.get(clientId);
        System.out.println("sendMessage:" + session);
        if (!session.isOpen()) return false;
        try {
            session.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * 广播信息
     * @param message
     * @return
     */
    public boolean sendMessageToAllUsers(TextMessage message) {
        boolean allSendSuccess = true;
        Set<String> clientIds = users.keySet();
        WebSocketSession session = null;
        for (String clientId : clientIds) {
            try {
                session = users.get(clientId);
                if (session.isOpen()) {
                    session.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                allSendSuccess = false;
            }
        }

        return  allSendSuccess;
    }

    //异常处理
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        users.remove(getClientId(webSocketSession));
            if (webSocketSession.isOpen()){
                webSocketSession.close();
            }
        System.out.println("连接出错");
    }
    /**
     * 获取用户标识
     * @param session
     * @return
     */
    private Integer getClientId(WebSocketSession session) {
        try {
            Integer clientId = (Integer) session.getAttributes().get("WEBSOCKET_USERID");
            return clientId;
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("连接已关闭"+closeStatus);
        users.remove(getClientId(webSocketSession));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
