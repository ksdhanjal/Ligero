package com.kamaldeep.ligero;

import android.os.AsyncTask;
import android.util.Log;

public class SERVER
{
    private static final String TAG = SERVER.class.getSimpleName();

    public static String IP_ADDRESS = "192.168.1.32";

    public static void urlHit(String url)
    {

        new AsyncTask<String, String, String>()
        {
            @Override
            protected void onPreExecute(){

            }

            @Override
            protected String doInBackground(String... partUrl)
            {
                HttpHandler sh = new HttpHandler();
                String url = partUrl[0];

                String jsonStr = sh.makeServiceCall(url);
                Log.d(TAG, "Response from url: " + jsonStr);
                return jsonStr;
            }

            @Override
            protected void onPostExecute(String result)
            {
                Log.e(TAG,"result = " + result);
            }
        }.execute( url );

    }
}
