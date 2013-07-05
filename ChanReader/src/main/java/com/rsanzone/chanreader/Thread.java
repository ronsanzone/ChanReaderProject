package com.rsanzone.chanreader;

import org.json.JSONArray;
import org.json.JSONException;
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
        try {
            JSONArray posts = response.getJSONArray("posts");
            JSONObject post = posts.getJSONObject(0);
            this.opPost = new OpPost(board, post);
        } catch(JSONException e) { e.printStackTrace(); }
    }

    public Post getOpPost() {
        return opPost;
    }
}
