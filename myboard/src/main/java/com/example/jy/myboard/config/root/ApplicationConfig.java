package com.example.jy.myboard.config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.example.jy.myboard")
//@Import({DBConfig.class})
@Import({MyBatisConfig.class})
public class ApplicationConfig {
	
}
