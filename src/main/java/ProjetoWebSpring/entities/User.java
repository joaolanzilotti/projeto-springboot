package projetoWebSpring.entities;

//Minha Entidade
//O Serializable que voce define ela quando vc quer que seus objetos sejam transformados em cadeia de bytes
//isso é para que os objetos possam ser trafegados na rede , gravados em arquivos e etc...

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nome;
    private String email;
    private String phone;
    private String password;
    
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
