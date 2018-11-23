package com.example.directories;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.directories.mapper")
public class DirectoriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DirectoriesApplication.class, args);
    }
}
