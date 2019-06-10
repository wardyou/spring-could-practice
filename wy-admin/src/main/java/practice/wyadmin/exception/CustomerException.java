package practice.wyadmin.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义异常
 *
 * @author
 * @create 2019-06-05 16:01
 */
@SuppressWarnings("serial")
public class CustomerException extends Exception{
    Logger logger = LoggerFactory.getLogger(CustomerException.class);
    private int errocode;//错误码
    private String data;//错误数据

    public CustomerException(String message) {
        super(message);
    }

    public CustomerException(int errocode, String message, String data) {
        super(message);
        this.errocode = errocode;
        this.data = data;
    }

    public CustomerException(Throwable cause, int errocode, String message) {
        super(cause);
        this.errocode = errocode;

    }

    public CustomerException(int errocode, String message) {
        this.errocode = errocode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
