package fsoft.app.dao;

import java.sql.SQLException;
import fsoft.app.entities.Administrator;

/**
 * @author NamNV25
 *
 */
public interface AdministratorDao {
  Administrator findAdminByUserName(String userName) throws SQLException;

  String getRoles(String username);
}
