package com.mazhar.automation.worker;

import com.mazhar.automation.model.DataSourceModel;
import com.opencsv.CSVReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSource {
    private List<DataSourceModel> dataSourceModelList = new ArrayList<>();

    public void loadData() {
        try {
            File file = new ClassPathResource("data.csv").getFile();
            List<String[]> values;
            try (CSVReader reader = new CSVReader(new FileReader(file))) {
                values = reader.readAll();
            }
            for (int i = 1; i < values.size(); i++) {
                String[] country = values.get(i);
                dataSourceModelList.add(new DataSourceModel(country[0], country[1], country[2]));
            }
        } catch (Exception e) {

        }

    }

    public List<DataSourceModel> getCountryList() {
        return dataSourceModelList;
    }
}
