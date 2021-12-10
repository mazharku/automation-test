package com.mazhar.automation.service;

import com.mazhar.automation.model.CountryDataFormat;
import com.mazhar.automation.model.DataSourceModel;
import com.mazhar.automation.worker.AutomationExecutor;
import com.mazhar.automation.worker.DataSource;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutomationService {
    final static Logger logger = LoggerFactory.getLogger(AutomationService.class);

    private final DataSource dataSource;
    private final AutomationExecutor executor;
    private List<CountryDataFormat> countryDataFormats = new ArrayList<>();

    public List<DataSourceModel> loadData(){
         dataSource.loadData();
         return dataSource.getCountryList();
    }

    public List<CountryDataFormat> show(DataSourceModel dataSourceModel) {
        List<CountryDataFormat> datas = executor.sendDataToUI(dataSourceModel);
        datas.addAll(countryDataFormats);
        return datas;
    }

    public String save() {
        if(countryDataFormats.isEmpty()) {
            return "No data found to save";
        }
        else {
            try {
                executor.writeToXML(countryDataFormats);
                return "Successfully sent data to FTP";
            } catch (IOException e) {
                logger.error(e.getMessage());
                return "Can not sent data to FTP!";
            }
        }
    }
}
