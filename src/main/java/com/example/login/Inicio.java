package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    Button salir,usuarios;
    TextView nombreUsuario;

    int id =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        salir=(Button)findViewById(R.id.salir);
        usuarios=(Button)findViewById(R.id.mostrar);
        nombreUsuario = (TextView)findViewById(R.id.nombreUsuario);

        salir.setOnClickListener(this);
        usuarios.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id = b.getInt("id");

        //nombreUsuario.setText(u.getNombre()+" "+u.getApellido());
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.mostrar:

                Intent i= new Intent(Inicio.this,Mostrar.class);
                startActivity(i);

                break;

            case R.id.salir:

                    Intent i3= new Intent(Inicio.this,MainActivity.class);
                    startActivity(i3);
                    finish();

                break;
        }

    }
}