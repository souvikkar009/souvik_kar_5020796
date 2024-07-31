package utils;

import models.Order;
import services.SortFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManager implements SortFunctions {
    private static OrderManager orderManager = null;
    private static List<Order> allOrders;
    Scanner sc = new Scanner(System.in);

    private OrderManager(){
        allOrders = new ArrayList<>();
    }

    public static OrderManager getOrderManager(){
        if (orderManager == null){
            orderManager = new OrderManager();
        }
        return orderManager;
    }

    public void storeOrders(int size){
        System.out.println("*** Store Orders ***");

        for (int i = 0; i < size; i++) {
            Order order = new Order();
            System.out.println("Enter orderId: ");
            order.setOrderId(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter customer name: ");
            order.setCustomerName(sc.nextLine());
            System.out.println("Enter order total price: ");
            order.setTotalPrice(sc.nextInt());
            allOrders.add(order);
        }
    }

    public void displayAllOrder(){
        System.out.println("Order List:");
        for (Order order : allOrders){
            System.out.println(order);
        }
    }

    @Override
    public void bubbleSort() {
        int n = allOrders.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                if(allOrders.get(j).getTotalPrice() > allOrders.get(j - 1).getTotalPrice()){
                    Order temp = allOrders.get(j);
                    allOrders.set(j, allOrders.get(j - 1));
                    allOrders.set(j - 1, temp);
                }
            }
        }
    }

    @Override
    public void quickSort() {
        helper(0, allOrders.size() - 1);
    }

    private void helper(int lb, int ub){
        if(lb < ub){
            int loc = partition(lb, ub);
            helper(lb, loc - 1);
            helper(loc + 1, ub);
        }
    }
    private static void swap(int idx1, int idx2){
        Order temp = allOrders.get(idx1);
        allOrders.set(idx1, allOrders.get(idx2));
        allOrders.set(idx2, temp);
    }

    private static int partition(int lb, int ub) {
        int piv = allOrders.get(lb).getTotalPrice();
        int start = lb;
        int end = ub;

        while (start < end){
            while (start <= ub && allOrders.get(start).getTotalPrice() >= piv) start++;
            while (end >= lb  && allOrders.get(end).getTotalPrice() < piv) end--;
            if (start < end){
                swap(start, end);
            }
        }
        swap(lb, end);
        return end;
    }
}
