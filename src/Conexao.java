
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Conexao {

    public Conexao(){
        //vazio
    }
    
    public void send(Socket socket, Object aux) {
        ObjectOutputStream out;
        try {
            out=new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(aux);
        } catch (Exception e) {
            System.out.println("Exceção no OutputStream "+e.getMessage());
        }
    }

    public Object receive(Socket socket) {
        ObjectInputStream in;
        Object result= new Object(); 
        /*int bt;
        byte btxt[];
        String txt = "";
        btxt = new byte[79];*/
        try {
            in = new ObjectInputStream(socket.getInputStream());
            result = in.readObject();
            //bt = in.read(btxt);
            //if (bt > 0) {
            //    txt = new String(btxt);
            //}
        } catch (Exception e) {
            System.out.println("Exceção no InputStream: " + e.getMessage());
        }
        return result;
    }
}