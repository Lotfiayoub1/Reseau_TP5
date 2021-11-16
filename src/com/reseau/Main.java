package com.reseau;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        int menu = 1;
        Scanner s = new Scanner(System.in);
        while (menu != 0){
            System.out.println("*------------------Menu : Client - Serveur----------------------*");
            System.out.println("* 1- Langueur                                                   *");
            System.out.println("* 2- Tri                                                        *");
            System.out.println("* 3- Quitter                                                    *");
            System.out.println("*---------------------------------------------------------------*");
            menu = s.nextInt();
            switch (menu){
                case 1:

                case 2:
                    Client c = new Client("localhost",9997);
                    c.lancerClient(menu);

                    break;
                case 3:
                    menu = 0;
                    break;
                default:
                    System.out.println("Ce numéro n'existe pas dans le menu");
                    break;
            }
        }
    }
}
