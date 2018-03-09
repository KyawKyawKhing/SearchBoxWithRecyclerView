package com.kkk.umg.searchboxwithrecyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.kkk.umg.searchboxwithrecyclerview.R;
import com.kkk.umg.searchboxwithrecyclerview.model.BlogData;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.MyViewHolder> {
    private Context context;
    private List<BlogData> list = Collections.emptyList();
    private LayoutInflater inflater;
    private String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    public void SwapList(List<BlogData> dataList) {
        this.list = dataList;
        notifyDataSetChanged();
    }

    public BlogListAdapter(Context context, List<BlogData> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.blog_list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.blog_title.setText(list.get(position).getBlog_title());
        holder.blog_desp.setText(list.get(position).getBlog_desp());
        String name = list.get(position).getBlog_title();
        String firstCharName = name.substring(0, 1);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstCharName, getColor());
        holder.blog_image.setImageDrawable(drawable);
    }

    public int getColor() {
        String color;

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);

        return colorAsInt;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView blog_image;
        TextView blog_title;
        TextView blog_desp;
        ImageButton blog_detail_btn;

        MyViewHolder(View itemView) {
            super(itemView);
            blog_image = (ImageView) itemView.findViewById(R.id.ivBlog);
            blog_title = (TextView) itemView.findViewById(R.id.blog_title);
            blog_desp = (TextView) itemView.findViewById(R.id.blog_desp);
            blog_detail_btn = (ImageButton) itemView.findViewById(R.id.blog_detail);
        }
    }
}
