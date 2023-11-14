package pe.edu.vallegrande.ecommerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pizza Shop API")
                        .description("REST API Docs")
                        .license(new License().name("Valle Grande").url("https://vallegrande.edu.pe/"))
                        .version("1.0.0")
                );
    }

}
