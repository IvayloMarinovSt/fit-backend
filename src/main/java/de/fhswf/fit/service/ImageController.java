package de.fhswf.fit.service;

import de.fhswf.fit.model.Image;
import de.fhswf.fit.repositories.ImageRepository;
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

@Path("/image")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
      MediaType.TEXT_HTML, MediaType.MULTIPART_FORM_DATA })
@Produces({ MediaType.APPLICATION_JSON })
public class ImageController
{
    @Inject
    ImageRepository imageRepository;

    @GET
    public Response getAll()
    {
        try
        {
            List<Image> categories = imageRepository.findAll();
            if (categories.isEmpty())
            {
                return Response.noContent().build();
            }
            return Response.ok(categories).build();
        }
        catch (Exception e)
        {
            return Response.serverError().entity(e.getMessage()).build();        }
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id)
    {
        try
        {
            Image image = imageRepository.findById(id);
            if (image == null)
                return Response.noContent().build();
            return Response.ok().build();
        }
        catch (Exception e)
        {
            return Response.serverError().entity(e.getMessage()).build();        }
    }

    @POST
    public Response add(Image image)
    {
        try
        {
            return Response.ok(imageRepository.create(image)).build();
        }
        catch (Exception e)
        {
            return Response.serverError().entity(e.getMessage()).build();        }
    }

    @DELETE
    public Response delete(Image image){
        try {
            imageRepository.delete(image);
            return Response.ok(image).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();        }
    }
}
