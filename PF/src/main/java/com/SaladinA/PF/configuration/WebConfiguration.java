package com.SaladinA.PF.configuration;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer{
	
//	@Bean
//	 public BCryptPasswordEncoder passwordEncoder() {
//	  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//	  return bCryptPasswordEncoder;
//	 }
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler(
	                "/fonts/**",
	                "/images/**",
	                "/css/**",
	                "/sass/**",
	                "/js/**")
	                .addResourceLocations(
	                        "classpath:/static/fonts/",
	                        "classpath:/static/images/",
	                        "classpath:/static/css/",
	                        "classpath:/static/sass/",
	                        "classpath:/static/js/");
	    }

}
