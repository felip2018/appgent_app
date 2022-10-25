package com.fgarzon.appgent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.fgarzon.appgent.services.AuthenticationServices;

public class Register extends AppCompatActivity {

    AuthenticationServices backendServices;
    Button btnCancelRegister, btnAcceptRegister;
    Spinner selectDocumentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        backendServices = new AuthenticationServices();

        selectDocumentType = (Spinner) findViewById(R.id.document_types);

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
                openViewActivity(MainActivity.class);
            }
        });
    }

    public void openViewActivity(Class activity) {
        Intent intent = new Intent(Register.this, activity);
        startActivity(intent);
    }

}