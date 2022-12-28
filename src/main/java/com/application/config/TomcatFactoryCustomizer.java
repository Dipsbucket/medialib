package com.application.config;

import org.apache.catalina.Context;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class TomcatFactoryCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public void customize(TomcatServletWebServerFactory factory) {
		factory.setContextPath("");
		factory.setPort(8080);

		final TomcatContextCustomizer customizer = new TomcatContextCustomizer() {
			@Override
			public void customize(Context context) {
				final StandardRoot standardRoot = new StandardRoot(context);
				final long cacheSize = 100 * 1024;
				standardRoot.setCacheMaxSize(cacheSize);
				context.setResources(standardRoot);
			}
		};

		factory.addContextCustomizers(customizer);
	}

}
