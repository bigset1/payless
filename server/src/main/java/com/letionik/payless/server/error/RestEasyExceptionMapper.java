package com.letionik.payless.server.error;

import org.jboss.resteasy.spi.Failure;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Provider
@Component
public class RestEasyExceptionMapper implements ExceptionMapper<Failure> {

	@Override
	public Response toResponse(Failure exception) {
		return new ErrorResponseBuilder().status(exception.getErrorCode())
				.cause(exception).buildErrorResponse();
	}

}
