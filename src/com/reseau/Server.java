package com.reseau;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args)
    {
        try {
            //cr�ation du socket serveur:
            ServerSocket listener = new ServerSocket(9997);

            try {
                while ( true )
                {
                    System.out.println("\nwaiting for a new connection.....\n");
                    //attente de connexion d'un client ( les connexion are queued in the port )
                    Socket client_sock = listener.accept();
                    try
                    {
                        //creation des flots de lecture et d'�criture ASCII
                        Scanner in = new Scanner( client_sock.getInputStream()) ;
                        PrintWriter out = new PrintWriter(client_sock.getOutputStream(), true) ;

                        out.println("Merhbaa bik f serveur dyalna!!! ");

                        //wait something from the client
                        String line= null;

                        System.out.println("<SERVER> waiting for client input ");

                        try {
                            //while ( !( line = in.nextLine() ).isEmpty())
                            line = in.nextLine();
                            System.out.println("<SERVER> from the client : " + line);
                            System.out.println("<SERVER> from the client : " + line.toUpperCase());
                            //PrintWriter out2 = new PrintWriter(client_sock.getOutputStream(), true) ;
                            //out2.print(line.toUpperCase());
                        }catch( Exception e) {
                            //System.out.println(e);
                        }
                        Scanner S = new Scanner(System.in);
                        String toto = S.nextLine();
                        out.println(toto);
                        out.flush();
                        System.out.println("<SERVER>: dakchi mcha");



                    }finally {
                        System.out.println("closing.....");
                        client_sock.close();
                    }


                }
            }finally
            {
                listener.close();
            }
        } catch (IOException e) {}

    }

}
