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
@Table(name = "category", catalog = "MobileStore", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoryId",
        query = "SELECT c FROM Category c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "Category.findByCategoryName",
        query = "SELECT c FROM Category c WHERE c.categoryName = :categoryName")})
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "category_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer categoryId;
  @Column(name = "category_name", length = 255)
  private String categoryName;
  @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
  private List<Product> productList;

  public Category() {}

  public Category(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
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
    hash += (categoryId != null ? categoryId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning -
    // this method won't
    // work in the case
    // the id fields are
    // not set
    if (!(object instanceof Category)) {
      return false;
    }
    Category other = (Category) object;
    if ((this.categoryId == null && other.categoryId != null)
        || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "fsoft.app.entities.Category[ categoryId=" + categoryId + " ]";
  }

}
