package com.example.octandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    EditText edtMobile, edtPassword;
    Button btnLogin;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edtMobile=findViewById(R.id.etmobile);
        edtPassword=findViewById(R.id.etpassword);
        btnLogin=findViewById(R.id.btnlogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileNo=edtMobile.getText().toString();
                String password=edtPassword.getText().toString();
                SharedPreferences sharedPreferences=getSharedPreferences("MySharedPref",MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                if (mobileNo.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Please Enter Mobile No and Password", Toast.LENGTH_SHORT).show();

                }
                else if (mobileNo.equals("9876543210") && password.equals("12345"))
                {
                    editor.putString("loginstatus","true");
                    editor.apply();
                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                    startActivity(intent);
                    //Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid Mobile No or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}