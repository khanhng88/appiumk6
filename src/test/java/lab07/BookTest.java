package lab07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookTest {
    public static void main(String[] args) {
        boolean isContinued = true;
        List<Book> bookList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        while (isContinued) {
            System.out.println("-------------Book menu------------");
            System.out.println("1. Input book");
            System.out.println("2. Find book via isbn");
            System.out.println("3. exit");
            System.out.println("Please input your option");
            int option = input.nextInt();
            if(option == 0 || option>3){
                System.out.println("Invalid option");
                isContinued = true;
            }else {
                switch (option) {
                    case 1:
                        System.out.println("Input book info");
                        System.out.print("Book title : ");
                        String title = input.next();
                        input.nextLine();
                        System.out.print("Author : ");
                        String author = input.next();
                        input.nextLine();
                        System.out.print("isbn : ");
                        String isbn = input.next();
                        input.nextLine();
                        System.out.print("year : ");
                        int year = input.nextInt();
                        bookList.add(new Book(isbn, title, author, year));
                        System.out.println("added book!");
                        break;
                    case 2:
                        System.out.print("Please enter isbn to search book: ");
                        String findISBN = input.next();
                        boolean result = false;
                        for (Book book : bookList) {
                            if (book.getIsbn().equals(findISBN)) {
                                System.out.println(book.toString());
                                result = true;
                                break;
                            }
                        }
                        if(result == false) {
                            System.out.println("Book not found!");
                        }
                        break;
                    case 3:
                        isContinued = false;
                        System.out.println("Exit program");
                        break;

                }
            }
        }
    }
}
