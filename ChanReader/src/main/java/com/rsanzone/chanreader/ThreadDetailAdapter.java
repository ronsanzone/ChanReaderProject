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
public class ThreadDetailAdapter extends ArrayAdapter<Post> {

    private Context context;
    private ArrayList<Post> posts;
    private Typeface typeface;
    private static Hashtable fontCache = new Hashtable();
    private LayoutInflater inflater;

    public class CustomListItem {
        TextView descText;
    }

    public ThreadDetailAdapter(Context context, int resource, ArrayList<Post> postsList) {
        super(context, R.layout.list_item, postsList);
        this.context = context.getApplicationContext();
        posts = new ArrayList<Post>();
        posts.addAll(postsList);
        //typeface = getTypeface(this.context, "fonts/Roboto-Light.ttf");
        inflater = LayoutInflater.from(this.context);
    }

    static Typeface getTypeface(Context context, String font) {
        Typeface typeface = (Typeface) fontCache.get(font);
        if(typeface == null) {
            typeface = Typeface.createFromAsset(context.getAssets(), font);
            fontCache.put(font, typeface);
        }
        return typeface;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CustomListItem mListItem;

        Post mPost = getItem(position);

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            mListItem = new CustomListItem();

            mListItem.descText = (TextView) convertView.findViewById(R.id.commandText);
            //mListItem.descText.setTypeface(typeface);

            convertView.setTag(mListItem);
        } else {
            mListItem = (CustomListItem) convertView.getTag();
        }

        mListItem.descText.setText(Long.toString(mPost.getNo()));

        return convertView;
    }

}
