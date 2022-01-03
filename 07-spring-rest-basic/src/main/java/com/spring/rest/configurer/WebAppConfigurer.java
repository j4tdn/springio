package com.spring.rest.configurer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("com.spring.rest")
@EnableWebMvc
public class WebAppConfigurer implements WebMvcConfigurer {

}
