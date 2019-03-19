package exercice4;


import exercice3.Server;

public class MainTestExo4 {

        public static void main(String argv[]) throws Exception {
            new ServeurTcpEchoPool("Client1");
            new ServeurTcpEchoPool("Client2");
            new ServeurTcpEchoPool("Client3");
        }


}
