package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user,pass;
    Button ingresar,registrarse;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText)findViewById(R.id.User);
        pass=(EditText)findViewById(R.id.Pass);
        ingresar=(Button)findViewById(R.id.Ingresar);
        registrarse=(Button)findViewById(R.id.Registrarse);

        ingresar.setOnClickListener(this);
        registrarse.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.Registrarse:
                Intent i= new Intent(MainActivity.this,Registrar.class);
                 startActivity(i);

                break;

           /* case R.id.Ingresar:
                String u = user.getText().toString();
                String p = pass.getText().toString();
                Log.d("me voy a loguear con ",u+":"+p);
                if (u.equals("")&&p.equals("")||u.equals("")||p.equals(""))
                {
                    Toast.makeText(this,"ERROR: CAMPOS VACIOS",Toast.LENGTH_LONG).show();
                    System.out.println(p);

                }else if (dao.login(u,p)==1)
                {

                    Usuario us = dao.getUsuario(u,p);
                    Toast.makeText(this,"Datos Correctos",Toast.LENGTH_LONG).show();
                    Intent i3= new Intent(MainActivity.this,Inicio.class);
                    i3.putExtra("id",us.getId());
                    startActivity(i3);
                    finish();

                }else{Toast.makeText(this,"Datos Incorrectos",Toast.LENGTH_LONG).show();}
                break;
                */

        }

    }
}