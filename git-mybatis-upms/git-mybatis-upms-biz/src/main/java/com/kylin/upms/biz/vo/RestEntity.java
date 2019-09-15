package com.kylin.upms.biz.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zhebin
 * @Date: 2019/9/15 19:35
 */
@Data
public class RestEntity implements Serializable {
    private Integer code;

    private String msg;

    private Object object;

    private RestEntity() {
    }

    private RestEntity(Integer code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public static RestEntity ok() {
        return new RestEntity(200, "操作成功", null);
    }

    public static RestEntity ok(String msg, Object obj) {
        return new RestEntity(200, msg, obj);
    }

    public static RestEntity ok(Object object) {
        return new RestEntity(200, "操作成功", object);
    }

    public static RestEntity error() {
        return new RestEntity(500, "操作失败", null);

    }

    public static RestEntity error(String msg, Object obj) {
        return new RestEntity(500, msg, obj);
    }

    public static RestEntity error(Object object) {
        return new RestEntity(500, "操作失败", object);
    }
}
