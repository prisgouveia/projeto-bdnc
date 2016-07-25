/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.servlets;

import br.edu.ifpb.bdnc.sosmulher.servicos.DenunciaService;
import br.edu.ifpb.bdnc.sosmulher.entidades.Denuncia;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
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
public class CadastrarDenuncia extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String lat = request.getParameter("latitude");
        String lgt = request.getParameter("longitude");
        String ocorrencia = request.getParameter("ocorrencia");
        String data = request.getParameter("data");
        String situacao = request.getParameter("situacao");
        String info = request.getParameter("info");
        DenunciaService servico = new DenunciaService();
        Denuncia denuncia = new Denuncia();
        denuncia.setOcorrencia(ocorrencia);
        denuncia.setData(data);
        denuncia.setSituacao(situacao);
        denuncia.setInfo(info);
        try {
            WKTReader reader = new WKTReader();
            Geometry ponto = reader.read("POINT("+lat+" "+ lgt+")");
            denuncia.setLocalizacao(ponto);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        servico.cadastrarDenuncia(denuncia);
        response.sendRedirect("ExibirDenuncias");
    }
    
}
