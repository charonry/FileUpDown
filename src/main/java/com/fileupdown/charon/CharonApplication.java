package com.fileupdown.charon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fileupdown.charon.file.dao")
public class CharonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CharonApplication.class, args);
    }

}
