/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public class Conexao {

    private Connection conn;

    protected Conexao() {
        String url = "jdbc:postgresql://localhost:5432/sosmulher";
        String usuario = "postgres";
        String senha = "123";
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException();
        }
    }
    
    public Connection getConnection() throws SQLException{
        return conn;
    }
    
}
