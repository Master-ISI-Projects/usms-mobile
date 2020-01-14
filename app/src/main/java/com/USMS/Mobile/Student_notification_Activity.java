package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.USMS.Mobile.Helpers.Constant;
import com.USMS.Mobile.models.NotificationItem;
import com.USMS.Mobile.models.NotificationItemAdapter;
import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.Map;

public class Student_notification_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NotificationItem> itemList;
    public static final String MY_PREFS = "com.USMS.Mobile.token";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_notification_);

        setTitle(R.string.menu_student_notif);

        recyclerView = findViewById(R.id.notification_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        SharedPreferences prefs = getSharedPreferences(MY_PREFS,MODE_PRIVATE);
        final String SharedToken = prefs.getString("token", null);
        Log.d("SharedToken",SharedToken);

        final Gson gson = new Gson();
        String url = Constant.API_URL + "/notifications";

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String r = response.toString();
                        Type listOfMyClassObject = new TypeToken<ArrayList<NotificationItem>>() {}.getType();
                        ArrayList<NotificationItem> notiItems = gson.fromJson(response, listOfMyClassObject);
                        itemList = new ArrayList<NotificationItem>();
                        for(NotificationItem notificationItem: notiItems) {
                            itemList.add(notificationItem);
                        }
                        myAdapter = new NotificationItemAdapter(Student_notification_Activity.this, itemList);
                        recyclerView.setAdapter(myAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("response-error", error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<>();
                params.put("Authorization", "bearer " + SharedToken);

                return params;
            }
        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);











        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
