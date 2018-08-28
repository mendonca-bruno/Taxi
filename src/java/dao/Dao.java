package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import modelo.Cliente;
import modelo.Motocicleta;
import util.JpaUtil;

/**
* Classe genérica para persistir objetos. 
 */
public class Dao <T> implements Serializable {

    private final Class<T> classe;
    EntityManager manager;

    public Dao(Class<T> classe) {
        this.classe = classe;
    }

    public T alterar(T objeto) {
        manager = JpaUtil.getEntityManager();
        manager.getTransaction().begin();
        objeto = manager.merge(objeto);
        manager.getTransaction().commit();
        manager.close();
        return objeto;
    }

    public T buscarPorCodigo(Object id) {
        T objeto;
        manager = JpaUtil.getEntityManager();
        objeto = manager.find(classe, id);
        manager.close();
        return objeto;
    }

    public void excluir(Integer id) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        T temp = manager.find(classe, id);
        manager.remove(temp);
        tx.commit();
        manager.close();
    }

    public void inserir(T objeto) {
        manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(objeto);
        tx.commit();       
        return;
    }

    public List<T> listarTodos() {        
        manager = JpaUtil.getEntityManager();
        CriteriaQuery<T> query = manager.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        List<T> lista = manager.createQuery(query).getResultList();
        manager.close();      
        return lista;
    }

    
    
    public Motocicleta buscarPorPlacaMotocicleta(String placa) {
        Motocicleta temp = new Motocicleta();
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT v FROM Motocicleta v WHERE v.placa = :p";
        TypedQuery<Motocicleta> query = manager.createQuery(sql, Motocicleta.class);
        query.setParameter("p", placa);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
    
    
    public Cliente buscarPorNomeCliente(String nome) {
        Cliente temp = new Cliente();
        manager = JpaUtil.getEntityManager();
        String sql = "SELECT u FROM Cliente u WHERE u.nome = :nome";
        TypedQuery<Cliente> query = manager.createQuery(sql, Cliente.class);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  //aqui poderia haver um tratamento de exceção mais decente
//            System.out.println("Exception in AdministradorDao.buscarPorNome(): " + e.toString());
        } finally {
            manager.close();
        }
        return temp;
    }
}
