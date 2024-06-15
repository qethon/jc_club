package org.chenqingci.subject.starter;

//import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description 刷题微服务
 * @Author 陈佳豪
 * @Date 2024/6/5
 * @Year 2024
 */
@SpringBootApplication
@ComponentScan("org.chenqingci")
@MapperScan("org.chenqingci.**.mapper")

public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
