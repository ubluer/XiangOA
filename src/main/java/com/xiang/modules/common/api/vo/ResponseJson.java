package com.xiang.modules.common.api.vo;

/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2017/3/24
 * @description ResponseJson
 */
public class ResponseJson {
    private Object obj;
    private String msg;
    private boolean success;

    public ResponseJson(boolean success, Object obj, String msg) {
        this.obj = obj;
        this.msg = msg;
        this.success = success;
    }

    public ResponseJson(Object obj) {
        this.success = true;
        this.msg = "";
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
