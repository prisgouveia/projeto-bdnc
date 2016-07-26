/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.dao;

import br.edu.ifpb.conexao.CreateConnection;
import br.edu.ifpb.bdnc.sosmulher.entidades.Denuncia;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.io.WKTReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public class DenunciaDAOImpl implements DenunciaDAO {

    private Connection connection;

    public DenunciaDAOImpl() {
        try {
            this.connection = CreateConnection.criarConexao();
        } catch (SQLException ex) {
            Logger.getLogger(DenunciaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cadastrarDenuncia(Denuncia denuncia) {
        String sql = "INSERT INTO DENUNCIA (ocorrencia, situacao, info, ponto, data) VALUES "
                + "(?, ?, ?, st_geomFromText('Point(" + denuncia.getLocalizacao().getCoordinate().x + " "
                + denuncia.getLocalizacao().getCoordinate().y + ")'), ? )";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, denuncia.getOcorrencia());
            statement.setString(5, denuncia.getData().toString());
            statement.setString(2, denuncia.getSituacao());
            statement.setString(3, denuncia.getInfo());
            statement.execute();
            statement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Denuncia> exibirDenuncias() {
        List<Denuncia> denuncias = new ArrayList<>();
        String sql = "SELECT ST_AsText(d.ponto) ponto, d.id, d.ocorrencia, d.situacao, d.info, d.data FROM Denuncia d";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Denuncia denuncia = new Denuncia();
                denuncia.setId(resultSet.getInt("id"));
                denuncia.setOcorrencia(resultSet.getString("ocorrencia"));
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                java.util.Date data = df.parse(resultSet.getString("data"));
                denuncia.setData(data);
                denuncia.setSituacao(resultSet.getString("situacao"));
                denuncia.setInfo(resultSet.getString("info"));
                WKTReader reader = new WKTReader();
                Geometry geometry = reader.read(resultSet.getString("ponto"));
                denuncia.setLocalizacao(geometry);
                denuncia.setLat(geometry.getCoordinate().x);
                denuncia.setLgt(geometry.getCoordinate().y);
                denuncias.add(denuncia);
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return denuncias;
    }

}
