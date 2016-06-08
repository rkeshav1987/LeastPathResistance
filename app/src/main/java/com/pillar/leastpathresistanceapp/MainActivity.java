package com.pillar.leastpathresistanceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new LeastPathResistance().printleastResistancePath("19 10 19 10 19 21 23 20 19 12 20 12 20 11 10",5,6);
    }
}
