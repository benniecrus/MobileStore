/**
 * 
 */
package fsoft.app.service;

import java.util.List;
import fsoft.app.entities.Category;

/**
 * @author NamNV25
 *
 */
public interface CategoryService {
  List<Category> getAllCategories();

  Category findCategoryById(int categoryId);
}
