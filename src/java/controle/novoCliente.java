/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.Dao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Cliente;

@ManagedBean (name="novoCliente")
@ViewScoped

public class novoCliente implements Serializable {
    private Cliente cliente;
    private Dao<Cliente> dao;
    
    public novoCliente(){
        cliente = new Cliente();
        dao = new Dao(Cliente.class);
    }
    
    public void inserirCliente(){
        dao.inserir(cliente);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Cliente cadastrado", null));
        
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Dao<Cliente> getDao() {
        return dao;
    }

    public void setDao(Dao<Cliente> dao) {
        this.dao = dao;
    }
}
