package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText userID, name_Signin, email_Signin, phonenumber_Signin, password, editTextAddress;
    Button buttonReg;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userID = findViewById(R.id.userID);
        name_Signin = findViewById(R.id.n);
        email_Signin = findViewById(R.id.email_Signin);
        phonenumber_Signin = findViewById(R.id.phonenumber_Signin);
        password = findViewById(R.id.password);
        editTextAddress = findViewById(R.id.editTextAddress);

        buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = userID.getText().toString();
                name_Signin = name_Signin.getText().toString();

                email_Signin = email_Signin.getText().toString();
                phonenumber_Signin = phonenumber_Signin.getText().toString();
                password = password.getText().toString();
                editTextAddress = editTextAddress.getText().toString();
            }
        });
    }
}