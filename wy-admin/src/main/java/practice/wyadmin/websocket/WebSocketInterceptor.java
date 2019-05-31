package practice.wyadmin.websocket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @author
 * @create 2019-05-31 13:55
 */
public class WebSocketInterceptor implements HandshakeInterceptor {
    @Override
    //握手之前拦截处理
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        if (serverHttpRequest instanceof ServletServerHttpRequest) {
            String ID = serverHttpRequest.getURI().toString().split("ID=")[1];
            System.out.println("当前session的ID=" + ID);
            //ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
            //HttpSession session = serverHttpRequest.getServletRequest().getSession();
            map.put("WEBSOCKET_USERID", ID);
        }
        return true;
    }

    @Override
    //握手之前的拦截器
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
        System.out.println("进来webSocket的afterHandshake拦截器！");
    }
}
