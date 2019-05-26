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
import javax.persistence.CascadeType;
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
@Table(name = "administrator", catalog = "MobileStore", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Administrator.findAll", query = "SELECT a FROM Administrator a"),
    @NamedQuery(name = "Administrator.findByAdminId",
        query = "SELECT a FROM Administrator a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "Administrator.findByUserName",
        query = "SELECT a FROM Administrator a WHERE a.userName = :userName"),
    @NamedQuery(name = "Administrator.findByPassword",
        query = "SELECT a FROM Administrator a WHERE a.password = :password"),
    @NamedQuery(name = "Administrator.findByRole",
        query = "SELECT a FROM Administrator a WHERE a.role = :role")})
public class Administrator implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "admin_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer adminId;
  @Column(name = "user_name", length = 255)
  private String userName;
  @Column(name = "password", length = 255)
  private String password;
  @Column(name = "role", length = 255)
  private String role;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "administrator", fetch = FetchType.EAGER)
  private List<Invoice> invoiceList;

  public Administrator() {}

  public Administrator(Integer adminId) {
    this.adminId = adminId;
  }

  public Integer getAdminId() {
    return adminId;
  }

  public void setAdminId(Integer adminId) {
    this.adminId = adminId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @XmlTransient
  public List<Invoice> getInvoiceList() {
    return invoiceList;
  }

  public void setInvoiceList(List<Invoice> invoiceList) {
    this.invoiceList = invoiceList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (adminId != null ? adminId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning -
    // this method won't
    // work in the case
    // the id fields are
    // not set
    if (!(object instanceof Administrator)) {
      return false;
    }
    Administrator other = (Administrator) object;
    if ((this.adminId == null && other.adminId != null)
        || (this.adminId != null && !this.adminId.equals(other.adminId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "fsoft.app.entities.Administrator[ adminId=" + adminId + " ]";
  }

}
