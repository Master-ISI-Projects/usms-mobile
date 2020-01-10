package com.USMS.Mobile.models;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.USMS.Mobile.R;

import java.util.ArrayList;

public class NotificationItemAdapter extends RecyclerView.Adapter<NotificationItemAdapter.ViewHolder> {

    private ArrayList<NotificationItem> notifications;

    public  NotificationItemAdapter(Context context, ArrayList notificationsItems){
        notifications = notificationsItems;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView notifcation_title, notification_content;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            notifcation_title = itemView.findViewById(R.id.notification_title);
            notification_content = itemView.findViewById(R.id.notification_content);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int a =  notifications.indexOf((NotificationItem) v.getTag());
                    String b = a + "e";
                    Log.i("ok", b);
                    Toast.makeText(itemView.getContext(), notifications.get(a).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public NotificationItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.notification_list_item, viewGroup, false);
        return new NotificationItemAdapter.ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull NotificationItemAdapter.ViewHolder Viewholder, int i) {

        Viewholder.itemView.setTag(notifications.get(i));
        Viewholder.notifcation_title.setText(notifications.get(i).getTitle());
        Viewholder.notification_content.setText(notifications.get(i).getContent());

    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

}
