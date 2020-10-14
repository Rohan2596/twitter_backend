package com.saptalabz.twitter_backend.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.saptalabz.twitter_backend"))
                .paths(PathSelectors.any()).build();
    }
    private ApiInfo getApiInfo() {
        Contact contact = new Contact("Rohan Kadam",
                "https://saptalabz.com/", "rohankadam662@gmail.com");
        return new ApiInfoBuilder().title("Twitter Api Backend")
                .description("Twitter Backend to fetchTweets by @username and #tag using twitter filter Stream Api." )
                .version("1.0")
                .license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").contact(contact)
                .build();
    }

}
