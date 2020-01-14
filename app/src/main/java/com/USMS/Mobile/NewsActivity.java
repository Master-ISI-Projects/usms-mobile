package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.USMS.Mobile.Helpers.Constant;
import com.USMS.Mobile.models.NewsItem;
import com.USMS.Mobile.models.NewsItemAdapter;
import com.USMS.Mobile.ui.NewsFragment;
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

public class NewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<NewsItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_news);

        setTitle(R.string.menu_news);

        recyclerView = findViewById(R.id.news_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        final Gson gson = new Gson();
        String url = Constant.API_URL + "/news";


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
                        Type listOfMyClassObject = new TypeToken<ArrayList<NewsItem>>() {}.getType();
                        ArrayList<NewsItem> newsItems = gson.fromJson(response, listOfMyClassObject);
                        Log.d("test", "start -----------------------");
                        itemList = new ArrayList<NewsItem>();
                        for(NewsItem newsItem: newsItems) {
                            NewsItem item = new NewsItem(newsItem.getId(), newsItem.getTitle(), newsItem.getImage(), newsItem.getDescription(), newsItem.getPublished_at(), newsItem.getScholar_year_id(), newsItem.getCreatedAt());
                            itemList.add(item);
                        }
                        myAdapter = new NewsItemAdapter(NewsActivity.this, itemList);
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











        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
