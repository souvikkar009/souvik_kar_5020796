package utils;

import models.Product;
import services.InventoryOps;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Inventory implements InventoryOps {
    private static Inventory inventory = null;
    private static HashMap<Integer, Product> allProducts;
    Scanner sc = new Scanner(System.in);

    private Inventory(){
        allProducts = new HashMap<>();
    }

    public static Inventory getInventory(){
        if (inventory == null){
            inventory = new Inventory();
        }
        return inventory;
    }

    @Override
    public void addNewProductInInventory() {
        Product product = createProduct();
        if (product == null) return;
        if (!productNotExists(product.getProductId())){
            System.out.println("Product Already Exists!");
            return;
        }
        allProducts.put(product.getProductId(), product);
        System.out.println(product.getProductName() + " is added to Inventory.");
    }

    @Override
    public void deleteAProductFromInventory() {
        try {
            System.out.println("Enter productId: ");
            int productId = sc.nextInt();
            if (productNotExists(productId)){
                System.out.println("Product Not exists!");
                return;
            }
            if (allProducts.isEmpty()){
                System.out.println("Empty Inventory!");
                return;
            }
            Product product = allProducts.get(productId);
            allProducts.remove(productId);
            System.out.println(product.getProductName() + " is deleted from Inventory.");
        }catch (InputMismatchException e){
            System.out.println("Wrong Input");
            sc.nextLine();
        }

    }

    @Override
    public void updateAProductName() {
        try {
            System.out.println("Enter productId: ");
            int productId = sc.nextInt();
            sc.nextLine();
            if (productNotExists(productId)){
                System.out.println("Product Not exists!");
                return;
            }
            System.out.println("Enter new name: ");
            String newName = sc.nextLine();
            Product product = allProducts.get(productId);
            product.setProductName(newName);
            allProducts.put(productId, product);
            System.out.println("ProductId " + productId + " new Name " + newName);
        }catch (InputMismatchException e){
            System.out.println("Wrong Input");
            sc.nextLine();
        }

    }

    @Override
    public void updateAProductPrice() {
        try {
            System.out.println("Enter productId: ");
            int productId = sc.nextInt();
            if (productNotExists(productId)){
                System.out.println("Product Not exists!");
                return;
            }
            System.out.println("Enter price: ");
            int newPrice = sc.nextInt();
            Product product = allProducts.get(productId);
            product.setPrice(newPrice);
            allProducts.put(productId, product);
            System.out.println(product.getProductName() + " new price " + newPrice);
        }catch (InputMismatchException e){
            System.out.println("Wrong Input");
            sc.nextLine();
        }

    }

    @Override
    public void increaseAProductQuantity() {
        try {
            System.out.println("Enter productId: ");
            int productId = sc.nextInt();
            if (productNotExists(productId)){
                System.out.println("Product Not exists!");
                return;
            }
            System.out.println("Enter the quantity to increase: ");
            int increasingQuantity = sc.nextInt();
            Product product = allProducts.get(productId);
            int newQuantity = product.getQuantity() + increasingQuantity;
            product.setQuantity(newQuantity);
            System.out.println(product.getProductName() + " current quantity " + newQuantity);
        }catch (InputMismatchException e){
            System.out.println("Wrong Input");
            sc.nextLine();
        }

    }

    @Override
    public void decreaseAProductQuantity() {
        try {
            System.out.println("Enter productId: ");
            int productId = sc.nextInt();
            if (productNotExists(productId)){
                System.out.println("Product Not exists!");
                return;
            }
            System.out.println("Enter the quantity to decrease: ");
            int decreasingQuantity = sc.nextInt();
            Product product = allProducts.get(productId);
            int newQuantity = product.getQuantity() - decreasingQuantity;
            if (newQuantity < 0){
                System.out.println("Quantity going negative");
                return;
            }
            product.setQuantity(newQuantity);
            System.out.println(product.getProductName() + " current quantity " + newQuantity);
        }catch (InputMismatchException e){
            System.out.println("Wrong Input");
            sc.nextLine();
        }

    }

    @Override
    public void getAProductDetails() {
        try {
            System.out.println("Enter productId: ");
            int productId = sc.nextInt();
            if (productNotExists(productId)){
                System.out.println("Product Not exists!");
                return;
            }
            Product product = allProducts.get(productId);
            System.out.println(product);
        }catch (InputMismatchException e){
            System.out.println("Wrong Input");
            sc.nextLine();
        }
    }

    @Override
    public void getAllProductDetails() {
        if (allProducts.isEmpty()){
            System.out.println("Empty Inventory!");
            return;
        }
        for (Map.Entry<Integer, Product> allP : allProducts.entrySet()){
            System.out.println(allP.getValue().toString());
        }
    }

    private boolean productNotExists(int productId){
        return !allProducts.containsKey(productId);
    }

    private Product createProduct(){
        Product product = new Product();
        try {
            System.out.println("Enter Product Id: ");
            product.setProductId(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter Product Name: ");
            String name = sc.nextLine();
            product.setProductName(name);
            System.out.println("Enter Product Quantity: ");
            product.setQuantity(sc.nextInt());
            System.out.println("Enter Product Price: ");
            product.setPrice(sc.nextInt());
            return product;
        }catch (InputMismatchException e){
            System.out.println("Wrong Input!");
            sc.nextLine();
            return null;
        }
    }
}
