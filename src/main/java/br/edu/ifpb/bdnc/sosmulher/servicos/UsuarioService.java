/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.servicos;

import br.edu.ifpb.bdnc.sosmulher.dao.UsuarioDAO;
import br.edu.ifpb.bdnc.sosmulher.dao.UsuarioDAOImpl;
import br.edu.ifpb.bdnc.sosmulher.entidades.Usuario;
/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public class UsuarioService {
    UsuarioDAO dao = new UsuarioDAOImpl();
    
    public void salvar(Usuario usuario){
        dao.cadastrar(usuario);
    }
    
    public Usuario buscar(String email){
        return dao.buscar(email);
    }
}
