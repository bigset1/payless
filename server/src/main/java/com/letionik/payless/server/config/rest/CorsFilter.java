package com.letionik.payless.server.config.rest;

import org.springframework.stereotype.Component;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Provider
@Component
public class CorsFilter implements ContainerResponseFilter {

	public void filter(ContainerRequestContext cReq, ContainerResponseContext cResp) {
		cResp.getHeaders().add("Access-Control-Allow-Origin", "*");
		cResp.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, auth-token, X-Requested-With");
		cResp.getHeaders().add("Access-Control-Allow-Credentials", "true");
		cResp.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}

}
