/**
 * 
 */
package fsoft.app.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fsoft.app.dao.ManufactureDao;
import fsoft.app.entities.Manufacture;
import fsoft.app.service.ManufactureService;

/**
 * @author NamNV25
 *
 */
@Service("manufactureService")
public class ManufactureServiceImpl implements ManufactureService {

  @Autowired
  private ManufactureDao manufactureDao;

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .
   * ManufactureService
   * #
   * getAllManufacture
   * ()
   */
  @Override
  public List<Manufacture> getAllManufacture() {
    // TODO
    // Auto-generated
    // method stub
    return manufactureDao.getAllManufacture();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * fsoft.app.service
   * .
   * ManufactureService
   * #
   * getManufactureById
   * (int)
   */
  @Override
  public Manufacture getManufactureById(int manufactureId) {
    // TODO
    // Auto-generated
    // method stub
    return manufactureDao.findManufactureById(manufactureId);
  }

}
