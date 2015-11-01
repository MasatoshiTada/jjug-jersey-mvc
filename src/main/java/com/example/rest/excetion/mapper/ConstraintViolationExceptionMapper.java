package com.example.rest.excetion.mapper;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.mvc.Viewable;

@Provider
public class ConstraintViolationExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        exception.printStackTrace();
        String[] messages = exception.getConstraintViolations()
                .stream()
                .map(violation -> violation.getMessage())
                .toArray(String[]::new);
        Viewable viewable = new Viewable("/WEB-INF/views/error/validationError", messages);
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(viewable).build();
    }
    
}
