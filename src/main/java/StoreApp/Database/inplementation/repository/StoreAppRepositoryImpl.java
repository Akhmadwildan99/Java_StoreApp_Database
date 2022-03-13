package StoreApp.Database.inplementation.repository;

import StoreApp.Database.inplementation.entities.Product;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreAppRepositoryImpl implements StoreAppRepository{
    private DataSource dataSource;

    private Product productExist;

    public StoreAppRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        String sqlProduct = "SELECT * FROM product";
        try(Connection connection = dataSource.getConnection();
            Statement statement =connection.createStatement();
            ResultSet resultSetProduct =statement.executeQuery(sqlProduct)){
            ArrayList<Product> products = new ArrayList<>();
            while (resultSetProduct.next()){
                Product product = new Product();
                Integer id = resultSetProduct.getInt("id");
                String name = resultSetProduct.getString("name");
                Integer price = resultSetProduct.getInt("price");
                Integer total = resultSetProduct.getInt("total");
                Integer totalCurrent = resultSetProduct.getInt("totalCurrent");
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                product.setTotal(total);
                product.setTotalCurrent(totalCurrent);
                products.add(product);
            }
            return products;
        } catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    public boolean getProductIfExist(Product product){
        String sql = "SELECT * FROM product WHERE name = ? AND price = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()){
                    productExist = new Product();
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Integer price = resultSet.getInt("price");
                    Integer total = resultSet.getInt("total");
                    Integer totalCurrent = resultSet.getInt("totalCurrent");
                    productExist.setId(id);
                    productExist.setName(name);
                    productExist.setPrice(price);
                    productExist.setTotal(total);
                    productExist.setTotalCurrent(totalCurrent);
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void productIn(Product product) {
        if (getProductIfExist(product)){
            String sqlUpdateTableProduct = "UPDATE product SET totalCurrent = ? WHERE id = ?";
            String sqlCreateTableUpdate = "INSERT INTO update_total (productId, totalUpdate) VALUES (?, ?)";
            try(Connection connection = dataSource.getConnection();
            PreparedStatement statementUpdate = connection.prepareStatement(sqlUpdateTableProduct);
            PreparedStatement statementCreate = connection.prepareStatement(sqlCreateTableUpdate)){
                Integer updateTotal = productExist.getTotalCurrent() + product.getTotalCurrent();
                statementUpdate.setInt(1, updateTotal);
                statementUpdate.setInt(2, productExist.getId());
                statementCreate.setInt(1, productExist.getId());
                statementCreate.setInt(2, product.getTotalCurrent());
                statementUpdate.executeUpdate();
                statementCreate.executeUpdate();

            }catch (SQLException e){
                throw new RuntimeException(e);
            }
            productExist = new Product();
        } else {
            String sqlCreateTableProduct = "INSERT INTO product (name, price, total, totalCurrent) VALUES (?, ?, ?, ?) ";
            try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlCreateTableProduct)){
                statement.setString(1, product.getName());
                statement.setInt(2, product.getPrice());
                statement.setInt(3, product.getTotal());
                statement.setInt(4, product.getTotal());
                statement.executeUpdate();
            } catch (SQLException exception){
                throw new RuntimeException(exception);
            }
        }

    }

    @Override
    public void checkOut() {

    }
}
