package com.hz.callanalysisengine.bean;

import java.util.List;

/**
 * Created by kotori on 2017/4/6.
 */
public class MainDataBean {

    /**
     * red : [{"songId":"CR-WMwuy7J","songName":"恋になりたい AQUARIUM","songCover":"/aqours/2.jpg"},{"songId":"CR-7fX2xAJ","songName":"Aqours☆HEROES","songCover":"/aqours/1.jpg"},{"songId":"CR-Yawopdw","songName":"青空Jumping Heart","songCover":"/aqours/6.jpg"},{"songId":"CR-8A8Dvb0","songName":"届かない星だとしても","songCover":"/aqours/2.jpg"},{"songId":"CR-kmTpGyi","songName":"君のこころは輝いてるかい？","songCover":"/aqours/1.jpg"},{"songId":"CR-PAjQQU3","songName":"空も心も晴れるから","songCover":"/aqours/11_1.jpg"},{"songId":"CR-nnYYSOx","songName":"想いよひとつになれ","songCover":"/aqours/12.jpg"},{"songId":"CR-zvj8GGK","songName":"Guilty Kiss, Guilty Night","songCover":"/aqours/5.jpg"}]
     * successed : true
     * newest : [{"songId":"CR-aAny0u9","songName":"Step! ZERO to ONE","songCover":"/aqours/1.jpg"},{"songId":"CR-nnYYSOx","songName":"想いよひとつになれ","songCover":"/aqours/12.jpg"},{"songId":"CR-3Gq322K","songName":"LONELY TUNING","songCover":"/aqours/19_3.jpg"},{"songId":"CR-3z3ErWg","songName":"MIRAI TICKET","songCover":"/aqours/12.jpg"}]
     */

    private boolean successed;
    private List<RedBean> red;
    private List<NewestBean> newest;

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }

    public List<RedBean> getRed() {
        return red;
    }

    public void setRed(List<RedBean> red) {
        this.red = red;
    }

    public List<NewestBean> getNewest() {
        return newest;
    }

    public void setNewest(List<NewestBean> newest) {
        this.newest = newest;
    }

    public static class RedBean {
        /**
         * songId : CR-WMwuy7J
         * songName : 恋になりたい AQUARIUM
         * songCover : /aqours/2.jpg
         */

        private String songId;
        private String songName;
        private String songCover;

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

        public String getSongCover() {
            return songCover;
        }

        public void setSongCover(String songCover) {
            this.songCover = songCover;
        }
    }

    public static class NewestBean {
        /**
         * songId : CR-aAny0u9
         * songName : Step! ZERO to ONE
         * songCover : /aqours/1.jpg
         */

        private String songId;
        private String songName;
        private String songCover;

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

        public String getSongCover() {
            return songCover;
        }

        public void setSongCover(String songCover) {
            this.songCover = songCover;
        }
    }
}
