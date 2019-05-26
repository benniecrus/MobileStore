/**
 * 
 */
package fsoft.app.dao;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import fsoft.app.entities.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring-config-test.xml")
public class CategoryDaoTest {
  @Autowired
  CategoryDao categoryDao;
  
  @Test
  public void testGetAllCate() {
    assertNotNull(categoryDao.getAllCategories());
  }
  
  @Test
  public void testFindCateByID() {
    Category cate = categoryDao.findCategoryById(897);
    assertNull(cate);
  }
  @Test
  public void testFailFindCateByID() {
    try {
    Category cate = categoryDao.findCategoryById(1);
    assertNotNull(cate);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
