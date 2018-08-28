/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Emprestimo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @Temporal(TemporalType.DATE)
    private Date retirada;
    @Column
    private int minGastos;
    @ManyToOne(optional=false )     // MUITOS Emprestimos para UM Veiculo
    @JoinColumn(name="motocicleta")
    private Motocicleta motocicleta;
    @ManyToOne(optional=false )       // MUITOS comprovantes para UM aluno
    @JoinColumn(name="cliente")
    private Cliente cliente;
    
    public Emprestimo(){
        this.motocicleta = new Motocicleta();
        this.retirada = new Date();
        minGastos = 0;
        this.cliente = new Cliente();
    }
    
    public Emprestimo(Motocicleta motocicleta, Date retirada, int minGastos, Cliente cliente){
        this.motocicleta = motocicleta;
        this.retirada = retirada;
        this.minGastos = minGastos;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRetirada() {
        return retirada;
    }

    public void setRetirada(Date retirada) {
        this.retirada = retirada;
    }

    public int getMinGastos() {
        return minGastos;
    }

    public void setMinGastos(int minGastos) {
        this.minGastos = minGastos;
    }

    public Motocicleta getMotocicleta() {
        return motocicleta;
    }

    public void setMotocicleta(Motocicleta motocicleta) {
        this.motocicleta = motocicleta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
