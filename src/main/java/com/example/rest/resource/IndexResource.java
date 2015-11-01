package com.example.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author tada
 */
@Path("index")
public class IndexResource {
    
    @GET
    public Viewable index() {
        return new Viewable("index");
    }
    
}
