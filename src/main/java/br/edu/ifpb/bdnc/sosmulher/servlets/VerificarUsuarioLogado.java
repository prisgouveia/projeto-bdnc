/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.servlets;

import br.edu.ifpb.bdnc.sosmulher.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public class VerificarUsuarioLogado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
        if(usuario != null){
            response.sendRedirect("nova-denuncia.jsp");
        }else {
            response.sendRedirect("login.html");
        }
    }

}
