package com.company;


import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);

        do {


            System.out.println("Enter length of arrays ");

            String userchoice = in.nextLine();
            while (!tryParseInt(userchoice))
                userchoice = in.nextLine();

            int lenofarr = Integer.parseInt(userchoice);
            Wrapper r = new Wrapper(lenofarr);
            r.Print();
            System.out.println("Do you want continue? yes/no");

        }
        while (!Objects.equals(in.nextLine(), "no"));


    }

    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException var2) {
            return false;
        }
    }
}
