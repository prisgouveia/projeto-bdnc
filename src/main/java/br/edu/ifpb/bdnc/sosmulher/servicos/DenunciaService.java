/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.sosmulher.servicos;

import br.edu.ifpb.bdnc.sosmulher.dao.DenunciaDAO;
import br.edu.ifpb.bdnc.sosmulher.dao.DenunciaDAOImpl;
import br.edu.ifpb.bdnc.sosmulher.entidades.Denuncia;
import java.util.List;

/**
 *
 * @author Priscila Gouveia <priscilaggouveia@gmail.com>
 */
public class DenunciaService {
    DenunciaDAO dao = new DenunciaDAOImpl();
    
    public void cadastrarDenuncia(Denuncia denuncia){
        dao.cadastrarDenuncia(denuncia);
    }
    
    public List<Denuncia> exibirDenuncias(){
        return dao.exibirDenuncias();
    }    
    
}
