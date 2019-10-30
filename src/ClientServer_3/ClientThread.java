package ClientServer_3;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.net.Socket;

public class ClientThread extends Thread {

    private static int clientNumber = 0;

    private Socket server;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public ClientThread(Socket server){
        super("Client thread" + clientNumber++);
        this.server = server;

    }

    public void run(){

    }
}
