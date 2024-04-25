package br.miestampaJPA.services;

import br.miestampaJPA.dao.UsuarioDao;
import br.miestampaJPA.models.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@RequestScoped
public class UsuarioService {

    @Inject
    UsuarioDao dao;

    void validaUsuario(Usuario usuario){

    }
    @Transactional(rollbackOn = Exception.class)
    public int AtualizaUsuario(long id, Usuario usuario){
        usuario.setId(id);
        validaUsuario(usuario);
        return dao.inseriUsuario(usuario);
    }

}
