package ProjetoWebSpring.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoWebSpring.entities.User;
import ProjetoWebSpring.repositories.UserRepository;
import ProjetoWebSpring.services.exceptions.DataBaseException;
import ProjetoWebSpring.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

//@Component -> é utilizado para registrar a classe como componente do Spring
//@Service -> é um termo mais especifico para registrar no Spring , nesse caso é um service!
//Assim podendo Injeta-la com @Autowired
@Service
public class UserService {

    //o UsuarioService depende do UsuarioRepository, quando eu injeto ele especifica isso!
    //Injetando como se fosse o EntityManager!
    @Autowired
    private UserRepository repository;

    public List<User> buscarTodos() {

        return repository.findAll();

    }

    //.findById -> é para buscar algum elemento por id!
    //Optinal -> retorna um objeto escolhido no meu caso <Usuario> Minha Entidade
//    public User buscarPorId(Long id){
//        Optional<User> obj = repository.findById(id);
//        return obj.get();
//    }
    //.findById -> é para buscar algum elemento por id!
    //Optinal -> retorna um objeto escolhido no meu caso <Usuario> Minha Entidade
    //Usei o .orElseThow ele vai tentar buscar o ID se o valor não exister, ele executa o meu erro personalizado!
    public User buscarPorId(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Inserindo Usuario, precisa de um resource!
    public User insert(User obj) {

        return repository.save(obj);
    }

    //Deletando Usuario por ID!
    public void delete(Long id) {
        try
        {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e)
        {
            throw new ResourceNotFoundException(id);
        }catch(DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    //O .getOne é mais eficiente que o .findById, para fazer updates de valores!, no meu caso dados do Usuario!
    //repository.getOne(id); -> Eu Busco pelo ID e o User Entity já está recebendo essa busca!
    //User entity -> eu estou pegando todos meus atributos da classe User , Metodos, Construtores e etc...
    public User update(Long id, User obj) {
        User entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
