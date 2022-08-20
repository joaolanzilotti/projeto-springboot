
package ProjetoWebSpring.config;

//Eu Define meu Perfil de Teste no application.properties e aqui vou configurar meu Perfil!
//@Configuration diz que essa classe vai ser uma classe de configuracao
//@Profile("perfil") diz qual perfil voce vai querer chamar para a configuracao
//Essa classe Vai Servir para Popular o Banco de Dados, Enviar as informacoes
//@Autowired é para associar uma estancia do UsuarioRepository dentro do TestConfig - Como Se Fosse um Contrutor puxando os objetos
//Com o implements CommandLineRunner -> é uma forma de essa classe ser iniciada junto com o programa! Alguns Jeitos do Spring
//Meu Objeto UsuarioRepository é quem acessa os dados! com ele vou salvar os usuarios!

import ProjetoWebSpring.repositories.UsuarioRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import projetoWebSpring.entities.Usuario;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    //Isso aqui é um metodo obrigatorio após eu iniciar essa classe com o CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        
        Usuario u1 = new Usuario(null, "João Pedro", "joaopedro@gmail.com", "12996387061", "123456");
        Usuario u2 = new Usuario(null, "Ana Catarina", "anacatarina@gmail.com", "12996269012", "123456");
        
        //Como esse é meu objeto que acessa os dados, tipo um EntityManager
        //Chamei ele e coloquei meus 2 usuarios dentro de uma lista para salvar os dois de uma vez só!
        usuarioRepository.saveAll(Arrays.asList(u1,u2));
        
    }
    
}
