package com.example.midexamproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    EditText edtFullName, edtTextPhone, edtEmailAddress, edtPassword, edtConfirmPassword;

    DBHelper dbHelper;
    Button regBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        edtFullName = findViewById(R.id.edtFullname);
        edtTextPhone = findViewById(R.id.edtPhone_reg);
        edtEmailAddress = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);

        dbHelper = new DBHelper(this);

        regBtn = findViewById(R.id.regButton_reg);
        regBtn.setOnClickListener(e -> {
            if(edtFullName.getText().toString().isEmpty() || edtTextPhone.getText().toString().isEmpty() || edtEmailAddress.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()|| edtConfirmPassword.getText().toString().isEmpty()){
                Toast.makeText(RegisterActivity.this, "Please fill all the blank fields", Toast.LENGTH_SHORT).show();
                return;
            } else{
                if (!edtEmailAddress.getText().toString().endsWith(".com") && !edtEmailAddress.getText().toString().contains("@")){
                    Toast.makeText(getApplicationContext(),
                            "Invalid email address", Toast.LENGTH_SHORT).show();
                    return;
                } else if (isValidPassword(edtPassword.getText().toString()) == null){
                    Toast.makeText(getApplicationContext(),
                            "Password must be alphanumeric\nMin 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                    return;
                } else if (edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())){
                    Boolean checkUserEmail = dbHelper.checkEmail(edtEmailAddress.getText().toString());
                    if(!checkUserEmail){
                        dbHelper.insertUsers(edtFullName.getText().toString(), edtTextPhone.getText().toString(), edtEmailAddress.getText().toString(), edtPassword.getText().toString());
                        Toast.makeText(this, "Account Succesfully Registered", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, LoginActivity.class));
                    } else {
                        Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        backBtn = findViewById(R.id.backButton_reg);
        backBtn.setOnClickListener(e -> {
            finish();
        });


    }

    String isValidPassword(String password) {

        Pattern regex;
        boolean matcher;

        regex = Pattern.compile("^(?=.*[0-9])((?=.*[a-z])|(?=.*[A-Z])).{4,}$");
        matcher = regex.matcher(password).matches();

        if(matcher){
            return password;
        }
        return null;
    }
}