package pt.ipp.estg.tourpediaexample.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pt.ipp.estg.tourpediaexample.Adapters.PlacesOfInterestAdapter;
import pt.ipp.estg.tourpediaexample.ConverterFactory;
import pt.ipp.estg.tourpediaexample.Models.PlacesOfInterest;
import pt.ipp.estg.tourpediaexample.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListFragment extends Fragment {
    private RecyclerView recyclerView;
    private Context mContext;
    private PlacesOfInterestAdapter adapter;
    private String location;
    private String name;

    private ConverterFactory api = new ConverterFactory();

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        if(bundle != null){
            this.location = bundle.getString("LOCATION");
            this.name = bundle.getString("NAME");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = v.findViewById(R.id.locations_recycler);

        api.getApi().getPointsOfInterest(location, name)
                .enqueue(new Callback<List<PlacesOfInterest>>() {
                    @Override
                    public void onResponse(Call<List<PlacesOfInterest>> call, Response<List<PlacesOfInterest>> response) {
                        List<PlacesOfInterest> places = response.body();
                        adapter = new PlacesOfInterestAdapter(mContext, places);

                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
                    }

                    @Override
                    public void onFailure(Call<List<PlacesOfInterest>> call, Throwable t) {
                        System.out.println("Error!");
                    }
                });

        return v;
    }
}