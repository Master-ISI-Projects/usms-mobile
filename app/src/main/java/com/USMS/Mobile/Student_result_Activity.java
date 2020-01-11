package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.USMS.Mobile.models.NotificationItem;
import com.USMS.Mobile.models.ResultItem;
import com.USMS.Mobile.models.ResultItemAdapter;

import java.util.ArrayList;

public class Student_result_Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ResultItem> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_result_);
        setTitle(R.string.menu_student_result);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.result_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        itemList = new ArrayList<ResultItem>();
        itemList.add(new ResultItem("Module 1", "att 1", "attTwo 1"));
        itemList.add(new ResultItem("Module 2", "att 2", "attTwo 2"));
        itemList.add(new ResultItem("Module 3", "att 3", "attTwo 3"));
        itemList.add(new ResultItem("Module 4", "att 4", "attTwo 4"));


        myAdapter = new ResultItemAdapter(this, itemList);
        recyclerView.setAdapter(myAdapter);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
