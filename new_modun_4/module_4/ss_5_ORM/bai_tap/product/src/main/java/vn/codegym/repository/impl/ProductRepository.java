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
    public void save(Product product) {entityManager.persist(product);

    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public void update(int id, Product product) {
        entityManager.merge(product);
    }

    @Override
    public void remove(Product product) {
        product = entityManager.merge(product);
        entityManager.remove(product);
    }


    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = entityManager
                .createQuery("select p FROM Product as p WHERE p.nameOfProduct like :name", Product.class)
                .setParameter(name,"%"+name+"%");
        return query.getResultList();
    }

}
