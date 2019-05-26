package fsoft.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import fsoft.app.dto.ProductPageDto;
import fsoft.app.entities.Category;
import fsoft.app.entities.Manufacture;
import fsoft.app.entities.OrderDetail;
import fsoft.app.entities.Product;
import fsoft.app.service.CategoryService;
import fsoft.app.service.ManufactureService;
import fsoft.app.service.ProductService;
import fsoft.app.utils.FileUtils;

/**
 * @author NamNV25
 *
 */
@Controller
public class ProductController {

  @Autowired
  private CategoryService categoryService;

  @Autowired
  private ManufactureService manufactureService;

  @Autowired
  private ProductService productService;

  /**
   * initialize add product page.
   * @param modelMap
   * @return
   */
  @RequestMapping("/initAddProduct")
  public String initAddProduct(ModelMap modelMap) {
    List<Category> categories = categoryService.getAllCategories();
    modelMap.addAttribute("categories", categories);
    List<Manufacture> manufactures = manufactureService.getAllManufacture();
    modelMap.addAttribute("manufactures", manufactures);
    return "product-add";
  }

  /**
   * @param product
   * @param productName
   * @param categoryId
   * @param manufactureId
   * @param file
   * @return
   * @throws IOException
   */
  @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
  public String addProduct(@ModelAttribute Product product,
      @RequestParam("productName") String productName,
      @RequestParam(value = "categoryId") int categoryId, @RequestParam int manufactureId,
      @RequestParam MultipartFile file) throws IOException {

    Category category = categoryService.findCategoryById(categoryId);
    Manufacture manufacture = manufactureService.getManufactureById(manufactureId);
    product.setManufacture(manufacture);
    product.setCategory(category);

    product.setBase64Image(FileUtils.processFileToBase64Encode(file));

    product = productService.createAndUpdateProduct(product);

    if (product == null)
      throw new NullPointerException();

    return "redirect:initProducManagement";
  }

  /**
   * @param modelMap
   * @param currentPage
   * @param session
   * @return
   */
  @RequestMapping("/product-list")
  public String getAllProduct(ModelMap modelMap, @RequestParam(defaultValue = "1") int currentPage,
      HttpSession session) {
    try {
      ProductPageDto productPageDto = productService.pagingProduct(currentPage);
      @SuppressWarnings("unchecked")
      List<OrderDetail> cart = (ArrayList<OrderDetail>) session.getAttribute("cart");
      if (cart != null) {
        modelMap.addAttribute("cartSize", cart.size());
      } else {
        modelMap.addAttribute("cartSize", 0);
      }
      modelMap.addAttribute("productPageDto", productPageDto);

      return "product-list";
    } catch (SQLException e) {
      e.printStackTrace();
      return "error-page";
    }
  }

  /**
   * @param modelMap
   * @param id
   * @return
   */
  @RequestMapping(value = "/product/{id}")
  public String getProductById(ModelMap modelMap, @PathVariable(value = "id") int id) {
    Product product;
    Manufacture manufacture;
    Category category;
    try {
      product = productService.getProductById(id);
      manufacture = product.getManufacture();
      category = product.getCategory();
      modelMap.addAttribute("product", product);
      modelMap.addAttribute("manufacture", manufacture);
      modelMap.addAttribute("category", category);
      return "product-details";
    } catch (Exception e) {
      e.printStackTrace();
      return "error-page";
    }
  }


  /**
   * @param modelMap
   *        the model
   *        map
   * @return product
   *         management
   *         page
   * @throws SQLException
   */
  @RequestMapping("initProducManagement")
  public String initProductManagement(ModelMap modelMap) throws SQLException {

    List<Product> productList = productService.getAllProduct();

    modelMap.addAttribute(productList);

    return "product-manager";
  }

  /**
   * @param productId
   * @param deleteFlag
   * @return
   */
  @RequestMapping("activeProduct")
  public String activeProduct(@RequestParam int productId, @RequestParam boolean deleteFlag) {

    Product product = productService.getProductById(productId);

    if (product != null && (deleteFlag == true || deleteFlag == false))
      productService.updateDeleteProduct(product, deleteFlag);

    return "redirect:initProducManagement";
  }

  /**
   * @param productId
   *        product id
   * @param product
   *        product
   *        model
   * @return
   * @throws IOException
   */
  @RequestMapping("editProduct")
  public String editProduct(@RequestParam int productId, @ModelAttribute Product product,
      @RequestParam(value = "categoryId") int categoryId, @RequestParam int manufactureId,
      @RequestParam MultipartFile file) throws IOException {

    Product oldProduct = productService.getProductById(productId);

    Category category = categoryService.findCategoryById(categoryId);
    Manufacture manufacture = manufactureService.getManufactureById(manufactureId);
    product.setManufacture(manufacture);
    product.setCategory(category);

    if (file != null)
      product.setBase64Image(FileUtils.processFileToBase64Encode(file));

    product = productService.updateProduct(oldProduct, product);

    return "redirect:initProducManagement";
  }

  /**
   * @param modelMap
   *        model map
   * @param productId
   *        product id
   * @return
   */
  @RequestMapping("initEditProduct")
  public String initEditProduct(ModelMap modelMap, @RequestParam int productId) {
    List<Category> categories = categoryService.getAllCategories();
    modelMap.addAttribute("categories", categories);
    List<Manufacture> manufactures = manufactureService.getAllManufacture();
    modelMap.addAttribute("manufactures", manufactures);
    Product product = productService.getProductById(productId);
    modelMap.addAttribute(product);

    return "edit-product";
  }
}
