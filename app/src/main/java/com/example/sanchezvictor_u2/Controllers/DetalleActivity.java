package com.example.sanchezvictor_u2.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sanchezvictor_u2.R;

public class DetalleActivity extends AppCompatActivity {
    private ImageView img_detalle_personaje;
    private TextView txt_detalle_planeta;
    private TextView txt_detalle_contenido;
    private TextView txt_detalle_nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        img_detalle_personaje = (ImageView)findViewById(R.id.img_detalle_personaje);
        txt_detalle_planeta = (TextView) findViewById(R.id.txt_detalle_planeta);
        txt_detalle_contenido = (TextView) findViewById(R.id.txt_detalle_contenido);
        txt_detalle_nombre = (TextView) findViewById(R.id.txt_detalle_nombre);

        Intent i = getIntent();
        img_detalle_personaje.setImageResource(i.getIntExtra("IMAGEN",1));
        txt_detalle_planeta.setText(i.getStringExtra("PLANETA"));
        txt_detalle_contenido.setText(i.getStringExtra("INFO"));
        txt_detalle_nombre.setText(i.getStringExtra("NOMBRE"));
    }
}