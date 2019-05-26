/**
 * 
 */
package fsoft.app.service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import fsoft.app.dao.CategoryDao;
import fsoft.app.entities.Category;
import fsoft.app.service.impl.CategoryServiceImpl;

/**
 * @author Nguyen
 *         Thanh
 *         Cong
 *
 */
public class CategoryServiceTest {

  @Mock
  private CategoryDao categoryDao;

  @InjectMocks
  private CategoryServiceImpl categoryService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getAllCategoriesSuccess() {
    Mockito.when(categoryDao.getAllCategories()).thenReturn(new ArrayList<>());
    List<Category> list = categoryService.getAllCategories();
    assertNotNull(list);
  }
  
  @Test
  public void testFindcateById() {
    when(categoryDao.findCategoryById(1)).thenReturn(new Category());
    assertNotNull(categoryService.findCategoryById(1));
  }
  
  @Test
  public void testFindcateByIdFail() {
    when(categoryDao.findCategoryById(1)).thenReturn(null);
    assertNull(categoryService.findCategoryById(1));
  }
}
