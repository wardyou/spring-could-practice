package practice.wyreadzuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import practice.wyreadzuul.util.HttpUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.charset.Charset;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

/**
 * post拦截器
 *
 * @author
 * @create 2019-05-15 15:56
 */
@Component
public class PostFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(PostFilter.class);

    //校验
    public String filterType() {
        return POST_TYPE;
    }

    //顺序设置
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER;
    }

    //过滤器是否生效
    public boolean shouldFilter() {
        return true;
    }

    //过滤逻辑
    public Object run() throws ZuulException {
        //获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //获取返回数据
        String responseContent = "";
        //服务器返回是否正确
        if (ctx.getResponseStatusCode() == 200) {
            //如果为get请求拦截
            if ("GET".equals(request.getMethod())) {
                logger.info("ppgame_marker:allowrequest:路由请求之后的数据拦截: 请求接口={},IP={},requestparam={}",
                        request.getRequestURI(), request.getQueryString());
                return null;
            }
            //处理post请求
            try {
                InputStream stream_request = request.getInputStream();
                String request_content = StreamUtils.copyToString(stream_request, Charset.forName("UTF-8"));
                InputStream stream_response = ctx.getResponseDataStream();
                responseContent = stream_response.toString();
//                responseContent = StreamUtils.copyToString(stream_response, Charset.forName("UTF-8"));
                if (request_content != null && responseContent != null) {
                    logger.info("ppgame_marker:allowrequest:路由请求之后的数据拦截: 请求接口={},IP={},requestparam={},responseparam={}",
                            request.getRequestURI());
                    ctx.setResponseBody(responseContent);
                } else {
                    //异常数据 直接返回统一说明
                    //设置返回数据
                    try {
                        String body = HttpUtils.errorBytes(ctx.getResponse(), 8073, "错误");
                        ctx.setResponseBody(body);
                    } catch (Exception e) {

                    }
                }
            } catch (Exception e) {
                logger.error("解析response 返回数据错误", e);

                //设置返回数据
                try {
                    String body = HttpUtils.errorBytes(ctx.getResponse(), 500, "异常");
                    ctx.setResponseBody(body);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }

            return null;

        }
        return null;
    }
}
