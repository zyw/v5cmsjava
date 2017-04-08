package cn.v5cn.v5cms.exception;

/**
 * Created by ZYW on 2014/11/7.
 */
public class V5CMSSessionValueNullException extends RuntimeException {
    public V5CMSSessionValueNullException(String message) {
        super(message);
    }

    public V5CMSSessionValueNullException() {
    }

    public V5CMSSessionValueNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public V5CMSSessionValueNullException(Throwable cause) {
        super(cause);
    }

    public V5CMSSessionValueNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
