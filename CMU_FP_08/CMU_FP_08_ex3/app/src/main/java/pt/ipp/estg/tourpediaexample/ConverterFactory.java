package pt.ipp.estg.tourpediaexample;

import pt.ipp.estg.tourpediaexample.Interfaces.TourDataAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConverterFactory {
    public TourDataAPI getApi(){
        return getRetrofit().create(TourDataAPI.class);
    }

    private Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("http://tour-pedia.org/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
