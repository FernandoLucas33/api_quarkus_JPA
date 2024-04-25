package br.miestampaJPA;


import br.miestampaJPA.dao.UsuarioDao;
import br.miestampaJPA.models.Usuario;
import br.miestampaJPA.services.UsuarioService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@RequestScoped
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
    public  Response obtemUsuarioPorId(final @PathParam("id") long id){
        return Response.status(Response.Status.OK).entity(dao.BuscarUsuarioPorId(id)).build();
    }

    @POST
    public Response acresentaUsuario(Usuario usuario){
        return Response.status(Response.Status.CREATED).entity(dao.inseriUsuario(usuario)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response excluiUsuario(final  @PathParam("id") long id){
        return Response.status(Response.Status.OK).entity(dao.excluirUsuario(id)).build();
    }

    /*@PUT
    @Path("/{id}")
    public  Response atualizaUsuario(final @PathParam("idUsuario") Usuario usuario){
        return Response.status(Response.Status.OK).entity(dao.atualizaUsuario(usuario)).build();
    }*/
}
