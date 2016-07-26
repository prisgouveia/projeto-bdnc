/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.servlets;

import br.edu.ifpb.bdnc.sosmulher.servicos.DenunciaService;
import br.edu.ifpb.bdnc.sosmulher.entidades.Denuncia;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
@WebServlet(name = "ExibirPontos", urlPatterns = {"/ExibirPontos"})
public class ExibirPontos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DenunciaService servico = new DenunciaService();
        List<Denuncia> denuncias = servico.exibirDenuncias();
        request.getSession().setAttribute("denuncias", denuncias);
        request.getSession().setAttribute("pointsLoaded", true);

        
        PrintWriter out = response.getWriter();

        out.println("<script>");
        out.println("alert('Deu certo!');");
        out.println("</script>");

        response.sendRedirect("index.jsp");
    }

}
