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
import modelo.Cliente;

@ManagedBean (name="ClienteGerenciar")
@ViewScoped
public class ClienteGerenciar implements Serializable{
    private List<Cliente> clientes;
    private Dao<Cliente> dao;
    private Cliente novo;
    private Cliente temp;
    private boolean mostraPopupNovo;
    
    public ClienteGerenciar(){
        dao = new Dao(Cliente.class);
        novo = new Cliente();
        clientes = dao.listarTodos();
        mostraPopupNovo = false; 
    }
    public void excluirCliente(Cliente u){
        dao.excluir(u.getId());
        clientes.remove(u); // remove da List
    }
    public void inserirCliente(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Cliente cadastrado", null));
        clientes = dao.listarTodos();
        novo = new Cliente();
    }
    public void preparaEditarCliente(Cliente u){
        temp = u;
    }
    public void alterarCliente(){
        
        dao.alterar(temp);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Cliente atualizado!", null));
        
        
    }
    
    public void abrirPopupNovo(Cliente u) {
        this.mostraPopupNovo = true;
        temp = u;
    }
    
    public void fecharPopupNovo(){
        mostraPopupNovo = false;
    }
    
    public boolean isMostraPopupNovo() {
        return mostraPopupNovo;
    }

    public void setMostraPopupNovo(boolean mostraPopupNovo) {
        this.mostraPopupNovo = mostraPopupNovo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Dao<Cliente> getDao() {
        return dao;
    }

    public void setDao(Dao<Cliente> dao) {
        this.dao = dao;
    }

    public Cliente getNovo() {
        return novo;
    }

    public void setNovo(Cliente novo) {
        this.novo = novo;
    }

    public Cliente getTemp() {
        return temp;
    }

    public void setTemp(Cliente temp) {
        this.temp = temp;
    }

    
}
