package fsoft.app.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fsoft.app.dao.OrderDao;
import fsoft.app.entities.Customer;
import fsoft.app.entities.OrderDetail;
import fsoft.app.entities.OrderDetailPK;
import fsoft.app.entities.Orders;
import fsoft.app.utils.HibernateUtils;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao {

  @Autowired
  private SessionFactory sessionFactory;

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao
   * .OrderDao
   * #getAllOrder()
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Orders> getAllOrder() {
    String sqlCmd = "From Orders";
    Session session = HibernateUtils.getSession(sessionFactory);
    List<Orders> orderList = session.createQuery(sqlCmd).list();
    HibernateUtils.closeSession(session);
    if (orderList == null)
      return new ArrayList<>();
    return orderList;
  }

  /*
   * DongTV3 Method
   * will add order
   * into database
   * throws
   * SQLException
   */
  @Override
  public Orders addOrder(Orders orders) throws SQLException {
    Session session = HibernateUtils.getSession(sessionFactory);
    session.save(orders);
    HibernateUtils.closeSession(session);
    return orders;
  }

  /*
   * CongNT12 Method
   * will update
   * delete_flag of
   * order in database
   * throws
   * SQLException
   */
  @Override
  public boolean removeOrder(int id) throws SQLException {
    Session session = HibernateUtils.getSession(sessionFactory);
    Query query = session.getNamedQuery("Orders.removeById");
    query.setParameter("orderId", id);
    query.executeUpdate();
    HibernateUtils.closeSession(session);
    return true;
  }

  /*
   * DongTV3 Method
   * will add Order
   * details throws
   * SQLException
   */
  @Override
  public OrderDetail addOrderDetails(OrderDetail detail) throws SQLException {
    Session session = HibernateUtils.getSession(sessionFactory);
    Transaction transaction = session.beginTransaction();
    session.save(detail);
    transaction.commit();
    HibernateUtils.closeSession(session);
    return detail;
  }

  /*
   * DongTV3 To method
   * will save
   * customer, order,
   * and list order
   * detail, if
   * exception data is
   * rollback.
   * 
   * @Parameter
   * customer
   * infomation
   * customer get from
   * UI
   * 
   * @Parameter
   * listOfOrderDetail
   * list of order
   * detail
   */
  @Override
  public int addCart(Customer customer, List<OrderDetail> listOfOrderDetail) throws SQLException {
    Session session = HibernateUtils.getSession(sessionFactory);
    Transaction transaction = session.beginTransaction();
    try {
      session.save(customer);
      Orders orders2 = new Orders(new Date(), "processing", customer);
      session.save(orders2);
      for (OrderDetail orderDetail : listOfOrderDetail) {
        orderDetail.setOrderDetailPK(
            new OrderDetailPK(orders2.getOrderId(), orderDetail.getProduct().getProductId()));
        orderDetail.setOrders(orders2);
        session.save(orderDetail);
      }
      transaction.commit();
      HibernateUtils.closeSession(session);
      return orders2.getOrderId();
    } catch (Exception e) {
      e.printStackTrace();
      transaction.rollback();
    }
    return 0;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * OrderDao#
   * getOrderById(int)
   */
  @Override
  public Orders getOrderById(int id) {
    Session session = HibernateUtils.getSession(sessionFactory);
    Orders orders = (Orders) session.get(Orders.class, id);
    HibernateUtils.closeSession(session);
    return orders;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * OrderDao#
   * getTotalOrder()
   */
  @Override
  public long getTotalOrder() {

    Session session = HibernateUtils.getSession(sessionFactory);

    Query query = session.createQuery("SELECT COUNT(*) FROM Orders");

    long count = (long) query.uniqueResult();

    HibernateUtils.closeSession(session);

    return count;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * OrderDao#
   * getPagingOrder(
   * int, int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Orders> getPagingOrder(int resultStart, int maxResults) {
    // TODO
    // Auto-generated
    // method stub
    Session session = HibernateUtils.getSession(sessionFactory);

    Query query =
        session.createQuery("From Orders").setFirstResult(resultStart).setMaxResults(maxResults);

    List<Orders> orderList = query.list();

    HibernateUtils.closeSession(session);

    if (orderList == null) {
      return new ArrayList<>();
    }

    return orderList;
  }

}
