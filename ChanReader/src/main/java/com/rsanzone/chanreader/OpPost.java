package com.rsanzone.chanreader;

import org.json.JSONObject;

/**
 * Created by thunaer on 6/30/13.
 */
public class OpPost extends Post {
    private int replyCount;
    private int imageCount;
    private int postsOmitted;
    private int imagesOmitted;
    private boolean isSticky;

    public OpPost(Board board, JSONObject response) {
        super(board, response);
        populateOpPost(response);
    }
    private void populateOpPost(JSONObject response) {
        this.replyCount = response.optInt("replies");
        this.imageCount = response.optInt("images");
        this.postsOmitted = response.optInt("omitted_posts");
        this.imagesOmitted = response.optInt("omitted_images");
        this.isSticky = response.optInt("sticky") != 0;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public int getImageCount() {
        return imageCount;
    }

    public int getPostsOmitted() {
        return postsOmitted;
    }

    public int getImagesOmitted() {
        return imagesOmitted;
    }

    public boolean isSticky() {
        return isSticky;
    }
}
