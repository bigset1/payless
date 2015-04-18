package com.letionik.payless.server.error.model;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.*;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class ErrorResponseBuilder {
	private Integer status = Status.INTERNAL_SERVER_ERROR.getStatusCode();
	private String message;
	private String developerMessage;
	private String exceptionClass;

	public ErrorResponseBuilder status(int status) {
		this.status = status;
		return this;
	}

	public ErrorResponseBuilder message(String message) {
		this.message = message;
		return this;
	}

	public ErrorResponseBuilder developerMessage(String developerMessage) {
		this.developerMessage = developerMessage;
		return this;
	}

	public ErrorResponseBuilder cause(Throwable throwable) {
		exceptionClass = throwable.getClass().getCanonicalName();
		message(throwable.getLocalizedMessage());
		developerMessage(getStackTrace(throwable));
		return this;
	}

	private String getStackTrace(Throwable exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, true);
		exception.printStackTrace(pw);
		return sw.getBuffer().toString();
	}

	public Error buildError() {
        Error error = new com.letionik.payless.server.error.model.Error();
        error.setStatus(status);
        error.setMessage(message);
        error.setDeveloperMessage(developerMessage);
        error.setExceptionClass(exceptionClass);
		return error;
	}

	public Response buildErrorResponse() {
		Error error = buildError();
		return Response.status(status).type(MediaType.APPLICATION_JSON_TYPE).entity(error).build();
	}
}
