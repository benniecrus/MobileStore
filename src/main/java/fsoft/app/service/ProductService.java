package fsoft.app.service;

import java.sql.SQLException;
import java.util.List;
import fsoft.app.dto.ProductPageDto;
import fsoft.app.entities.Product;

public interface ProductService {
  Product createAndUpdateProduct(Product product);

  Product getProductById(int id);

  List<Product> getAllProduct() throws SQLException;

  ProductPageDto pagingProduct(int currentPage) throws SQLException;

  boolean updateDeleteProduct(Product product, boolean deleteFlag);

  Product updateProduct(Product oldProduct, Product newProduct);
}
