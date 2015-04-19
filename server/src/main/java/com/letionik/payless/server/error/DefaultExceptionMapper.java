package com.letionik.payless.server.error;

import com.letionik.payless.server.error.model.ErrorResponseBuilder;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Component
@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        return new ErrorResponseBuilder()
                .status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .message("An unexpected error occurred")
                .cause(e)
                .buildErrorResponse();

    }
}
