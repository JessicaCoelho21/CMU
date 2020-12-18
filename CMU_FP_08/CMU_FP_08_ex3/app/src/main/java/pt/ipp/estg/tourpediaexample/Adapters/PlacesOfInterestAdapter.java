package pt.ipp.estg.tourpediaexample.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.ipp.estg.tourpediaexample.LocationActivity;
import pt.ipp.estg.tourpediaexample.Models.PlacesOfInterest;
import pt.ipp.estg.tourpediaexample.R;

public class PlacesOfInterestAdapter extends RecyclerView.Adapter<PlacesOfInterestAdapter.PlacesOfInterestViewHolder> {
    private Context mContext;
    private List<PlacesOfInterest> mPlacesOfInterest;
    private String location;
    private String name;

    public PlacesOfInterestAdapter (Context context, List<PlacesOfInterest> placesOfInterests){
        this.mContext = context;
        this.mPlacesOfInterest = placesOfInterests;
    }

    @NonNull
    @Override
    public PlacesOfInterestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View locationView = inflater.inflate(R.layout.activity_recycler, parent, false);

        return new PlacesOfInterestViewHolder(locationView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesOfInterestViewHolder holder, int position) {
        PlacesOfInterest placesOfInterest = mPlacesOfInterest.get(position);

        TextView textView = holder.location;
        textView.setText(placesOfInterest.getName());

        Button button = holder.button;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlacesOfInterest.size();
    }

    public class PlacesOfInterestViewHolder extends RecyclerView.ViewHolder{
        public TextView location;
        public Button button;

        public PlacesOfInterestViewHolder (View view){
            super(view);

            location = view.findViewById(R.id.location_name);
            button = view.findViewById(R.id.details_button);
        }
    }
}
