package exercice6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientMailTest {
    public static void main(String argv[]) throws Exception {
            String modifiedSentence = "";



            Socket clientSocket = new Socket("139.124.187.23", 110);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));




            out.write("USER laroubine");
            out.newLine();
            out.flush();
            modifiedSentence = modifiedSentence +  inFromServer.readLine();

            out.write("PASS laroubine");
            out.newLine();
            out.flush();
            modifiedSentence = modifiedSentence +  inFromServer.readLine();
            out.write("LIST");
            out.newLine();
            out.flush();
            String tempLine = inFromServer.readLine();
            while (tempLine == ".")
        {
            modifiedSentence = modifiedSentence + tempLine;
            tempLine = inFromServer.readLine();
        }
            modifiedSentence = modifiedSentence +  inFromServer.readLine();
            out.write("RETR 3");
            out.newLine();
            out.flush();

            modifiedSentence = modifiedSentence +  inFromServer.readLine();



            while (modifiedSentence != null)
            {
                System.out.println(modifiedSentence);
                modifiedSentence = inFromServer.readLine();
            }


        }





}
