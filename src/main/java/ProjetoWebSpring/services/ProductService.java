
package ProjetoWebSpring.services;

import ProjetoWebSpring.entities.Product;
import ProjetoWebSpring.repositories.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component -> é utilizado para registrar a classe como componente do Spring
//@Service -> é um termo mais especifico para registrar no Spring , nesse caso é um service!
//Assim podendo Injeta-la com @Autowired

@Service
public class ProductService {
    
    //o UsuarioService depende do UsuarioRepository, quando eu injeto ele especifica isso!
    //Injetando como se fosse o EntityManager!
    
    @Autowired
    private ProductRepository repository;
    
    public List<Product> buscarTodos(){
    
        return repository.findAll();
        
    }
    
    //.findById -> é para buscar algum elemento por id!
    //Optinal -> retorna um objeto escolhido no meu caso <Usuario> Minha Entidade
    public Product buscarPorId(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
    
}
