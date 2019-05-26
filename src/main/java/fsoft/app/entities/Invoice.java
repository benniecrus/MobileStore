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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NamNV25
 */
@Entity
@Table(name = "invoice", catalog = "MobileStore", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i"),
    @NamedQuery(name = "Invoice.findByOrderId",
        query = "SELECT i FROM Invoice i WHERE i.invoicePK.orderId = :orderId"),
    @NamedQuery(name = "Invoice.findByAuditorId",
        query = "SELECT i FROM Invoice i WHERE i.invoicePK.auditorId = :auditorId"),
    @NamedQuery(name = "Invoice.findByAuditTime",
        query = "SELECT i FROM Invoice i WHERE i.auditTime = :auditTime")})
public class Invoice implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected InvoicePK invoicePK;
  @Column(name = "audit_time")
  @Temporal(TemporalType.DATE)
  private Date auditTime;
  @JoinColumn(name = "auditor_id", referencedColumnName = "admin_id", nullable = false,
      insertable = false, updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Administrator administrator;
  @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false,
      insertable = false, updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.EAGER)
  private Orders orders;

  public Invoice() {}

  public Invoice(InvoicePK invoicePK) {
    this.invoicePK = invoicePK;
  }

  public Invoice(int orderId, int auditorId) {
    this.invoicePK = new InvoicePK(orderId, auditorId);
  }

  public InvoicePK getInvoicePK() {
    return invoicePK;
  }

  public void setInvoicePK(InvoicePK invoicePK) {
    this.invoicePK = invoicePK;
  }

  public Date getAuditTime() {
    return auditTime;
  }

  public void setAuditTime(Date auditTime) {
    this.auditTime = auditTime;
  }

  public Administrator getAdministrator() {
    return administrator;
  }

  public void setAdministrator(Administrator administrator) {
    this.administrator = administrator;
  }

  public Orders getOrders() {
    return orders;
  }

  public void setOrders(Orders orders) {
    this.orders = orders;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (invoicePK != null ? invoicePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning -
    // this method won't
    // work in the case
    // the id fields are
    // not set
    if (!(object instanceof Invoice)) {
      return false;
    }
    Invoice other = (Invoice) object;
    if ((this.invoicePK == null && other.invoicePK != null)
        || (this.invoicePK != null && !this.invoicePK.equals(other.invoicePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "fsoft.app.entities.Invoice[ invoicePK=" + invoicePK + " ]";
  }

}
