
package ProjetoWebSpring.resources.exceptions;

import ProjetoWebSpring.services.exceptions.DataBaseException;
import ProjetoWebSpring.services.exceptions.ResourceNotFoundException;
import java.time.Instant;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice -> essa anotacao que me permite editar as mensagens de erro!
@ControllerAdvice
public class ResourceExceptionHandler {
    
    //@ExceptionHandler -> Especifico que esse erro espeficado vai fazer o tratamento especificado pelo metodo!
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> ResourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
            String error = "Resource not Found";
            HttpStatus status = HttpStatus.NOT_FOUND;
            StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
    }
    
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request){
            String error = "DataBase Error";
            HttpStatus status = HttpStatus.BAD_REQUEST;
            StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
            return ResponseEntity.status(status).body(err);
    }
}
