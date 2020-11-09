package pt.ipp.estg.cmu_fp_05_ex2.models;

import java.io.Serializable;

public class City implements Serializable {
    private String city;
    private String country;
    private String description;

    public City(String city, String country, String description) {
        this.city = city;
        this.country = country;
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getDescription() {
        return description;
    }
}
