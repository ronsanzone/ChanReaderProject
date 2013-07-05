package com.rsanzone.chanreader;

import org.json.JSONObject;

import java.util.Calendar;

/**
 * Created by thunaer on 6/28/13.
 */
public class Post {
    protected Board board;
    protected long no;
    protected Calendar time;
    protected String subject;
    protected String name;
    protected String tripcode;
    protected String email;
    protected String capcode;
    protected String countryCode;
    protected String countryName;
    protected String comment;
    protected long imageId;
    protected String imageName;
    protected String imageExtension;

    public Post() {
        this.board = null;
        this.no = 0L;
        this.time = Calendar.getInstance();
        this.subject = "";
        this.name = "";
        this.tripcode = "";
        this.email = "";
        this.capcode = "";
        this.countryCode = "";
        this.countryName = "";
        this.comment = "";
        this.imageId = 0L;
        this.imageName = "";
        this.imageExtension = "";
    }
    public Post(Board board, JSONObject response) {
        this();
        this.board = board;
        populatePost(response);

    }
    private void populatePost(JSONObject response) {

        this.no = response.optLong("no");
        this.time.setTimeInMillis(1000L * response.optLong("time"));
        this.subject = response.optString("sub");
        this.name = response.optString("name");
        this.tripcode = response.optString("trip");
        this.email = response.optString("email");
        this.capcode = response.optString("capcode");
        this.countryCode = response.optString("country");
        this.countryName = response.optString("country_name");
        this.comment = response.optString("com");
        this.imageId = response.optLong("tim");
        this.imageName = response.optString("filename");
        this.imageExtension = response.optString("ext");
    }

    public Board getBoard() {
        return board;
    }

    public long getNo() {
        return no;
    }

    public Calendar getTime() {
        return time;
    }

    public String getSubject() {
        return subject;
    }

    public String getName() {
        return name;
    }

    public String getTripcode() {
        return tripcode;
    }

    public String getEmail() {
        return email;
    }

    public String getCapcode() {
        return capcode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getComment() {
        return comment;
    }

    public long getImageId() {
        return imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageExtension() {
        return imageExtension;
    }
    public String getUrl() {
        return "http://images.4chan.org/x/src/" + getImageId() + getImageExtension();
    }
}
