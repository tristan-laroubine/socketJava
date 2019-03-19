package exercice4;

import java.io.*;
import java.net.Socket;

public class ServeurTcpEchoPool extends Thread {
    String name;
        ServeurTcpEchoPool(String name){
            this.name = name;
            System.out.println(name + " lancement !");
            this.start();
        }

    @Override
    public void run() {
            try{
        String sentence = null;
        String modifiedSentence;

        while (true) {

            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            Socket clientSocket = new Socket("172.17.0.1", 50050);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    clientSocket.getOutputStream()));


            if (sentence == null)
                sentence = inFromUser.readLine();
            out.write(sentence);

            out.newLine();
            out.flush();


            modifiedSentence = inFromServer.readLine();

            System.out.println(this.name + " => " + modifiedSentence);
            clientSocket.close();
            sentence = inFromUser.readLine();

            if (sentence.toString().equals("q")) {
                break;
            }

        }

    }catch (IOException e)
            {

            }

        }
}
