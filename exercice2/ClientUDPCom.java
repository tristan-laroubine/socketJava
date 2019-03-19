package exercice2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientUDPCom {
    public static void main(String argv[]) throws Exception {
        String sentence = null;
        String modifiedSentence;

        while(true)
        {

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            Socket clientSocket = new Socket("172.17.0.1", 50050);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    clientSocket.getOutputStream()));



            if( sentence == null)
                sentence = inFromUser.readLine();

            out.write(sentence);
            out.newLine();
            out.flush();




            modifiedSentence = inFromServer.readLine();

            System.out.println("DU SERVEUR  : " + modifiedSentence);
            clientSocket.close();
            sentence = inFromUser.readLine();

            if(sentence.toString().equals("q")){
                break;
            }

        }


    }
}
