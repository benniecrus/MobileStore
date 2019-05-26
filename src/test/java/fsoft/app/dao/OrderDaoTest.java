/**
 * 
 */
package fsoft.app.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import fsoft.app.entities.Customer;
import fsoft.app.entities.OrderDetail;
import fsoft.app.entities.OrderDetailPK;
import fsoft.app.entities.Orders;
import fsoft.app.entities.Product;

/**
 * @author NamNV25,
 *         TrangDTV
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
    locations = "file:src/main/webapp/WEB-INF/spring-config-test.xml")
public class OrderDaoTest {

  @Autowired
  private OrderDao orderDao;
  @Autowired
  private CustomerDao customerDao;
  @Autowired
  private ProductDao productDao;

  @Test
  public void testGetAllOrders() {
    List<Orders> orders = orderDao.getAllOrder();
    Assert.assertNotNull(orders);
  }

  @Test
  public void testAddOrders() throws SQLException {
    Orders order = new Orders();
    Customer customer = new Customer();

    order.setStatus("processing");
    order.setCustomer(customer);

    Assert.assertNotNull(orderDao.addOrder(order));

  }

  @Test
  public void testRemoveOrders() throws SQLException {
    int id = 1;
    Assert.assertTrue(orderDao.removeOrder(id));

  }

  @Test
  public void testAddOrderDetail() throws SQLException {
    Product product = new Product();
    product.setCondition(Short.valueOf("1"));
    product.setProductDescription("ABCXYZZZZZZZZZZZZZZZZZZZZZZZZZ");
    product.setProductName("ABCXYZ");
    product.setUnitPrice(Long.valueOf("222"));
    product.setUnitInStock(5);
    product = productDao.createAndUpdateProduct(product);

    Orders order = new Orders();
    order.setStatus("processing");

    order = orderDao.addOrder(order);

    OrderDetail orderDetail = new OrderDetail();

    orderDetail.setOrderDetailPK(new OrderDetailPK(order.getOrderId(), product
        .getProductId()));

    orderDetail.setQuantity(2);

    orderDao.addOrderDetails(orderDetail);

  }

  @Test
  public void testAddCart() throws SQLException {
    Customer customer = new Customer();
    customer.setCustomerId(2);
    customer.setCustomerName("Trang");
    customer.setAddress("HN");
    customer.setPhoneNumber("09877436445");
    customer.setOrdersList(null);

    List<OrderDetail> listOfOrderDetail = new ArrayList<OrderDetail>();
    OrderDetail orderDetail = new OrderDetail();

    Orders order = new Orders();
    order.setStatus("processing");

    Product product = new Product();
    product.setProductId(4);

    orderDetail.setOrders(order);
    orderDetail.setQuantity(2);
    orderDetail.setProduct(product);

    int result = orderDao.addCart(customer, listOfOrderDetail);
    assertTrue(result != 0);

    listOfOrderDetail.add(orderDetail);
    int rs = orderDao.addCart(customer, listOfOrderDetail);
    assertTrue(rs != 0);

  }

  @Test
  public void testGetOrderById() throws SQLException {
    int id = 4;
    Orders orders = orderDao.getOrderById(id);
    assertTrue(orders != null);

  }

  @Test
  public void testGetTotalOrder() throws SQLException {

    long total = orderDao.getTotalOrder();
    System.out.println(total);
    assertNotNull(total);
  }

  @Test
  public void testGetPagingOrder() throws SQLException {
    int resultStart = 3;
    int maxResult = 6;

    List<Orders> orderList = orderDao.getPagingOrder(resultStart, maxResult);
    assertNotNull(orderList);
  }

}
