package com.reseau;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTP5 {

    public static void main(String[] args) {

        try
        {
            Socket sock_client = new Socket("localhost",9997) ;

            //binary input stream
            InputStream in = sock_client.getInputStream();

            byte[] myBytes = new byte[1000];

            //read message from the server (accepted connection for example) ==> read it in myBytes array
            int nbBitsRecus = in.read(myBytes); //effectivement recues

            if ( nbBitsRecus > 0 )
                System.out.println("<CLIENT> from the server : " + new String(myBytes,0,nbBitsRecus)); /// => new String(myBytes,0,nbBitsRecus);

            OutputStream out = sock_client.getOutputStream();

//			try
//			{
//				Thread.sleep(10000);
//			} catch (InterruptedException e)
//			{
//				e.printStackTrace();
//			}
            String line ;
            Scanner S = new Scanner(System.in);
            line = S.next();
            //send a hello world message
            //String str =  "hello world, here i am\n" ;
            out.write(line.getBytes());
            out.close();
            System.out.println("<CLIENT> waiting for the echo using uppercase");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            Scanner in1 = new Scanner( sock_client.getInputStream()) ;
            String line1 ;
            try {
                line1 = in1.nextLine();
                System.out.println(line1);
            } catch (Exception e) {
                // TODO: handle exception
            }


        } catch (UnknownHostException e) {
        } catch (IOException e) {}




    }

}
