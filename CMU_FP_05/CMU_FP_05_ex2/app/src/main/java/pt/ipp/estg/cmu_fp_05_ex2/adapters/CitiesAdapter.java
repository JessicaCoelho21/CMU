package pt.ipp.estg.cmu_fp_05_ex2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.ipp.estg.cmu_fp_05_ex2.R;
import pt.ipp.estg.cmu_fp_05_ex2.models.City;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder> {
    private Context mContext;
    private List <City> mCities;

    public CitiesAdapter(Context mContext, List<City> mCities) {
        this.mContext = mContext;
        this.mCities = mCities;
    }

    @Override
    public CitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Get layout inflater from context
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //Inflate layout
        View citiesView = inflater.inflate(R.layout.items_cities, parent, false);

        //Return a new holder instance
        return new CitiesViewHolder(citiesView);
    }

    @Override
    public void onBindViewHolder(CitiesAdapter.CitiesViewHolder holder, int position) {
        //Get the data model based on position
        City city = mCities.get(position);

        //Set name
        TextView cityName = holder.nameCity;
        TextView countryName = holder.nameCountry;

        cityName.setText(city.getCity());
        countryName.setText(city.getCountry());
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    public class CitiesViewHolder extends RecyclerView.ViewHolder{
        public TextView nameCity;
        public TextView nameCountry;
        public Button button;

        public CitiesViewHolder(View itemView) {
            super(itemView);

            nameCity = itemView.findViewById(R.id.city_name);
            nameCountry = itemView.findViewById(R.id.country_name);
            button = itemView.findViewById(R.id.button);
        }
    }
}
