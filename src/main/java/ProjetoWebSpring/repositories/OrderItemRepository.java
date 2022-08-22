
package ProjetoWebSpring.repositories;

import ProjetoWebSpring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;


//Implementando o Repositorio do JPA, Indicando minha Entidade e minha Primary Key
//A Classe Repositories é utilizada para Salvar os Dados!
//No caso do UsuarioRepository eu nao preciso espeficar que ele é um componente Spring com o @Repository
//Pois quando eu usei extends JpaRepository , ele ja reconheceu que ele é um componente Spring

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

    
    
}
