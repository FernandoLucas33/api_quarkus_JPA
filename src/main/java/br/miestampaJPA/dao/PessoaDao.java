package br.miestampaJPA.dao;

import br.miestampaJPA.models.Pessoa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import java.util.List;

@RequestScoped
public class PessoaDao {


    EntityManager entityManager;

    public PessoaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Pessoa> buscaPessoas(){
        String nameQuary ="LISTA_PESSOA";
        TypedQuery<Pessoa> query = entityManager.createNamedQuery(nameQuary,Pessoa.class);

        return query.getResultList();
    }
    public Pessoa buscaPessoaId(long id){
        String namedQuery = "CONSULTA_USUARIO_ID";
        TypedQuery<Pessoa> query = entityManager.createNamedQuery(namedQuery, Pessoa.class);
        query.setParameter("idPessoa", id);
        return query.getSingleResult();
    }

    public int inserirPessoa(Pessoa pessoa){
        String nameQuery = "INSERIR_PESSOA";
        return inserirOuAtualizar(pessoa, nameQuery);
    }

    private int inserirOuAtualizar(Pessoa pessoa, String nameQuery){

        Query query = entityManager.createNamedQuery(nameQuery);
        query.setParameter("idPessoa", pessoa.getIdPessoa());
        query.setParameter("nome", pessoa.getNome());
        query.setParameter("sobrenome", pessoa.getSobrenome());

        return query.executeUpdate();
    }

    @Transactional
    public int excluirPessoa(long idPessoa){
        String nameQuery = "EXCLUIR_PESSOA";
        Query query = entityManager.createNamedQuery(nameQuery);

        query.setParameter("idPessoa", idPessoa);

        return query.executeUpdate();
    }
}
