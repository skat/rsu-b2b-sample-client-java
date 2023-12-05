package dk.skat.rsu.b2b.sample.mvc.configuration;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.servlet.ServletContext;
import org.springframework.context.annotation.ComponentScan;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.webflow.view.AjaxThymeleafViewResolver;
import org.thymeleaf.spring6.webflow.view.FlowAjaxThymeleafView;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@EnableWebMvc
@Configuration
@ComponentScan({
    "dk.skat.rsu.b2b.sample.mvc"
})
public class WebMvcConfig implements WebMvcConfigurer, ServletContextAware {

    @Autowired
    private WebFlowConfig webFlowConfig;

    private ServletContext servletContext;


    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/", "classpath:/META-INF/web-resources/");
    }


    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public FlowHandlerMapping flowHandlerMapping() {
        FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
        handlerMapping.setOrder(-1);
        handlerMapping.setFlowRegistry(this.webFlowConfig.flowRegistry());
        return handlerMapping;
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter() {
        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
        handlerAdapter.setFlowExecutor(this.webFlowConfig.flowExecutor());
        handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
        return handlerAdapter;
    }

    @Bean
    public AjaxThymeleafViewResolver thymeleafViewResolver() {
        AjaxThymeleafViewResolver viewResolver = new AjaxThymeleafViewResolver();
        viewResolver.setViewClass(FlowAjaxThymeleafView.class);
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine(){

        Set<IDialect> dialects = new LinkedHashSet();
        dialects.add(new SpringSecurityDialect());

        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setAdditionalDialects(dialects);
        return templateEngine;
    }

    @Bean
    public WebApplicationTemplateResolver templateResolver() {
        IWebApplication application = JakartaServletWebApplication.buildApplication(this.servletContext);
        WebApplicationTemplateResolver resolver = new WebApplicationTemplateResolver(application);
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }

}
