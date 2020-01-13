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
        tvDescription.setText("Description : On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. L'avantage du Lorem Ipsum sur un texte générique comme 'Du texte. Du texte. Du texte.' est qu'il possède une distribution de lettres plus ou moins normale, et en tout cas comparable avec celle du français standard. De nombreuses suites logicielles de mise en page ou éditeurs de sites Web ont fait du Lorem Ipsum leur faux texte par défaut, et une recherche pour 'Lorem Ipsum' vous conduira vers de nombreux sites qui n'en sont encore qu'à leur phase de construction. Plusieurs versions sont apparues avec le temps, parfois par accident, souvent intentionnellement (histoire d'y rajouter de petits clins d'oeil, voire des phrases embarassantes).\n" +
                "\n"+description);
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
