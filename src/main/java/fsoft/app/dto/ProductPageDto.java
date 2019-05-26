/**
 * 
 */
package fsoft.app.dto;

import java.util.List;
import fsoft.app.entities.Product;

/**
 * @author NamNV25
 *
 */
public class ProductPageDto {
  PageDto pageDto;
  List<Product> productList;

  public ProductPageDto() {
    super();
  }

  public ProductPageDto(PageDto pageDto, List<Product> productList) {
    super();
    this.pageDto = pageDto;
    this.productList = productList;
  }

  public PageDto getPageDto() {
    return pageDto;
  }

  public void setPageDto(PageDto pageDto) {
    this.pageDto = pageDto;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }


}
