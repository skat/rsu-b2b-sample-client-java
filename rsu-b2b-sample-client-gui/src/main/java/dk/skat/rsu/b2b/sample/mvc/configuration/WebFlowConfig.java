package dk.skat.rsu.b2b.sample.mvc.configuration;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

    @Autowired
    private WebMvcConfig webMvcConfig;

    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowRegistry())
            //.addFlowExecutionListener(new SecurityFlowExecutionListener(), "*")
            .build();
    }

    @Bean
    public FlowDefinitionRegistry flowRegistry() {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
            .setBasePath("/WEB-INF/flows")
            .addFlowLocationPattern("/**/*-flow.xml").build();
    }

    @Bean
    public FlowBuilderServices flowBuilderServices() {
        return getFlowBuilderServicesBuilder()
            .setViewFactoryCreator(mvcViewFactoryCreator())
            .setValidator(validator())
            .setDevelopmentMode(true)
            .build();
    }

    @Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator() {
        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
        factoryCreator.setViewResolvers(Collections.<ViewResolver>singletonList(this.webMvcConfig.thymeleafViewResolver()));
        factoryCreator.setUseSpringBeanBinding(true);
        return factoryCreator;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }

}
