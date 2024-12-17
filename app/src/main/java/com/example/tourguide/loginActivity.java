package com.example.tourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {

    EditText emailD, passwordL;
    ImageView iv;
    Button finloButton;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailD = findViewById(R.id.emailL);
        passwordL = findViewById(R.id.passwordD);

        iv = findViewById(R.id.loginLogo);

        finloButton = findViewById(R.id.logButton);

        auth = FirebaseAuth.getInstance();

        emailD.setOnClickListener(v -> {
            startTranslateAnimation(iv, 0, 0, 0, -150, 3000);
        });

        passwordL.setOnClickListener(v -> {
            startTranslateAnimation(iv, 0, 0, -150, 0, 3000);
        });

        finloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt_email = emailD.getText().toString();
                String txt_password = passwordL.getText().toString();

                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(loginActivity.this,"Empty Credentials!", Toast.LENGTH_SHORT).show();
                } else {
                    if(txt_email.equals("admin@gmail.com") && txt_password.equals("admin321")){
                        startActivity(new Intent(loginActivity.this, MainActivity.class));

                    } else {
                    loginUser(txt_email, txt_password);
                }}
            }
        });

    }

    private void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(loginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginActivity.this, MainActivity2.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(loginActivity.this, "Login failed!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void startTranslateAnimation(View view, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, long duration) {
        TranslateAnimation moveAnimation = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        moveAnimation.setDuration(duration);
        moveAnimation.setFillAfter(false);
        view.startAnimation(moveAnimation);
    }

}