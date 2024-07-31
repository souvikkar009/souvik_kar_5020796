package services;

public interface InventoryOps {
    public void addNewProductInInventory();
    public void deleteAProductFromInventory();
    public void updateAProductName();
    public void updateAProductPrice();
    public void increaseAProductQuantity();
    public void decreaseAProductQuantity();
    public void getAProductDetails();
    public void getAllProductDetails();

}
