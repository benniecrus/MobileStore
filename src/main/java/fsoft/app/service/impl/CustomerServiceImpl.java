package fsoft.app.service.impl;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fsoft.app.dao.CustomerDao;
import fsoft.app.entities.Customer;
import fsoft.app.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  CustomerDao customerDao;

  @Override
  public Customer addCustomer(Customer customer) throws SQLException {
    return customerDao.addCustomer(customer);
  }

}
