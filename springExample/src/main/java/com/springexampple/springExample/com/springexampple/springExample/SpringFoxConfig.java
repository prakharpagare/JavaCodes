package com.springexampple.springExample.com.springexampple.springExample;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Component
public class SpringFoxConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(metaInfo());
//		.select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
	}
	
	private ApiInfo metaInfo() {
		ApiInfo api = new ApiInfo("SpringBootExample",
				"Some Description for the example",
				"v1", "www.google.com", 
				"ContactMe", null, null);
		return api;
		
	}
}
