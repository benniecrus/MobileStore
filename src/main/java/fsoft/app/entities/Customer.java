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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NamNV25
 */
@Entity
@Table(name = "customer", catalog = "MobileStore", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.findByCustomerId",
        query = "SELECT c FROM Customer c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customer.findByCustomerName",
        query = "SELECT c FROM Customer c WHERE c.customerName = :customerName"),
    @NamedQuery(name = "Customer.findByAddress",
        query = "SELECT c FROM Customer c WHERE c.address = :address"),
    @NamedQuery(name = "Customer.findByPhoneNumber",
        query = "SELECT c FROM Customer c WHERE c.phoneNumber = :phoneNumber")})
public class Customer implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "customer_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer customerId;
  @Column(name = "customer_name", length = 255)
  private String customerName;
  @Column(name = "address", length = 255)
  private String address;
  @Column(name = "phone_number", length = 20)
  private String phoneNumber;
  @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
  private List<Orders> ordersList;

  public Customer() {}

  public Customer(Integer customerId) {
    this.customerId = customerId;
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @XmlTransient
  public List<Orders> getOrdersList() {
    return ordersList;
  }

  public void setOrdersList(List<Orders> ordersList) {
    this.ordersList = ordersList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (customerId != null ? customerId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning -
    // this method won't
    // work in the case
    // the id fields are
    // not set
    if (!(object instanceof Customer)) {
      return false;
    }
    Customer other = (Customer) object;
    if ((this.customerId == null && other.customerId != null)
        || (this.customerId != null && !this.customerId.equals(other.customerId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "fsoft.app.entities.Customer[ customerId=" + customerId + " ]";
  }

}
