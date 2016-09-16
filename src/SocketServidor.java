
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {

    private ServerSocket serverSocket;
    private Socket clientSocket;

    public SocketServidor(int porta) {
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Criando o Server Socket");
            System.out.println("Servidor no ar na porta "+porta);
        } catch (Exception e) {
            System.out.println("Nao criei o server socket... "+e.getMessage());
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public boolean connect() {
        boolean retorno;
        try {
            // fase de conexao
            clientSocket = serverSocket.accept();
            retorno = true;
        } catch (Exception e) {
            System.out.println("Não fez conexão" + e.getMessage());
            retorno = false;
        }
        return retorno;
    }

    public void encerraServidor() {
        try {
            //desconexao
            clientSocket.close();
            serverSocket.close();								 // desconexao
        } catch (Exception e) {
            System.out.println("Não encerrou a conexão corretamente" + e.getMessage());
        }
    }
}