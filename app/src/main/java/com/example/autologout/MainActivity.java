package com.example.autologout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();

        timer = new Timer();
//        Log.i("Main","Invoking logout timer");
        LogOutTimerTask logOutTimerTask = new LogOutTimerTask();
        timer.schedule(logOutTimerTask,5000);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (timer != null){
            timer.cancel();
//            Log.i("Main","cancel timer");
            timer = null;
        }
    }

    private class LogOutTimerTask extends TimerTask {
        @Override
        public void run() {
            //redirect user to login screen
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    }
}
