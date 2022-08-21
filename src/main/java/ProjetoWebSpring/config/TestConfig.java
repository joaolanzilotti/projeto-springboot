package ProjetoWebSpring.config;

//Eu Define meu Perfil de Teste no application.properties e aqui vou configurar meu Perfil!
//@Configuration diz que essa classe vai ser uma classe de configuracao
//@Profile("perfil") diz qual perfil voce vai querer chamar para a configuracao
//Essa classe Vai Servir para Popular o Banco de Dados, Enviar as informacoes
//@Autowired é para associar uma estancia do UsuarioRepository dentro do TestConfig - Como Se Fosse um Contrutor puxando os objetos ou um Injection
//Com o implements CommandLineRunner -> é uma forma de essa classe ser iniciada junto com o programa! Alguns Jeitos do Spring
//Meu Objeto UsuarioRepository é quem acessa os dados! com ele vou salvar os usuarios!
import ProjetoWebSpring.entities.Order;
import ProjetoWebSpring.repositories.OrderRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import projetoWebSpring.entities.User;
import ProjetoWebSpring.repositories.UserRepository;
import java.time.Instant;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository usuarioRepository;

    @Autowired
    private OrderRepository orderRepository;

    //Isso aqui é um metodo obrigatorio após eu iniciar essa classe com o CommandLineRunner
    @Override
    public void run(String... args) throws Exception {

        //Criando o obj User e estanciando seu valores!
        User u1 = new User(null, "João Pedro", "joaopedro@gmail.com", "12996387061", "123456");
        User u2 = new User(null, "Ana Catarina", "anacatarina@gmail.com", "12996269012", "123456");

        //Como os Dois estao Relacionados , Chamo o obj User também!
        //Estou Chamando meu obj Order e definindo seu atributos, id nulo, Instant.parse(Formato Escolhido), User1;
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        //Como esse é meu objeto que acessa os dados, tipo um EntityManager
        //Chamei ele e coloquei meus 2 usuarios dentro de uma lista para salvar os dois de uma vez só!
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }

}
