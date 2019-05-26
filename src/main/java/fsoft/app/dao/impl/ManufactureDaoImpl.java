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
import fsoft.app.dao.ManufactureDao;
import fsoft.app.entities.Manufacture;
import fsoft.app.utils.HibernateUtils;

/**
 * @author NamNV25
 *
 */
@Repository
public class ManufactureDaoImpl implements ManufactureDao {

  @Autowired
  SessionFactory sessionFactory;

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * ManufactureDao#
   * getAllManufacture
   * ()
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Manufacture> getAllManufacture() {
    // TODO
    // Auto-generated
    // method stub
    Session session = HibernateUtils.getSession(sessionFactory);
    List<Manufacture> manufactures = session.createQuery("From Manufacture").list();
    HibernateUtils.closeSession(session);
    if (manufactures != null)
      return manufactures;
    else
      return new ArrayList<>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * ManufactureDao#
   * getManufactureByid
   * (int)
   */
  @Override
  public Manufacture findManufactureById(int id) {
    // TODO
    // Auto-generated
    // method stub
    Session session = HibernateUtils.getSession(sessionFactory);
    Manufacture manufacture = (Manufacture) session.get(Manufacture.class, id);
    HibernateUtils.closeSession(session);
    return manufacture;

  }

}
