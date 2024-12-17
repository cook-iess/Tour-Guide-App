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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerActivity extends AppCompatActivity {

    private EditText email, password, cpassword;
    ImageView iv;
    private Button regButton;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cPassword);

        iv = findViewById(R.id.logLogo);

        regButton = findViewById(R.id.registerButton);

        auth = FirebaseAuth.getInstance();

        email.setOnClickListener(v -> {
            startTranslateAnimation(iv, 0, 0, 0, -150, 3000);
        });

        password.setOnClickListener(v -> {
            startTranslateAnimation(iv, 0, 0, -150, 0, 3000);
        });

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                String txt_cPassword = cpassword.getText().toString();

                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_cPassword)){
                    Toast.makeText(registerActivity.this,"Empty Credentials!", Toast.LENGTH_SHORT).show();
                } else if (txt_password.length()<6) {
                    Toast.makeText(registerActivity.this,"Password too short!", Toast.LENGTH_SHORT).show();
                } else if (!(txt_password.equals(txt_cPassword))) {
                    Toast.makeText(registerActivity.this,"Passwords don't match!", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txt_email , txt_password);
                }
            }
        });
    }

    private void registerUser(String email, String password) {
        auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(registerActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(registerActivity.this, "User registered successfully! ",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(registerActivity.this, loginActivity.class));
                } else{
                    Toast.makeText(registerActivity.this, "User registration Failed!",Toast.LENGTH_SHORT).show();
                }
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