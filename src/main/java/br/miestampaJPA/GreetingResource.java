package br.miestampaJPA;

import br.miestampaJPA.dao.PessoaDao;
import br.miestampaJPA.services.PessoaService;
import br.miestampaJPA.models.Pessoa;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/pessoas")
public class GreetingResource {

    @Inject
    PessoaService service;

    @Inject
    PessoaDao dao;

    @GET
    public Response obtemPessoas(){
        return Response.status(Response.Status.OK).entity(dao.buscaPessoas()).build();
    }

    @GET
    @Path("/{idPessoa}")
    public Response obtemPessoaPorId(final @PathParam("idPessoa") long idPessoa){
        return Response.status(Response.Status.OK).entity(dao.buscaPessoaId(idPessoa)).build();
    }

    @POST
    public Response inserirPessoa(Pessoa pessoa){
        return Response.status(Response.Status.CREATED).entity(service.inserirPessoa(pessoa)).build();
    }

    @DELETE
    @Path("/{idPessoa}")
    public Response excluirPessoa(final @PathParam("idPessoa") long idPessoa){
        return Response.status(Response.Status.OK).entity(dao.excluirPessoa(idPessoa)).build();
    }

}
