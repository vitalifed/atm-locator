package com.backbase.assignment.solution.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.backbase.assignment.solution.util.JsonRawResponseProcessor;
import com.backbase.assignment.solution.util.JsonResponseProcessor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.backbase.assignment.solution"})
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration extends WebMvcConfigurerAdapter
{

	@Bean
	public JsonResponseProcessor processor(){
		return new JsonResponseProcessor();
	}
	
	@Bean
	public JsonRawResponseProcessor rawRrocessor(){
		return new JsonRawResponseProcessor();
	}
	
    @Bean
    public ViewResolver resolver()
    {
        UrlBasedViewResolver url = new UrlBasedViewResolver();
        url.setPrefix("/WEB-INF/views/");
        url.setViewClass(JstlView.class);
        url.setSuffix(".jsp");
        return url;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }
    
}
