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
        product.setName("kapalapi");
        product.setPrice(3000);
        product.setTotal(30);
        product.setTotalCurrent(30);

        storeAppRepository.productIn(product);

        String sql = "SELECT * FROM product WHERE name = ? AND price = ?";
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        ResultSet resultSet = statement.executeQuery();
        Product productQuery = new Product();
        if(resultSet.next()){
            var name = resultSet.getString("name");
            var totalCurrent = resultSet.getInt("totalCurrent");
            productQuery.setName(name);
            productQuery.setTotalCurrent(totalCurrent);
        }
        Assertions.assertEquals("kapalapi", productQuery.getName());
        Assertions.assertEquals(60, productQuery.getTotalCurrent());
    }

    @Test
    void testProductIn() throws SQLException {
        Product product = new Product();
        product.setName("kopi gayo");
        product.setPrice(3000);
        product.setTotal(80);

        storeAppRepository.productIn(product);

        String sql = "SELECT * FROM product WHERE name = ? AND price = ?";
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        ResultSet resultSet = statement.executeQuery();
        Product productQuery = new Product();
        if(resultSet.next()){
            var total = resultSet.getInt("total");
            var totalCurrent = resultSet.getInt("totalCurrent");
            productQuery.setTotal(total);
            productQuery.setTotalCurrent(totalCurrent);
        }
        Assertions.assertEquals(80, productQuery.getTotal());
        Assertions.assertEquals(80, productQuery.getTotalCurrent());
    }
}
