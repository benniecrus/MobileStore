package fsoft.app.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionHandlerController {

  /**
   * @param error
   * @return
   * @throws IOException
   */
  @RequestMapping("getIOException")
  public String getIOException(@RequestParam boolean error) throws IOException {

    if (error == true)
      throw new IOException("IO Exception");

    return "login";
  }

  /**
   * @param error
   * @return
   * @throws IOException
   */
  @RequestMapping("getNullException")
  public String getNullException(@RequestParam boolean error) throws IOException {

    if (error == true)
      throw new NullPointerException("Null pointer exception");

    return "login";
  }

  /**
   * @param ex
   * @return
   */
  @ExceptionHandler(Exception.class)
  public ModelAndView defaultErrorHandler(Exception ex) {

    ModelAndView model = new ModelAndView("error-page");

    model.addObject("exception", ex.getMessage());

    return model;
  }
  
  /**
   * @param model
   * @return
   */
  @RequestMapping("/errorHandle")
  public String errorHandle(Model model) {
    model.addAttribute("handler", "errorHandler");
    return "error-page";
  }
}
