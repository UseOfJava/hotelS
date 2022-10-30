package com.sdau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
/*过滤器*/
//@ServletComponentScan(basePackages = "com.sdau.filter")

public class HotelSApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotelSApplication.class,args);
    }
}
