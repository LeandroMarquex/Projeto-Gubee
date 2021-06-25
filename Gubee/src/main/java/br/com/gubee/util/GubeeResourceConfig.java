package br.com.gubee.util;


import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8080/gubee/rest
@ApplicationPath("rest")
public class GubeeResourceConfig extends ResourceConfig {
	public GubeeResourceConfig(){
		packages("br.com.gubee.service");
	}
}
