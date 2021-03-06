package com.biz.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * serlvet.xml을 대신할 클래스
 */
@Configuration
@EnableWebMvc

/*
 * servlet Config 에서 scan 하는 shop.controller, shop.service 패키지의
 * 클래스들에게 Transaction을 적용시키려면
 * servletConfig의 ComponentScan이 설정된 부분에
 * @EnableTranstionManagement 를 설정해 두어야 한다.
 */
@EnableTransactionManagement 
@ComponentScan(basePackages = { "com.biz.shop.controller", "com.biz.shop.service" })
public class ServletConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

		registry.addResourceHandler("/files/**")
				.addResourceLocations("/files/");

		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		
		registry.addResourceHandler("/upload/**")
			.addResourceLocations("file:///c:/bizwork/upload/");


		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	@Bean(name="filePath")
	public String filePath() {
		return "c:/bizwork/upload";
	}
	
	
	/*
	 * fileUpload를 하기 위한 설정
	 */
	@Bean(name="multipartResolver")
	public MultipartResolver multipartResolver() {
		MultipartResolver mr = new CommonsMultipartResolver();
		((CommonsMultipartResolver) mr).setMaxUploadSizePerFile(2_000_1000);

		((CommonsMultipartResolver) mr).setMaxUploadSize(20_000_000);
		return mr;
	}


	/*
	 * jsp Rendering을 위한 설정
	 */
	@Bean
	public InternalResourceViewResolver resolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
