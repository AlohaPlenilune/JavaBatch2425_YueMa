package com.plenilune.SpringBootPractice.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
        public Docket productApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.plenilune.SpringBootPractice"))
                    .paths(regex("/api.*"))
                    .build()
                    .apiInfo(metaInfo());
        }

        private ApiInfo metaInfo() {
            ApiInfo apiInfo = new ApiInfo("ProductItem Api",
                    "ProductItem Api method",
                    "1.0",
                    "Terms of Service",
                    new Contact("Plenilune","https://github.com/AlohaPlenilune","helloyuema@gmail.com"),
                    "License for productItem Details ",
                    "Url of productItem", Collections.EMPTY_LIST);
            return apiInfo;
        }
}
