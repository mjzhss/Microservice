package com.exception.domain;

import java.io.Serializable;

/**
 * 自定义异常类
 * @author zhou 2019-02-26 20:40:49
 */
public class BusinessException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 6911967223467557739L;
    /**
     * 异常信息
     */
    private String msg;
    /**
     * 异常代码
     */
    private int code;

    /**
     *
     * @param msg
     */
    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BusinessException(String msg, Exception e) {
        super(msg, e);
        this.msg = msg;
    }

    public BusinessException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
