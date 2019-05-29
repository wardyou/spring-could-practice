package practice.wyreadzuul.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * http工具类
 *
 * @author
 * @create 2019-05-16 10:05
 */
public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    final static String RESULT = "result";
    final static String MSG = "msg";
    final public static int STATUS_SUCCESS = 0;// 状态码：0代表成功，其它代表失败
  public static String errorBytes(HttpServletResponse response,int erroCode,String msg){

      System.out.println();
      return "";
  }
}
