package com.mazhar.automation.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Teacher {
    private String name;
    private String subject;
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Student> students;
}
