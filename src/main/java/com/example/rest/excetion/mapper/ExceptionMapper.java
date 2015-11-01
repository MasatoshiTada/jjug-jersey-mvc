package com.example.rest.excetion.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.server.mvc.Viewable;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        System.out.println("[START] ===================================");
        exception.printStackTrace(); // 本来はログを取る
        System.out.println("[END] ===================================");
        Viewable viewable = new Viewable("/WEB-INF/views/error/exception");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(viewable).build();
    }
    
}
