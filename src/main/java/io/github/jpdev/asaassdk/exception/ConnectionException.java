package io.github.jpdev.asaassdk.exception;

public class ConnectionException extends RuntimeException {

    private int code;

    public ConnectionException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
