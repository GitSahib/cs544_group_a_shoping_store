package mum.edu.webstore;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.braintreegateway.BraintreeGateway;

@Component
public class WebStoreAppCtxHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;
    public static String DEFAULT_CONFIG_FILENAME = "/resources/config.properties";
    public static BraintreeGateway gateway;
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    	WebStoreAppCtxHolder.applicationContext = applicationContext;
    	gateway = BTGatewayFactory.fromStaticConfig();
    }
}