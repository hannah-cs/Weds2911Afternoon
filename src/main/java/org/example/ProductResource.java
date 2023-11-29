package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/product")
public class ProductResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return ProductDAO.getAllProducts();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@PathParam("id") int id) {
        return ProductDAO.getProductById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(Product product) {
        ProductDAO.addProduct(product);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateProduct(@PathParam("id") int id, Product product) {
        product.setId(id);
        ProductDAO.updateProduct(product);
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(@PathParam("id") int id) {
        ProductDAO.deleteProduct(id);
    }
}