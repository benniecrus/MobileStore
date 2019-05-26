package fsoft.app.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import fsoft.app.dao.AdministratorDao;
import fsoft.app.entities.Administrator;
import fsoft.app.service.AdministratorService;

/**
 * @author TrangDTV
 *
 */
@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {
  @Autowired
  AdministratorDao administratorDao;

  @Autowired
  public void setAdministratorDao(AdministratorDao administratorDao) {
    this.administratorDao = administratorDao;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .
   * AdministratorService
   * #
   * loadUserByUsername
   * (java.lang.
   * String)
   */
  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    Administrator administrator;
    try {
      administrator = administratorDao.findAdminByUserName(userName);
      if (administrator == null) {
        throw new UsernameNotFoundException("username was not found");
      }
      String role = administrator.getRole();
      List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
      grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));
      UserDetails userDetails =
          new User(administrator.getUserName(), administrator.getPassword(), grantedAuthorities);
      return userDetails;

    } catch (SQLException e) {
      // TODO
      // Auto-generated
      // catch block
      e.printStackTrace();
    }
    return null;



  }

}
