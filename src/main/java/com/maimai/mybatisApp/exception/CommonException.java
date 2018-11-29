package com.maimai.mybatisApp.exception;

/**
 * @author baica
 */
public class CommonException extends  Exception {
    private static final long serialVersionUID = 1L;


    private  String errorCode = "";
    private  String errorMessage = "";


    public CommonException(String message) {
        super(message);
    }

    public CommonException() {
    }
    public CommonException(String errorCode,String message) {
        this.errorCode=errorCode;
        this.errorMessage=message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
