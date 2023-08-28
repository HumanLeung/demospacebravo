package com.example.demospacebravo;

import com.example.demospacebravo.Annotation.IndustryExt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@IndustryExt
public class DemoSpaceBravoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpaceBravoApplication.class, args);
    }

}
