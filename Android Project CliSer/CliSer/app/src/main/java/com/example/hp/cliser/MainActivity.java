package com.example.hp.cliser;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.utils.URIBuilder;
import cz.msebera.android.httpclient.impl.client.BasicResponseHandler;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    TextView result;
    EditText edit, edit2, edit3;
    Button butt;
    HttpClient httpclient;
    HttpPost httppost;

    String finalResult;
    String string1, string2;

    Timer t;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butt = (Button) findViewById(R.id.button);
        edit = (EditText) findViewById(R.id.editText);
        edit2 = (EditText) findViewById(R.id.editText2);
        edit3 = (EditText) findViewById(R.id.editText3);
        result = (TextView) findViewById(R.id.textView5);
        httpclient = new DefaultHttpClient();
        butt.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                //ALERT MESSAGE
                Toast.makeText(getBaseContext(), "Please wait, connecting to the server.", Toast.LENGTH_LONG).show();

                string1 = edit.getText().toString();
                string2 = edit2.getText().toString();

                Log.d("STRING", string1 + ":" + string2);

                GetRequest getRequest = new GetRequest();
                getRequest.execute(edit3.getText().toString());

//                ApiCall.Factory.getInstance().getResponse(string1, string2).enqueue(new Callback<List<String>>() {
//                    @Override
//                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//                        try {
//                            result.setText(response.raw().body().string());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<String>> call, Throwable t) {
//                        Log.d("RETRO", t.getMessage() + ":");
//                    }
//                });


            }
        });
    }

    private class GetRequest extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = null;
            try {
                URI uri = new URIBuilder(urls[0])
                        .addParameter("string1", string1)
                        .addParameter("string2", string2)
                        .build();

                httpGet = new HttpGet(uri);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }


            try {
                HttpResponse httpResponse = httpClient.execute(httpGet);
                finalResult = getString(httpResponse.getEntity().getContent());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return finalResult;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String fresult = finalResult.substring(2,finalResult.length()-2);
                    result.setText(fresult);
                }
            });
        }
    }

    private String getString(InputStream is) {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = null;
        try {
            in = new InputStreamReader(is, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (; ; ) {
            int rsz = 0;
            try {
                rsz = in.read(buffer, 0, buffer.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }
        return out.toString();
    }

    private String getString2(InputStream is) {
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        StringBuilder total = new StringBuilder();
        String line = "XYZ";
        try {
            while ((line = r.readLine()) != null) {
                total.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

}

