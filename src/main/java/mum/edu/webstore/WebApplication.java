package mum.edu.webstore;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }
   
    public static void main(String[] args) throws Exception {
    	
        SpringApplication.run(WebApplication.class, args);
    }
    @Bean(name = "messageSource")
	public MessageSource messageSource() {
    	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("validation");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}

	@Bean(name="localeChangeIntercepter")
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeIntercepter = new LocaleChangeInterceptor();		
		return localeChangeIntercepter;
	}
 
   
}
