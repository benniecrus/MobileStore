package fsoft.app.dao;

import static org.junit.Assert.assertNotNull;
import java.sql.SQLException;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import fsoft.app.entities.Customer;
import fsoft.app.entities.Orders;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring-config-test.xml")
public class CustomersDaoTest {
  
  @Autowired
  CustomerDao customerDao;
  @Autowired
  OrderDao orderDao;
  
  @Test
  public void addCustomer() throws SQLException {
    Customer customer = new Customer();
    List<Orders> ordersList = orderDao.getAllOrder();
    
    customer.setCustomerId(2);
    customer.setAddress("HN");
    customer.setCustomerName("TrangDTV");
    customer.setOrdersList(ordersList);
    customer.setPhoneNumber("09876653435");
    
    assertNotNull(customerDao.addCustomer(customer));
    
  }
 
  

}
