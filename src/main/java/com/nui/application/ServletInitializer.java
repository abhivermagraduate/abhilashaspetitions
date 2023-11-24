/**
 * @author Abhilasha Verma
 * Email : A.Verma7@nuigalway.ie 
 * Student Number : 22102028
 */
package com.nui.application;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.nui.controller.PetitionController;

/**
 * Purpose of this ServletInitializer is to runs a SpringApplication from a traditional WAR archive deployed on a web container. 
 * This SpringBootServletInitializer binds Servlet, Filter and ServletContextInitializer beans from the application context to the server.
 *  
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * This method configure the application.
	 * @param application
	 * @return application
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PetitionController.class);
	}

}
