package com.rsanzone.chanreader;

import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by thunaer on 7/7/13.
 */
public abstract class Row {
    protected final Post post;
    protected final LayoutInflater inflater;

    protected Row(LayoutInflater inflater, Post post) {
        this.inflater = inflater;
        this.post = post;
    }
    public abstract View getView(View convertView);
    public abstract int getViewType();

}
