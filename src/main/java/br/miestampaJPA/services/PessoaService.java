package br.miestampaJPA.services;

import br.miestampaJPA.dao.PessoaDao;
import br.miestampaJPA.models.Pessoa;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class PessoaService {

    @Inject
    PessoaDao dao;

    void validarPessoa(Pessoa pessoa){

    }

    @Transactional(rollbackOn = Exception.class)
    public int inserirPessoa(Pessoa pessoa){
        validarPessoa(pessoa);
        return dao.inserirPessoa(pessoa);
    }
}
