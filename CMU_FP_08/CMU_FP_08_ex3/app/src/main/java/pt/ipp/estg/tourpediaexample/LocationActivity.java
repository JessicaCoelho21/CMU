package pt.ipp.estg.tourpediaexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import pt.ipp.estg.tourpediaexample.Fragments.DetailsFragment;
import pt.ipp.estg.tourpediaexample.Fragments.ListFragment;
import pt.ipp.estg.tourpediaexample.Models.PlacesOfInterest;

public class LocationActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ListFragment listFragment;
    private String location;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        //Set toolbar
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Locations' List");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        location = i.getStringExtra("Location");
        name = i.getStringExtra("Name");

        listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("LOCATION", location);
        bundle.putString("NAME", name);
        listFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, listFragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }

        switch (item.getItemId()){
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void ReplaceDetails(PlacesOfInterest placesOfInterest){
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("POI", placesOfInterest);
        detailsFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailsFragment)
                .addToBackStack(null)
                .commit();
    }
}