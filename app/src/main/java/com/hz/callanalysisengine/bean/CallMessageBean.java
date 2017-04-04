package com.hz.callanalysisengine.bean;

/**
 * Created by kotori on 2017/4/4.
 */
public class CallMessageBean {


    /**
     * result : {"song":{"songId":"0to1","songName":"Step! ZERO to ONE","songSellTime":"2015-10-07","songOwner":"Aqours","songCover":"/aqours/1.jpg","songCreateTime":null,"songLastModifyTime":"2017-04-03","songClick":null},"callId":"CR-aAny0u9","callSource":"/aqours/Step! ZERO to ONE.html","callVersion":16}
     * successed : true
     */

    private ResultBean result;
    private boolean successed;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }

    public static class ResultBean {
        /**
         * song : {"songId":"0to1","songName":"Step! ZERO to ONE","songSellTime":"2015-10-07","songOwner":"Aqours","songCover":"/aqours/1.jpg","songCreateTime":null,"songLastModifyTime":"2017-04-03","songClick":null}
         * callId : CR-aAny0u9
         * callSource : /aqours/Step! ZERO to ONE.html
         * callVersion : 16
         */

        private SongBean song;
        private String callId;
        private String callSource;
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

        public String getCallSource() {
            return callSource;
        }

        public void setCallSource(String callSource) {
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
             * songId : 0to1
             * songName : Step! ZERO to ONE
             * songSellTime : 2015-10-07
             * songOwner : Aqours
             * songCover : /aqours/1.jpg
             * songCreateTime : null
             * songLastModifyTime : 2017-04-03
             * songClick : null
             */

            private String songId;
            private String songName;
            private String songSellTime;
            private String songOwner;
            private String songCover;
            private Object songCreateTime;
            private String songLastModifyTime;
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

            public String getSongSellTime() {
                return songSellTime;
            }

            public void setSongSellTime(String songSellTime) {
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

            public String getSongLastModifyTime() {
                return songLastModifyTime;
            }

            public void setSongLastModifyTime(String songLastModifyTime) {
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
