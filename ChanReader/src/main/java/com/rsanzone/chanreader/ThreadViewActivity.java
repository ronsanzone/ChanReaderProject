package com.rsanzone.chanreader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by thunaer on 6/28/13.
 */
public class ThreadViewActivity extends Activity {
    private final String TAG = getClass().getSimpleName();

    private Thread thread;
    private ListView listView;
    private ProgressDialog progress;
    public ImageLoader imageHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        Bundle recdData = getIntent().getExtras();
        String threadNum = Integer.toString(recdData.getInt("com.rsanzone.data"));
        Thread thread;
        String url = "http://api.4chan.org/x/res/"+threadNum+".json";
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        ImageLoader mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache());
        this.imageHolder = mImageLoader;
        JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJSONResponse(response);
                populateHead();
                progress.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, error.getMessage());
            }
        });
        progress = ProgressDialog.show(this, "", "Loading thread data...");

        mRequestQueue.add(jr);

    }
    private void parseJSONResponse(JSONObject response) {
        try {


                JSONArray posts = response.getJSONArray("posts");
                JSONObject firstPost = posts.getJSONObject(0);
                int no = firstPost.getInt("no");
                String com = firstPost.getString("com");
                String url = "http://images.4chan.org/x/src/" + Long.toString(firstPost.getLong("tim")) + firstPost.getString("ext");
                thread = new Thread(no, com, url);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void populateHead()
    {
        TextView txtNo = (TextView) findViewById(R.id.txtNo);
        TextView txtCom = (TextView) findViewById(R.id.txtCom);
        NetworkImageView imgView = (NetworkImageView) findViewById(R.id.thread_detail_image);

        txtNo.setText(Integer.toString(thread.getNo()));
        txtCom.setText(Html.fromHtml(thread.getCom()));
        imgView.setImageUrl(thread.getUrl(), imageHolder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}