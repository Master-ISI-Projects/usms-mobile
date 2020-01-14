package com.USMS.Mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class EventsDetailsActivity extends AppCompatActivity {
    TextView tvDescription, tvStart_at, tvScholar_year_id, tvDuration;
    ImageView tvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_details);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvImage = findViewById(R.id.event_image);
        tvDescription = findViewById(R.id.event_description);
        tvStart_at = findViewById(R.id.event_start_at);
        tvDuration = findViewById(R.id.event_duration);
        tvScholar_year_id = findViewById(R.id.event_scholar_year_id);

        String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");
        String description = getIntent().getStringExtra("description");
        String start_at = getIntent().getStringExtra("start_at");
        String duration = getIntent().getStringExtra("duration");
        String scholar_year_id = getIntent().getStringExtra("scholar_year_id");

        setTitle(title);

        Picasso.get().load(image).into(tvImage);
        tvDescription.setText("Description : "+description);
        tvStart_at.setText("Commencer à : "+start_at);
        tvDuration.setText("Durée : "+duration);
        tvScholar_year_id.setText("Année scolaire : "+scholar_year_id);



    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
