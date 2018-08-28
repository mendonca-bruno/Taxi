
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 10)
    private String login;
    @Column(length = 50)
    private String nome;
    @Column(length = 50)
    private String senha;
    @Column
    private int corridas;
    @OneToMany(mappedBy = "cliente")    
    private List<Emprestimo> emprestimos; 
    
    public Cliente(){
        id = 0;
        login = "";
        nome = "";
        senha = "";
        corridas = 0;
        
    }
    public Cliente(String login, String nome, String senha){
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        corridas = 0;
    }

    public int getCorridas() {
        return corridas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", login=" + login + ", nome=" + nome + ", senha=" + senha + ", corridas=" + corridas + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.login);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.senha);
        hash = 59 * hash + this.corridas;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.corridas != other.corridas) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public void setCorridas(int corridas) {
        this.corridas = corridas;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
