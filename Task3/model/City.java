package Task3.model;

import java.util.ArrayList;
import java.util.List;

public class City {
    String name;
    String state;
    List<TouristPlace> touristPlaces;

    public City(String name, String state) {
        this.name = name;
        this.state = state;
        touristPlaces=new ArrayList<>();
    }
}
