package com.keofertas;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Utils {

    public static final String servidor = "http://movilhuejutla.com.mx/";

    public static boolean servidorDisponible(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            try {
                int time = 1000;
                URL url = new URL(servidor);
                HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                conexion.setConnectTimeout(time);
                conexion.setReadTimeout(time);
                conexion.connect();
                if (conexion.getResponseCode() == 200) {
                    return true;
                } else {
                    return false;
                }
            } catch (MalformedURLException e1) {
                return false;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }

}
