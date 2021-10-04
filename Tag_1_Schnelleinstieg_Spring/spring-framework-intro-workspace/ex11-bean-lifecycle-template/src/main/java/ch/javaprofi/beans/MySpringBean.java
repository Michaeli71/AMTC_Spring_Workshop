package ch.javaprofi.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
class MySpringBean implements BeanNameAware, ApplicationContextAware {

	@Override
	public void setBeanName(String name) {
		// ...
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// ...
	}
}
