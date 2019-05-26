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
public class InvoicePK implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @Column(name = "order_id", nullable = false)
  private int orderId;
  @Basic(optional = false)
  @Column(name = "auditor_id", nullable = false)
  private int auditorId;

  public InvoicePK() {}

  public InvoicePK(int orderId, int auditorId) {
    this.orderId = orderId;
    this.auditorId = auditorId;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getAuditorId() {
    return auditorId;
  }

  public void setAuditorId(int auditorId) {
    this.auditorId = auditorId;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (int) orderId;
    hash += (int) auditorId;
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning -
    // this method won't
    // work in the case
    // the id fields are
    // not set
    if (!(object instanceof InvoicePK)) {
      return false;
    }
    InvoicePK other = (InvoicePK) object;
    if (this.orderId != other.orderId) {
      return false;
    }
    if (this.auditorId != other.auditorId) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "fsoft.app.entities.InvoicePK[ orderId=" + orderId + ", auditorId=" + auditorId + " ]";
  }

}
