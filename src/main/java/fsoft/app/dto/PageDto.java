/**
 * 
 */
package fsoft.app.dto;

import java.util.List;

/**
 * @author NamNV25
 *
 */
public class PageDto {

  private int perPage;
  private long totalRecord;
  private int currentPage;
  private long numberOfPage;
  private int startResult;
  private List<Integer> listPage;

  public PageDto() {
    this.perPage = 8;
  }

  public int getPerPage() {
    return perPage;
  }

  public void setPerPage(int perPage) {
    this.perPage = perPage;
  }

  public long getTotalRecord() {
    return totalRecord;
  }

  public void setTotalRecord(long totalRecord) {
    this.totalRecord = totalRecord;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public long getNumberOfPage() {
    return numberOfPage;
  }

  public void setNumberOfPage(long numberOfPage) {
    this.numberOfPage = numberOfPage;
  }

  public int getStartResult() {
    return startResult;
  }

  public void setStartResult(int startResult) {
    this.startResult = startResult;
  }

  public List<Integer> getListPage() {
    return listPage;
  }

  public void setListPage(List<Integer> listPage) {
    this.listPage = listPage;
  }

}
