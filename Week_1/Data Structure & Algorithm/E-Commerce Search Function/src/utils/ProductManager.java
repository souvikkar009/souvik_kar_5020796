package utils;

import models.Product;
import services.SearchFunctions;

import java.util.*;

public class ProductManager implements SearchFunctions {
    private static ProductManager productManager = null;
    private static List<Product> unsortedList;
    private static List<Product> sortedList;
    Scanner sc = new Scanner(System.in);

    private ProductManager(){
        unsortedList = new ArrayList<>();
        sortedList = new ArrayList<>();
    }

    public static ProductManager getProductManager(){
        if (productManager == null){
            productManager = new ProductManager();
        }
        return productManager;
    }

    public void storeProducts(int size){
        System.out.println("*** Store Products ***");

        for (int i = 0; i < size; i++) {

            Product product = new Product();
            System.out.println("Enter productId: ");
            product.setProductId(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter product name: ");
            product.setProductName(sc.nextLine());
            System.out.println("Enter product category");
            product.setCategory(sc.nextLine());
            unsortedList.add(product);
            sortedList.add(product);
        }
        sortedList.sort(Comparator.comparing(Product::getProductName));

    }

    public void displayUnsortedProducts(){
        for(Product product : unsortedList){
            System.out.println(product);
        }
    }

    public void displaySortedProducts(){
        for(Product product : sortedList){
            System.out.println(product);
        }
    }

    @Override
    public void LinearSearch(String productName) {
        for (Product product : unsortedList) {
            if (product.getProductName().equals(productName)) {
                System.out.println("Product Found!");
                System.out.println(product);
                break;
            }
        }
        System.out.println("Product Not Found!");
    }

    @Override
    public void BinarySearch(String productName) {
        int ub = sortedList.size() - 1;
        int lb = 0;

        while (lb <= ub){
            int mid = (ub - lb) / 2 + lb;
            if (sortedList.get(mid).getProductName().compareTo(productName) == 0){
                System.out.println("Product Found!");
                System.out.println(sortedList.get(mid));
                return;
            }else if(sortedList.get(mid).getProductName().compareTo(productName) > 0){
                ub = mid - 1;
            }else {
                lb = mid + 1;
            }
        }
        System.out.println("Product Not Found!");
    }
}
