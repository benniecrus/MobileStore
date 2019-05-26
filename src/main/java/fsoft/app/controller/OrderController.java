package fsoft.app.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import fsoft.app.entities.OrderDetail;
import fsoft.app.entities.Orders;
import fsoft.app.service.OrderService;

@Controller
public class OrderController {

  @Autowired
  private OrderService orderService;

  /**
   * @param modelMap
   * @return
   */
  @RequestMapping("/order-list")
  public String getAllProduct(ModelMap modelMap) {
    List<Orders> listOfOrder = new ArrayList<Orders>();
    listOfOrder = orderService.getAllOrder();
    modelMap.addAttribute("listOfOrder", listOfOrder);
    return "order-list";

  }

  /**
   * @param modelMap
   * @param id
   * @param session
   * @return
   */
  @RequestMapping("/remove-order/{id}")
  public String removeOrder(ModelMap modelMap, @PathVariable(value = "id") int id,
      HttpSession session) {
    try {
      orderService.removeOrder(id);
      return "redirect:/order-list";
    } catch (SQLException e) {
      e.printStackTrace();
      return "error-page";
    }
  }

  /**
   * @param orderId
   * @param modelMap
   * @param session
   * @return
   */
  @RequestMapping(value = "/order-information", method = RequestMethod.GET)
  public String showInformationOrder(@RequestParam("orderId") int orderId, ModelMap modelMap,
      HttpSession session) {
    try {
      Orders orders = orderService.getOrderById(orderId);
      modelMap.addAttribute("customer", orders.getCustomer());
      List<OrderDetail> listOfOrderDetail = orders.getOrderDetailList();
      modelMap.addAttribute("listOfOrderDetail", listOfOrderDetail);
      int totalPrice = 0;
      for (OrderDetail value : listOfOrderDetail) {
        totalPrice += (int) (value.getQuantity() * value.getProduct().getUnitPrice());
      }
      modelMap.addAttribute("totalPrice", totalPrice);

      return "order-information";
    } catch (SQLException e) {
      e.printStackTrace();
      return "error-page";
    }
  }
}
