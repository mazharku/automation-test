package com.mazhar.automation.worker;

import com.mazhar.automation.model.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Data {
    public static List<Country> countryList= new ArrayList<>();

    public static void loadData() {
        countryList.add(new Country("Norway","Oslo"));
        countryList.add(new Country("Denmark","Copenhagen"));
        countryList.add(new Country("United Kingdom","London"));
        countryList.add(new Country("Serbia","�a�ak"));
        countryList.add(new Country("Bosnia and Herzegovina","Banja Luka"));

    }
}
