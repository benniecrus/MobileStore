package fsoft.app.service;

import java.sql.SQLException;
import fsoft.app.entities.Customer;

public interface CustomerService {
  Customer addCustomer(Customer customer) throws SQLException;

}
