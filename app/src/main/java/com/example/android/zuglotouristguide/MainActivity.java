package com.example.android.zuglotouristguide;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        Fragment sightsFragment = new SightsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, sightsFragment).commit();

        Location vajdahunyad = new Location("Vajdahnyad", "Castle", 2);
        Location pedalBar = new Location("Pedal", "Bar", "Ajtosi");
        Log.i("Main", Boolean.toString(vajdahunyad.hasAddress()));
        Log.i("Main", Boolean.toString(pedalBar.hasImage()));

    }
}
