package exercice5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientMailTest {
    public static void main(String argv[]) throws Exception {
        String modifiedSentence;



            Socket clientSocket = new Socket("139.124.187.23", 25);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));




            out.write("EHLO jupiter");
            out.newLine();



            out.write("MAIL FROM: garfield");
            out.newLine();


            out.write("RCPT TO: laroubine");
            out.newLine();

            out.write("DATA");
            out.newLine();

            out.write("FROM: garfield");
            out.newLine();

            out.write("TO: laroubine");
            out.newLine();

            out.write("SUBJECT: Lasagnes");
            out.newLine();

            out.write("Coucou Dorians,");
            out.newLine();

            out.write("DSL Mé t'es PAS TROP BO");
            out.newLine();

            out.write("Bye");
            out.newLine();

            out.write(".");
            out.newLine();

            out.write("QUIT");
            out.newLine();


            out.flush();




            modifiedSentence = inFromServer.readLine();


            while (modifiedSentence != null)
            {
                System.out.println(modifiedSentence);
                modifiedSentence = inFromServer.readLine();
            }


        }



}
