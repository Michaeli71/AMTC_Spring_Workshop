package ch.javaprofi.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean
		implements ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
		BeanNameAware, LoadTimeWeaverAware, MessageSourceAware, NotificationPublisherAware, ResourceLoaderAware,
		InitializingBean, DisposableBean {
	
	
	// technische Dinge  *Aware interfaces for specific behavior
	
	@Override
	public void setResourceLoader(ResourceLoader arg0) {
		System.out.println("setResourceLoader");
	}

	@Override
	public void setNotificationPublisher(NotificationPublisher arg0) {
		System.out.println("setNotificationPublisher");

	}

	@Override
	public void setMessageSource(MessageSource arg0) {
		System.out.println("setMessageSource");
	}

	@Override
	public void setLoadTimeWeaver(LoadTimeWeaver arg0) {
		System.out.println("setLoadTimeWeaver");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("setBeanName");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("setBeanFactory");
	}

	@Override
	public void setBeanClassLoader(ClassLoader arg0) {
		System.out.println("setBeanClassLoader");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		System.out.println("setApplicationEventPublisher");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("setApplicationContext");
	}
	
	// InitializingBean, DisposableBean 
	
    @Override
    public void afterPropertiesSet() throws Exception
    {
    	System.out.println("afterPropertiesSet");
    }
     
    @Override
    public void destroy() throws Exception 
    {
    	System.out.println("destroy");
    }
    
	// eigene Callbacks
	
	// => neue Abhängigkeit => Achtung: wird nicht ausgewertet, wenn nur XML-Config!!!
	
    @PostConstruct
    public void customInit() 
    {
        System.out.println("Method LifeCycleDemoBean::customInit() invoked...");
    }
     
    @PreDestroy
    public void customDestroy() 
    {
        System.out.println("Method LifeCycleDemoBean::customDestroy() invoked...");
    }

}
