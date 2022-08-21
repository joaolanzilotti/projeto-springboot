package projetoWebSpring.entities;

//Minha Entidade
//O Serializable que voce define ela quando vc quer que seus objetos sejam transformados em cadeia de bytes
//isso é para que os objetos possam ser trafegados na rede , gravados em arquivos e etc...

import ProjetoWebSpring.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String phone;
    private String password;
    
    //@OneToMany(mappedBy = "client") -Tem que Colocar o Atributo la da minha outra classe que está sendo mapeada! 
    //O Muitos para Um La da minha Classe Pedido , está sendo Mapeado ''mappedBy"" por "client"
    //@JsonIgnore -> o meu mapeamento tem uma mào dupla, ele chama o cliente e chama um pedido e o pedido chama o cliente novamente, assim fazendo um loop
    //para corrigir isso , usaremos o jsonignore
    //Usar o @JsonIgnore somente nos mapeamentos OneToMany - Nunca usar no ManyToOne, vai dar erro!
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }
    
    
    
    public User(){
    }

    public User(Long id, String nome, String email, String phone, String password) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final User other = (User) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
    
}
