package pt.ipp.estg.cmu_fp_05_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.estg.cmu_fp_05_ex2.adapters.CitiesAdapter;
import pt.ipp.estg.cmu_fp_05_ex2.fragments.DetailsFragment;
import pt.ipp.estg.cmu_fp_05_ex2.fragments.RecyclerFragment;
import pt.ipp.estg.cmu_fp_05_ex2.models.City;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CitiesAdapter adapter;

    FragmentManager fragmentManager = getSupportFragmentManager();
    DetailsFragment detailsFragment;
    RecyclerFragment recyclerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create cities list
        List<City> cities = new ArrayList<City>();
        cities.add(new City("Porto", "Portugal"));
        cities.add(new City("Porto", "Portugal"));
        cities.add(new City("Porto", "Portugal"));

        //Create cities adapter
        adapter = new CitiesAdapter(this, cities);

        //Set RecyclerView Adapter
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);

        //Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Divide RecyclerView elements with a gray line
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        /*
        recyclerFragment = new RecyclerFragment();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.)
         */
    }
}