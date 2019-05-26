package fsoft.app.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import fsoft.app.entities.Category;
import fsoft.app.entities.Manufacture;
import fsoft.app.entities.Product;
import java.sql.SQLException;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
    locations = "file:src/main/webapp/WEB-INF/spring-config-test.xml")
public class ProductDaoTest {
  @Autowired
  ProductDao productDao;

  @Test
  public void testGetProductById() {
    Product product = productDao.getProductById(1);
    assertNotNull(product);
  }

  @Test
  public void AtestGetProdcutById() {
    try {
      Product product2 = productDao.getProductById(1163);
      assertNull(product2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testGetAllProduct() throws SQLException {
    List<Product> listProduct = productDao.getAllProduct();
    assertNotNull(listProduct);
  }

  @Test
  public void testAddProduct() {
    Product product = new Product();
    product.setProductId(1);
    product.setCategory(new Category(1));
    product.setManufacture(new Manufacture(1));
    product.setCondition(Short.valueOf("1"));
    product.setProductDescription("ABCXYZZZZZZZZZZZZZZZZZZZZZZZZZ");
    product.setProductName("ABCXYZ");
    product.setUnitPrice(Long.valueOf("222"));
    product.setUnitInStock(5);
    assertNotNull(productDao.createAndUpdateProduct(product));
  }

  @Test
  public void testGetPagingProduct() {
    int resultStart = 3;
    int maxResult = 6;
    assertNotNull(productDao.getPagingProduct(resultStart, maxResult));
  }

  @Test
  public void testGetTotalProduct() {
    assertNotNull(productDao.getTotalProduct());
  }
}
