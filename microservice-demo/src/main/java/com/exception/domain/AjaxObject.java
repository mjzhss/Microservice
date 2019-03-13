package com.exception.domain;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * @author zhou 2019-02-26 20:51:57
 */
public class AjaxObject extends HashMap<String, Object> {
    private static final long serialVersionUID = 1257863761643598479L;

    public AjaxObject() {
        put("code", 0);
    }

    public static AjaxObject error() {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }

    private static AjaxObject error(int code, String msg) {
        AjaxObject r = new AjaxObject();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static AjaxObject ok() {
        return new AjaxObject();
    }

    public static AjaxObject ok(Map<String, Object> map) {
        AjaxObject r = new AjaxObject();
        r.putAll(map);
        return r;
    }

    @Override
    public AjaxObject put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public AjaxObject data(Object value) {
        super.put("data", value);
        return this;
    }

    public static AjaxObject apiError(String msg) {
        return error(1, msg);
    }
}
