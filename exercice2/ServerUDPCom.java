package exercice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerUDPCom {


    public static void main(String argv[]) throws Exception {

        Socket client;

        BufferedWriter out;
        BufferedReader in;
        ServerSocket serveur = new ServerSocket(50050);

        while (true) {
            client = serveur.accept();
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(
                    client.getOutputStream()));
            while(true)
            {
                String data = in.readLine();
                System.out.println(client.getInetAddress().toString());
                System.out.println("SERV : " + client.getLocalAddress() + client.getPort());
                if (data == "q") break;
                out.write("T'ES OPD DORIAN");
                out.newLine();
                out.flush();
            }

            client.close();
        }
    }


}
