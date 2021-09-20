package resultsconsumer.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .tags(
                        new Tag("Resultados",
                                "Endpoint para listar todas os resultados de todas as votações")
                )
                .select()
                .apis(RequestHandlerSelectors.basePackage("resultsconsumer.entities"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Results Consumer")
                .description("API with Kafka Consumer for to consume Back Vote Challenge API")
                .version("v1")
                .contact(
                        new Contact("Matheus Carvalho",
                                "https://www.linkedin.com/in/matheus-carvalho69",
                                "matheus9126@gmail.com"))
                .build();
    }


}
