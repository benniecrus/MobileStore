/**
 * 
 */
package fsoft.app.utils;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import com.sun.jersey.core.util.Base64;

/**
 * @author NamNV25
 *
 */
public class FileUtils {

  /**
   * @param file
   *        convert
   *        file
   * @return string
   *         encode
   *         file
   * @throws IOException
   */
  public static String processFileToBase64Encode(MultipartFile file) throws IOException {
    String encodedBase64 = null;
    if (file != null) {
      byte[] base64Encode = Base64.encode(file.getBytes());
      encodedBase64 = new String(base64Encode, "UTF-8");
    }

    return encodedBase64;

  }

}
