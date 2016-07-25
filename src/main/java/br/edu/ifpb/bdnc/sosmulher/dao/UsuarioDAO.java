/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.dao;
import br.edu.ifpb.bdnc.sosmulher.entidades.Usuario;
/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public interface UsuarioDAO {
    public void cadastrar(Usuario usuario);
    public Usuario buscar(String email);
//    public Usuario login(String login);
}
