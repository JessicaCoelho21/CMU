package pt.ipp.estg.tourpediaexample.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pt.ipp.estg.tourpediaexample.Models.PlacesOfInterest;
import pt.ipp.estg.tourpediaexample.R;

public class DetailsFragment extends Fragment {
    private TextView id;
    private TextView name;
    private TextView address;
    private TextView category;
    private TextView location;
    private TextView latitude;
    private TextView longitude;
    private TextView details;

    private PlacesOfInterest place;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null){
            place = (PlacesOfInterest) bundle.getSerializable("POI");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_details, container, false);

        id = v.findViewById(R.id.obj_ID);
        name = v.findViewById(R.id.obj_name);
        address = v.findViewById(R.id.obj_address);
        category = v.findViewById(R.id.obj_category);
        location = v.findViewById(R.id.obj_location);
        latitude = v.findViewById(R.id.obj_lat);
        longitude = v.findViewById(R.id.obj_long);
        details = v.findViewById(R.id.obj_details);

        id.setText(place.getId());
        name.setText(place.getName());
        address.setText(place.getAddress());
        category.setText(place.getCategory());
        location.setText(place.getLocation());
        latitude.setText(String.valueOf(place.getLatitude()));
        longitude.setText(String.valueOf(place.getLongitude()));
        details.setText(String.valueOf(place.getDetails()));

        return v;
    }
}