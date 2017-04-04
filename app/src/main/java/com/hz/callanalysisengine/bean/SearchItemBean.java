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
     * resultList : [{"song":{"songId":null,"songName":"Daydream Warrior","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/15.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-tdMGXHo","callSource":null,"callVersion":18},{"song":{"songId":null,"songName":"Waku-Waku-Week!","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/14_1.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-QeWCVsU","callSource":null,"callVersion":15},{"song":{"songId":null,"songName":"Pops heartで踊るんだもん！","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/10.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-Q3N1b4W","callSource":null,"callVersion":18},{"song":{"songId":null,"songName":"MIRAI TICKET","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/12.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-3z3ErWg","callSource":null,"callVersion":20},{"song":{"songId":null,"songName":"未熟DREAMER","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/9.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-H8PyUs6","callSource":null,"callVersion":21},{"song":{"songId":null,"songName":"決めたよHand in Hand","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/7.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-iSIL1oA","callSource":null,"callVersion":20},{"song":{"songId":null,"songName":"青空Jumping Heart","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/6.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-Yawopdw","callSource":null,"callVersion":17},{"song":{"songId":null,"songName":"Strawberry Trapper","songSellTime":null,"songOwner":"GuiltyKiss","songCover":"/aqours/5.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-o2fVgUP","callSource":null,"callVersion":16},{"song":{"songId":null,"songName":"トリコリコPLEASE!!","songSellTime":null,"songOwner":"AZALEA","songCover":"/aqours/4.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-3JpX4Pg","callSource":null,"callVersion":16},{"song":{"songId":null,"songName":"元気全開DAY！DAY！DAY！","songSellTime":null,"songOwner":"CYaRon!","songCover":"/aqours/3.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null},"callId":"CR-Qsg2phn","callSource":null,"callVersion":20}]
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
         * song : {"songId":null,"songName":"Daydream Warrior","songSellTime":null,"songOwner":"Aqours","songCover":"/aqours/15.jpg","songCreateTime":null,"songLastModifyTime":null,"songClick":null}
         * callId : CR-tdMGXHo
         * callSource : null
         * callVersion : 18
         */

        private SongBean song;
        private String callId;
        private Object callSource;
        private int callVersion;

        public SongBean getSong() {
            return song;
        }

        public void setSong(SongBean song) {
            this.song = song;
        }

        public String getCallId() {
            return callId;
        }

        public void setCallId(String callId) {
            this.callId = callId;
        }

        public Object getCallSource() {
            return callSource;
        }

        public void setCallSource(Object callSource) {
            this.callSource = callSource;
        }

        public int getCallVersion() {
            return callVersion;
        }

        public void setCallVersion(int callVersion) {
            this.callVersion = callVersion;
        }

        public static class SongBean {
            /**
             * songId : null
             * songName : Daydream Warrior
             * songSellTime : null
             * songOwner : Aqours
             * songCover : /aqours/15.jpg
             * songCreateTime : null
             * songLastModifyTime : null
             * songClick : null
             */

            private Object songId;
            private String songName;
            private Object songSellTime;
            private String songOwner;
            private String songCover;
            private Object songCreateTime;
            private Object songLastModifyTime;
            private Object songClick;

            public Object getSongId() {
                return songId;
            }

            public void setSongId(Object songId) {
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


}
