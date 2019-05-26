package fsoft.app.dao;

import java.sql.SQLException;
import fsoft.app.entities.Customer;

/**
 * @author NamNV25
 *
 */
public interface CustomerDao {

  Customer addCustomer(Customer customer) throws SQLException;
}
