package StoreApp.Database.inplementation.repository;

import StoreApp.Database.inplementation.entities.Product;
import StoreApp.Database.inplementation.util.ConnectionUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepositoryTest {
    private HikariDataSource dataSource;
    private StoreAppRepository storeAppRepository;
    @BeforeEach
    void setUp() throws SQLException {
        dataSource = ConnectionUtil.getDataSource();
        storeAppRepository = new StoreAppRepositoryImpl(dataSource);
    }

    @Test
    void testGetAllProduct() {
        ArrayList<Product> allProduct = storeAppRepository.getAllProduct();
        Assertions.assertNotNull(allProduct, "tidak null atau ada datanya");
        for (int i = 0; i < allProduct.size(); i++) {
            var get = allProduct.get(i);
            System.out.println(i+1 + ". " + get.getName() + " | " + get.getPrice() + " | " + get.getTotal());
        }
    }

    @Test
    void testProductUpdate() throws SQLException {
        Product product = new Product();
        product.setName("nescafe");
        product.setPrice(3000);
        product.setTotal(30);
        product.setTotalCurrent(30);

        storeAppRepository.productIn(product);

//        String sql = "SELECT * FROM product WHERE name = ? AND price = ?";
//        Connection connection = dataSource.getConnection();
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, product.getName());
//        statement.setInt(2, product.getPrice());
//        ResultSet resultSet = statement.executeQuery();
//        Assertions.assertEquals("nescafe", resultSet.getString("name"));
//        Assertions.assertEquals(80, resultSet.getInt("totalCurrent"));
    }

    @Test
    void testProductIn() throws SQLException {
        Product product = new Product();
        product.setName("kopi luwak");
        product.setPrice(3000);
        product.setTotal(100);

        storeAppRepository.productIn(product);

//        String sql = "SELECT * FROM product WHERE name = ? AND price = ?";
//        Connection connection = dataSource.getConnection();
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, product.getName());
//        statement.setInt(2, product.getPrice());
//        ResultSet resultSet = statement.executeQuery();
//        Assertions.assertEquals(100, resultSet.getString("total"));
//        Assertions.assertEquals(100, resultSet.getInt("totalCurrent"));
    }
}
