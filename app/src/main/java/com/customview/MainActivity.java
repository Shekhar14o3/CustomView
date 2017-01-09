package com.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.customview.fragments.FragmentHome;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppSingleton.getSingleton().initMainActivity(this);

        getSupportFragmentManager().beginTransaction().add(R.id.frameContainer, new FragmentHome(), "fragmentHome").commit();
    }
}
