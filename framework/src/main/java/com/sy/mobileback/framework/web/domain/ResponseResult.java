package com.sy.mobileback.framework.web.domain;

/**
 * @author shiyu
 * @Description
 * @create 2019-03-24 15:39
 */
public class ResponseResult {
    private int code;
    private String msg;

    public ResponseResult(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
