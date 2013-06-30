package com.rsanzone.chanreader;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by thunaer on 6/27/13.
 */
public class Thread {
    Board board;
    OpPost opPost;


    public Thread(Board board, JSONObject response) {
        this.board = board;
        populateOpPost(response);
    }

    public void populateOpPost(JSONObject response) {
        this.opPost = new OpPost(board, response);
    }

    public Post getOpPost() {
        return opPost;
    }
}
