package com.rsanzone.chanreader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by thunaer on 6/30/13.
 */
public class DetailThread extends Thread {
    private ArrayList<Post> posts;

    public DetailThread(Board board, JSONObject response) {
        super(board, response);
        populatePosts(response);
    }

    private void populatePosts(JSONObject response) {
        try {
            JSONArray postArray = response.getJSONArray("posts");
            for(int count = 1; count < postArray.length(); count++){
                posts.add(new Post(board, postArray.getJSONObject(count)));
            }
        } catch (JSONException e) { e.printStackTrace(); }
    }
}
