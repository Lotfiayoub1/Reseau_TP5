package com.reseau;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private String adresse;
    private int port;

    public Client(String adresse, int port) {
        this.adresse = adresse;
        this.port = port;
    }

    public void lancerClient(int menu) throws IOException {
        Socket sock_client = new Socket(adresse,port);

        PrintWriter out = new PrintWriter(sock_client.getOutputStream());
        Scanner s = new Scanner(System.in);
        out.println(menu + "\n");
        out.flush();

        InputStreamReader in = new InputStreamReader(sock_client.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        System.out.println("<CLIENT> From the server : "+ str);


        String message2 = s.nextLine();
        out.println(message2 + "\n");
        out.flush();


        String str1 =bf.readLine();
        System.out.println("<CLIENT> From the server : "+ str1);

        sock_client.close();

    }
}
