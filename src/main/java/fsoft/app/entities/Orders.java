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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NamNV25
 */
@Entity
@Table(name = "Orders", catalog = "MobileStore", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findByOrderId",
        query = "SELECT o FROM Orders o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Orders.findByOrderDate",
        query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Orders.removeById",
        query = "UPDATE Orders o SET o.deleteFlag = 1 WHERE o.orderId = :orderId")})
public class Orders implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "order_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderId;
  @Column(name = "order_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date orderDate;
  @Column(name = "status")
  private String status;
  @Column(name = "delete_flag")
  private boolean deleteFlag;
  @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Customer customer;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", fetch = FetchType.EAGER)
  private List<Invoice> invoiceList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders", fetch = FetchType.EAGER)
  private List<OrderDetail> orderDetailList;

  public Orders() {}



  public Orders(Date orderDate, String status, Customer customert) {
    super();
    this.orderDate = orderDate;
    this.status = status;
    this.customer = customert;
  }



  public Orders(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }


  public String getStatus() {
    return status;
  }


  public void setStatus(String status) {
    this.status = status;
  }



  public boolean isDeleteFlag() {
    return deleteFlag;
  }


  public void setDeleteFlag(boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }


  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @XmlTransient
  public List<Invoice> getInvoiceList() {
    return invoiceList;
  }

  public void setInvoiceList(List<Invoice> invoiceList) {
    this.invoiceList = invoiceList;
  }

  @XmlTransient
  public List<OrderDetail> getOrderDetailList() {
    return orderDetailList;
  }

  public void setOrderDetailList(List<OrderDetail> orderDetailList) {
    this.orderDetailList = orderDetailList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (orderId != null ? orderId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Orders)) {
      return false;
    }
    Orders other = (Orders) object;
    if ((this.orderId == null && other.orderId != null)
        || (this.orderId != null && !this.orderId.equals(other.orderId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "fsoft.app.entities.Orders[ orderId=" + orderId + " ]";
  }

}
