package ClientServer_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server extends Thread {

    private final Logger logger = Logger.getLogger("");

    public static void main(String[] args){

    }

    public void run(){

        try(ServerSocket listener = new ServerSocket(10243, 10, null)) {
            logger.info("Listening on port: " + 10243);

            while (true){
                Socket socket = listener.accept();
                ClientThread client = new ClientThread(socket);
                client.start();
            }

        } catch (IOException e){

        }

    }

}
