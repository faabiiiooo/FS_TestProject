package ClientServer_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class WebServer_Model extends Thread {
    private Integer port;
    private final Logger logger = Logger.getLogger("");


    public void run() {
        try(ServerSocket listener = new ServerSocket(port,10,null)){
            logger.info("Listening on Port " + port);

            while(true){
                try(Socket client = listener.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(client.getOutputStream());){

                    logger.info("Request from client " + client.getInetAddress().toString()
                    + " for server " + client.getLocalAddress().toString());

                    out.print("HTTP/1.0 200 \r\n");
                    out.print("Content-Type: text/plain\r\n");
                    out.print("\r\n");

                    StringBuilder received = new StringBuilder();
                    String inString;
                    while ((inString = in.readLine()) != null && inString.length() != 0) {
                        received.append(inString + "\n");
                    }

                    String outString = received.toString();
                    out.print(outString);
                    logger.info("Request contents:\n" + outString);

                    out.flush();


                }
            }
        } catch (IOException e){
            System.err.println(e);
        }
    }

    public void setPort(int port){
        this.port = port;
    }
}
