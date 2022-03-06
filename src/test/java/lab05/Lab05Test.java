package lab05;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Lab05Test {
    public static void main(String[] args) {

        /*
        Menu:
        1. Input student info
        2. Find student id
        0. exit
         */
        Map<Integer , String> studentInfoList = new HashMap<>();
        boolean isContinued = true;
        while (isContinued) {
            System.out.println("-----------Menu-----------");
            System.out.println("1.Input student info");
            System.out.println("2.Find student id");
            System.out.println("0.Exit");
            System.out.print("Please input option:");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            if (option == 0){
                System.exit(0);
            }else if(option == 1) {
                System.out.print("Please input student name :");
                String studentName = input.next();
                int studentId = new Random().nextInt(900) + 100;
                studentInfoList.put(studentId, studentName);
                System.out.println("Student id added: "+studentId);
            } else if(option == 2) {
                System.out.print("Please input student id :");
                int inputId = input.nextInt();
                boolean result = false;
                for (Integer studentID : studentInfoList.keySet()) {
                    if(studentID == inputId) {
                        result = true;
                        break;
                    }
                }

                if(result==true) {
                    System.out.println("==> Found student with name "+studentInfoList.get(inputId));
                }else {
                    System.out.println("==> Sorry not found.");
                }
            }

        }
    }
}
