package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.USMS.Mobile.models.EventItem;
import com.USMS.Mobile.models.EventItemAdapter;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<EventItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        setTitle(R.string.menu_events);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.events_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        itemList = new ArrayList<EventItem>();
        itemList.add(new EventItem("Yassine", "19/21/1111"));
        itemList.add(new EventItem("Yassine", "19/21/1111"));
        itemList.add(new EventItem("Yassine", "19/21/1111"));
        itemList.add(new EventItem("Yassine", "19/21/1111"));
        itemList.add(new EventItem("Yassine", "19/21/1111"));
        itemList.add(new EventItem("Yassine", "19/21/1111"));
        itemList.add(new EventItem("Yassine", "19/21/1111"));
        itemList.add(new EventItem("Yassine", "19/21/1111"));
        itemList.add(new EventItem("Yassine", "19/21/1111"));
        itemList.add(new EventItem("Yassine", "19/21/1111"));

        myAdapter = new EventItemAdapter(this, itemList);
        recyclerView.setAdapter(myAdapter);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
