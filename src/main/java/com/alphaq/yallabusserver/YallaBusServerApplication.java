package com.alphaq.yallabusserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.alphaq.yallabusserver")
public class YallaBusServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(YallaBusServerApplication.class, args);
    }

}
