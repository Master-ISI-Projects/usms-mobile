package com.USMS.Mobile.models;

import android.content.Context;
import android.content.Intent;
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

public class EventItemAdapter   extends RecyclerView.Adapter<EventItemAdapter.ViewHolder> {

    private ArrayList<EventItem> events;



    public  EventItemAdapter(Context context, ArrayList eventsItems){
        events = eventsItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView events_image;
        TextView events_name, events_date;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            events_image = itemView.findViewById(R.id.event_image);
            events_name = itemView.findViewById(R.id.event_name);
            events_date = itemView.findViewById(R.id.event_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a =  events.indexOf((EventItem) v.getTag());
                    Intent intent = new Intent(itemView.getContext(), com.USMS.Mobile.EventsDetailsActivity.class);
                    intent.putExtra("title", events.get(a).getTitle());
                    intent.putExtra("image", events.get(a).getImage());
                    intent.putExtra("description", events.get(a).getDescription());
                    intent.putExtra("start_at", events.get(a).getStart_at());
                    intent.putExtra("duration", events.get(a).getDuration());
                    intent.putExtra("scholar_year_id", events.get(a).getScholar_year_id());
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public EventItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.events_list_items, viewGroup, false);
        return new EventItemAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EventItemAdapter.ViewHolder Viewholder, int i) {

        Viewholder.itemView.setTag(events.get(i));
        Viewholder.events_name.setText(events.get(i).getTitle());
        Viewholder.events_date.setText(events.get(i).getStart_at());
        Viewholder.events_image.setImageResource(R.drawable.news_item);
        Picasso.get().load(events.get(i).getImage()).into(Viewholder.events_image);

    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
