package com.rsanzone.chanreader;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private final String TAG = getClass().getSimpleName();
    private ArrayList<Thread> threadList;
    private ListView listView;
    private ThreadAdapter ta;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue reqQueue = Volley.newRequestQueue(this);
        ImageLoader mImageLoader = new ImageLoader(reqQueue, new BitmapLruCache());

        threadList = new ArrayList<Thread>();
        listView = (ListView) findViewById(R.id.listView);
        ta = new ThreadAdapter(this, mImageLoader , R.layout.thread_item, threadList);

        listView.setAdapter(ta);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showThread = new Intent(view.getContext(), ThreadViewActivity.class);
                showThread.putExtra("com.rsanzone.data", threadList.get(position).getNo());
                startActivity(showThread);
            }
        });

        String url = "http://api.4chan.org/x/0.json";

        JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        parseJSONResponse(response);
                        ta.notifyDataSetChanged();
                        progress.dismiss();
                    }
                }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.v(TAG, error.getMessage());
                        }
                    });
        progress = ProgressDialog.show(this, "", "Loading 4Chan Data...");

        reqQueue.add(jr);
    }

    private void parseJSONResponse(JSONObject response) {
        try {
            JSONArray threads = response.getJSONArray("threads");
            for(int count = 0; count < threads.length(); count++)
            {
                JSONObject aThread = threads.getJSONObject(count);
                JSONArray posts = aThread.getJSONArray("posts");
                JSONObject firstPost = posts.getJSONObject(0);
                int no = firstPost.getInt("no");
                String com = firstPost.getString("com");
                String url = "http://thumbs.4chan.org/x/thumb/" + Long.toString(firstPost.getLong("tim")) + "s.jpg";
                Thread thread = new Thread(no, com, url);
                threadList.add(thread);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
