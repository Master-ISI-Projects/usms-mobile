package com.USMS.Mobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.USMS.Mobile.ui.student_side.StudentNotifFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

public class StudentAuthActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    TextView tvStudentName,tvStudentClasseName;
    public static final String MY_PREFS = "com.USMS.Mobile.token";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_auth);

        String fullName = getIntent().getStringExtra("firstName")
                +" "+ getIntent().getStringExtra("lastName");

        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS,MODE_PRIVATE).edit();
        editor.putString("token",getIntent().getStringExtra("token"));
        editor.commit();


        NavigationView navigationViewOnme = (NavigationView) findViewById(R.id.nav_view_student);
        View headerView = navigationViewOnme.getHeaderView(0);
        tvStudentName = (TextView) headerView.findViewById(R.id.Student_Name);
        tvStudentClasseName = (TextView) headerView.findViewById(R.id.Student_classe_name);
        tvStudentName.setText(fullName);
        tvStudentClasseName.setText(getIntent().getStringExtra("classeName"));


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StudentAuthActivity.this,
                        com.USMS.Mobile.Student_notification_Activity.class);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view_student);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                 R.id.nav_student_home, R.id.nav_student_result, R.id.nav_student_table,
                R.id.nav_student_notif, R.id.nav_student_acro, R.id.nav_student_disco)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_for_student);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_for_student);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
