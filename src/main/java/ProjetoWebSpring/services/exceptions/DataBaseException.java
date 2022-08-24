/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoWebSpring.services.exceptions;

/**
 *
 * @author joaoferretti
 */
public class DataBaseException extends RuntimeException{
    
    public DataBaseException(String message){
            super(message);
    }
    
}
