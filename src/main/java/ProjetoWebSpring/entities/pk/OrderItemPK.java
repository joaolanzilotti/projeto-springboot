
package ProjetoWebSpring.entities.pk;

import ProjetoWebSpring.entities.Order;
import ProjetoWebSpring.entities.Product;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//A minha Classe OrderItemPK não vai ter ID Proprio 
//Essa Classe aqui é para mim associar as duas Classes Product e Order - So vou fazer isso com tabelas que nao vao ter ID!
//@Embeddable -> Está é uma Classe de chave Composta, para isso vamos substuir o @Id por @Embeddable
//Classe Auxiliar!

@Embeddable
public class OrderItemPK implements Serializable{
    private static final Long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.order);
        hash = 59 * hash + Objects.hashCode(this.product);
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
        final OrderItemPK other = (OrderItemPK) obj;
        if (!Objects.equals(this.order, other.order))
        {
            return false;
        }
        return Objects.equals(this.product, other.product);
    }
    
    
    
    
    
}
