package pt.ipp.estg.cmu_fp_05_ex2.models;

import java.io.Serializable;

public class City implements Serializable {
    private String city;
    private String country;
    private String description;

    public City(String city, String country) {
        this.city = city;
        this.country = country;
        this.description = "";
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
