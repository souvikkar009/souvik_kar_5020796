import utils.Inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = Inventory.getInventory();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Inventory Management System");
        String dash = "---------------------------------------------------";
        final String menu = "0. Exit Inventory Management System.\n1. Add new product\n2. Delete a product\n3. Update a product name\n4. Update a product price\n5. Increase a product quantity\n6. Decrease a product quantity\n7. Get a product details\n8. Get all product details";
        while (true){
            System.out.println(dash);
            System.out.println("*** Menu ***");
            System.out.println(dash);
            System.out.println(menu);
            System.out.println(dash);
            System.out.print("Choose One Option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 0:
                    break;
                case 1:
                    inventory.addNewProductInInventory();
                    break;
                case 2:
                    inventory.deleteAProductFromInventory();
                    break;
                case 3:
                    inventory.updateAProductName();
                    break;
                case 4:
                    inventory.updateAProductPrice();
                    break;
                case 5:
                    inventory.increaseAProductQuantity();
                    break;
                case 6:
                    inventory.decreaseAProductQuantity();
                    break;
                case 7:
                    inventory.getAProductDetails();
                    break;
                case 8:
                    inventory.getAllProductDetails();
                    break;
                default:
                    System.out.println("Choose correct options");
                    break;
            }
            if (choice == 0){
                System.out.println("Bye!");
                break;
            }
        }
    }
}