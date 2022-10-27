package com.fgarzon.appgent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fgarzon.appgent.models.LoginResponse;
import com.fgarzon.appgent.services.AuthenticationServices;

import org.springframework.web.client.HttpClientErrorException;

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
                if (validation) {

                    ProgressDialog dialog = ProgressDialog.show(
                            MainActivity.this,
                            "Iniciar sesión",
                            "Validando datos",
                            true
                    );

                    // Consumir el servicio de inicio de sesion
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            LoginResponse loginResponse = authenticationServices.login(username.getText().toString(), password.getText().toString());
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    dialog.hide();
                                    validateLoginResponse(loginResponse);
                                }
                            });
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

    public void validateLoginResponse(LoginResponse loginResponse) {
        if (loginResponse != null) {
            System.out.println("Bienvenido: "+loginResponse.getData().getFirst_name());
            Toast.makeText(MainActivity.this, "Bienvenido: "+loginResponse.getData().getFirst_name(), Toast.LENGTH_SHORT).show();
        } else {
            System.out.println("Verifique usuario y clave");
            Toast.makeText(MainActivity.this, "Verifique usuario y clave", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validateFields(EditText username, EditText password) {
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