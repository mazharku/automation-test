package com.mazhar.automation.worker;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mazhar.automation.model.CountryDataFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutomationExecutor {
    private final String xmlLocation= "./input/test";
    private final DataSource dataSource;
    private final AutomationWorker worker;

    public void doStart(){
        try {
            dataSource.loadData();
            final List<CountryDataFormat> countryDataFormats = worker.startProcess();
            writeToXML(countryDataFormats);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToXML(List<CountryDataFormat> countryDataFormats) throws IOException {
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

    }
}
