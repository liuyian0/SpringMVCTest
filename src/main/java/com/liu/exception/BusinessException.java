package com.liu.exception;

//业务异常处理器
public class BusinessException extends RuntimeException{
    private Integer code;  //异常的状态码（响应的状态码）

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }
    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}