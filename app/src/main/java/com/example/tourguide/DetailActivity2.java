package com.example.tourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailActivity2 extends AppCompatActivity {

    TextView detDesc, detTitle, detCost, detLocation, detDate, detReview, detCont, detGenre;
    ImageView detImage;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        detTitle = findViewById(R.id.detailTitle);
        detImage = findViewById(R.id.detailImage);

        detLocation = findViewById(R.id.detailLocation);
        detDate = findViewById(R.id.detailDate);

        detDesc = findViewById(R.id.detailDesc);

        detReview = findViewById(R.id.detailReview);
        detCont = findViewById(R.id.detailContact);

        detGenre = findViewById(R.id.detailGenre);
        detCost = findViewById(R.id.detailCost);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detTitle.setText(bundle.getString("Title"));
            detDesc.setText(bundle.getString("Description"));
            detCost.setText(bundle.getString("Cost"));
            detLocation.setText(bundle.getString("Location"));
            detDate.setText(bundle.getString("Date"));
            detReview.setText(bundle.getString("Review"));
            detCont.setText(bundle.getString("Contact"));
            detGenre.setText(bundle.getString("Genre"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detImage);
        }

    }
}
