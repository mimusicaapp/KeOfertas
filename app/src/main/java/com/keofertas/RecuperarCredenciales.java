package com.keofertas;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RecuperarCredenciales extends ActionBarActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_recuperar_credenciales);
        email = (EditText) findViewById(R.id.editText_recuperar_email);
    }

    public void recuperarPassword(View view){
        String email = this.email.getText().toString();
        if(email.contains("@")){
            //Hacer tarea asincrona...
        }else{
            Toast.makeText(this, "La direccion de correo no es valida", Toast.LENGTH_SHORT).show();
        }
    }

}
