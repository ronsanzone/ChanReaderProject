package com.rsanzone.chanreader;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by thunaer on 6/27/13.
 */
public class ThreadAdapter extends BaseAdapter {

    private ArrayList<Thread> threadList;
    private int layout;
    private Context context;
    private MainActivity holder;
    private ImageLoader mImageLoader;

    public ThreadAdapter(Context context, ImageLoader imageLoader, int layout, ArrayList<Thread> threadList){
        this.context = context.getApplicationContext();
        this.threadList = threadList;
        this.layout = layout;
        this.mImageLoader = imageLoader;
    }

    @Override
    public int getCount() {
        return threadList.size();
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
        if (convertView == null) {
            convertView = ((LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(layout, null);
        }

        Thread aThread = threadList.get(position);

        TextView txtNo = (TextView) convertView.findViewById(R.id.txtNo);
        TextView txtCom = (TextView) convertView.findViewById(R.id.txtCom);
        NetworkImageView imgView = (NetworkImageView) convertView.findViewById(R.id.thread_image);
       // TextView txtUrl = (TextView) convertView.findViewById(R.id.txtUrl);

        txtNo.setText(Long.toString(aThread.getOpPost().getNo()));
        txtCom.setText(Html.fromHtml(aThread.getOpPost().getComment()));
        imgView.setImageUrl(aThread.getOpPost().getUrl(), mImageLoader);

        //txtUrl.setText(aThread.getUrl());

        return convertView;
    }



}
