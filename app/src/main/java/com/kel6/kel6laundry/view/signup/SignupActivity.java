package com.kel6.kel6laundry.view.signup;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kel6.kel6laundry.R;
import com.kel6.kel6laundry.view.login.LoginActivity;
import com.kel6.kel6laundry.view.main.MainActivity;

public class SignupActivity extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize views
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSignup = findViewById(R.id.buttonSignUp);


        // Set click listener for the login button
        buttonSignup.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            // Perform login validation here
            if (username.equals("test") && password.equals("admin")) {
                // Login successful, navigate to the next screen or perform other actions
                Toast.makeText(SignupActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                //anymore jenis akun

                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(SignupActivity.this, "Login successfull", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        }
}
