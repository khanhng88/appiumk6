package lab06;

import java.util.Scanner;

public class Lab6_2Test {
    public static void main(String[] args) {
       int count = 0;
        Scanner inputString = new Scanner(System.in);
        while (count<3) {
            System.out.print("Please input your string (max:3 times) :");
            String myPass = inputString.next();
            count++;
        }
        System.out.println("exit! You have input string 3 times.");
    }
}
