
package ProjetoWebSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoWebSpring.entities.Usuario;


//Implementando o Repositorio do JPA, Indicando minha Entidade e minha Primary Key
//A Classe Repositories é utilizada para Salvar os Dados!
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
