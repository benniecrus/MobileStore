package fsoft.app.dao;

import java.sql.SQLException;
import java.util.List;
import fsoft.app.entities.Product;

/**
 * @author NamNV25
 *
 */
public interface ProductDao {
  Product createAndUpdateProduct(Product product);

  Product getProductById(int id);

  List<Product> getAllProduct() throws SQLException;

  List<Product> getPagingProduct(int resultStart, int maxResult);

  long getTotalProduct();

  boolean updateDeleteProduct(Product product);
}
