
import java.io.IOException;
import java.net.Socket;

public class SocketCliente {
    
    private Socket socket;
    
    public SocketCliente(String ip,int porta) {
        try {
            // fase de conexão
            socket = new Socket(ip, porta);
        } catch (Exception e) {
            System.out.println("Nao consegui resolver o host... "+e.getMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public void encerraCliente(){
        try {
            socket.close();									// fase de desconexão
        } catch (IOException e) {
            System.out.println("Não encerrou a conexão corretamente" + e.getMessage());
        }
    }
}