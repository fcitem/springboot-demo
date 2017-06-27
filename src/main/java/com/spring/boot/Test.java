package com.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
@SpringBootApplication  
public class Test {  
    
  @RequestMapping("/")  
  public String hello(){  
    return "Hello world!";  
  }  
    
  public static void main(String[] args) {  
          SpringApplication.run(Test.class, args);  
  }  
}  