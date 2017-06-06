package com.hz.callanalysisengine.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kotori on 2017/6/6.
 * 反馈信息bean类
 */
public class FeedBackBean {

    /**
     * type : 邮件类型(目前只能传1)
     * mail.title : 邮件标题
     * mail.content : 邮件内容
     */

    private String type;
    @SerializedName("mail.title")
    private String _$MailTitle64; // FIXME check this code
    @SerializedName("mail.content")
    private String _$MailContent269; // FIXME check this code

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String get_$MailTitle64() {
        return _$MailTitle64;
    }

    public void set_$MailTitle64(String _$MailTitle64) {
        this._$MailTitle64 = _$MailTitle64;
    }

    public String get_$MailContent269() {
        return _$MailContent269;
    }

    public void set_$MailContent269(String _$MailContent269) {
        this._$MailContent269 = _$MailContent269;
    }
}
