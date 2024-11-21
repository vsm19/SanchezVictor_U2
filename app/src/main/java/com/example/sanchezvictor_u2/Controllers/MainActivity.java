package com.example.sanchezvictor_u2.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sanchezvictor_u2.Model.Explorador;
import com.example.sanchezvictor_u2.R;

import Utilidades.Utilidades;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_login;
    private Button btn_lista;
    private TextView text_welcome;
    private TextView text_user;
    private ImageView img_inicio;
    private ImageView imageOjo;


    public static int RQ_LOGIN = 0;

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
            btn_login = (Button) findViewById(R.id.btn_login);
            btn_lista = (Button) findViewById(R.id.btn_lista);
            text_welcome = (TextView) findViewById(R.id.text_welcome);
            text_user = (TextView) findViewById(R.id.text_user);
            img_inicio = (ImageView) findViewById(R.id.img_inicio);
            imageOjo = (ImageView) findViewById(R.id.imageOjo);
            btn_login.setOnClickListener(this);
            btn_lista.setOnClickListener(this);

        Utilidades.getExploradores().add(new Explorador("Chert","Chert es un astrónomo que está bien informado y entusiasmado con su trabajo. Tienen curiosidad por el Nomai y el funcionamiento del universo, y mostrar algún nivel de devoción a su trabajo, comentando, “A veces creo que soy el único viajero aquí interesado en hacer cualquier ciencia en absoluto.” Cuando se les habla al principio del ciclo, parecen optimistas y entusiasmados por haber visto más supernovas de lo habitual. Sin embargo, cuando se les habla más tarde en el bucle, han visto cómo más y más estrellas mueren, se ponen nerviosas y luego entran en pánico sobre lo que esto podría significar para su propio sol.",R.drawable.huevo,"Gemelo Ceniza","Chert es un astrónomo que está bien informado y entusiasmado con su trabajo. Tienen curiosidad por el Nomai y el funcionamiento del universo"));
        Utilidades.getExploradores().add(new Explorador("Esker","Esker es uno de los primeros Hearthian astronautas, y se encuentra en su puesto de avanzada en El Attlerock. Solían correr el Puesto de avanzada lunar cuando era necesario para reparaciones frecuentes de barcos, pero ahora solo \" vigilan las cosas\"."+'\n'+"Esker está muy solo en The Attlerock ya que ya no reciben visitantes, ya que el programa espacial se hizo más exitoso y se produjeron menos accidentes. Le piden repetidamente al personaje del jugador que se quede con ellos junto al fuego. También son el primer hearthian espacial en aparecer en el epílogo.",R.drawable.viejo,"Rocaterra","Esker es uno de los primeros Hearthian astronautas, y se encuentra en su puesto de avanzada en El Attlerock. Solían correr el Puesto de avanzada lunar cuando era necesario para reparaciones"));
        Utilidades.getExploradores().add(new Explorador("Riebeck","Riebeck es un hearthian generalmente educado pero tímido que parece estar ansioso por la mayoría de las cosas, pero especialmente por todo lo relacionado con el espacio y los viajes espaciales. Se describen a sí mismos como “más sorprendidos que nadie aquí”, habiendo llegado a su campamento bajo la corteza de Brittle Hollowis, literalmente cayendo después de tropezar con un cristal de gravedad. A pesar de su miedo al espacio, Riebeck es un arqueólogo que se ve obligado a explorar el sistema solar debido a su fascinación por la historia, particularmente cualquier cosa relacionada con el Nomai. Cuando se trata de sus pasiones, pueden ser extremadamente entusiastas, lo suficiente como para estar dispuestos a enfrentar su miedo al espacio si eso significa aprender más sobre los Nomai.",R.drawable.popu, "Hondonada Fragil","Riebeck es un hearthian generalmente educado pero tímido que parece estar ansioso por la mayoría de las cosas, pero especialmente por todo lo relacionado con el espacio y los viajes espaciales."));
        Utilidades.getExploradores().add(new Explorador("Gabro","Gabro es un astronauta hearthian ubicado en su campamento en un isla en Gigante es Profundo. Encontraron múltiples Estatuas Nomai y trajo la estatua que el personaje del jugador empareja con el observatorio en Corazón de Madera. Se emparejan accidentalmente a uno durante el mismo bucle que el personaje del jugador, lo que significa que ambos experimentan los bucles de tiempo, pero solo recuerdan haber comenzado en el bucle de tiempo 9,318,054. Tocan la flauta.",R.drawable.zaidin,"Abismo del gigante","Gabbro es amigable con el protagonista y muestra una actitud muy informal y relajada, aunque según su conocimiento sobre la mecánica cuántica, parecen ser un gran astronauta"));
        Utilidades.getExploradores().add(new Explorador("Feldespato","Feldespato es a Hearthian astronauta ubicado dentro Bramble Oscuro. Son uno de Outer Wilds Ventures' miembros fundadores, y son venerados como uno de los mejores pilotos dentro del Hearthian Viajeros. Fueron los primeros Hearthian en ser lanzados intencionalmente al espacio, completando una órbita alrededor Corazón de Madera y luego haciendo el primer aterrizaje el Attlerock. Han viajado a través del sistema solar (puedes encontrar sus máquinas de cinta en múltiples planetas) pero han estado varados en Dark Bramble durante algún tiempo. Tocan la armónica.",R.drawable.flipao, "Espinoscuro/Lumbre","Hornfels describe a Feldspar como \"absolutamente intrépido\" y afirma que \"nada los asustó\", y agregó, \"Es una maravilla que Feldspar vivió para ver el espacio, francamente.\""));
    }
    @Override
    public void onClick(View view) {
        Button btn = (Button) view;

        switch (btn.getId()){
            case R.id.btn_login:
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(i,RQ_LOGIN);
            break;
            case R.id.btn_lista:
                Intent j = new Intent(MainActivity.this, ListActivity.class);
                startActivity(j);
                break;


        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Todo 3.2 Usamos RQ_SECOND_ACT para saber si el mensaje proviene de la segunda actividad
        if(requestCode == RQ_LOGIN){
            //Todo 3.3 Usamos RESULT_OK para saber si el mensaje que llega es el correcto.
            if(resultCode==RESULT_OK){
                String msg = data.getStringExtra("result");
                img_inicio.setVisibility(View.VISIBLE);
                imageOjo.setVisibility(View.INVISIBLE);
                text_welcome.setText("Bienvenido " + msg);

            }

        }

    }
}