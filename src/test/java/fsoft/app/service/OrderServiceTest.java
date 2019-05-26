/**
 * 
 */
package fsoft.app.service;

import org.junit.*;
import org.mockito.*;
import fsoft.app.dao.OrderDao;
import fsoft.app.entities.Orders;
import fsoft.app.service.impl.OrderServiceImpl;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.*;
/**
 * @author Nguyen Thanh Cong
 *
 */
public class OrderServiceTest {
  
  @InjectMocks
  private OrderServiceImpl orderService;
  
  @Mock
  private OrderDao orderDao;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void testGetAllOrder() {
    when(orderDao.getAllOrder()).thenReturn(new ArrayList<Orders>());
    assertNotNull(orderService.getAllOrder());
  }
  @Test
  public void testGetOrderByID() throws SQLException{
    when(orderDao.getOrderById(1)).thenReturn(new Orders());
    assertNotNull(orderService.getOrderById(1));
  }
  @Test
  public void testGetOrderByIdFail() throws SQLException{
    when(orderDao.getOrderById(1)).thenReturn(null);
    assertNull(orderService.getOrderById(1));
  }
  @Test
  public void testAddOrder() throws SQLException{
    Orders order = new Orders();
    when(orderDao.addOrder(order)).thenReturn(order);
    assertNotNull(orderService.addOrder(order));
    
  }
  @Test
  public void testRemoveOrder() throws SQLException{
    int id = Mockito.anyInt();
    when(orderDao.removeOrder(id)).thenReturn(true);
    assertTrue(orderService.removeOrder(id));
  }
 
  
}
