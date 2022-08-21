
package ProjetoWebSpring.entities.enums;

//Usar Uma Classe Enum , quando for fazer algo parecido com Status, não vai ter um valor especifico mas representa algo!
//Aguardando Pagamento, Pago, Enviado, Entrega, Cancelado!
//Na classe Enum , todos elementos colocado aqui são atribuidos uma numeracao , comecando do 0 automaticamente
//Eu Irei escrever manualmente para evitar futuros problemas!

public enum OrderStatus {
    
    WAITING_PAYMENT(1), 
    PAID(2),                           
    SHIPPED(3),                    
    DELIVERED(4),               
    CANCELED(5);    
    private int code;

    //Contrutor do OrderStatus
    private OrderStatus(int code) {
        this.code = code;
    }
    
    //Chamei um Get para o code
    public int getCode(){
        return code;
    }
    
    //Criei um Metodo para Analisar os Valores dos elementos acima!
    //Coloquei um for que vai pegar todos codigo com o .values() e um if para comparar os codigos 
    //E uma excecao com o throw new caso o FOR nao Ache nenhum valor dos codigos acima ele retorne um ERRO com uma mensagem!
    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw  new IllegalArgumentException("Codigo Invalido!");
    }
    
}
