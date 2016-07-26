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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            String coordenada = request.getParameter("coordenada");
            String coord[] = coordenada.split(", ");
            String ocorrencia = request.getParameter("ocorrencia");
            String dt = request.getParameter("data");
            String situacao = request.getParameter("situacao");
            String info = request.getParameter("info");
            DenunciaService servico = new DenunciaService();
            Denuncia denuncia = new Denuncia();
            denuncia.setOcorrencia(ocorrencia);
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            Date data = df.parse(dt);

            denuncia.setData(data);
            denuncia.setSituacao(situacao);
            denuncia.setInfo(info);

            WKTReader reader = new WKTReader();
            Geometry ponto = reader.read("POINT(" + coord[0].replace("(", " ") + " " + coord[1].replace(")", " ") + ")");
            denuncia.setLocalizacao(ponto);
            servico.cadastrarDenuncia(denuncia);
            System.out.println(denuncia.getLocalizacao().toText());
            response.sendRedirect("ExibirPontos");
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (java.text.ParseException ex) {
            Logger.getLogger(CadastrarDenuncia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
