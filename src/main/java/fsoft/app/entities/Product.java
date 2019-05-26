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
import javax.persistence.Lob;
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
@Table(name = "Product", catalog = "MobileStore", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId",
        query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByProductName",
        query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByUnitPrice",
        query = "SELECT p FROM Product p WHERE p.unitPrice = :unitPrice"),
    @NamedQuery(name = "Product.findByUnitInStock",
        query = "SELECT p FROM Product p WHERE p.unitInStock = :unitInStock"),
    @NamedQuery(name = "Product.findByUpdateTime",
        query = "SELECT p FROM Product p WHERE p.updateTime = :updateTime")})
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "product_id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer productId;
  @Column(name = "product_name", length = 255)
  private String productName;
  @Lob
  @Column(name = "product_description", length = 2147483647)
  private String productDescription;
  @Column(name = "unit_price")
  private Long unitPrice;
  @Column(name = "unit_in_stock")
  private Integer unitInStock;
  @Column(name = "status")
  private boolean status;
  @Column(name = "delete_flag")
  private boolean deleteFlag;
  @Column(name = "update_time")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updateTime;
  @Column(name = "base_64_Image")
  private String base64Image;
  @Column(name = "condition")
  private Short condition;
  @JoinColumn(name = "category_id", referencedColumnName = "category_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Category category;
  @JoinColumn(name = "manufacture_id", referencedColumnName = "manufacture_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Manufacture manufacture;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.EAGER)
  private List<OrderDetail> orderDetailList;

  public Product() {}

  public Product(Integer productId) {
    this.productId = productId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Long getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Long unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Integer getUnitInStock() {
    return unitInStock;
  }

  public void setUnitInStock(Integer unitInStock) {
    this.unitInStock = unitInStock;
  }


  public Short getCondition() {
    return condition;
  }

  public void setCondition(Short condition) {
    this.condition = condition;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Manufacture getManufacture() {
    return manufacture;
  }

  public void setManufacture(Manufacture manufacture) {
    this.manufacture = manufacture;
  }


  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public boolean isDeleteFlag() {
    return deleteFlag;
  }

  public void setDeleteFlag(boolean deleteFlag) {
    this.deleteFlag = deleteFlag;
  }

  public String getBase64Image() {
    return base64Image;
  }

  public void setBase64Image(String base64Image) {
    this.base64Image = base64Image;
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
    hash += (productId != null ? productId.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Product)) {
      return false;
    }
    Product other = (Product) object;
    if ((this.productId == null && other.productId != null)
        || (this.productId != null && !this.productId.equals(other.productId))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Product [productId=" + productId + ", productName=" + productName
        + ", productDescription=" + productDescription + ", unitPrice=" + unitPrice
        + ", unitInStock=" + unitInStock + ", status=" + status + ", updateTime=" + updateTime
        + ", category=" + category + ", manufacture=" + manufacture + ", orderDetailList="
        + orderDetailList + "]";
  }

}
