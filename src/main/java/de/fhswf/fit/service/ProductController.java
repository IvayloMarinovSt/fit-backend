package de.fhswf.fit.service;

import de.fhswf.fit.model.Product;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

@Path("/product")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML})
@Produces({MediaType.APPLICATION_JSON})
public class ProductController {


	@GET
	public List<Product> getAll() {
		Product pr1 = new Product(null,
				"3231",
				"name",
				new BigDecimal(2),
				null,
				null,
				2,
				"desc");
		return Arrays.asList(pr1);
	}

	@POST
	public Product addProduct(Product product) {
		System.out.println(product);
//		return productRepository.save(product);
		return null;
//		TODO impl
	}

}
