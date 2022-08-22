
package ProjetoWebSpring.entities;

import ProjetoWebSpring.entities.pk.OrderItemPK;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
    private static final Long serialVersionUID = 1L;
    
    //Como Eu Especifiquei meu Id da forma Embedded na classe auxiliar aqui também precisa ser!
    //Sempre que for criar classes auxiliares como essa , você tem que estanciar a classe como novo objeto para ela n vir com valor nulo!
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    
    private Integer quantity;
    
    private Double price;

    public OrderItem() {
    }

    //No Meu Construtor eu Especifiquei Uma Ordem , Um Produto , Quantidade , Preço
    //e dei id.setOrder(order); -> aqui especifiquei que minha ordem vai receber o valor da ordem da minha outra classe auxiliar e o valor vai ser setado no elemento do construtor no caso Order order
    //e dei id.setProduct(product); -> aqui especifiquei que meu produto vai receber o valor do meu produto da minha outra classe auxiliar e o valor vai ser setado no elemento do construtor no caso Product product
    public OrderItem(Order order,Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    
    //Criei um Get do meu Order que retorna o meu Id la de cima!
    public Order getOrder(){
            return id.getOrder();
        }
    
    //Criei um Set que vai Setar o meu Id conforme la encima!
    public void setOrder(Order order){
        id.setOrder(order);
    }

    //Criei um Get do meu Order que retorna o meu Id la de cima!
    public Product getProduct(){
            return id.getProduct();
        }
    
    //Criei um Set que vai Setar o meu Id conforme la encima!
    public void setProduct(Product product){
        id.setProduct(product);
    }
    
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final OrderItem other = (OrderItem) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
}
