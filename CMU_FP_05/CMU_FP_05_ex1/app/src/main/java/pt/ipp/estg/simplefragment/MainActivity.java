package pt.ipp.estg.simplefragment;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import pt.ipp.estg.simplefragment.fragments.SimpleFragment;
import pt.ipp.estg.simplefragment.fragments.SimpleFragment2;

public class MainActivity extends AppCompatActivity implements Interface {
    FragmentManager fragmentManager = getSupportFragmentManager();

    SimpleFragment fragment1;
    SimpleFragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new SimpleFragment();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout2, fragment1, "home");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void sendTextToFragment(String text) {
        fragment2 = new SimpleFragment2();

        Bundle bundle = new Bundle();
        bundle.putString("value", text);
        fragment2.setArguments(bundle);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout2, fragment2, "details");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}