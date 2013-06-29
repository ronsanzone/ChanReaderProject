package com.rsanzone.chanreader;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by thunaer on 6/28/13.
 */
public class ThreadDetailAdapter extends BaseAdapter {
    private ArrayList<Thread> postList;
    private int layout;
    private Context context;
    private ImageLoader mImageLoader;

    public ThreadDetailAdapter(Context context, ImageLoader imageLoader, int layout, ArrayList<Thread> postList) {
        this.context = context.getApplicationContext();
        this.postList = postList;
        this.layout = layout;
        this.mImageLoader = imageLoader;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = ((LayoutInflater) context
                            .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                            .inflate(layout, null);

        }
        //TODO finish implementing the post listview adapter
        return null;
    }


}
