/**
 * 
 */
package fsoft.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import fsoft.app.dto.CartPageDto;
import fsoft.app.dto.PageDto;
import fsoft.app.entities.OrderDetail;
import fsoft.app.service.PagingService;

/**
 * @author NamNV25
 *
 */
@Service
public class PagingServiceImpl implements PagingService {

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .PagingService#
   * processPaging(
   * int)
   */
  @Override
  public PageDto processPaging(int currentPage, long totalRecord) {
    PageDto pageDto = new PageDto();

    pageDto.setCurrentPage(currentPage);

    pageDto.setTotalRecord(totalRecord);

    long numberOfPage;

    if (pageDto.getTotalRecord() % pageDto.getPerPage() > 0) {
      numberOfPage = (pageDto.getTotalRecord() / pageDto.getPerPage()) + 1;
    } else {
      numberOfPage = (pageDto.getTotalRecord() / pageDto.getPerPage());
    }

    pageDto.setNumberOfPage(numberOfPage);

    pageDto.setStartResult((currentPage - 1) * pageDto.getPerPage());

    List<Integer> listPage = new ArrayList<>();

    for (int i = 1; i <= pageDto.getNumberOfPage(); i++) {
      listPage.add(i);
    }

    pageDto.setListPage(listPage);

    return pageDto;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .PagingService#
   * pagingCart(int,
   * java.util.List)
   */
  @Override
  public CartPageDto pagingCart(int currentPage, List<OrderDetail> cartList) {
    // TODO
    // Auto-generated
    // method stub

    PageDto pageDto = processPaging(currentPage, cartList.size());

    List<OrderDetail> pagingList = null;
    if (pageDto.getStartResult() < cartList.size()) {
      int endIndex = pageDto.getStartResult() + pageDto.getPerPage();
      if (endIndex < cartList.size()) {
        pagingList = cartList.subList(pageDto.getStartResult(), endIndex - 1);
      } else {
        pagingList = cartList.subList(pageDto.getStartResult(), cartList.size() - 1);
      }
    }

    if (pagingList == null)
      pagingList = new ArrayList<>();

    CartPageDto cartPageDto = new CartPageDto();

    cartPageDto.setOrderDetailList(pagingList);

    cartPageDto.setPageDto(pageDto);

    return cartPageDto;
  }

}
