package edu.hubu.xiaomishop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.hubu.xiaomishop.mapper")
public class XiaoMiShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaoMiShopApplication.class, args);
    }

}
