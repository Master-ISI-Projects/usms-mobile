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



    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
