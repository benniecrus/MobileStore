package fsoft.app.config;

/*
 * @author TrangDTV
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import fsoft.app.service.AdministratorService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  AdministratorService administratorService;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) {
    try {
      auth.userDetailsService(administratorService);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(administratorService);
    return authenticationProvider;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.authorizeRequests().antMatchers("/login").permitAll();
    http.authorizeRequests().antMatchers("/initAddProduct").access("hasRole('ROLE_ADMIN')");
    http.authorizeRequests().antMatchers("/initProducManagement").access("hasRole('ROLE_ADMIN')");
    http.authorizeRequests().antMatchers("/initEditProduct").access("hasRole('ROLE_ADMIN')");
    http.authorizeRequests().antMatchers("/order-list").access("hasRole('ROLE_ADMIN')");


    http.authorizeRequests().and().formLogin().loginProcessingUrl("/login_security")
        .loginPage("/login").usernameParameter("username").passwordParameter("password")
        .defaultSuccessUrl("/product-list").failureUrl("/login?error=true");

    http.logout().logoutUrl("/logout").logoutSuccessUrl("/product-list")
        .invalidateHttpSession(true);


  }



}
