package com.tajy.appviewlayout;

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

public class MainActivity extends AppCompatActivity {

    //variables
    private EditText etNombre,etApellido,etDomicilio, etCuidad, etPais, etCpostal, etTelMovil, etEmail;
    private Button btnEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Vincular variables con elementos views
        etNombre=(EditText)findViewById(R.id.etNombre);
        etApellido=(EditText)findViewById(R.id.etApellido);
        etDomicilio=(EditText)findViewById(R.id.etDomicilio);
        etCuidad=(EditText)findViewById(R.id.etCuidad);
        etPais=(EditText)findViewById(R.id.etPais);
        etCpostal=(EditText)findViewById(R.id.etCpostal);
        etTelMovil=(EditText)findViewById(R.id.etTelMovil);
        etEmail=(EditText)findViewById(R.id.etEmail);
        btnEnviar=(Button) findViewById(R.id.btnEnviar);


        //controlar eventos
        btnEnviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //validacion
                if(validar(etNombre)&&validar(etApellido)&&validar(etDomicilio)&&validar(etCuidad)&&validar(etPais)&&validar(etCpostal)&&validar(etTelMovil)&&validar(etEmail)) {
                    Toast.makeText(getApplicationContext(), "Registro exitoso!", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public boolean validar(EditText campo){
        //verificar contenido del campo (elemento view)
        if (campo.getText().toString().trim().length()<1){
            campo.setError("Favor Completar datos!");
            campo.requestFocus();
            return false;
        }else {
            return true;
        }
    }
}