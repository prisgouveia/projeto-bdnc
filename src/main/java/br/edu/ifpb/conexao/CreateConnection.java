/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.conexao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public class CreateConnection {
    public static Connection criarConexao() throws SQLException{
        return new Conexao().getConnection();
    }
}
