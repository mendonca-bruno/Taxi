/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Motocicleta;

/**
 *
 * @author BrunoPC
 */

@ManagedBean (name="MotoGerenciar")
@ViewScoped
public class MotoGerenciar implements Serializable{
    private List<Motocicleta> motos;
    private Dao<Motocicleta> dao;
    private Motocicleta novo;
    private boolean mostraPopupNovo;

    public boolean isMostraPopupNovo() {
        return mostraPopupNovo;
    }

    public void setMostraPopupNovo(boolean mostraPopupNovo) {
        this.mostraPopupNovo = mostraPopupNovo;
    }
    
    public MotoGerenciar(){
        dao = new Dao(Motocicleta.class);
        novo = new Motocicleta();
        motos = dao.listarTodos();
        mostraPopupNovo = false; 
    }
    
    public void excluirMoto(Motocicleta u){
        dao.excluir(u.getId());
        motos.remove(u); // remove da List
    }
    public void inserirCliente(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Veiculo cadastrado", null));
        motos = dao.listarTodos();
        novo = new Motocicleta();
    }
    
    public void abrirPopupNovo(Motocicleta u) {
        this.mostraPopupNovo = true;
        
    }
    
    public void fecharPopupNovo(){
        mostraPopupNovo = false;
    }

    public List<Motocicleta> getMotos() {
        return motos;
    }

    public void setMotos(List<Motocicleta> motos) {
        this.motos = motos;
    }

    public Dao<Motocicleta> getDao() {
        return dao;
    }

    public void setDao(Dao<Motocicleta> dao) {
        this.dao = dao;
    }

    public Motocicleta getNovo() {
        return novo;
    }

    public void setNovo(Motocicleta novo) {
        this.novo = novo;
    }
    
}
