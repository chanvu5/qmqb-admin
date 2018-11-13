package com.hzed.qmqb.admin.infrastructure.config.shiro;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author guichang
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    @Profile({"dev", "test"})
    public Docket createRestApi() {
        /*Parameter tokenPar = new ParameterBuilder()
                .name("token")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();*/

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("后台管理系统接口")
                .termsOfServiceUrl("http://www.hzed.com/")
                .version("1.0")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hzed.qmqb.admin"))
                .paths(PathSelectors.any())
                .build()/*.globalOperationParameters(Lists.newArrayList(tokenPar))*/;
    }

}