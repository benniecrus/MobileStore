/**
 * 
 */
package fsoft.app.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fsoft.app.dao.CategoryDao;
import fsoft.app.entities.Category;
import fsoft.app.utils.HibernateUtils;

/**
 * @author NamNV25
 *
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
  @Autowired
  SessionFactory sessionFactory;

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * CategoryDao#
   * getAllCategories(
   * )
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Category> getAllCategories() {
    // TODO
    // Auto-generated
    // method stub
    Session session = HibernateUtils.getSession(sessionFactory);
    List<Category> categories = session.createQuery("From Category").list();
    HibernateUtils.closeSession(session);
    if (categories != null)
      return categories;
    else
      return new ArrayList<>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * CategoryDao#
   * findCategoryById(
   * int)
   */
  @Override
  public Category findCategoryById(int categoryId) {
    // TODO
    // Auto-generated
    // method stub
    Session session = HibernateUtils.getSession(sessionFactory);
    Category category = (Category) session.get(Category.class, categoryId);
    HibernateUtils.closeSession(session);
    if (category != null)
      return category;
    return null;
  }

}
