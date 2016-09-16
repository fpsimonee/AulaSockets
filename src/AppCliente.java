
import java.util.Scanner;
import javax.swing.JOptionPane;


public class AppCliente {

    public static void main(String args[]) {
        
        int porta = 9600;
        String ip = "localhost";
        //String requisicao = "Cliente envia : Olá, Servidor ";
        Operacao op = new Operacao();
        resultado Res = new resultado();
        //String texto;
        SocketCliente cliente = new SocketCliente(ip, porta);
        Conexao conexao = new Conexao();
        
        
        op.setNum1(0);
        op.setNum2(5);
        op.setOp("/");
        
        //for (int i = 0; i < 10; i++) {
           // fase de dados
            conexao.send(cliente.getSocket(), op);
            
            Res = (resultado) conexao.receive(cliente.getSocket());
            
            System.out.println("num1="+op.getNum1()+"operacao="+op.getOp()+"num2="+
                    op.getNum2()+"resultado="+Res.getResultado());
        //}
        cliente.encerraCliente();
    }
}