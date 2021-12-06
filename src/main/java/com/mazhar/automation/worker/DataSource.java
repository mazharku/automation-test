package com.mazhar.automation.worker;

import com.mazhar.automation.model.DataSourceModel;
import com.opencsv.CSVReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSource {
    final static Logger logger = LoggerFactory.getLogger(DataSource.class);
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
            logger.error("can't read data from CSV due to {}", e.getMessage());
        }

    }

    public List<DataSourceModel> getCountryList() {
        return dataSourceModelList;
    }
}
