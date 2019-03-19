package exercice3;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {


    Server() throws IOException {
        ServerSocket serveur = new ServerSocket(50050);
        while(true){
            new ThreadServer(serveur.accept());
        }

    }



}
