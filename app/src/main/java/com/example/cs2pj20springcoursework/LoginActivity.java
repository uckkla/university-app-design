package com.example.cs2pj20springcoursework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText emailTextView, passwordTextView;
    private Button loginButton;
    private TextView registerText;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Create FireBase auth instance
        mAuth = FirebaseAuth.getInstance();

        // Initialise TextViews, used for registerUser
        emailTextView = findViewById(R.id.editTextEmailAddress);
        passwordTextView = findViewById(R.id.editTextPassword);

        loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });


        // Handling user clicking the signup button, takes them to signup page
        registerText = findViewById(R.id.textViewRegister);
        registerText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }

    private void loginUser(){
        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();

        // Check if email box is empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter email.",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }
        // Check if password box is empty
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(),
                            "Please enter password.",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }
        // Handle signup process
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),
                                            "Login successful.",
                                            Toast.LENGTH_LONG)
                                    .show();
                            Intent intent = new Intent(LoginActivity.this, MainAppActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),
                                            "Login failed. Please try again.",
                                            Toast.LENGTH_LONG)
                                    .show();
                            return;
                        }
                    }
                });
    }
}