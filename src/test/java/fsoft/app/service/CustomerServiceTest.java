/**
 * 
 */
package fsoft.app.service;

import org.junit.*;
import org.mockito.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import fsoft.app.dao.CustomerDao;
import fsoft.app.dao.impl.CustomerDaoImpl;
import fsoft.app.entities.Customer;
import fsoft.app.service.impl.CustomerServiceImpl;

/**
 * @author Nguyen Thanh Cong
 *
 */
public class CustomerServiceTest {
  @InjectMocks
  private CustomerServiceImpl customerService;
  @Mock
  private CustomerDao customerDao;
  
  @Before
  public void setUp() throws Exception {
       MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void testAddCustomer() throws SQLException{
    Customer customer = new Customer();
    when(customerDao.addCustomer(customer)).thenReturn(customer);
    assertNotNull(customerService.addCustomer(customer));
  }
  
}
