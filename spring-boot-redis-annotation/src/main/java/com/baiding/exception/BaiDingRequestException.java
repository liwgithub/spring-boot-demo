package com.baiding.exception;

public class BaiDingRequestException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID=8039064911759412512L;

    public BaiDingRequestException(){
        super();
    }

    public BaiDingRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message,cause,enableSuppression,writableStackTrace);
    }

    public BaiDingRequestException(String message, Throwable cause){
        super(message,cause);
    }

    public BaiDingRequestException(String message){
        super(message);
    }

    public BaiDingRequestException(Throwable cause){
        super(cause);
    }
    
}
