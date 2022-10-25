package com.fgarzon.appgent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterCase extends AppCompatActivity {

    Button btnCancel, btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_case);
        getSupportActionBar().hide();

        btnCancel = findViewById(R.id.btn_cancel_register_case);
        btnAccept = findViewById(R.id.btn_accept_register_case);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterCase.this, Tabs.class);
                startActivity(intent);
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterCase.this, Tabs.class);
                startActivity(intent);
            }
        });
    }
}