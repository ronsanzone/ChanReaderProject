package com.rsanzone.chanreader;

import java.util.ArrayList;
import java.util.Hashtable;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by thunaer on 6/28/13.
 */
public class ThreadDetailAdapter extends BaseAdapter {

    private Context context;
    private Typeface typeface;
    private static Hashtable fontCache = new Hashtable();
    private ArrayList<Row> rows;
    private ArrayList<Post> posts;

    public ThreadDetailAdapter(Context context, int resource, ArrayList<Post> postsList) {
        //super(context, R.layout.list_item);
        this.context = context.getApplicationContext();
        typeface = getTypeface(this.context, "fonts/Roboto-Light.ttf");

        posts = postsList;
        rows = new ArrayList<Row>();


        //add the op post to the adapter
        refreshRows();
    }
    public void refreshRows(){
        if(!posts.isEmpty()){
            rows.add(new OpPostRow(LayoutInflater.from(context), posts.get(0)));
            //add the other posts in the thread.
            for(int count = 1; count < posts.size(); count++) {
                rows.add(new PostRow(LayoutInflater.from(context),posts.get(count)));
            }
        }
    }
    static Typeface getTypeface(Context context, String font) {
        Typeface typeface = (Typeface) fontCache.get(font);
        if(typeface == null) {
            //typeface = Typeface.createFromAsset(context.getAssets(), font);
            typeface = Typeface.DEFAULT;
            fontCache.put(font, typeface);
        }
        return typeface;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return RowType.values().length;
    }
    @Override
    public int getItemViewType(int position) {
        refreshRows();
        return rows.get(position).getViewType();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        refreshRows();
        return rows.get(position).getView(convertView);
    }

}
