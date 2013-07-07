package com.rsanzone.chanreader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by thunaer on 7/7/13.
 */
public class OpPostRow extends Row {

    public OpPostRow(LayoutInflater inflater, Post post) {
        super(inflater, post);
    }

    @Override
    public View getView(View convertView) {
        ViewHolder holder;
        View view;
        //check for convertview and create new
        if(convertView == null) {
            ViewGroup viewGroup = (ViewGroup)inflater.inflate(R.layout.op_post_row, null);

            holder = new ViewHolder((TextView)viewGroup.findViewById(R.id.noText),
                    (TextView)viewGroup.findViewById(R.id.comText));
            viewGroup.setTag(holder);

            view = viewGroup;

        }
        else {
            holder = (ViewHolder)convertView.getTag();

            view = convertView;
        }

        holder.noView.setText(Long.toString(post.getNo()));
        holder.comView.setText(post.getComment());

        return view;
    }

    @Override
    public int getViewType() {
        return RowType.OP_POST_ROW.ordinal();
    }
    private static class ViewHolder {
        final TextView noView;
        final TextView comView;

        private ViewHolder(TextView noView, TextView comView) {
            this.noView = noView;
            this.comView = comView;
        }
    }
}
