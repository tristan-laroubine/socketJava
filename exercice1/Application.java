package exercice1;

import java.io.*;
import java.net.*;


class Application {
    public static void main(String argv[]) throws Exception {
            String sentence;
            String modifiedSentence;
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            Socket clientSocket = new Socket("10.203.9.145", 50007);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                clientSocket.getOutputStream()));



            sentence = inFromUser.readLine();
            while(true)
            {


                out.write(sentence);
                out.newLine();
                out.flush();




                modifiedSentence = inFromServer.readLine();

                System.out.println("DU SERVEUR  : " + modifiedSentence);
                sentence = inFromUser.readLine();
                if(sentence.toString().equals("q")){
                    break;
                }
            }

            clientSocket.close();
    }
}