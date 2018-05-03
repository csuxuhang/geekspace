package com.csu.geekspace.detectsoftware;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.csu.geekspace.detectsoftware.mapper")
public class DetectsoftwareApplication {

    public static void main(String[] args) {
        SpringApplication.run(DetectsoftwareApplication.class, args);
    }

}

