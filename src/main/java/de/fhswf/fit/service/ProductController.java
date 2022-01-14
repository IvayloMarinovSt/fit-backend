package de.fhswf.fit.service;

import de.fhswf.fit.model.Product;
import de.fhswf.fit.repositories.ProductRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/product")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_HTML, MediaType.WILDCARD})
@Produces({MediaType.APPLICATION_JSON, MediaType.WILDCARD})
public class ProductController {

	@Inject
	ProductRepository productRepository;

	@GET
	public Response getAll() {
		try {
			List<Product> products = productRepository.findAll();
			if (products.isEmpty()) {
				return Response.noContent().build();
			}
			return Response.ok(products).build();
		} catch (Exception exc) {
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/{id}")
	public Response getById(@PathParam("id") Long id) {
		try {
			Product product = productRepository.findById(id);
			if (product == null)
				return Response.noContent().build();
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@POST
	public Response addProduct(Product product) {
		try {
			return Response.ok(productRepository.create(product)).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@DELETE
	public Response delete(Product product) {
		try {
			productRepository.delete(product);
			return Response.ok(product).build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}
