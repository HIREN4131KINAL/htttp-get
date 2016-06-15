package com.hometech.okhttpget;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    String responseString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetData().execute();

    }

    public class GetData extends AsyncTask<Void, Void, Void> {

        private static final String TAG = "Response";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://api.androidhive.info/json/movies.json")
                    .build();

            Response response = null;

            try {

                response = client.newCall(request).execute();
                responseString = response.body().string();

            } catch (Exception e) {

                Log.e(TAG, "doInBackground: Error"+e );
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            TextView response = (TextView) findViewById(R.id.response);
            response.setText(responseString);
            Log.i(TAG, "onPostExecute: " + responseString);
        }

    }

    //POST METHOD

  /*  OkHttpClient client = new OkHttpClient();

    RequestBody formBody = new FormBody.Builder()
            .add("deviceId", "821373")
            .add("accountId", preferenceInterface.retrivePreference(Keys.Pref.ACCOUNT_ID))
            .add("status_type", "internet")
            .add("status", "OFF")
            .add("ram", String.valueOf(getCurrentAvailableRAM()))
            .add("time", time)
            .add("difference", params[0])
            .build();

    Request request = new Request.Builder()
            .url("YOUR URL")
            .post(formBody)
            .build();

    try {
        Response response = client.newCall(request).execute();
        String responseString = response.body().string();
        response.body().close();



    } catch (Exception e) {

    }*/




}
