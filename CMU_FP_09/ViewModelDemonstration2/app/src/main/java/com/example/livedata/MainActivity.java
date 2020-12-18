package com.example.livedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private MasterFragment masterFragment;
    private DetailsFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        masterFragment = new MasterFragment();
        detailsFragment = new DetailsFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment, masterFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment2, detailsFragment).commit();
    }
}
