package pt.ipp.estg.cmu_fp_05_ex2.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pt.ipp.estg.cmu_fp_05_ex2.R;
import pt.ipp.estg.cmu_fp_05_ex2.models.City;

public class DetailsFragment extends Fragment {
    private TextView city;
    private TextView country;
    private TextView description;
    private City cityModel;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(String param1, String param2) {
        DetailsFragment fragment = new DetailsFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        if(bundle != null) {
            cityModel = (City) bundle.getSerializable("city");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mContentView = inflater.inflate(R.layout.fragment_details, container, false);

        city = mContentView.findViewById(R.id.city_name);
        country = mContentView.findViewById(R.id.country_name);
        description = mContentView.findViewById(R.id.details);

        if(cityModel != null){
            city.setText(cityModel.getCity());
            country.setText(cityModel.getCountry());
            description.setText(cityModel.getDescription());
        } else {
            city.setText("Nome");
            country.setText("País");
            description.setText("Descrição");
        }

        return mContentView;
    }


    public void updateCities(City c) {
        // Atualiza a interface colocando os dados de c nos respetivos elementos do layout do Fragment
        city.setText(c.getCity());
        country.setText(c.getCountry());
        description.setText(c.getDescription());
    }
}