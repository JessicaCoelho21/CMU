package pt.ipp.estg.cmu_fp_05_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import pt.ipp.estg.cmu_fp_05_ex2.fragments.DetailsFragment;
import pt.ipp.estg.cmu_fp_05_ex2.fragments.RecyclerFragment;
import pt.ipp.estg.cmu_fp_05_ex2.models.City;

public class MainActivity extends AppCompatActivity implements Interface{
    RecyclerFragment recyclerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null) {
            if(savedInstanceState != null) {
                return;
            }

            recyclerFragment = new RecyclerFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, recyclerFragment).commit();
        }
    }

    @Override
    public void sendTextToFragment(City city) {
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.b_fragment);

        if(detailsFragment != null) {
            detailsFragment.updateCities(city);
        } else {
            detailsFragment = new DetailsFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("city", city);
            detailsFragment.setArguments(bundle);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, detailsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}