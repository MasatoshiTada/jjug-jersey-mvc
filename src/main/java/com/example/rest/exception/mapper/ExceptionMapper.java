package com.example.rest.exception.mapper;

import com.example.rest.excetion.dto.ExceptionDto;
import java.util.ResourceBundle;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author tada
 */
@Provider
@ApplicationScoped
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {
    
    @Inject
    private ExceptionDto exceptionDto;
    
    @Override
    public Response toResponse(Exception exception) {
        fillExceptionDto(exception);
        System.out.println("errorType = " + exceptionDto.getErrorType() + " : message = " + exceptionDto.getMessages()[0]);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new Viewable("exception"))
                .build();
    }
    
    private void fillExceptionDto(Exception exception) {
        String exceptionClassName = exception.getClass().getName();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ExceptionMessages");
        String errorType;
        String message;
        if (resourceBundle.containsKey(exceptionClassName)) {
            errorType = resourceBundle.getString(exceptionClassName);
            message = resourceBundle.getString(exceptionClassName + "_detail");
        } else {
            errorType = resourceBundle.getString(Exception.class.getName());
            message = resourceBundle.getString(Exception.class.getName() + "_detail");
        }
        exceptionDto.setErrorType(errorType);
        exceptionDto.setMessages(message);
    }
}
