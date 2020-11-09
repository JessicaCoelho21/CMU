package pt.ipp.estg.cmu_fp_05_ex2.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pt.ipp.estg.cmu_fp_05_ex2.R;
import pt.ipp.estg.cmu_fp_05_ex2.adapters.CitiesAdapter;
import pt.ipp.estg.cmu_fp_05_ex2.models.City;

public class RecyclerFragment extends Fragment {
    private RecyclerView recyclerView;
    private CitiesAdapter adapter;
    private Context context;

    public RecyclerFragment() {
        // Required empty public constructor
    }

    public static RecyclerFragment newInstance(String param1, String param2) {
        RecyclerFragment fragment = new RecyclerFragment();

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mContentView = inflater.inflate(R.layout.fragment_recycler, container, false);

        //Create cities list
        List<City> cities = new ArrayList<City>();
        cities.add(new City("Porto", "Portugal", "Cidade do Porto"));
        cities.add(new City("Lisboa", "Portugal", "Cidade de Lisboa"));
        cities.add(new City("Braga", "Portugal", "Cidade de Braga"));

        //Create cities adapter
        adapter = new CitiesAdapter(context, cities);

        //Set RecyclerView Adapter
        recyclerView = mContentView.findViewById(R.id.recycler2);
        recyclerView.setAdapter(adapter);

        //Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        //Divide RecyclerView elements with a gray line
        recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        return mContentView;
    }
}