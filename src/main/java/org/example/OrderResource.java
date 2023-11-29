package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/order")
public class OrderResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getOrders() {
        return OrderDAO.getAllOrders();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrder(@PathParam("id") int id) {
        return OrderDAO.getOrderById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addOrder(Order order) {
        OrderDAO.addOrder(order);
    }

    @DELETE
    @Path("/{id}")
    public void deleteOrder(@PathParam("id") int id) {
        OrderDAO.deleteOrder(id);
    }
}