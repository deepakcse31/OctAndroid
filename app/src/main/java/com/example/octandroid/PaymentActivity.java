package com.example.octandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PaymentActivity extends AppCompatActivity {
    EditText edtamount;
    Button btnpay;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_payment);
        edtamount = findViewById(R.id.edtamount);
        btnpay = findViewById(R.id.btnpay);

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = edtamount.getText().toString();
                Intent intent=new Intent(PaymentActivity.this, PaymentDetailsActivity.class);
                intent.putExtra("amount", amount);
                startActivity(intent);

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}