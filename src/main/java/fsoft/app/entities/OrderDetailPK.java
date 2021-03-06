/*
 * To change this
 * license header,
 * choose License
 * Headers in
 * Project
 * Properties. To
 * change this
 * template file,
 * choose Tools |
 * Templates and
 * open the template
 * in the editor.
 */
package fsoft.app.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author NamNV25
 */
@Embeddable
public class OrderDetailPK implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "order_id", nullable = false)
  private int orderId;
  @Basic(optional = false)
  @Column(name = "product_id", nullable = false)
  private int productId;

  public OrderDetailPK() {}

  public OrderDetailPK(int orderId, int productId) {
    this.orderId = orderId;
    this.productId = productId;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) orderId;
    hash += (int) productId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning -
    // this method won't
    // work in the case
    // the id fields are
    // not set
    if (!(object instanceof OrderDetailPK)) {
      return false;
    }
    OrderDetailPK other = (OrderDetailPK) object;
    if (this.orderId != other.orderId) {
      return false;
    }
    if (this.productId != other.productId) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "fsoft.app.entities.OrderDetailPK[ orderId=" + orderId + ", productId=" + productId
        + " ]";
  }

}
