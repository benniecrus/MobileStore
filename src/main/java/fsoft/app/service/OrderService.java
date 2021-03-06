package fsoft.app.service;

import java.sql.SQLException;
import java.util.List;
import fsoft.app.dto.OrderPageDto;
import fsoft.app.entities.Customer;
import fsoft.app.entities.OrderDetail;
import fsoft.app.entities.Orders;

public interface OrderService {
  List<Orders> getAllOrder();

  Orders addOrder(Orders orders) throws SQLException;

  boolean removeOrder(int id) throws SQLException;

  OrderDetail addOrderDetails(OrderDetail detail) throws SQLException;

  int addCart(Customer customer, List<OrderDetail> listOfOrderDetail) throws SQLException;

  Orders getOrderById(int id) throws SQLException;

  OrderPageDto pagingOrder(int currentPage) throws SQLException;
}
