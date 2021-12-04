package com.mazhar.automation.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileRouter extends RouteBuilder {

    @Value("${ftp.server}")
    private String hostUrl;
    @Value("${ftp.user}")
    private String userName;
    @Value("${ftp.password}")
    private String password;
    @Value("${ftp.output.folder}")
    private String outputFolderName;

    @Override
    public void configure() throws Exception {
        from("file:input")
                /*.choice()
                .when(simple("${in.header.CamelFileName} contains '.xlsx'"))*/
                .to(getFTPConnectionString());
                /*.otherwise()
                .to("log://org.apache.camel.howto?showAll=true&level=DEBUG");*/
    }

    private String getFTPConnectionString() {
        return "ftp://"+userName+"@"+hostUrl+outputFolderName+"?password="+password;
    }
}
