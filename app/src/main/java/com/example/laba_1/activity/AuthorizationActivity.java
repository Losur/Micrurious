package com.example.laba_1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laba_1.Interfaces.Authorization.IAuthorizationRepository;
import com.example.laba_1.Model.AuthorizationRepository;
import com.example.laba_1.R;
import com.example.laba_1.dto.User;

public class AuthorizationActivity extends AppCompatActivity {

    private final IAuthorizationRepository authorizationRepository = new AuthorizationRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText emailInput = findViewById(R.id.email);
        EditText passwordInput = findViewById(R.id.password);

        Button signIn = findViewById(R.id.signIn);

        signIn.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            User user = authorizationRepository.authorizeUser(email, password);

            if (user == null){
                Toast.makeText(this, "Cannot login user", Toast.LENGTH_LONG).show();
            }
            else {
                Intent mainActivityIntent = new Intent(this, MainActivity.class);
                startActivity(mainActivityIntent);
                finish();
            }
        });
    }
}