import utils.ProductManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dash = "---------------------------------------------------";
        System.out.println("Enter the number of product to store: ");
        int nProduct = sc.nextInt();
        sc.nextLine();
        System.out.println(dash);
        ProductManager productManager = ProductManager.getProductManager();
        productManager.storeProducts(nProduct);
        System.out.println(dash);
        String menu = "0. Exit\n1. Linear Search\n2. Binary Search\n3. Show All Products\n";
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
                        System.out.println("Enter the product name to search: ");
                        String productName1 = sc.nextLine();
                        productManager.LinearSearch(productName1);
                        break;
                    case 2:
                        System.out.println("Enter the product name to search: ");
                        String productName2 = sc.nextLine();
                        productManager.BinarySearch(productName2);
                        break;
                    case 3:
                        System.out.println("Products are : ");
                        productManager.displaySortedProducts();
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