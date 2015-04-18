package com.letionik.payless.server.error;

import com.letionik.payless.server.error.model.ErrorResponseBuilder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Provider
@Component
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException>{

    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(NotFoundException e) {
        return new ErrorResponseBuilder()
                .status(404)
                .message("Requested resource '" + request.getRequestURI() + "' was not found")
                .buildErrorResponse();
    }
}
