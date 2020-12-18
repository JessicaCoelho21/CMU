package pt.ipp.estg.tourpediaexample.Interfaces;

import java.util.List;

import pt.ipp.estg.tourpediaexample.Models.PlacesOfInterest;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TourDataAPI {
    @GET("getPlaces")
    Call<List<PlacesOfInterest>> getPointsOfInterest(@Query("location") String location, @Query("name") String name);
}
