package com.example.sanchezvictor_u2.Controllers;

import android.app.Activity;
import android.content.Intent;
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

import com.example.sanchezvictor_u2.R;

public class LoginActivity extends AppCompatActivity {
    private Button btn_login;
    private EditText et_gmail;
    private EditText et_nombre;
    private EditText et_edad;
    private String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_login = (Button) findViewById(R.id.btn_log);
        et_gmail = (EditText) findViewById(R.id.editText_gmail);
        et_nombre = (EditText) findViewById(R.id.editText_nombre);
        et_edad = (EditText) findViewById(R.id.editText_edad);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String gmail = et_gmail.getText().toString().trim();
                String nombre = et_nombre.getText().toString().trim();
                String edad = et_edad.getText().toString().trim();
                if (gmail.isEmpty() || nombre.isEmpty() || edad.isEmpty()) {
                    myLongToast("Rellene todos los campos");
                } else {
                    if (gmail.matches(emailRegex)) {
                        try {
                            // Intentar convertir el texto a un número
                            int edad2 = Integer.parseInt(edad);
                            // Comprobar que la edad esté dentro del rango permitido
                            if (edad2 >= 18 && edad2 <= 117) {
                                //Creamos y rellenamos el Intent que contendra la informacion de la ventana
                                Intent returnIntent = new Intent();
                                returnIntent.putExtra("result",nombre);
                                setResult(Activity.RESULT_OK,returnIntent);
                                finish();
                            } else {
                                // La edad no está en el rango
                                myLongToast("Edad minima: 18"+'\n'+"Edad maxima: 117");
                            }
                        } catch (NumberFormatException e) {
                            // Si la conversión falla (no es un número válido)
                            myLongToast("La edad solo puede ser un numero");
                        }
                    } else {
                        myLongToast("Correo invalido. Formato valido: ejemplo@gmail.com");
                    }
                }
            }
        });

    }

    public void myLongToast(String msg){
        Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}