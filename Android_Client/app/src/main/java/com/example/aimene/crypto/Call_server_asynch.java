package com.example.aimene.crypto;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by zexes-g on 14/05/17.
 */

public class Call_server_asynch extends AsyncTask<String, Void, String> {

    private final OkHttpClient client = new OkHttpClient();


    public String sendData(String name, String methode, String message, String key){

        try {
            /* Create body */
            RequestBody body = new FormBody.Builder()
                    .add("name", name)
                    .add("methode", methode)
                    .add("message", message)
                    .add("key", key)
                    .build();

            /* Create request */
            Request request = new Request.Builder()
                    .url("http://criptoBox.ngrok.io/cript")
                    .post(body)
                    .build();

            /*
            *  Send ----> Request
            *  Get  ----> Response
            */
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }

    @Override
    protected String doInBackground(String... data) {
        return /*res.body*/sendData(data[0], data[1], data[2], data[3]);
    }

    @Override
    protected void onPostExecute(String response) {
        String res = response;
        Log.d("networking", response);
    }


}
