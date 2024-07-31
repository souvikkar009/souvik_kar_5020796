import utils.LibraryManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dash = "---------------------------------------------------";
        System.out.println("Enter the number of books to store: ");
        int nBooks = sc.nextInt();
        sc.nextLine();
        System.out.println(dash);
        LibraryManager libraryManager = LibraryManager.getLibraryManager();
        libraryManager.storeBooks(nBooks);
        System.out.println(dash);
        String menu = "0. Exit\n1. Linear Search\n2. Binary Search\n3. Show All Books\n";
        while (true){
            try {
                System.out.println(menu);
                System.out.print("Choose One: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 0:
                        break;
                    case 1:
                        System.out.println("Enter the book title to search: ");
                        String book1 = sc.nextLine();
                        libraryManager.LinearSearch(book1);
                        break;
                    case 2:
                        System.out.println("Enter the book title to search: ");
                        String book2 = sc.nextLine();
                        libraryManager.BinarySearch(book2);
                        break;
                    case 3:
                        System.out.println("Books are : ");
                        libraryManager.displayBooks();
                    default:
                        System.out.println("Choose right option");
                        break;
                }
                if (choice == 0) {
                    System.out.println("Bye!");
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Wrong Input!");
                sc.nextLine();
            }
        }
    }
}