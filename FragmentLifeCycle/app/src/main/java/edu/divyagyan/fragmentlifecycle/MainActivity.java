package edu.divyagyan.fragmentlifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String TAG =MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate method called Activity");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart method called Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume method called Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause method called Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onsStop method called Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy method called Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart method called Activity");

    }
}
