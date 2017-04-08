package cn.v5cn.v5cms.exception;

/**
 * Created by ZYW on 2014/11/7.
 */
public class V5CMSNullValueException extends RuntimeException {
    public V5CMSNullValueException() {
    }

    public V5CMSNullValueException(String message) {
        super(message);
    }

    public V5CMSNullValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public V5CMSNullValueException(Throwable cause) {
        super(cause);
    }

    public V5CMSNullValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
