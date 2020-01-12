package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.USMS.Mobile.models.EventItem;
import com.USMS.Mobile.models.EventItemAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
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

        final Gson gson = new Gson();
        String url ="http://192.168.43.239:8000/api/events";

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String r = response.toString();
                        Log.d("-----test------", r);
                        Type listOfMyClassObject = new TypeToken<ArrayList<EventItem>>() {}.getType();
                        ArrayList<EventItem> eventItems = gson.fromJson(response, listOfMyClassObject);
                        Log.d("test", "start -----------------------");
                        itemList = new ArrayList<EventItem>();
                        for(EventItem eventItem: eventItems) {
                            itemList.add(eventItem);
                        }
                        myAdapter = new EventItemAdapter(EventsActivity.this, itemList);
                        recyclerView.setAdapter(myAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ok", error.toString());
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
