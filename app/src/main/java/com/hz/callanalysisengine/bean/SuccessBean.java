package com.hz.callanalysisengine.bean;

/**
 * Created by kotori on 2017/6/6.
 * post请求返回bean类
 */
public class SuccessBean {

    /**
     * successed : true
     */

    private boolean successed;
    private String token;
    private String errInfo;

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getErrInfo() {
        return errInfo;
    }

    public void setErrInfo(String errInfo) {
        this.errInfo = errInfo;
    }
}
