package com.example.jy.myboard.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.example.jy.myboard")
@Import({DBConfig.class})
public class ApplicationConfig {
	

}
