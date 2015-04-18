package com.letionik.payless.server.error;

import com.letionik.payless.server.error.model.ErrorResponseBuilder;
import com.letionik.payless.server.service.ServiceException;
import org.apache.http.HttpStatus;
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
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException> {

    @Override
    public Response toResponse(ServiceException e) {
        return new ErrorResponseBuilder()
                .status(HttpStatus.SC_BAD_REQUEST)
                .message(e.getMessage())
                .cause(e)
                .buildErrorResponse();
    }
}
