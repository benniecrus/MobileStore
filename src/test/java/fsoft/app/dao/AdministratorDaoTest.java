package fsoft.app.dao;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/*
 * author TrangDTV
 */
import java.sql.SQLException;
import org.eclipse.jdt.internal.compiler.flow.UnconditionalFlowInfo.AssertionFailedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import fsoft.app.entities.Administrator;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring-config-test.xml")
public class AdministratorDaoTest {
	@Autowired
	AdministratorDao administratorDao;
	
	@Test
	public void getAdministrator() throws SQLException {
		Administrator administrator = administratorDao.findAdminByUserName("trangdtv");
		assertNotNull(administrator);
	}
	@Test 
	public void getRole() {
		String administrator = administratorDao.getRoles("TrangDTV");
		assertNotNull(administrator);
		
	}

}
