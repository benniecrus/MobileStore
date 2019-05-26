/**
 * 
 */
package fsoft.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fsoft.app.dao.CategoryDao;
import fsoft.app.entities.Category;
import fsoft.app.service.CategoryService;

/**
 * @author NamNV25
 *
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryDao categoryDao;

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .CategoryService#
   * getAllCategories(
   * )
   */
  @Override
  public List<Category> getAllCategories() {
    // TODO
    // Auto-generated
    // method stub
    return categoryDao.getAllCategories();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .CategoryService#
   * findCategoryById(
   * int)
   */
  @Override
  public Category findCategoryById(int categoryId) {
    // TODO
    // Auto-generated
    // method stub
    return categoryDao.findCategoryById(categoryId);
  }

}
