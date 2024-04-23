package br.miestampaJPA;


import br.miestampaJPA.dao.UsuarioDao;
import br.miestampaJPA.models.Usuario;
import br.miestampaJPA.services.UsuarioService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


@Path("/v1/usuario")
public class UsuarioResource {

    @Inject
    UsuarioService service;

    @Inject
    UsuarioDao dao;

    @GET
    public Response obtemUsuarios(){
        return Response.status(Response.Status.OK).entity(dao.BuscarUsuarios()).build();
    }

    @GET
    @Path("/{id}")
    public  Response obtemUsuarioPorId(final @PathParam("idUsuario") long id){
        return Response.status(Response.Status.OK).entity(dao.BuscarUsuarioPorId(id)).build();
    }

    @POST
    public Response acresentaUsuario(Usuario usuario){
        return Response.status(Response.Status.CREATED).entity(dao.inserirUsuario(usuario)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluiUsuario(final  @PathParam("idUsuario") long id){
        return Response.status(Response.Status.OK).entity(dao.excluirUsuario(id)).build();
    }

    @PUT
    @Path("/{id}")
    public  Response atualizaUsuario(final @PathParam("idUsuario") long id, Usuario usuario){
        return Response.status(Response.Status.OK).entity(service.AtualizaUsuario(id, usuario)).build();
    }
}
