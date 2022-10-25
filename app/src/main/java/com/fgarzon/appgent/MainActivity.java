package com.fgarzon.appgent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fgarzon.appgent.services.AuthenticationServices;

public class MainActivity extends AppCompatActivity {

    AuthenticationServices authenticationServices;
    Button btnLogin, btnRegister;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        authenticationServices = new AuthenticationServices();

        username    = findViewById(R.id.username);
        password    = findViewById(R.id.password);

        btnLogin    = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validación de campos
                boolean validation = validateFields(username, password);
                System.out.println("Validation Fields > "+(validation ? "OK" : "WRONG"));
                if (validation) {
                    // Consumir el servicio de inicio de sesion
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                authenticationServices.login(username.getText().toString(), password.getText().toString());
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                    }).start();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }

    public boolean validateFields(EditText username, EditText password) {
        System.out.println("User: "+username.getText());
        if (username.getText().toString().equals("")) {
            username.requestFocus();
            Toast.makeText(MainActivity.this, "Ingrese el usuario!", Toast.LENGTH_SHORT).show();
            return false;
        } else if(password.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Ingrese la clave!", Toast.LENGTH_SHORT).show();
            password.requestFocus();
            return false;
        } else {
            return true;
        }
    }
}