package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
    EditText pass,nombre,apellido,documento,direccion,correo,telefono;
    Button registrar,salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_registrar);

       // user = (EditText) findViewById(R.id.UserR);
        pass=(EditText)findViewById(R.id.PassR);
        nombre = (EditText) findViewById(R.id.NombreR);
        apellido=(EditText)findViewById(R.id.ApellidoR);
        documento=(EditText)findViewById(R.id.documento);
        direccion=(EditText)findViewById(R.id.direccion);
        correo=(EditText)findViewById(R.id.correo);
        telefono=(EditText)findViewById(R.id.telefono);
        salir=(Button)findViewById(R.id.Salir);
        registrar=(Button)findViewById(R.id.Registrar);

        salir.setOnClickListener(this);
        registrar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.Registrar:

            insert();
            break;
            case R.id.Salir:
                Intent i= new Intent(Registrar.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }

    private void insert()
    {
        final String password = pass.getText().toString();
        final String nombre1 = nombre.getText().toString();
        final   String apellido1 = apellido.getText().toString();
        final String documento1 = documento.getText().toString();
        final String direccion1 = direccion.getText().toString();
        final String correo1 = correo.getText().toString();
        final String telefono1 = telefono.getText().toString();

        final ProgressDialog progressDialog = new ProgressDialog(this);
         if(correo1.isEmpty())
        {
        correo.setError("Complete los campos");
        }
        else if(nombre1.isEmpty())
        {
            nombre.setError("Complete los campos");
        }
        else if(apellido1.isEmpty())
        {
             apellido.setError("Complete los campos");
        }
        else if(documento1.isEmpty())
        {
             documento.setError("Complete los campos");
        }
        else if(direccion1.isEmpty())
        {
             direccion.setError("Complete los campos");
        }
        else if(password.isEmpty())
        {
            pass.setError("Complete los campos");
        }
       else if(telefono1.isEmpty())
        {
            telefono.setError("Complete los campos");
        }else
            {
                progressDialog.show();
                StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.0.13/covid/insert.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Datos insertados"))
                        {
                            Toast.makeText(Registrar.this, "datos ingresados", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        } else {
                            Toast.makeText(Registrar.this, response, Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(Registrar.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                })
                 {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError
                    {
                        
                        Map<String,String>parametros= new HashMap<String, String>();
                        parametros.put("nombre",nombre1);
                        parametros.put("apellido",apellido1);
                        parametros.put("numero_documento",documento1);
                        parametros.put("direccion",direccion1);
                        parametros.put("telefono",telefono1);
                        parametros.put("estado","activo");
                        parametros.put("password",password);
                        parametros.put("correo",correo1);

                        return parametros;
                    }
                 };
                RequestQueue requestQueue = Volley.newRequestQueue(Registrar.this);
                requestQueue.add(request);


            }



    }
}