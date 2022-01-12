package de.fhswf.fit.service;

import de.fhswf.fit.model.Category;
import de.fhswf.fit.repositories.CategoryRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/category")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
      MediaType.TEXT_HTML })
@Produces({ MediaType.APPLICATION_JSON })
public class CategoryController
{
    @Inject
    CategoryRepository categoryRepository;

    @GET
    public Response getAll()
    {
        try
        {
            List<Category> categories = categoryRepository.findAll();
            if (categories.isEmpty())
            {
                return Response.noContent().build();
            }
            return Response.ok(categories).build();
        }
        catch (Exception exc)
        {
            return Response.serverError().build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id)
    {
        try
        {
            Category category = categoryRepository.findById(id);
            if (category == null)
                return Response.noContent().build();
            return Response.ok().build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }

    @POST
    public Response add(Category category)
    {
        try
        {
            return Response.ok(categoryRepository.update(category)).build();
        }
        catch (Exception e)
        {
            return Response.serverError().build();
        }
    }

}
