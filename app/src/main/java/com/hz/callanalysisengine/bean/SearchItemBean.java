package com.hz.callanalysisengine.bean;

import java.util.List;

/**
 * Created by kotori on 2017/4/2.
 * 搜索bean类
 */
public class SearchItemBean {


    /**
     * totalPage : 2
     * successed : true
     * resultList : [{"songId":"0to1","songName":"Step! ZERO to ONE","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/1.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"jiexing","songName":"届かない星だとしても","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/2.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"kimikoko","songName":"君のこころは輝いてるかい？","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/1.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"mengyekong","songName":"夢で夜空を照らしたい","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/9.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"mt","songName":"MIRAI TICKET","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/12.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"op","songName":"青空Jumping Heart","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/6.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"op/cw","songName":"ハミングフレンド","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/6.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"please","songName":"トリコリコPLEASE!!","songSellTime":null,"songOwner":"AZALEA","songCover":"/aqours/4.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"ps","songName":"P.S.の向こう侧","songSellTime":null,"songOwner":"CYaRon!","songCover":"/aqours/19_2.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"sandan","songName":"HAPPY PARTY TRAIN","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/20.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"shengdan","songName":"ジングルベルがとまらない","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/13.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"shengri","songName":"聖なる日の祈り","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/13.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"shuizuguan","songName":"恋になりたい AQUARIUM","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/2.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"st","songName":"Strawberry Trapper","songSellTime":null,"songOwner":"GuiltyKiss","songCover":"/aqours/5.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"weishu","songName":"未熟DREAMER","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/9.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"xiangyi","songName":"想いよひとつになれ","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/12.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"heros","songName":"Aqours☆HEROES","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/1.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"handinhand","songName":"決めたよHand in Hand","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/7.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"gkgn","songName":"Guilty Kiss, Guilty Night","songSellTime":null,"songOwner":"GuiltyKiss","songCover":"/aqours/5.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},{"songId":"bd1","songName":"Pops heartで踊るんだもん！","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/10.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null}]
     * nowPage : 1
     */

    private int totalPage;
    private boolean successed;
    private int nowPage;
    private List<ResultListBean> resultList;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public List<ResultListBean> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultListBean> resultList) {
        this.resultList = resultList;
    }

    public static class ResultListBean {
        /**
         * songId : 0to1
         * songName : Step! ZERO to ONE
         * songSellTime : null
         * songOwner : Aqours
         * songCover : /aqours/1.jpg
         * songCreateTime : null
         * songLastModifyTime : null
         * songClick : null
         */

        private String songId;
        private String songName;
        private Object songSellTime;
        private String songOwner;
        private String songCover;
        private Object songCreateTime;
        private Object songLastModifyTime;
        private Object songClick;

        public String getSongId() {
            return songId;
        }

        public void setSongId(String songId) {
            this.songId = songId;
        }

        public String getSongName() {
            return songName;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        public Object getSongSellTime() {
            return songSellTime;
        }

        public void setSongSellTime(Object songSellTime) {
            this.songSellTime = songSellTime;
        }

        public String getSongOwner() {
            return songOwner;
        }

        public void setSongOwner(String songOwner) {
            this.songOwner = songOwner;
        }

        public String getSongCover() {
            return songCover;
        }

        public void setSongCover(String songCover) {
            this.songCover = songCover;
        }

        public Object getSongCreateTime() {
            return songCreateTime;
        }

        public void setSongCreateTime(Object songCreateTime) {
            this.songCreateTime = songCreateTime;
        }

        public Object getSongLastModifyTime() {
            return songLastModifyTime;
        }

        public void setSongLastModifyTime(Object songLastModifyTime) {
            this.songLastModifyTime = songLastModifyTime;
        }

        public Object getSongClick() {
            return songClick;
        }

        public void setSongClick(Object songClick) {
            this.songClick = songClick;
        }
    }
}
