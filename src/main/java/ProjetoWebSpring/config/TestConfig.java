package ProjetoWebSpring.config;

//Eu Define meu Perfil de Teste no application.properties e aqui vou configurar meu Perfil!
//@Configuration diz que essa classe vai ser uma classe de configuracao
//@Profile("perfil") diz qual perfil voce vai querer chamar para a configuracao
//Essa classe Vai Servir para Popular o Banco de Dados, Enviar as informacoes
//@Autowired é para associar uma estancia do UsuarioRepository dentro do TestConfig - Como Se Fosse um Contrutor puxando os objetos ou um Injection
//Com o implements CommandLineRunner -> é uma forma de essa classe ser iniciada junto com o programa! Alguns Jeitos do Spring
//Meu Objeto UsuarioRepository é quem acessa os dados! com ele vou salvar os usuarios!
import ProjetoWebSpring.entities.Category;
import ProjetoWebSpring.entities.Order;
import ProjetoWebSpring.entities.Product;
import ProjetoWebSpring.entities.enums.OrderStatus;
import ProjetoWebSpring.repositories.CategoryRepository;
import ProjetoWebSpring.repositories.OrderRepository;
import ProjetoWebSpring.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    //Isso aqui é um metodo obrigatorio após eu iniciar essa classe com o CommandLineRunner
    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Eletronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Uma Rig.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Samsung SmartTv 50 4K.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "MacBook Pro 1Tb.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Rtx 3090Ti 24Gb.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Rails Coloridos.", 100.99, "");

        //Aqui eu chamo o meu produto  p1 uso .getCategories , pego a colecao categoria estanciado no product e uso .add para adiocionar um elemento no cat o cat1 nessa categoria!
        //Estou adicionando os valores na minha tabela imtermediadora
        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        //Criando o obj User e estanciando seu valores!
        User u1 = new User(null, "João Pedro", "joaopedro@gmail.com", "12996387061", "123456");
        User u2 = new User(null, "Ana Catarina", "anacatarina@gmail.com", "12996269012", "123456");

        //Como os Dois estao Relacionados , Chamo o obj User também!
        //Estou Chamando meu obj Order e definindo seu atributos, id nulo, Instant.parse(Formato Escolhido), User1;
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.SHIPPED, u1);

        //Como esse é meu objeto que acessa os dados, tipo um EntityManager
        //Chamei ele e coloquei meus 2 usuarios dentro de uma lista para salvar os dois de uma vez só!
        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }

}
