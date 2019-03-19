package exercice3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer extends Thread {

    BufferedWriter out;
    BufferedReader in;
    Socket client;

    ThreadServer(Socket client ) throws IOException {
        this.client = client;
        this.out = new BufferedWriter(new OutputStreamWriter(
                client.getOutputStream()));

        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.start();
    }




    @Override
    public void run() {
        try {

            String data = in.readLine();
            System.out.println(client.getInetAddress());
            out.write(data.toUpperCase());
            out.newLine();
            out.flush();
            client.close();
    } catch (IOException e) {
        e.printStackTrace();
    }


    }
}
