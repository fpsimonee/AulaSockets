
public class AppServidor {

    public static void main(String args[]) {
        
        int porta = 9600;
        String texto;
        
        resultado resultado = new resultado();
        String resposta = "Servidor Envia: Olá, Cliente ";
        SocketServidor servidor = new SocketServidor(porta);
        Conexao conexao = new Conexao();
        
        
        if (servidor.connect()) {
            //for (int i = 0; i < 10; i++) {
                // fase de dados
                Operacao op = (Operacao) conexao.receive(servidor.getClientSocket());
                int num1 = op.getNum1();
                int num2 = op.getNum2();
                String oper = op.getOp();
                int result = 0;
                
            // se o numero 2 for igual zero temos uma divisão por zero que tende 
            // a zero. 
            if(num2== 0 && oper.equalsIgnoreCase("/"))   
                result =  (int) Double.POSITIVE_INFINITY; // Constante para definir valor como Infinito
                                                          // dados provavelmente truncados na conversão
                                                          // mas a representação conseguimos fazer.
                                                          
            if(num1==0 && oper.equalsIgnoreCase("/"))    // zero dividido por qualquer numero é zero.
                result = 0;
            
            else{
                switch(oper){
                    case "/" :
                        result = num1 / num2;
                        break;
                        
                     case "*" : 
                        result = num1 * num2;
                        break;
                        
                     case "+" : 
                        result = num1 + num2;
                        break;
                        
                      case "-" : 
                        result = num1 - num2;
                        break;   
                
                }
            }    
                resultado.setResultado(result);
                
//                  if(oper.equalsIgnoreCase("/")){
//                        
//                        System.out.println("entrou na div");
//                  }
//                  
//                  if(oper.equalsIgnoreCase("*"))
//                        result = num1 * num2;
//                  
//                  if(oper.equalsIgnoreCase("+"))
//                        result = num1 + num2;
//                  
//                  if(oper.equalsIgnoreCase("-"))
//                        result = num1 - num2;
                  
                  
                }
                //System.out.println(texto);
                conexao.send(servidor.getClientSocket(), resultado);
                 servidor.encerraServidor();
            }
        
}
        
