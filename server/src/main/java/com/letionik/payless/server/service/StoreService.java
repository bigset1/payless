package com.letionik.payless.server.service;

import com.letionik.payless.model.Store;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Path("/store")
public interface StoreService {

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	List<Store> searchStores(@QueryParam("latitude") double latitude,
			@QueryParam("longitude") double longitude, @QueryParam("distance") @DefaultValue("1.0") double distance);

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	Store getStoreById(@QueryParam("id") String id);
}
