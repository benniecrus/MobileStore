package fsoft.app.service.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fsoft.app.dao.OrderDao;
import fsoft.app.dto.OrderPageDto;
import fsoft.app.dto.PageDto;
import fsoft.app.entities.Customer;
import fsoft.app.entities.OrderDetail;
import fsoft.app.entities.Orders;
import fsoft.app.service.OrderService;
import fsoft.app.service.PagingService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

  @Autowired
  OrderDao orderDao;

  @Autowired
  PagingService pagingService;

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .OrderService#
   * getAllOrder()
   */
  @Override
  public List<Orders> getAllOrder() {
    return orderDao.getAllOrder();
  }

  @Override
  public Orders addOrder(Orders orders) throws SQLException {
    return orderDao.addOrder(orders);
  }

  @Override
  public boolean removeOrder(int id) throws SQLException {
    return orderDao.removeOrder(id);
  }

  @Override
  public OrderDetail addOrderDetails(OrderDetail detail) throws SQLException {
    return orderDao.addOrderDetails(detail);
  }

  @Override
  public int addCart(Customer customer, List<OrderDetail> listOfOrderDetail) throws SQLException {
    return orderDao.addCart(customer, listOfOrderDetail);
  }

  @Override
  public Orders getOrderById(int id) throws SQLException {
    return orderDao.getOrderById(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .OrderService#
   * pagingOrder(int)
   */
  @Override
  public OrderPageDto pagingOrder(int currentPage) throws SQLException {
    // TODO
    // Auto-generated
    // method stub

    PageDto pageDto = pagingService.processPaging(currentPage, orderDao.getTotalOrder());

    List<Orders> orderList =
        orderDao.getPagingOrder(pageDto.getStartResult(), pageDto.getPerPage());

    OrderPageDto orderPageDto = new OrderPageDto(pageDto, orderList);

    return orderPageDto;
  }

}
