
package ProjetoWebSpring.resources;

//Resources se comunicam com a web com as entidades- Bean

import ProjetoWebSpring.entities.Order;
import ProjetoWebSpring.services.OrderService;
import ProjetoWebSpring.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import projetoWebSpring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController -> Usar para dizer que ,Essa classe é um recurso web que é implementado por um controlador Rest
//@RequestMapping -> Usar Para dar um Nome para meu Recurso!
//@GetMapping -> Para Dizer que esse Metodo responde a uma requisicao!
//ResponseEntity<User> -> é um tipo especifico do Spring para Retornar Respostas!
//Retornei um ResponseEntity.ok para retornar um sucesso no http! e o .body para retornar o corpo da resposta! no meu caso é o usuario (u)
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    
    //O UsuarioResource depende do UsuarioService
    //Injetando as dependencias do UsuarioService
    @Autowired
    private OrderService service;
    
    @GetMapping
    public ResponseEntity<List<Order>> buscarTodos(){
         List<Order> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }
    
    //@PathVariable -> é para o Spring Aceitar o Parametro que esta sendo requisitado pelo @GetMapping
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> buscarPorId(@PathVariable Long id){
    Order obj = service.buscarPorId(id);
    return ResponseEntity.ok().body(obj);
    }
    
}
