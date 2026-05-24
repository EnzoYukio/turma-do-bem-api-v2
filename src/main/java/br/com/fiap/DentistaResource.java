package br.com.fiap;

import br.com.fiap.entities.Dentista;
import br.com.fiap.bo.DentistaBO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;
import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/dentista")
public class DentistaResource {

    private DentistaBO dentistaBO = new DentistaBO();

    // Selecionar todos os dentistas
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Dentista> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Dentista>) dentistaBO.selecionarBo();
    }

    // Buscar dentista por ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dentista buscarPorID(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        return dentistaBO.buscarPorIdBo(id);
    }

    // Inserir novo dentista
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Dentista dentista, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        DentistaBO.inserirBo(dentista);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(dentista.getIddentista()));
        return Response.created(builder.build()).build();
    }

    // Atualizar dentista
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Dentista dentista) throws ClassNotFoundException, SQLException {
        dentistaBO.atualizarBo(dentista);
        return Response.ok().build();
    }

    // Deletar dentista por ID
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        dentistaBO.deletarBo(id);
        return Response.ok().build();
    }

}
