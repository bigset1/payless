package com.letionik.payless.server.service;

import com.letionik.payless.model.transport.BasketSearchResult;
import org.springframework.stereotype.Component;

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
@Component
@Path("/basket")
public interface BasketService {

	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	List<BasketSearchResult> searchBasket(@QueryParam("barcodeList") List<String> barcodeList,
			@QueryParam("latitude") double latitude, @QueryParam("longitude") double longitude);
}
