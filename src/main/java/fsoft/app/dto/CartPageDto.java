/**
 * 
 */
package fsoft.app.dto;

import java.util.List;
import fsoft.app.entities.OrderDetail;

/**
 * @author NamNV25
 *
 */
public class CartPageDto {
  List<OrderDetail> orderDetailList;
  PageDto pageDto;

  public List<OrderDetail> getOrderDetailList() {
    return orderDetailList;
  }

  public void setOrderDetailList(List<OrderDetail> orderDetailList) {
    this.orderDetailList = orderDetailList;
  }

  public PageDto getPageDto() {
    return pageDto;
  }

  public void setPageDto(PageDto pageDto) {
    this.pageDto = pageDto;
  }


}
