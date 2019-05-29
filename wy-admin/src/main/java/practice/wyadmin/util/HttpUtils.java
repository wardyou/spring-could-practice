package practice.wyadmin.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.IOUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * @create 2019-05-17 11:31
 */
public class HttpUtils {
   static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    public static JSONObject getJSONObject(HttpServletRequest request) {
        String data;
        try {
            byte[] body = IOUtils.toByteArray(request.getInputStream());
            data = new String(body, "UTF-8");
            logger.info("getJSONObject request data is : " + data);
            return JSONObject.parseObject(data);
        }catch (Exception e){
            logger.error("读取body失败,e:",e);
        }

        return null;
    }
}
