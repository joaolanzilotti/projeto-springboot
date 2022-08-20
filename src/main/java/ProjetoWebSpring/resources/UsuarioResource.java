
package projetoWebSpring.resources;

//Resources se comunicam com a web com as entidades- Bean

import projetoWebSpring.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController -> Usar para dizer que ,Essa classe é um recurso web que é implementado por um controlador Rest
//@RequestMapping -> Usar Para dar um Nome para meu Recurso!
//@GetMapping -> Para Dizer que esse Metodo responde a uma requisicao!
//ResponseEntity<User> -> é um tipo especifico do Spring para Retornar Respostas!
//Retornei um ResponseEntity.ok para retornar um sucesso no http! e o .body para retornar o corpo da resposta! no meu caso é o usuario (u)
@RestController
@RequestMapping(value = "/users")
public class UsuarioResource {
    
    @GetMapping
    public ResponseEntity<Usuario> buscarTodos(){
        Usuario u = new Usuario(1L, "Joao", "algamer@hotmail.com", "12996387061", "12345");
        return ResponseEntity.ok().body(u);
    }
    
}
