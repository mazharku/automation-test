package com.mazhar.automation;

import com.mazhar.automation.model.DataSourceModel;
import com.mazhar.automation.worker.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomationService {
    @Autowired
    private DataSource dataSource;

    public List<DataSourceModel> loadData(){
         dataSource.loadData();
         return dataSource.getCountryList();
    }
}
