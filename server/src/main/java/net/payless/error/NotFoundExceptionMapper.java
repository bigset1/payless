package net.payless.error;

import org.springframework.stereotype.Component;

import javax.ws.rs.NotFoundException;
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

    @Override
    public Response toResponse(NotFoundException e) {
        return new ErrorResponseBuilder()
                .status(404)
                .cause(e)
                .message("Resource not found")
                .buildErrorResponse();
    }
}
