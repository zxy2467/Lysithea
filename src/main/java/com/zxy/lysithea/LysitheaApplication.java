package com.zxy.lysithea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LysitheaApplication {
/*
对于静态的资源放入类路径下static目录下
thymeleaf的模板放在templates目录下
spring boot默认的首页是static下的index.html或者是一个index控制器

 */
    public static void main(String[] args) {
        SpringApplication.run(LysitheaApplication.class, args);
    }

}
