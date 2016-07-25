/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.entidades;

import com.vividsolutions.jts.geom.Geometry;
import java.util.Date;


/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public class Denuncia {
    private long id;
    private String info;
    private Geometry localizacao;
    private Date data;
    private String situacao;
    private String ocorrencia;
    private double lat;
    private double lgt;

    public Denuncia() {
    }

    public Denuncia(long id, String info, Geometry localizacao, Date data, String situacao, String ocorrencia, double lat, double lgt) {
        this.id = id;
        this.info = info;
        this.localizacao = localizacao;
        this.data = data;
        this.situacao = situacao;
        this.ocorrencia = ocorrencia;
        this.lat = lat;
        this.lgt = lgt;
    }

   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Geometry getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Geometry localizacao) {
        this.localizacao = localizacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLgt() {
        return lgt;
    }

    public void setLgt(double lgt) {
        this.lgt = lgt;
    }

    public void setData(String data) {
        this.data = new java.util.Date();
        int ano = Integer.parseInt(data.substring(0, 4));
        int mes = Integer.parseInt(data.substring(5, 7));
        this.data.setYear(ano);
        this.data.setMonth(mes);
    }

    
    
}
