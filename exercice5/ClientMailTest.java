package exercice5;

import java.io.*;
import java.net.Socket;



public class ClientMailTest {

    public static void main(String argv[]) throws Exception {
        String modifiedSentence = "";



            Socket clientSocket = new Socket("139.124.187.23", 25);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));




            out.write("EHLO jupiter");
        modifiedSentence = getString(modifiedSentence, inFromServer, out);
            if (modifiedSentence.equals("erreur"))
            {
                return;
            }

        out.write("MAIL FROM: garfield");
        modifiedSentence = getString(modifiedSentence, inFromServer, out);
        if (modifiedSentence.equals("erreur"))
        {
            return;
        }

        out.write("RCPT TO: laroubine");
        modifiedSentence = getString(modifiedSentence, inFromServer, out);
        if (modifiedSentence.equals("erreur"))
        {
            return;
        }
        out.write("DATA");
        modifiedSentence = getString(modifiedSentence, inFromServer, out);
        if (modifiedSentence.equals("erreur"))
        {
            return;
        }
        out.write("FROM: garfield");
        modifiedSentence = getString(modifiedSentence, inFromServer, out);
        if (modifiedSentence.equals("erreur"))
        {
            return;
        }
        out.write("TO: laroubine");
        modifiedSentence = getString(modifiedSentence, inFromServer, out);

        out.write("SUBJECT: Lasagnes");
        modifiedSentence = getString(modifiedSentence, inFromServer, out);

        out.write("Coucou Dorians,");
        modifiedSentence = getString(modifiedSentence, inFromServer, out);
        out.write("TEST");
            out.newLine();

            out.write("Bye");
            out.newLine();

            out.write(".");
            out.newLine();

            out.write("QUIT");
            out.newLine();


            out.flush();


        System.out.println(modifiedSentence);
            modifiedSentence = inFromServer.readLine();


            while (modifiedSentence != null)
            {
                System.out.println(modifiedSentence);
                modifiedSentence = inFromServer.readLine();
            }


        }

    private static String getString(String modifiedSentence, BufferedReader inFromServer, BufferedWriter out) throws IOException {
        out.newLine();

        out.flush();
        while(true)
        {
            String temp = inFromServer.readLine();
            modifiedSentence = modifiedSentence + "\n" + temp;
            if (!temp.substring(2,3).equals("-"))
            {

                if(temp.substring(3,4).equals(4) || temp.substring(3,4).equals(5))
                {
                    modifiedSentence = "erreur";

                }
                break;
            }

        }
        return modifiedSentence;
    }

}
