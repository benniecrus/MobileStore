package fsoft.app.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fsoft.app.dao.ProductDao;
import fsoft.app.entities.Product;
import fsoft.app.utils.HibernateUtils;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
  @Autowired
  SessionFactory sessionFactory;

  @Override
  public Product createAndUpdateProduct(Product product) {
    // TODO
    // Auto-generated
    // method stub
    Session session = HibernateUtils.getSession(sessionFactory);
    session.beginTransaction();
    session.saveOrUpdate(product);
    session.getTransaction().commit();
    HibernateUtils.closeSession(session);
    return product;
  }

  @Override
  public Product getProductById(int id) {
    // TODO
    // Auto-generated
    // method stub
    Session session = HibernateUtils.getSession(sessionFactory);
    Query query = session.getNamedQuery("Product.findByProductId");
    query.setParameter("productId", id);
    Product product = (Product) query.list().get(0);
    HibernateUtils.closeSession(session);
    return product;
  }

  /*
   * Method will get
   * all product
   * throws
   * SQLException
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Product> getAllProduct() throws SQLException {
    Session session = HibernateUtils.getSession(sessionFactory);
    Query query = session.getNamedQuery("Product.findAll");
    List<Product> products = new ArrayList<Product>();
    products = query.list();
    HibernateUtils.closeSession(session);
    return products;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * ProductDao#
   * getPagingProduct(
   * int, int)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Product> getPagingProduct(int resultStart, int maxResults) {
    Session session = HibernateUtils.getSession(sessionFactory);
    Query query = session.createQuery("From Product p where p.deleteFlag = 0")
        .setFirstResult(resultStart).setMaxResults(maxResults);
    List<Product> productList = query.list();
    if (productList == null)
      return new ArrayList<>();
    HibernateUtils.closeSession(session);
    return productList;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * ProductDao#
   * getTotalProduct()
   */
  @Override
  public long getTotalProduct() {
    // TODO
    // Auto-generated
    // method stub
    Session session = HibernateUtils.getSession(sessionFactory);
    Query query = session.createQuery("SELECT COUNT(*) FROM Product WHERE delete_flag = '0'");
    long count = (long) query.uniqueResult();
    HibernateUtils.closeSession(session);
    return count;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * ProductDao#
   * updateDeleteProduct
   * (fsoft.app.
   * entities.Product,
   * boolean)
   */
  @Override
  public boolean updateDeleteProduct(Product product) {
    // TODO
    // Auto-generated
    // method stub
    Session session = HibernateUtils.getSession(sessionFactory);
    session.beginTransaction();
    session.saveOrUpdate(product);
    session.getTransaction().commit();
    HibernateUtils.closeSession(session);
    return true;
  }
}
