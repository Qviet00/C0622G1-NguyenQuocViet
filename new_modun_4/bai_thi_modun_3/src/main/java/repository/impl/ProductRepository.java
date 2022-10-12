package repository.impl;

import model.Product;
import repository.Database;
import repository.IProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static final String FIND_ALL = "select * from san_pham";
    private static final String NEW_HOUSE = "insert into phong_tro(id,ten_san_pham,gia_san_pham,so_luong,mau_sac,id_danh_muc_san_pham) value(?,?,?,?,?,?);";
    private static final String DELETE_HOUSE = "delete from san_pham where id=?";
    private static final String EDIT_HOUSE = "update san_pham set ten_san_pham=?, gia_san_pham=?, so_luong=?, " +
            "mau_sac=?,mo_ta=? where id =? ";
    private static final String EDIT_BY_ID = "select * from san_pham where id=?";
    private static final String SEARCH = "select * from san_pham where ten_san_pham like ?";


    @Override
    public List<Product> selectAll() {
        List<Product>products = new ArrayList<>();
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("ten_san_pham");
                String price = rs.getString("gia_san_pham");
                int quantity = rs.getInt("so_luong");
                String color = rs.getString("mau_sac");
                int typeIdProuct = rs.getInt("id_danh_muc_san_pham");
                products.add(new Product(id,name,price,quantity,color,typeIdProuct));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean newHouse(Product house) {
        return false;
    }

    @Override
    public boolean editHouse(Product house) {
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
