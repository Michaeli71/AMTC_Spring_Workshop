package ch.javaprofi_academy.web.webinitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import ch.javaprofi_academy.web.config.WebAppConfig;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
		webCtx.register(WebAppConfig.class);

		DispatcherServlet dispatcherServler = new DispatcherServlet(webCtx);
		Dynamic dynamic = servletContext.addServlet("dispatcher", dispatcherServler);
		dynamic.setLoadOnStartup(1);
		dynamic.addMapping("/*");
	}

}
