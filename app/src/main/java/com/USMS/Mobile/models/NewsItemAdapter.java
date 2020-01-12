package com.USMS.Mobile.models;


import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.USMS.Mobile.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsItemAdapter extends RecyclerView.Adapter<NewsItemAdapter.ViewHolder> {

    private ArrayList<NewsItem> news;



        public  NewsItemAdapter(Context context, ArrayList newsItems){
        news = newsItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView news_image;
        TextView news_name, news_date;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            news_image = itemView.findViewById(R.id.news_image);
            news_name = itemView.findViewById(R.id.news_name);
            news_date = itemView.findViewById(R.id.news_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  int a =  news.indexOf((NewsItem) v.getTag());
                  String b = a + "e";
                    Log.i("ok", b);
                    Toast.makeText(itemView.getContext(), news.get(a).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public NewsItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemAdapter.ViewHolder Viewholder, int i) {

        Viewholder.itemView.setTag(news.get(i));
        Viewholder.news_name.setText(news.get(i).getTitle());
        Viewholder.news_date.setText(news.get(i).getPublished_at());
        Picasso.get().load(news.get(i).getImage()).into(Viewholder.news_image);


    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}
