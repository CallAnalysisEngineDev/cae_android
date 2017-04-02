package com.hz.callanalysisengine.bean;

/**
 * Created by kotori on 2017/4/2.
 * 搜索返回bean类
 */
public class SearchItem {

    // 图片封面地址
    private String imgUrl;
    // 歌曲名称
    private String callName;
    // 歌曲作者
    private String singer;
    // 歌曲call表id
    private String callID;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCallName() {
        return callName;
    }

    public void setCallName(String callName) {
        this.callName = callName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCallID() {
        return callID;
    }

    public void setCallID(String callID) {
        this.callID = callID;
    }
}
