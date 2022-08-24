
package projetoWebSpring.resources;

//Resources se comunicam com a web com as entidades- Bean

import ProjetoWebSpring.services.UserService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import projetoWebSpring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//@RestController -> Usar para dizer que ,Essa classe é um recurso web que é implementado por um controlador Rest
//@RequestMapping -> Usar Para dar um Nome para meu Recurso!
//@GetMapping -> Para Dizer que esse Metodo responde a uma requisicao!
//ResponseEntity<User> -> é um tipo especifico do Spring para Retornar Respostas!
//Retornei um ResponseEntity.ok para retornar um sucesso no http! e o .body para retornar o corpo da resposta! no meu caso é o usuario (u)
//@GetMapping-> Quando eu for buscar algum metodo microservice como o buscartodos ou buscarporid
//@PostMapping-> é quando eu for precisar salvar ou setar algo,como salvar um usuario,  diferente do @GetMapping
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    
    //O UsuarioResource depende do UsuarioService
    //Injetando as dependencias do UsuarioService
    @Autowired
    private UserService service;
    
    @GetMapping
    public ResponseEntity<List<User>> buscarTodos(){
         List<User> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }
    
    //@PathVariable -> é para o Spring Aceitar o Parametro que esta sendo requisitado pelo @GetMapping
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> buscarPorId(@PathVariable Long id){
    User obj = service.buscarPorId(id);
    return ResponseEntity.ok().body(obj);
    }
    
    //@RequestBody -> Meu User obj vai vir em formato Json e para dizer que esse User vai ser um Objeto , vamos utilizar o @RequestBody
    //Converte o valor em Json para objeto, assim podendo salvar os dados!
    //O URI eu criei um caminho que diz que foi criado , esse jeito é mais limpo de salvar! o caminho do recurso!
    //Inserindo Usuario, precisa de um Service!
    //No .body tem que colocara o conteudo no meu caso OBJ
    @PostMapping
    public ResponseEntity<User> Insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
    //Para deletar Usar @DeleteMapping é um método HTTP
    //@pathVariable -> Nesse Caso é para o valor Long id Ser reconhecido como Variavel da minha URL usar o @pathVariable
    //.noContent é porque não vai ter conteudo!
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
            service.delete(id);
            return ResponseEntity.noContent().build();
    }
    
    //Usar o @PutMapping para Atualizar dados é um metodo HTTP
    //Meu Metodo está recebendo um User atualizado por conta do meu ResponseEntity<User>
    //@PathVariable para reconhecer meu valor como objeto!
    //@RequestBody -> Converte o valor de Json para objeto e reconhece como objeto!
    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
            obj = service.update(id, obj);
            return ResponseEntity.ok().body(obj);
    }
    
}
