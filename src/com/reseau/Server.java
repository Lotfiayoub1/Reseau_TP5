package com.reseau;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(9997);

        try {
            while(true) {
                System.out.println("\nwaiting for a new connection.....\n");
                Socket client_sock = server.accept();

                InputStreamReader in = new InputStreamReader(client_sock.getInputStream());
                BufferedReader bf = new BufferedReader(in);
                String str = bf.readLine();
                System.out.println("<SERVER> From the client the menu number : "+ str);

                if (Integer.parseInt(str) == 1){

                    PrintWriter out = new PrintWriter(client_sock.getOutputStream());
                    out.println("Le serveur Va calculer la longuer de la phrase que tu va entrer!!!" );
                    out.flush();
                    //System.out.println("Client connected");
                    System.out.println("<SERVER> waiting for client input ");

                    BufferedReader bf2 = new BufferedReader(in);
                    String str2 = bf2.readLine();
                    System.out.println("<SERVER> From the client : "+ str2);


                    out.println("la longueur de la phrase est "+ str2.length());
                    out.flush();


                    client_sock.close();
                }else{
                    PrintWriter out = new PrintWriter(client_sock.getOutputStream());
                    out.println("Le serveur Va trier la phrase!!!" );
                    out.flush();
                    //System.out.println("Client connected");
                    System.out.println("<SERVER> waiting for client input ");

                    BufferedReader bf2 = new BufferedReader(in);
                    String str2 = bf2.readLine();
                    System.out.println("<SERVER> From the client : "+ str2);

                    char[] StringtoChar = str2.toCharArray();
                    Arrays.sort(StringtoChar);
                    String SortedString = new String(StringtoChar);
                    out.println("The Sorted String is : " + SortedString);
                    //System.out.println("The Unsorted String is : " + str2);
                    //System.out.println("The Sorted String is : " + SortedString);
                    out.flush();


                    client_sock.close();
                }


            }
        } finally {
            server.close();
        }


    }

}
