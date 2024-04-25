package br.miestampaJPA.dao;

import br.miestampaJPA.models.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
public class UsuarioDao {

    EntityManager em;

    public UsuarioDao(EntityManager em){
        this.em = em;
    }

    public List<Usuario> BuscarUsuarios(){
        String nameQuery = "LISTA_USUARIOS";
        TypedQuery<Usuario> query = em.createNamedQuery(nameQuery, Usuario.class);

        return query.getResultList();
    }

    public Usuario BuscarUsuarioPorId(long id){
        String nameQuery = "LISTA_USUARIO_ID";
        TypedQuery<Usuario> query = em.createNamedQuery(nameQuery, Usuario.class);
        query.setParameter("idUsuario", id);
        return query.getSingleResult();
    }
    @Transactional
    public int inseriUsuario(Usuario usuario){
        String nameQuery = "INSERI_USUARIO";
        Query query = em.createNamedQuery(nameQuery);
        query.setParameter("nome", usuario.getNome());
        query.setParameter("cpf", usuario.getCpf());
        query.setParameter("email", usuario.getEmail());
        query.setParameter("password", usuario.getPassword());
        return query.executeUpdate();
    }
    @Transactional
    public int atualizaUsuario(Usuario usuario){
        String nameQuery ="ATUALIZA_USUARIO";
        Query query = em.createNamedQuery(nameQuery);
        query.setParameter("idUsuario", usuario.getId());
        query.setParameter("nome", usuario.getNome());
        query.setParameter("cpf", usuario.getCpf());
        query.setParameter("email", usuario.getEmail());
        query.setParameter("password", usuario.getPassword());

        return query.executeUpdate();
    }

    @Transactional
    public int excluirUsuario(long id){
        String nameQuery = "EXCLUI_USUARIO";
        Query query = em.createNamedQuery(nameQuery);

        query.setParameter("idUsuario",id);

        return query.executeUpdate();
    }
}
