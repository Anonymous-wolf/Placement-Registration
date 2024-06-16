package com.example.placementreg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextRegisterName, editTextRegisterCollegeId, editTextRegisterEmail, editTextRegisterRegNumber, editTextRegisterPassword;
    Button buttonRegister;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DatabaseHelper(this);
        editTextRegisterName = findViewById(R.id.editTextRegisterName);
        editTextRegisterCollegeId = findViewById(R.id.editTextRegisterCollegeId);
        editTextRegisterEmail = findViewById(R.id.editTextRegisterEmail);
        editTextRegisterRegNumber = findViewById(R.id.editTextRegisterRegNumber);
        editTextRegisterPassword = findViewById(R.id.editTextRegisterPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextRegisterName.getText().toString().trim();
                String collegeId = editTextRegisterCollegeId.getText().toString().trim();
                String email = editTextRegisterEmail.getText().toString().trim();
                String regNumber = editTextRegisterRegNumber.getText().toString().trim();
                String password = editTextRegisterPassword.getText().toString().trim();

                long result = dbHelper.insertUser(name, collegeId, email, regNumber, password);

                if (result != -1) {
                    Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
