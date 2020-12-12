package cn.kgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableCaching
@MapperScan("cn.kgc.mapper")
@SpringBootApplication
public class SchoolmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolmanagerApplication.class, args);
    }

}
