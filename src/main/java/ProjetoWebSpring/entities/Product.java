
package ProjetoWebSpring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "tb_product")
public class Product implements Serializable{
    private static final Long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    private String description;
    private Double price;
    private String imgUrl;
    
    //O Set representa um Conjunto!
    //Com o Atributo Set , ele não vai permitir um produto ter a mesma categoria novamente! o produto não vai uma mesma categoria mais de uma vez!
    //Com o HashSet -> Estou garantindo que minha coleção não podera vir nulla! e o Set é uma Interface , Assim nao podendo estanciar! , por isso usei HashSet, Como List usa o ArrayList!
    //Nao se coloca colecao em construtor!
    //@Transient -> Impede o JPA de Interpretar!
//    @JsonIgnore
//    @OneToMany(mappedBy = "products")
    @Transient
    private Set<Category> categories = new HashSet<>();

    public Product() {
    }

    public Product(Long Id, String nome, String description, Double price, String imgUrl) {
        this.Id = Id;
        this.nome = nome;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this.Id, other.Id);
    }
    
    
   
    
}
