package fsoft.app.dao.impl;

import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import fsoft.app.dao.CustomerDao;
import fsoft.app.entities.Customer;
import fsoft.app.utils.HibernateUtils;

@Repository
public class CustomerDaoImpl implements CustomerDao {
  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Customer addCustomer(Customer customer) throws SQLException {
    Session session = HibernateUtils.getSession(sessionFactory);
    session.save(customer);
    HibernateUtils.closeSession(session);
    return customer;
  }

}
