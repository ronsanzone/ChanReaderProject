package com.rsanzone.chanreader;

import android.app.Activity;
import android.app.ListActivity;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thunaer on 6/28/13.
 */
public class ThreadViewActivity extends ListActivity {
    private final String TAG = getClass().getSimpleName();
    private Board board;
    private ArrayList<Post> postList;
    private DetailThread detailThread;
    private ListView listView;
    private ThreadDetailAdapter mDetailAdapter;
    private ProgressDialog progress;
    public ImageLoader imageHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_thread);

        Bundle recdData = getIntent().getExtras();
        String threadNum = Long.toString(recdData.getLong("com.rsanzone.data"));
        String url = "http://api.4chan.org/x/res/"+threadNum+".json";

        postList = new ArrayList<Post>();
        //listView = (ListView) findViewById(R.id.postListView);
        mDetailAdapter = new ThreadDetailAdapter(this, R.layout.list_item, postList);
        //listView.setAdapter(mDetailAdapter);
        setListAdapter(mDetailAdapter);
        RequestQueue mRequestQueue = Volley.newRequestQueue(this);
        ImageLoader mImageLoader = new ImageLoader(mRequestQueue, new BitmapLruCache());
        this.imageHolder = mImageLoader;
        JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                detailThread = new DetailThread(board, response);
                postList.addAll(detailThread.getPosts());
                populateHead();
               // mDetailAdapter.addAll(detailThread.getPosts());
                mDetailAdapter.notifyDataSetChanged();

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

    private void populateHead()
    {
        //TextView txtNo = (TextView) findViewById(R.id.txtNo);
       //TextView txtCom = (TextView) findViewById(R.id.txtCom);
        //NetworkImageView imgView = (NetworkImageView) findViewById(R.id.thread_detail_image);

        //txtNo.setText(Long.toString(detailThread.getOpPost().getNo()));
        //txtCom.setText(Html.fromHtml(detailThread.getOpPost().getComment()));
        //imgView.setImageUrl(detailThread.getOpPost().getUrl(), imageHolder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
