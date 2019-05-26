package fsoft.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import fsoft.app.entities.Orders;
import fsoft.app.service.OrderService;

@Controller
public class HomeController {

  @Autowired
  private OrderService orderService;

  /**
   * @param modelMap
   * @return
   */
  @RequestMapping("initHome")
  public String initHome(ModelMap modelMap) {
    List<Orders> orderList = orderService.getAllOrder();
    modelMap.addAttribute("orderList", orderList);
    return "home-page";
  }
}
