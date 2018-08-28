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
import modelo.Emprestimo;
import modelo.Cliente;
import modelo.Motocicleta;

@ManagedBean (name="emprestarMotocicleta")
@ViewScoped
public class EmprestarMotocicleta implements Serializable{
    private List<Motocicleta> motocicletas;
    private List<Cliente> clientes;
    private Dao<Motocicleta> daoMotocicleta;
    private Dao<Cliente> daoCliente;
    private Emprestimo emprestimo; 
    Dao<Emprestimo> daoEmprestimo;
    
    public EmprestarMotocicleta(){
        daoMotocicleta = new Dao(Motocicleta.class);
        daoCliente = new Dao(Cliente.class);
        motocicletas = daoMotocicleta.listarTodos();
        clientes = daoCliente.listarTodos();
        daoEmprestimo = new Dao(Emprestimo.class);
        emprestimo = new Emprestimo();    
    }
    
    public void registrarEmprestimo(){
        daoEmprestimo.inserir(emprestimo);
        emprestimo = new Emprestimo(); 
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Retirada gravada com sucesso", null));
    }

    public List<Motocicleta> getMotocicletas() {
        return motocicletas;
    }

    public void setMotocicletas(List<Motocicleta> motocicletas) {
        this.motocicletas = motocicletas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Dao<Motocicleta> getDaoMotocicleta() {
        return daoMotocicleta;
    }

    public void setDaoMotocicleta(Dao<Motocicleta> daoMotocicleta) {
        this.daoMotocicleta = daoMotocicleta;
    }

    public Dao<Cliente> getDaoCliente() {
        return daoCliente;
    }

    public void setDaoCliente(Dao<Cliente> daoCliente) {
        this.daoCliente = daoCliente;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Dao<Emprestimo> getDaoEmprestimo() {
        return daoEmprestimo;
    }

    public void setDaoEmprestimo(Dao<Emprestimo> daoEmprestimo) {
        this.daoEmprestimo = daoEmprestimo;
    }
}
