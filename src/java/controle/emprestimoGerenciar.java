/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Emprestimo;

/**
 *
 * @author BrunoPC
 */
@ManagedBean (name="emprestimoGerenciar")
@ViewScoped
public class emprestimoGerenciar implements Serializable {
    private List<Emprestimo> emprestimos;
    private Dao<Emprestimo> dao;
    
    public emprestimoGerenciar(){
        dao = new Dao(Emprestimo.class);
        emprestimos = dao.listarTodos();
        
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public Dao<Emprestimo> getDao() {
        return dao;
    }

    public void setDao(Dao<Emprestimo> dao) {
        this.dao = dao;
    }
    
    public void excluirPedido(Emprestimo u){
        dao.excluir(u.getId());
        emprestimos.remove(u);
    }
}
