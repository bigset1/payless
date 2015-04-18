package com.letionik.payless.server.service;

import com.letionik.payless.model.Product;
import com.letionik.payless.model.transport.PriceItemDTO;
import com.letionik.payless.model.transport.ProductSearchResult;
import org.xml.sax.SAXException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
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
	void addPriceItem(PriceItemDTO priceItem) throws ServiceException, ParserConfigurationException, SAXException;

	@GET
	@Path("/parse")
	@Produces(MediaType.APPLICATION_JSON)
	Product parseProduct(@QueryParam("barcode") String barcode)
			throws IOException, ServiceException, ParserConfigurationException, SAXException;

	@GET
	@Path("/search/location")
	@Produces(MediaType.APPLICATION_JSON)
	List<ProductSearchResult> searchProductByLocation(@QueryParam("barcode") String barcode,
			@QueryParam("latitude") double latitude, @QueryParam("longitude") double longitude);

	@GET
	@Path("/search/name")
	@Produces(MediaType.APPLICATION_JSON)
	List<Product> searchProductsByName(@QueryParam("name") String name,
                                       @QueryParam("page") @DefaultValue("0") Integer page,
                                       @QueryParam("perPage") @DefaultValue("5") Integer perPage);

	@GET
	@Path("/search/barcode")
	@Produces(MediaType.APPLICATION_JSON)
	Product searchProductByBarcode(@QueryParam("barcode") String barcode);

}
