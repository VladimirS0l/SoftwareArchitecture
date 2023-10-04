package ru.java.lesson10.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import ru.java.lesson10.exception.AppError;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Configuration
public class SwaggerConfig {
    TypeResolver typeResolver = new TypeResolver();
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).
            alternateTypeRules( AlternateTypeRules.newRule(
                    typeResolver.resolve(List.class, WildcardType.class),
                    typeResolver.resolve(Map.class, String.class, Object.class), Ordered.HIGHEST_PRECEDENCE))
                .select().apis(RequestHandlerSelectors
                .basePackage("ru.java.lesson10")).paths(PathSelectors.any()).build();
    }
}

