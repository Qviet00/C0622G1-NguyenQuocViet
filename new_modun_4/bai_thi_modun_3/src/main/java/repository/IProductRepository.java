package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAll();
    boolean newHouse(Product house);
    boolean editHouse(Product house);
    public boolean deleteHouse(int id);
    List<Product> search(String name);
    Product byId(int id);
}
