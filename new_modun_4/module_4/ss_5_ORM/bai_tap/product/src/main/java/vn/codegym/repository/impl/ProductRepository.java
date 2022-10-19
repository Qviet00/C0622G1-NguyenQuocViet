package vn.codegym.repository.impl;

import org.springframework.stereotype.Repository;
import vn.codegym.model.Product;
import vn.codegym.repository.IProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepository implements IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager
                .createQuery("select s from Product as s", Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }
//    private static final Map<Integer, Product> products;
//
//    static {
//        products = new HashMap<>();
//        products.put(1, new Product(1, "XiaoMi", 100, "Còn hàng", "Mi"));
//        products.put(2, new Product(2, "Iphone", 200, "Hết hàng", "Apple"));
//        products.put(3, new Product(3, "Galaxy", 300, "Còn hàng", "Samsung"));
//        products.put(4, new Product(4, "Q-mobile", 400, "Hết hàng", "Q"));
//        products.put(5, new Product(5, "Realme", 500, "Còn hàng", "Xiaomi"));
//    }
//
//    @Override
//    public List<Product> findAll() {
//        return new ArrayList<>(products.values());
//    }
//
//    @Override
//    public void save(Product product) {
//        products.put(product.getId(), product);
//
//    }
//
//    @Override
//    public Product findById(int id) {
//        return products.get(id);
//    }
//
//    @Override
//    public void update(int id, Product product) {
//        products.put(id, product);
//    }
//
//    @Override
//    public void remove(int id) {
//        products.remove(id);
//
//    }
//
//    @Override
//    public List<Product> findByName(String name) {
//    List<Product> productList = findAll();
//    List<Product> products = new ArrayList<>();
//        for (int i = 0; i < productList.size(); i++) {
//            if (productList.get(i).getNameOfProduct().contains(name)){
//                products.add(productList.get(i));
//            }
//        }
//    return products;
//    }
}
