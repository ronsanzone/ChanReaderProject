package com.rsanzone.chanreader;

/**
 * Created by thunaer on 6/29/13.
 */
public class Board {

    private String discr;
    private String path;

    public Board() {
        this.discr = new String();
        this.path = new String();
    }
    public Board(String path) {
        this.path = path;
    }
    public Board(String discr, String path) {
        this.discr = discr;
        this.path = path;
    }
    @Override
    public boolean equals(Object object) {
        return (object instanceof Board) ?
                ((Board) object).getPath().equals(this.getPath())
                : false;
    }
    public String getPath() {
        return this.path;
    }
}
