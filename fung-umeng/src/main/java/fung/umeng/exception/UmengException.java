package fung.umeng.exception;

public class UmengException extends RuntimeException {

    public UmengException() {

    }

    public UmengException(String msg) {
        super(msg);
    }

    public UmengException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

}
