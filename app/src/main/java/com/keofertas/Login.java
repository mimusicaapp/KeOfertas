package com.keofertas;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

public class Login extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_login);
		new Conectar().execute(this);
	}

    public void crearCuenta(View view){
        Intent cuenta =  new Intent(this, Registro.class);
        startActivity(cuenta);
    }

    public void recuperarCredenciales(View v){
        Intent recuperar = new Intent(this, RecuperarCredenciales.class);
        startActivity(recuperar);
    }

	private class Conectar extends AsyncTask<Context,Void,Void>{

		@Override
		protected Void doInBackground(Context... contexto) {
			if(Utils.servidorDisponible(contexto[0])){
				Log.v("Conexion con Servidor: ","Hay conexion con el servidor");
			}else{
                Log.v("Conexion con Servidor: ","No hay conexion a Internet");
			}
            return null;
		}
	}

}
