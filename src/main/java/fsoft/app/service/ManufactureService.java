/**
 * 
 */
package fsoft.app.service;

import java.util.List;
import fsoft.app.entities.Manufacture;

/**
 * @author NamNV25
 *
 */
public interface ManufactureService {
  List<Manufacture> getAllManufacture();

  Manufacture getManufactureById(int manufactureId);
}
