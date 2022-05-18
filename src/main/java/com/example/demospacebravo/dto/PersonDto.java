package com.example.demospacebravo.dto;

import com.example.demospacebravo.Annotation.Demo;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;


@ToString
public class PersonDto {

    @Demo(name = "John")
    private String name;
    @Demo(name = "Can")
    private Integer age;
    @Demo(name = "Haha")
    private String Address;
}
