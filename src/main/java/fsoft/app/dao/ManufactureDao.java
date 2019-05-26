/**
 * 
 */
package fsoft.app.dao;

import java.util.List;
import fsoft.app.entities.Manufacture;

/**
 * @author NamNV25
 *
 */
public interface ManufactureDao {
  List<Manufacture> getAllManufacture();

  Manufacture findManufactureById(int manufactureId);
}
