package com.aries.scloud.common.core.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aries
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {
    /**
     * 代码
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 数据实体
     */
    private T data;

    public static R success() {
        return parse(Rcode.SUCCESS, null, null);
    }

    public static <T> R success(T t) {
        return parse(Rcode.SUCCESS, null, t);
    }

    public static R fail(String msg) {
        return parse(Rcode.FAIL, msg, null);
    }

    public static <T> R fail(String msg, T t) {
        return parse(Rcode.FAIL, msg, t);
    }

    public static <T> R fail(T t) {
        return parse(Rcode.FAIL, null, t);
    }

    public static R unauthorized() {
        return parse(Rcode.UNAUTHORIZED, Rcode.UNAUTHORIZED.getDescription(), null);
    }

    public static R noLogin() {
        return parse(Rcode.NOT_LOGIN, Rcode.NOT_LOGIN.getDescription(), null);
    }

    public static <T> R parse(Rcode code, String msg, T t) {
        return new R(code.getCode(), msg, t);
    }

    public static R parse(Rcode code) {
        return parse(code, code.getDescription(), null);
    }

    public boolean ifSuccess() {
        return this.code.equals(Rcode.SUCCESS.getCode());
    }

    public boolean ifFail() {
        return this.code.equals(Rcode.FAIL.getCode());
    }
}
