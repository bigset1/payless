package com.letionik.payless.server.filter;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Component
@Provider
public class CharacterEncodingFilter implements ContainerResponseFilter {

    public static final String CHARSET = ";charset=UTF-8";

    @Context
    private HttpServletResponse response;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext containerResponseContext) throws IOException {
        String contentType = containerResponseContext.getStringHeaders().getFirst(HttpHeaders.CONTENT_TYPE);
        if (contentType != null) {
            response.setHeader(HttpHeaders.CONTENT_TYPE, contentType + CHARSET);
        }
    }
}