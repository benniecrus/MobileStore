/**
 * 
 */
package fsoft.app.service;

import java.util.List;
import fsoft.app.dto.CartPageDto;
import fsoft.app.dto.PageDto;
import fsoft.app.entities.OrderDetail;

/**
 * @author NamNV25
 *
 */
public interface PagingService {
  PageDto processPaging(int currentPage, long totalRecord);

  CartPageDto pagingCart(int currentPage, List<OrderDetail> cartList);
}
