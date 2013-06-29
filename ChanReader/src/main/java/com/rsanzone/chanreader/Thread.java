package com.rsanzone.chanreader;

/**
 * Created by thunaer on 6/27/13.
 */
public class Thread {
    String com, url;
    int no;

    public Thread(int no, String com, String url) {
        super();
        this.no = no;
        this.com = com;
        this.url = url;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}
