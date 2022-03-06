package lab04;

import java.util.ArrayList;
import java.util.Scanner;

public class Lab04Test {

    public static void main(String[] args) {

        /**
         * Menu:
         * 1 input numbers
         * 2 print numbers
         * 3 Get max
         * 4 Get min
         */

        ArrayList<Integer> numberList = new ArrayList<>();
        boolean isContinued = true;
        while(isContinued) {
            System.out.println("_______________Menu_____________");
            System.out.println("1. Input number ");
            System.out.println("2. Print numbers ");
            System.out.println("3. Find max ");
            System.out.println("4. Find min ");
            System.out.println("5. Find number-> index ");
            System.out.print("Please input option (0: exit): ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            if(option!=0) {
                switch (option){
                    case 1:
                        System.out.println("PLease input number: ");
                        int num = input.nextInt();
                        numberList.add(num);
                        break;
                    case 2:
                        if(!numberList.isEmpty()) {
                            System.out.print("The numbers in array list: ");
                            for (Integer integer : numberList) {
                                System.out.print(integer + " ");
                            }
                            System.out.println();
                        }else{
                            System.out.println("Sorry!The number list is empty");
                        }
                        break;
                    case 3:
                        if(!numberList.isEmpty()) {
                            int max = numberList.get(0);
                            for (int index = 0; index < numberList.size(); index++) {
                                if (max < numberList.get(index)) {
                                    max = numberList.get(index);
                                }
                            }
                            System.out.println("Max is " + max);
                        }else {
                            System.out.println("Sorry the number list is empty, no max found.");
                        }
                        break;
                    case 4:
                        if(!numberList.isEmpty()) {
                        int min = numberList.get(0);
                        for(int index = 0; index < numberList.size(); index++) {
                            if(min > numberList.get(index)) {
                                min = numberList.get(index);
                            }
                        }
                        System.out.println("Min is "+min);
                        }else {
                            System.out.println("Sorry the number list is empty, no min found.");
                        }
                        break;
                    case 5:
                        System.out.print("Please input number you want to find: ");
                        int number = input.nextInt();
                        int index = 0;
                        for (Integer integer : numberList) {
                            if(integer.equals(number)) {
                                index = numberList.indexOf(integer);
                            }
                            continue;
                        }
                        if(index==0)
                            System.out.println("Sorry not found.");
                        else
                            System.out.println("Index is "+index);
                        break;
                }
            }else {
                isContinued = false;
            }

        }
    }
}
