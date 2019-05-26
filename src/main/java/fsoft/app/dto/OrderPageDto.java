/**
 * 
 */
package fsoft.app.dto;

import java.util.List;
import fsoft.app.entities.Orders;

/**
 * @author NamNV25
 *
 */
public class OrderPageDto {
  PageDto pageDto;
  List<Orders> orderList;

  public OrderPageDto() {
    super();
  }

  public OrderPageDto(PageDto pageDto, List<Orders> orderList) {
    super();
    this.pageDto = pageDto;
    this.orderList = orderList;
  }

  public PageDto getPageDto() {
    return pageDto;
  }

  public void setPageDto(PageDto pageDto) {
    this.pageDto = pageDto;
  }

  public List<Orders> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<Orders> orderList) {
    this.orderList = orderList;
  }

}
