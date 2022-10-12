package repository.impl;

import model.Category;
import repository.Database;
import repository.ICategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private static final String FIN_ALL = "select * from danh_muc";

    @Override
    public List<Category> seclectAll() {
        List<Category> categories = new ArrayList<>();
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIN_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id_danh_muc");
                String nameType= rs.getString("ten_danh_muc");
                categories.add(new Category(id,nameType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
