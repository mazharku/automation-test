package com.mazhar.automation.worker;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mazhar.automation.model.CountryDataFormat;
import com.mazhar.automation.model.DataSourceModel;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutomationExecutor {
    final static Logger logger = LoggerFactory.getLogger(AutomationExecutor.class);

    private final String xmlLocation= "./input/test";
    private final DataSource dataSource;
    private final AutomationWorker worker;

    public void doStart(){
        try {
            dataSource.loadData();
            final List<CountryDataFormat> countryDataFormats = worker.startProcess();
            writeToXML(countryDataFormats);
        } catch (IOException e) {
           logger.debug("Can't load data due to: {} ", e.getMessage());
        }
    }
    public List<CountryDataFormat> sendDataToUI(DataSourceModel dataSourceModel) {
       return worker.loadDataFromUI(dataSourceModel);
    }

    public void writeToXML(List<CountryDataFormat> countryDataFormats) throws IOException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            File file = new File(xmlLocation+System.currentTimeMillis()+".xml");
            xmlMapper.writeValue(byteArrayOutputStream, countryDataFormats);
            boolean exists = file.exists();
            if(!exists) {
                file.createNewFile();
            }
            try(OutputStream outputStream = new FileOutputStream(file)) {
                byteArrayOutputStream.writeTo(outputStream);
            }
        } catch (IOException e) {
           logger.error("can not write to a xml file due to {} ", e.getMessage());
        }

    }
}
