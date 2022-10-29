package com.fgarzon.appgent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fgarzon.appgent.models.LoginResponse;
import com.fgarzon.appgent.services.AuthenticationServices;

public class MainActivity extends AppCompatActivity {

    AuthenticationServices authenticationServices;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    Button btnLogin, btnRegister;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        boolean isLogged = sharedPreferences.getBoolean("isLogged", false);

        if (isLogged) {
            // A session already exists, navigate to application
            Intent intent = new Intent(MainActivity.this, Tabs.class);
            startActivity(intent);
        }

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
            sharedPreferencesEditor.putBoolean("isLogged", true);
            sharedPreferencesEditor.putString("document", loginResponse.getData().getDocument());
            sharedPreferencesEditor.putString("address", loginResponse.getData().getAddress());
            sharedPreferencesEditor.putString("firstName", loginResponse.getData().getFirstName());
            sharedPreferencesEditor.putString("secondName", loginResponse.getData().getSecondName());
            sharedPreferencesEditor.putString("firstLastname", loginResponse.getData().getFirstLastname());
            sharedPreferencesEditor.putString("secondLastname", loginResponse.getData().getSecondLastname());
            sharedPreferencesEditor.putString("phone", loginResponse.getData().getPhone());
            sharedPreferencesEditor.putString("email", loginResponse.getData().getEmail());
            sharedPreferencesEditor.putString("personId", loginResponse.getData().getPersonId());
            sharedPreferencesEditor.putString("profileId", loginResponse.getData().getProfileId());
            sharedPreferencesEditor.putString("username", loginResponse.getData().getUsername());
            sharedPreferencesEditor.putString("validateAccount", loginResponse.getData().getValidateAccount());
            sharedPreferencesEditor.putString("registerStatus", loginResponse.getData().getRegisterStatus());
            sharedPreferencesEditor.putString("profile", loginResponse.getData().getProfile());
            sharedPreferencesEditor.putString("abbreviation", loginResponse.getData().getAbbreviation());
            sharedPreferencesEditor.putString("city", loginResponse.getData().getCity());

            sharedPreferencesEditor.commit();

            // Toast.makeText(MainActivity.this, "Bienvenido: "+loginResponse.getData().getFirst_name(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Tabs.class);
            startActivity(intent);

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