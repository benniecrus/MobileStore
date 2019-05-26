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
@Table(name = "manufacture", catalog = "MobileStore", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Manufacture.findAll", query = "SELECT m FROM Manufacture m"),
    @NamedQuery(name = "Manufacture.findByManufactureId",
        query = "SELECT m FROM Manufacture m WHERE m.manufactureId = :manufactureId"),
    @NamedQuery(name = "Manufacture.findByManufactureName",
        query = "SELECT m FROM Manufacture m WHERE m.manufactureName = :manufactureName")})
public class Manufacture implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "manufacture_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer manufactureId;
  @Column(name = "manufacture_name", length = 255)
  private String manufactureName;
  @OneToMany(mappedBy = "manufacture", fetch = FetchType.EAGER)
  private List<Product> productList;

  public Manufacture() {}

  public Manufacture(Integer manufactureId) {
    this.manufactureId = manufactureId;
  }

  public Integer getManufactureId() {
    return manufactureId;
  }

  public void setManufactureId(Integer manufactureId) {
    this.manufactureId = manufactureId;
  }

  public String getManufactureName() {
    return manufactureName;
  }

  public void setManufactureName(String manufactureName) {
    this.manufactureName = manufactureName;
  }

  @XmlTransient
  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (manufactureId != null ? manufactureId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning -
    // this method won't
    // work in the case
    // the id fields are
    // not set
    if (!(object instanceof Manufacture)) {
      return false;
    }
    Manufacture other = (Manufacture) object;
    if ((this.manufactureId == null && other.manufactureId != null)
        || (this.manufactureId != null && !this.manufactureId.equals(other.manufactureId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "fsoft.app.entities.Manufacture[ manufactureId=" + manufactureId + " ]";
  }

}
