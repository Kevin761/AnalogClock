package com.example.clock;

import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnalogClock analogClock = (AnalogClock) findViewById(R.id.analog_clock);

        Thread t = new Thread(new ClockThread(new Handler(), analogClock));
        t.start();

    }
}
