/**
 * 
 */
package fsoft.app.dao;

import java.util.List;
import fsoft.app.entities.Category;

/**
 * @author NamNV25
 *
 */
public interface CategoryDao {
  List<Category> getAllCategories();

  Category findCategoryById(int categoryId);
}
