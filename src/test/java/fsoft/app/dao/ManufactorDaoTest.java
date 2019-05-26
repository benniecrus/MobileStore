/**
 * 
 */
package fsoft.app.dao;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import fsoft.app.entities.Manufacture;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring-config-test.xml")
public class ManufactorDaoTest {
  @Autowired
  ManufactureDao manufactureDao;

  @Test
  public void getManById() {
    Manufacture man1 = manufactureDao.findManufactureById(1);
    assertNotNull(man1);
  }
  
  @Test
  public void AtestGetManById() {
    try {
      Manufacture man2 = manufactureDao.findManufactureById(100);
      assertNull(man2);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void getAllMan() {
    List<Manufacture> listMan = manufactureDao.getAllManufacture();
    assertNotNull(listMan);
  }
}
