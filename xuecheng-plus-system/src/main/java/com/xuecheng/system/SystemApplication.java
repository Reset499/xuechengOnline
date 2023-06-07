package com.xuecheng.system;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.xuecheng.system.mapper")
@SpringBootApplication
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }
}
