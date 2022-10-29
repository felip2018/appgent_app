package com.fgarzon.appgent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fgarzon.appgent.models.LoginResponse;
import com.fgarzon.appgent.models.RegisterData;
import com.fgarzon.appgent.services.AuthenticationServices;

public class Register extends AppCompatActivity {

    AuthenticationServices authenticationServices;

    EditText name, lastname, document, phone, email, password;

    Button btnCancelRegister, btnAcceptRegister;
    Spinner selectDocumentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        authenticationServices = new AuthenticationServices();

        name                = findViewById(R.id.field_name);
        lastname            = findViewById(R.id.field_surname);
        selectDocumentType  = (Spinner) findViewById(R.id.document_types);
        document            = findViewById(R.id.field_document);
        phone               = findViewById(R.id.field_phone);
        email               = findViewById(R.id.field_email);
        password            = findViewById(R.id.field_password);

        // Definición de listado de documentos de identidad
        // Crear un adaptador usando el arreglo de strings
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.documents_array, android.R.layout.simple_spinner_item);
        // Especificar el layout a usar cuando la lista de elecciones aparezca
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Aplicar el adaptador al spinner
        selectDocumentType.setAdapter(adapter);

        btnCancelRegister = (Button) findViewById(R.id.btn_cancel_register);
        btnAcceptRegister = (Button) findViewById(R.id.btn_accept_register);

        btnCancelRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewActivity(MainActivity.class);
            }
        });

        btnAcceptRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // openViewActivity(MainActivity.class);
                registerUser();
            }
        });
    }

    public void openViewActivity(Class activity) {
        Intent intent = new Intent(Register.this, activity);
        startActivity(intent);
    }

    public void registerUser() {
        if (validateFields()) {
            System.out.println("Se inicia el consumo del servicio para registrar!");
            RegisterData registerData = new RegisterData();
            String[] names = name.getText().toString().split(" ");
            String[] lastNames = lastname.getText().toString().split(" ");

            registerData.setFirstName(names[0]);
            registerData.setSecondName(names.length > 1 ? names[1] : "");
            registerData.setFirstLastname(lastNames[0]);
            registerData.setSecondLastname(lastNames.length > 1 ? lastNames[1] : "");
            registerData.setDocumentTypeId(getDocumentTypeId(selectDocumentType.getSelectedItem().toString()));
            registerData.setDocument(Long.parseLong(document.getText().toString()));
            registerData.setPhone(phone.getText().toString());
            registerData.setEmail(email.getText().toString());
            registerData.setPassword(password.getText().toString());

            // System.out.println(registerData.toString());

            // Consumir el servicio de inicio de sesion
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean register = authenticationServices.register(registerData);
                    if (register) {
                        System.out.println("Registro exitoso");
                    } else {
                        System.out.println( "Error al registrar!");
                    }
                }
            }).start();



        } else {
            System.out.println("Error en validación de campos!");
        }
    }

    public int getDocumentTypeId(String documentType) {
        switch (documentType) {
            case "Cedula de ciudadanía":
                return 1;
            case "Cedula de extranjeria":
                return 2;
            case "Pasaporte":
                return 3;
            case "Tarjeta de identidad":
                return 5;
            default:
                return 1;
        }
    }

    public boolean validateFields() {
        if (TextUtils.isEmpty(name.getText().toString())) {
            name.requestFocus();
            Toast.makeText(Register.this, "Ingrese el nombre!", Toast.LENGTH_SHORT).show();
            return false;
        } else if(TextUtils.isEmpty(lastname.getText().toString())) {
            Toast.makeText(Register.this, "Ingrese el apellido!", Toast.LENGTH_SHORT).show();
            lastname.requestFocus();
            return false;
        } else if(TextUtils.isEmpty(selectDocumentType.getSelectedItem().toString())) {
            Toast.makeText(Register.this, "Seleccione un tipo de identificación!", Toast.LENGTH_SHORT).show();
            selectDocumentType.requestFocus();
            return false;
        } else if(TextUtils.isEmpty(document.getText().toString())) {
            Toast.makeText(Register.this, "Ingrese el documento!", Toast.LENGTH_SHORT).show();
            document.requestFocus();
            return false;
        } else if(TextUtils.isEmpty(phone.getText().toString())) {
            Toast.makeText(Register.this, "Ingrese el teléfono!", Toast.LENGTH_SHORT).show();
            phone.requestFocus();
            return false;
        } else if(TextUtils.isEmpty(email.getText().toString())) {
            Toast.makeText(Register.this, "Ingrese el email!", Toast.LENGTH_SHORT).show();
            email.requestFocus();
            return false;
        } else if(TextUtils.isEmpty(password.getText().toString())) {
            Toast.makeText(Register.this, "Asigne una clave de ingreso!", Toast.LENGTH_SHORT).show();
            password.requestFocus();
            return false;
        } else {
            return true;
        }
    }
}