/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.AdministradorDao;
import dao.Dao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Administrador;
import modelo.Cliente;

/**
 * Controlador para página de index
 * @author José
 */
@ManagedBean (name="indexCliente")
@ViewScoped
public class IndexCliente implements Serializable{
    private Cliente cli;
    
    public IndexCliente(){
        cli = new Cliente();
    }
    
    public String autenticar(){
        this.cli.setLogin(cli.getLogin());
        Dao<Cliente> dao = new Dao(Cliente.class);
        Cliente temp;
        temp = dao.autenticarCliente(cli);
        if (temp == null){  // se houver erro, método autenticar no dao retorna null
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos", null));
            return null;  //fica na página
        }  
        //seta usuario na Sessao
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ectx = context.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(true);
        session.setAttribute("usuarioLogado", temp);        
        return "menuCliente";    // menu.xhtml
    }
    
      public Cliente getCliente() {
        return cli;
    }

    public void setCliente(Cliente cli) {
        this.cli = cli;
    }
}
