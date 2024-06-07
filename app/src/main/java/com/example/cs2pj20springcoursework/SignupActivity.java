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

public class SignupActivity extends AppCompatActivity {
    private EditText emailTextView, passwordTextView, confirmPasswordTextView;
    private Button signupButton;
    private TextView loginText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Create FireBase auth instance
        mAuth = FirebaseAuth.getInstance();

        // Initialise TextViews, used for registerUser
        emailTextView = findViewById(R.id.editTextEmailAddress);
        passwordTextView = findViewById(R.id.editTextPassword);
        confirmPasswordTextView = findViewById(R.id.editTextPasswordConfirm);

        // Handing user signup
        signupButton = findViewById(R.id.button_signup);
        signupButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                registerUser();
            }
        });

        // Handling user clicking the login button, takes them to login page
        loginText = findViewById(R.id.textViewLogin);
        loginText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }

    private void registerUser(){
        String email = emailTextView.getText().toString();
        String password = passwordTextView.getText().toString();
        String confirmPassword = confirmPasswordTextView.getText().toString();

        // Validation for email and pass
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
        // Check if passwords match
        if (!password.equals(confirmPassword)){
            Toast.makeText(getApplicationContext(),
                            "Please make sure passwords match.",
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // Handle signup process
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),
                                            "Account successfully created.",
                                            Toast.LENGTH_LONG)
                                    .show();
                            startActivity(new Intent(SignupActivity.this, MainAppActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),
                                        "Registration failed. Please try again.",
                                        Toast.LENGTH_LONG)
                                    .show();
                            return;
                        }
                    }
                });
    }
}