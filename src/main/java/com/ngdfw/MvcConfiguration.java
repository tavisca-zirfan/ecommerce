package com.ngdfw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.ngdfw.furniture.controller.MenuInterceptor;
@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public MenuInterceptor getMenuInterceptor(){
		return new MenuInterceptor();
	}
	ApplicationContext applicationContext;
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
			"classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	@Bean
	public TemplateResolver getTemplateResolver(){
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setApplicationContext(applicationContext);
		resolver.setSuffix(".html");
		//resolver.setTemplateMode("LEGACYHTML5");
		return resolver;
	}
	@Bean
	public SpringTemplateEngine getTemplateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.addTemplateResolver(getTemplateResolver());
		return templateEngine;
	}
	@Bean
	public ViewResolver getViewResolver(){
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(getTemplateEngine());
		resolver.setOrder(1);
		return resolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		super.addInterceptors(registry);
		registry.addInterceptor(getMenuInterceptor());
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		if (!registry.hasMappingForPattern("/webjars/**")) {
			registry.addResourceHandler("/webjars/**").addResourceLocations(
					"classpath:/META-INF/resources/webjars/");
		}
		if (!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**").addResourceLocations(
					CLASSPATH_RESOURCE_LOCATIONS);
		}
	}
}
