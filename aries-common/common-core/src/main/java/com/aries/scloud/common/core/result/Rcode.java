package com.aries.scloud.common.core.result;

/**
 * @author aries
 */
public enum Rcode {
    /**
     * 成功
     */
    SUCCESS("200", "成功"),
    /**
     * 操作失败
     */
    FAIL("500", "操作失败"),
    /**
     * 请求被禁止，或无权调用该接口
     */
    UNAUTHORIZED("403", "请求被禁止，或无权调用该接口"),
    /**
     * 未登录
     */
    NOT_LOGIN("401", "未登录");
    /**
     * 代码
     */
    private String code;
    /**
     * 中文描述
     */
    private String description;

    /**
     * 构造方法
     *
     * @param code        编码
     * @param description 中文描述
     */
    Rcode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
