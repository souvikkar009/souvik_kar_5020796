import utils.OrderManager;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dash = "---------------------------------------------------";
        System.out.println("Enter the number of Orders to store: ");
        int nOrders = sc.nextInt();
        sc.nextLine();
        System.out.println(dash);
        OrderManager orderManager = OrderManager.getOrderManager();
        orderManager.storeOrders(nOrders);
        System.out.println(dash);
        System.out.println("Orders before sorting: ");
        orderManager.displayAllOrder();
        System.out.println(dash);
        System.out.println("Orders after sorting: ");
        orderManager.quickSort();
//        orderManager.bubbleSort();
        orderManager.displayAllOrder();
    }
}