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

public class DetailActivity extends AppCompatActivity {

    TextView detDesc, detTitle, detCost, detLocation, detDate, detReview, detCont, detGenre;
    ImageView detImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detTitle = findViewById(R.id.detailTitle);
        detImage = findViewById(R.id.detailImage);

        detLocation = findViewById(R.id.detailLocation);
        detDate = findViewById(R.id.detailDate);

        detDesc = findViewById(R.id.detailDesc);

        detReview = findViewById(R.id.detailReview);
        detCont = findViewById(R.id.detailContact);

        detGenre = findViewById(R.id.detailGenre);
        detCost = findViewById(R.id.detailCost);

        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);

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
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Tours");
                FirebaseStorage storage = FirebaseStorage.getInstance();

                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                reference.child(key).removeValue();
                                Toast.makeText(DetailActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // Handle the failure case here
                                Toast.makeText(DetailActivity.this, "Deletion Failed!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class)
                        .putExtra("Title", detTitle.getText().toString())
                        .putExtra("Description", detDesc.getText().toString())
                        .putExtra("Cost", detCost.getText().toString())
                        .putExtra("Location", detLocation.getText().toString())
                        .putExtra("Date", detDate.getText().toString())
                        .putExtra("Review", detReview.getText().toString())
                        .putExtra("Contact", detCont.getText().toString())
                        .putExtra("Genre", detGenre.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("Key", key);
                startActivity(intent);
            }
        });

    }
}
