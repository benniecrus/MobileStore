/**
 * 
 */
package fsoft.app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import fsoft.app.dao.ProductDao;
import fsoft.app.service.AdministratorService;

/**
 * @author Nguyen Thanh Cong
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring-config-test.xml")
public class AdminControllerTest {
  
  private MockMvc mockMvc;
  
  @Autowired
  private AdministratorService administratorService;
  
  @Autowired
  private ProductDao productDao;
  
  @Test
  public void testLogin() {
    
  }
}
