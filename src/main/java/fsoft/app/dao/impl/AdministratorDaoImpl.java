package fsoft.app.dao.impl;

import java.sql.SQLException;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fsoft.app.dao.AdministratorDao;
import fsoft.app.entities.Administrator;
import fsoft.app.utils.HibernateUtils;

/**
 * @author TrangDTV
 *
 */
@Repository("administratorDao")
@Transactional
public class AdministratorDaoImpl implements AdministratorDao {
  @Autowired
  SessionFactory sessionFactory;

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.dao.
   * AdministratorDao#
   * findAdminByUserNameAndPassword
   * (java.lang.
   * String,
   * java.lang.String)
   */
  @SuppressWarnings("unchecked")
  @Override
  public Administrator findAdminByUserName(String userName) throws SQLException {
    Session session = HibernateUtils.getSession(sessionFactory);
    Query query = session.createQuery("FROM Administrator WHERE userName = '" + userName + "' ");
    List<Administrator> administrator = query.list();
    HibernateUtils.closeSession(session);
    if (administrator != null && administrator.size() > 0)
      return administrator.get(0);
    return null;
  }


  @Override
  public String getRoles(String userName) {
    Administrator admin;
    try {
      admin = findAdminByUserName(userName);
      if (admin != null)
        return admin.getRole();
    } catch (SQLException e) {
      // TODO
      // Auto-generated
      // catch block
      e.printStackTrace();
    }
    return "";
  }



}
