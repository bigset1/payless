package com.letionik.payless.server.service;

import com.letionik.payless.model.transport.BasketQueryDTO;
import com.letionik.payless.model.transport.BasketSearchResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Path("/basket")
public interface BasketService {

    @POST
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	List<BasketSearchResult> searchBasket(BasketQueryDTO query);
}
