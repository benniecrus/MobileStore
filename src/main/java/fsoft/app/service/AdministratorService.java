package fsoft.app.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author NamNV25
 *
 */
public interface AdministratorService extends UserDetailsService {
  UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;
}
