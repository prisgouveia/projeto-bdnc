/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.dao;

import br.edu.ifpb.conexao.CreateConnection;
import br.edu.ifpb.bdnc.sosmulher.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private Connection connection;

    public UsuarioDAOImpl(){
        try {
            this.connection = CreateConnection.criarConexao();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO USUARIO (nome, email, senha) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Usuario buscar(String email) {
        String sql = "SELECT * FROM usuario WHERE email ='" + email + "'";
        Usuario usuario = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }
            statement.close();
            connection.close();
            return usuario;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

//    public String login(String login) {
//        String senha = null;
//        String sql = "SELECT senha FROM usuario WHERE login = ?";
//        try {
//            PreparedStatement stat = connection.prepareStatement(sql);
//            stat.setString(1, login);
//            ResultSet rs = stat.executeQuery();
//            if (rs.next()) {
//                senha = rs.getString("senha");
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return senha;
//    }
    
}
