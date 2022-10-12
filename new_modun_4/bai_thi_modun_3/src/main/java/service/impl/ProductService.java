package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository iCategoryRepository=new ProductRepository();
    @Override
    public List<Product> selectAll() {
        return iCategoryRepository.selectAll();
    }

    @Override
    public boolean newHouse(Product product) {
        return false;
    }

    @Override
    public boolean editHouse(Product product) {
        return false;
    }

    @Override
    public boolean deleteHouse(int id) {
        return false;
    }

    @Override
    public List<Product> search(String name) {
        return null;
    }

    @Override
    public Product byId(int id) {
        return null;
    }
}
