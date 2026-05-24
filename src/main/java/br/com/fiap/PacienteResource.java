package br.com.fiap;

import br.com.fiap.entities.Paciente;
import br.com.fiap.bo.PacienteBO;
import br.com.fiap.exceptions.CpfInvalidoException;
import br.com.fiap.exceptions.EnderecoNaoEncontradoException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;
import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/paciente")
public class PacienteResource {

    private PacienteBO pacienteBO = new PacienteBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Paciente> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Paciente>) pacienteBO.selecionarBo();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente buscarPorID(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        return PacienteBO.buscarPorID(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Paciente paciente, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException, EnderecoNaoEncontradoException, CpfInvalidoException {
        PacienteBO.inserirBo(paciente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(paciente.getId()));
        return Response.created(builder.build()).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Paciente paciente) throws ClassNotFoundException, SQLException {
        pacienteBO.atualizarBo(paciente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        pacienteBO.deletarBo(id);
        return Response.ok().build();
    }

}
