/**
 * 
 */
package fsoft.app.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fsoft.app.common.Constants;
import fsoft.app.entities.Customer;
import fsoft.app.entities.OrderDetail;
import fsoft.app.service.OrderService;
import fsoft.app.service.ProductService;

/**
 * @author NamNV25
 *
 */
@Controller
public class CartController {

  @Autowired
  private ProductService productService;

  @Autowired
  private OrderService orderService;

  /**
   * Method will add
   * product to cart
   * 
   * @param id is
   *        product id
   * @param modelMap
   *        ModelMap
   * @param session
   *        HttpSession
   * @return
   */
  @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
  public String addProductIntoCart(@PathVariable(value = "id") int id, ModelMap modelMap,
      HttpSession session) {
    OrderDetail orderDetail = new OrderDetail();
    boolean isExist = false;
    int totalPrice = 0;
    if (id == 0) {
      @SuppressWarnings("unchecked")
      List<OrderDetail> cart = (ArrayList<OrderDetail>) session.getAttribute(Constants.CART);
      if (cart != null) {
        for (OrderDetail orderDetail2 : cart) {
          totalPrice +=
              (int) (orderDetail2.getQuantity() * orderDetail2.getProduct().getUnitPrice());
        }
        modelMap.addAttribute("totalPrice", totalPrice);
        modelMap.addAttribute("listOfOrderDetail", cart);
      }
    } else {
      if (session.getAttribute(Constants.CART) == null) {
        orderDetail.setProduct(productService.getProductById(id));
        orderDetail.setQuantity(1);
        List<OrderDetail> cart = new ArrayList<OrderDetail>();
        cart.add(orderDetail);
        session.setAttribute(Constants.CART, cart);
        for (OrderDetail orderDetail2 : cart) {
          totalPrice +=
              (int) (orderDetail2.getQuantity() * orderDetail2.getProduct().getUnitPrice());
        }
        modelMap.addAttribute("totalPrice", totalPrice);
        modelMap.addAttribute("listOfOrderDetail", cart);
      } else {
        @SuppressWarnings("unchecked")
        List<OrderDetail> cart = (ArrayList<OrderDetail>) session.getAttribute(Constants.CART);
        for (OrderDetail orderDetail1 : cart) {
          if (orderDetail1.getProduct().getProductId() == id) {
            orderDetail1.setQuantity(orderDetail1.getQuantity() + 1);
            isExist = true;
            break;
          }
        }
        if (isExist == false) {
          orderDetail.setProduct(productService.getProductById(id));
          orderDetail.setQuantity(1);
          cart.add(orderDetail);
        }
        session.setAttribute(Constants.CART, cart);
        for (OrderDetail orderDetail2 : cart) {
          totalPrice +=
              (int) (orderDetail2.getQuantity() * orderDetail2.getProduct().getUnitPrice());
        }
        modelMap.addAttribute("totalPrice", totalPrice);
        modelMap.addAttribute("listOfOrderDetail", cart);
      }
    }

    return Constants.SHOPPING_CART;
  }

  /**
   * Method will
   * remove session
   * save cart
   * 
   * @param session
   *        HttpSession
   * @return redirect
   *         Controller
   *         ProductController
   */
  @RequestMapping("/clear-cart")
  public String clearCart(HttpSession session) {
    session.removeAttribute("cart");
    return Constants.REDIRECT + Constants.PRODUCT_LIST;
  }

  /**
   * Method will save
   * order into
   * database
   * 
   * @param modelMap
   *        ModelMap
   * @param session
   *        HttpSession
   * @return
   */
  @RequestMapping(value = "/check-out", method = RequestMethod.POST)
  public String checkOutCart(@ModelAttribute Customer customer, ModelMap modelMap,
      HttpSession session) {
    try {
      @SuppressWarnings("unchecked")
      List<OrderDetail> cart = (ArrayList<OrderDetail>) session.getAttribute("cart");
      int orderId = orderService.addCart(customer, cart);
      if (orderId != 0) {
        session.removeAttribute("cart");
        modelMap.addAttribute("orderId", orderId);
        return Constants.REDIRECT + Constants.ORDER_INFORMATION;
      } else {
        return Constants.REDIRECT + Constants.PRODUCT_LIST;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return Constants.ERROR_PAGE;
    }
  }


  /**
   * @param modelMap
   * @param index
   * @param session
   * @return
   */
  @RequestMapping("/remove-product-cart/{index}")
  public String removeOrder(ModelMap modelMap, @PathVariable(value = "index") int index,
      HttpSession session) {
    @SuppressWarnings("unchecked")
    List<OrderDetail> cart = (ArrayList<OrderDetail>) session.getAttribute(Constants.CART);
    cart.remove(index - 1);
    session.setAttribute(Constants.CART, cart);

    return Constants.REDIRECT + Constants.CART_0;

  }


  /**
   * @param request
   * @param session
   * @return
   */
  @RequestMapping(value = "/cart/update", method = RequestMethod.POST)
  public String updateCart(HttpServletRequest request, HttpSession session) {
    @SuppressWarnings("unchecked")
    List<OrderDetail> cart = (List<OrderDetail>) session.getAttribute("cart");
    for (OrderDetail orderDetail : cart) {
      int quantity = Integer.parseInt(
          request.getParameter("product[" + orderDetail.getProduct().getProductId() + "]"));
      if (quantity != orderDetail.getQuantity() && quantity > 0) {
        orderDetail.setQuantity(quantity);
      }
    }
    session.setAttribute("cart", cart);

    return Constants.REDIRECT + Constants.CART_0;
  }


}
