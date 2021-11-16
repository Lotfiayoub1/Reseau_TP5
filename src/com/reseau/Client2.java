package com.reseau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket sock_client = new Socket("localhost",9997);

        InputStreamReader in = new InputStreamReader(sock_client.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        String str = bf.readLine();
        System.out.println("<CLIENT> From the server : "+ str);

        PrintWriter out = new PrintWriter(sock_client.getOutputStream());
        Scanner s = new Scanner(System.in);
        String message = s.nextLine();
        out.println(message + "\n");
        out.flush();


        String str1 =bf.readLine();
        System.out.println("<CLIENT> From the server : "+ str1);

        out.println(str1+" \n");
        out.flush();
        sock_client.close();

    }

}
