
package ProjetoWebSpring.entities;

import ProjetoWebSpring.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import projetoWebSpring.entities.User;

//@table(name = "") -> Dando uma nome para minha tabela
@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
    private static final Long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    //@JsonFormat -> Formata o elemento escolhido no tipo requerido, eu escolhi em formato String , ano,mes,dia:horas,minutos,segundos - o timezone é um horario universal!
    //O tipo Instant é o substituto do Date!
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    
    //Aqui ele recebe um Inteiro Internamente, mas ele recebe um OrderStatus
    private Integer orderStatus;
    
    //Mapenando Muitos para Um JPA
    //Estou associando a Classe Usuario que é uma Entidade, aqui!
    //@JoinColumn(name = "cliente_id") ->Defifindo minha Entrada na tabela cliente e Definindo o nome da minha chave estrangeira
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    
    //Um Pagamento tem um Pedido e um pedido tem uma pagamento, entao @OneToOne
    //Quando for mapear @OneToOne Tem Essa Diferença, tem que colocar o cascade
    //O cascade é quando se for utilizar um mesmo id no mapeamento é obrigatório usar o cascade! ex: o pagamento vai receber o mesmo ID de pedido!
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;
    
    //Estanciando minha coleção 
    //Eu Coloquei mappedBy = "id.order" pois na minha classe auxiliar eu setei não tem o Id Normalmente especificado! entao nesse caso tenho que especificar com id.order - > o ID vai ser da classe Order
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();
    
    public Set<OrderItem> getItems(){
        return items;
    }

    public Order() {
    }     

    public Order(Long id, Instant moment,OrderStatus orderStatus, User Client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = Client;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null){
        this.orderStatus = orderStatus.getCode();
        }
    }  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User Client) {
        this.client = Client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Order other = (Order) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
    

    
    
    
    
}
