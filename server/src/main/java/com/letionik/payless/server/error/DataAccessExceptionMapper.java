package com.letionik.payless.server.error;

import com.letionik.payless.server.error.model.ErrorResponseBuilder;
import org.apache.http.HttpStatus;
import org.springframework.dao.DataAccessException;
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
public class DataAccessExceptionMapper implements ExceptionMapper<DataAccessException>{

    @Override
    public Response toResponse(DataAccessException e) {
        return new ErrorResponseBuilder()
                .status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                .message("An unexpected error occurred during accessing database")
                .cause(e)
                .buildErrorResponse();
    }
}
