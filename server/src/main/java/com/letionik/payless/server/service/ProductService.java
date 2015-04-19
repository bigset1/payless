package com.letionik.payless.server.service;

import com.letionik.payless.model.Product;
import com.letionik.payless.model.transport.PriceItemDTO;
import com.letionik.payless.model.transport.ProductSearchResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Path("/product")
public interface ProductService {

	@POST
	@Path("/priceItem")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    Response addPriceItem(PriceItemDTO priceItem) throws ServiceException;

	@GET
	@Path("/parse")
	@Produces(MediaType.APPLICATION_JSON)
	Product parseProduct(@QueryParam("barcode") String barcode) throws ServiceException;

	@GET
	@Path("/search/location")
	@Produces(MediaType.APPLICATION_JSON)
	List<ProductSearchResult> searchProductByLocation(@QueryParam("barcode") String barcode,
			@QueryParam("latitude") double latitude,
            @QueryParam("longitude") double longitude,
            @QueryParam("maxDistance") Double maxDistance);

	@GET
	@Path("/search/name")
	@Produces(MediaType.APPLICATION_JSON)
	List<Product> searchProductsByName(@QueryParam("name") String name,
                                       @QueryParam("number") @DefaultValue("10") int number) throws ServiceException;

	@GET
	@Path("/search/barcode")
	@Produces(MediaType.APPLICATION_JSON)
	Product searchProductByBarcode(@QueryParam("barcode") String barcode);

}
