package com.android.bytemarket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.android.bytemarket.dao")//不能少
public class BytemarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BytemarketApplication.class, args);
    }

}
