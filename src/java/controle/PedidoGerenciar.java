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
import modelo.Pedido;

/**
 *
 * @author BrunoPC
 */
@ManagedBean (name="PedidoGerenciar")
@ViewScoped
public class PedidoGerenciar implements Serializable {
    private List<Pedido> pedidos;
    private Dao<Pedido> dao;
    private Pedido novo;

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Dao<Pedido> getDao() {
        return dao;
    }

    public void setDao(Dao<Pedido> dao) {
        this.dao = dao;
    }

    public Pedido getNovo() {
        return novo;
    }

    public void setNovo(Pedido novo) {
        this.novo = novo;
    }
    
    public PedidoGerenciar(){
        dao = new Dao(Pedido.class);
        novo = new Pedido();
        pedidos = dao.listarTodos();
        
    }
    
    public void inserirPedido(){
        dao.inserir(novo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage
        (null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
                "Pedido cadastrado, seu veiculo chegará em breve!", null));
        pedidos = dao.listarTodos();
        novo = new Pedido();
    }
    
    public void excluirPedido(Pedido u){
        dao.excluir(u.getId());
        pedidos.remove(u);
    }
}
