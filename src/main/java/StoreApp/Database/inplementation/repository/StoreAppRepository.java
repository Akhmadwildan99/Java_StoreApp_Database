package StoreApp.Database.inplementation.repository;

import StoreApp.Database.inplementation.entities.Product;

import java.util.ArrayList;

public interface StoreAppRepository {
    ArrayList<Product> getAllProduct();
    void productIn(Product product);
    void checkOut();
}
