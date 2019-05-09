package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;


public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    private TextView mTextView;

    public SimpleAsyncTask(TextView tv){
        mTextView = tv;
    }


    @Override
    protected String doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);

        //creating task long enough to rotate phone during it
        int s = n*200;

        try{
            Thread.sleep(s);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        //return string result
        return "Awake at last after sleeping for " + s + " miliseconds!";
    }

    @Override
    protected void onPostExecute(String result) {

        mTextView.setText(result);
    }
}