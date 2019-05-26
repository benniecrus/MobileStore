package fsoft.app.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fsoft.app.dao.ProductDao;
import fsoft.app.dto.PageDto;
import fsoft.app.dto.ProductPageDto;
import fsoft.app.entities.Product;
import fsoft.app.service.PagingService;
import fsoft.app.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductDao productDao;

  @Autowired
  private PagingService pagingService;

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .ProductService#
   * createProduct(
   * fsoft.app.
   * entities.Product
   * )
   */
  @Override
  public Product createAndUpdateProduct(Product product) {
    // TODO
    // Auto-generated
    // method stub
    product.setUpdateTime(new Date());
    return productDao.createAndUpdateProduct(product);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .ProductService#
   * getProductById(
   * int)
   */
  @Override
  public Product getProductById(int id) {
    // TODO
    // Auto-generated
    // method stub
    Product product = productDao.getProductById(id);
    return product;
  }

  /*
   * Method will get
   * all product
   * throws
   * SQLException
   */
  @Override
  public List<Product> getAllProduct() throws SQLException {
    return productDao.getAllProduct();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .ProductService#
   * pagingProduct(
   * int)
   */
  @Override
  public ProductPageDto pagingProduct(int currentPage) throws SQLException {

    PageDto pageDto = pagingService.processPaging(currentPage, productDao.getTotalProduct());

    List<Product> productList =
        productDao.getPagingProduct(pageDto.getStartResult(), pageDto.getPerPage());

    ProductPageDto productPageDto = new ProductPageDto(pageDto, productList);

    return productPageDto;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .ProductService#
   * updateDeleteProduct
   * (fsoft.app.
   * entities.Product,
   * boolean)
   */
  @Override
  public boolean updateDeleteProduct(Product product, boolean deleteFlag) {
    // TODO
    // Auto-generated
    // method stub

    product.setDeleteFlag(deleteFlag);
    product.setUpdateTime(new Date());
    return productDao.updateDeleteProduct(product);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .ProductService#
   * updateProduct(
   * fsoft.app.
   * entities.Product,
   * fsoft.app.
   * entities.Product)
   */
  @Override
  public Product updateProduct(Product oldProduct, Product newProduct) {
    // TODO
    // Auto-generated
    // method stub

    boolean isChange = false;

    if (!newProduct.getBase64Image().isEmpty()
        && !oldProduct.getBase64Image().equals(newProduct.getBase64Image())) {
      oldProduct.setBase64Image(newProduct.getBase64Image());
      isChange = true;
    }

    if (!newProduct.getProductName().isEmpty()
        && !oldProduct.getProductName().equals(newProduct.getProductName())) {
      oldProduct.setProductName(newProduct.getProductName());
      isChange = true;
    }

    if (newProduct.getUnitPrice() != 0 && oldProduct.getUnitPrice() != newProduct.getUnitPrice()) {
      oldProduct.setUnitPrice(newProduct.getUnitPrice());
      isChange = true;
    }

    if (oldProduct.getUnitInStock() != newProduct.getUnitInStock()) {
      oldProduct.setUnitInStock(newProduct.getUnitInStock());
      isChange = true;
    }

    if (!newProduct.getProductDescription().isEmpty()
        && !oldProduct.getProductDescription().equals(newProduct.getProductDescription())) {
      oldProduct.setProductDescription(newProduct.getProductDescription());
      isChange = true;
    }

    if (!newProduct.getProductDescription().isEmpty()
        && !oldProduct.getProductDescription().equals(newProduct.getProductDescription())) {
      oldProduct.setProductDescription(newProduct.getProductDescription());
      isChange = true;
    }

    if (newProduct.getCondition() != 0 && oldProduct.getCondition() != newProduct.getCondition()) {
      oldProduct.setCondition(newProduct.getCondition());
      isChange = true;
    }

    if (newProduct.getCategory() != null
        && !oldProduct.getCategory().equals(newProduct.getCategory())) {
      oldProduct.setCategory(newProduct.getCategory());
      isChange = true;
    }

    if (newProduct.getManufacture() != null
        && !oldProduct.getManufacture().equals(newProduct.getManufacture())) {
      oldProduct.setManufacture(newProduct.getManufacture());
      isChange = true;
    }
    if (isChange == true) {
      return productDao.createAndUpdateProduct(oldProduct);
    } else {
      return oldProduct;
    }
  }

}
