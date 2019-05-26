package fsoft.app.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import fsoft.app.dao.ProductDao;
import fsoft.app.entities.Product;
import fsoft.app.service.impl.ProductServiceImpl;

public class ProductServiceTest {

   @Mock
    private ProductDao productDao;
    
    @InjectMocks
    private ProductServiceImpl productService;

    
    @Before
    public void setUp() throws Exception {
         MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testGetProductById() {
      when(productDao.getProductById(1)).thenReturn(new Product());
      assertNotNull(productService.getProductById(1));
	}
	@Test
    public void testGetProductByIdFail() {
      when(productDao.getProductById(1)).thenReturn(null);
      assertNull(productService.getProductById(1));
    }
	@Test
	public void testAddProduct() {
		Product product = new Product();
		when(productDao.createAndUpdateProduct(product)).thenReturn(product);
		assertNotNull(productService.createAndUpdateProduct(product));
	}
	

}
