package com.keofertas;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends ActionBarActivity {

    private EditText email, pass1, pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_registro);

        email = (EditText) findViewById(R.id.editText_email);
        pass1 = (EditText) findViewById(R.id.editText_password);
        pass2 = (EditText) findViewById(R.id.editText_again_password);
    }

    public void registrarCuenta(View view){
        String email = this.email.getText().toString();
        String pass1 = this.pass1.getText().toString();
        String pass2 = this.pass2.getText().toString();

        if(validarCampos(email, pass1, pass2)){
            String[] array = {email, pass1, pass2};
            RegistrarCuentaEnServidor registro = new RegistrarCuentaEnServidor(this);
            registro.execute(array);
        }
    }

    private boolean validarCampos(String email, String pass1, String pass2){

        int p1 = pass1.length();
        int p2 = pass2.length();

        if(email.length() != 0) {
            if(email.contains("@")) {
                if (p1 >= 5 && p2 >= 5) {
                    if (pass1.contentEquals(pass2)) {
                        return true;
                    } else {
                        Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }else{
                    Toast.makeText(this, "La contraseña debe tener 5 caracteres como minimo", Toast.LENGTH_LONG).show();
                    return false;
                }
            }else{
                Toast.makeText(this, "Su correo electronico no es válido", Toast.LENGTH_SHORT).show();
                return false;
            }
        }else{
            Toast.makeText(this, "Ingrese su correo electronico", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private class RegistrarCuentaEnServidor extends AsyncTask<String[], Void, String>{

        @Override
        protected String doInBackground(String[]... strings) {
            Log.v("AsyncTask:","Metodo doInBackground()...");
            return null;
        }
    }

}
