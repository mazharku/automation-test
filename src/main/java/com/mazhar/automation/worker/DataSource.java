package com.mazhar.automation.worker;

import com.mazhar.automation.model.Country;
import com.opencsv.CSVReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSource {
    private  List<Country> countryList= new ArrayList<>();

    public  void loadData() {
        try {
            File file = new ClassPathResource("data.csv").getFile();
            List<String[]> values;
            try (CSVReader reader = new CSVReader(new FileReader(file))) {
                values = reader.readAll();
            }
            for (int i = 1; i < values.size(); i++) {
                String[] country = values.get(i);
                countryList.add(new Country(country[0], country[1]));
            }
        }catch (Exception e) {

        }

    }

    public List<Country> getCountryList() {
        return countryList;
    }
}
