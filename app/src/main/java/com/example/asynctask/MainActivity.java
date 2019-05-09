package com.example.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TEXT_STATE = "currentText";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.textView1);

        if(savedInstanceState !=null)
        {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        mTextView.setText("Napping... ");
        SimpleAsyncTask simpleAsyncTask = new SimpleAsyncTask(mTextView);
        simpleAsyncTask.execute(); // pass attributes here that goes to doInBackground(), here not needed

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(TEXT_STATE, mTextView.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
