/**
 * 
 */
package fsoft.app.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author NamNV25
 *
 */
public class HibernateUtils {
  public static Session getSessionAndTransaction(SessionFactory sessionFactory) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    return session;
  }

  public static void commitSessionAndTransaction(Session session) {
    if (session.isOpen()) {
      Transaction transaction = session.getTransaction();
      if (transaction.isActive()) {
        transaction.commit();
      }
    }
  }

  public static Session getSession(SessionFactory sessionFactory) {
    Session session = sessionFactory.openSession();
    return session;
  }

  public static void closeSession(Session session) {
    if (session.isOpen()) {
      session.close();
    }
  }
}
