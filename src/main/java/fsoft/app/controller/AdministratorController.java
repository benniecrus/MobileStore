package fsoft.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
/*
 * @author TrangDTV
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import fsoft.app.dao.ProductDao;
import fsoft.app.service.AdministratorService;

@Controller
public class AdministratorController {

  @Autowired
  AdministratorService administratorService;

  @Autowired
  ProductDao productDao;

  /**
   * @param error
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
    ModelAndView model = new ModelAndView();
    if (error != null) {
      model.addObject("error", "The username and password incorrect");
    }
    model.setViewName("login");
    return model;

  }

  /**
   * @param modelMap
   * @param userName
   * @return
   */
  @RequestMapping("getUser")
  public String getUserByUserName(ModelMap modelMap, @RequestParam String userName) {
    UserDetails userDetails = administratorService.loadUserByUsername(userName);
    System.out.println(userDetails);
    return "home";
  }
}
