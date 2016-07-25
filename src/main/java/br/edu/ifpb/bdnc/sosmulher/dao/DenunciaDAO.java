/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.dao;

import br.edu.ifpb.bdnc.sosmulher.entidades.Denuncia;
import java.util.List;

/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public interface DenunciaDAO {
    public void cadastrarDenuncia(Denuncia denuncia);
    public List<Denuncia> exibirDenuncias();
}
