/**
 * 
 */
package fsoft.app.service;

import org.junit.*;
import org.mockito.*;
import fsoft.app.dao.ManufactureDao;
import fsoft.app.dao.impl.ManufactureDaoImpl;
import fsoft.app.entities.Manufacture;
import fsoft.app.service.impl.ManufactureServiceImpl;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.*;

/**
 * @author Nguyen Thanh Cong
 *
 */
public class ManufactureServiceTest {
  @InjectMocks
  private ManufactureServiceImpl manufactureService;
  @Mock
  private ManufactureDao manufactureDao;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  public void testGetAllMan() {
    List<Manufacture> listMan= new ArrayList<Manufacture>();
    listMan.add(new Manufacture());
    when(manufactureDao.getAllManufacture()).thenReturn(listMan);
    assertNotNull(manufactureService.getAllManufacture());
  }
  
  @Test
  public void testFindManById() {
    Manufacture manufacture = new Manufacture();
    when(manufactureDao.findManufactureById(1)).thenReturn(manufacture);
    assertNotNull(manufactureService.getManufactureById(1));
  }
  
  @Test
  public void testGetFailManById() {
    when(manufactureDao.findManufactureById(1)).thenReturn(null);
    assertNull(manufactureService.getManufactureById(1));
  }
}
