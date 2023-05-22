package com.kel6.kel6laundry.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kel6.kel6laundry.R;
import com.kel6.kel6laundry.view.main.MainActivity;
import com.kel6.kel6laundry.view.signup.SignupActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;

    private Button buttonSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize views
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        // Set click listener for the login button
        buttonLogin.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            // Perform login validation here
            if (username.equals("test") && password.equals("admin")) {
                // Login successful, navigate to the next screen or perform other actions
                Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                //anymore jenis akun

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(LoginActivity.this, "Login successfull", Toast.LENGTH_SHORT).show();
            }
        });
        //set click listener for the signup button
        buttonSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
            Toast.makeText(LoginActivity.this, "Silahkan daftar", Toast.LENGTH_SHORT).show();
            finish();
            }
        );
    }
}
