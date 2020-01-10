package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Student_table_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_table_);

        setTitle(R.string.menu_student_table);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
