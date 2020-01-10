package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.USMS.Mobile.models.NotificationItem;
import com.USMS.Mobile.models.NotificationItemAdapter;

import java.util.ArrayList;

public class Student_notification_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NotificationItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notification_);

        setTitle(R.string.menu_student_notif);


        recyclerView = findViewById(R.id.notification_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        itemList = new ArrayList<NotificationItem>();
        itemList.add(new NotificationItem("Notif 1", "body 1"));
        itemList.add(new NotificationItem("Notif 2", "body 2"));
        itemList.add(new NotificationItem("Notif 3", "body 3"));
        itemList.add(new NotificationItem("Notif 4", "body 4"));


        myAdapter = new NotificationItemAdapter(this, itemList);
        recyclerView.setAdapter(myAdapter);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
