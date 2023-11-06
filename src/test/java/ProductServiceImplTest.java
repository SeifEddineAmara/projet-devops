import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.ProductServiceImpl;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
@InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private StockRepository stockRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImpl(productRepository, stockRepository);
    }

    @Test
    public void testAddProduct() {
        Stock stock = new Stock();
        Product product = new Product();
        product.setTitle("Test Product");
        Long stockId = 1L;

        when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));
        when(productRepository.save(product)).thenReturn(product);

        Product savedProduct = productService.addProduct(product, stockId);

        assertEquals("Test Product", savedProduct.getTitle());
        assertEquals(stock, savedProduct.getStock());
    }

    @Test
    public void testRetrieveProduct() {
        Product product = new Product();
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Product retrievedProduct = productService.retrieveProduct(productId);

        assertEquals(product, retrievedProduct);
    }

    @Test
    public void testRetrieveAllProduct() {
        List<Product> productList = Arrays.asList(new Product(), new Product(), new Product());

        when(productRepository.findAll()).thenReturn(productList);

        List<Product> retrievedProducts = productService.retreiveAllProduct();

        assertEquals(productList, retrievedProducts);
    }

    @Test
    public void testRetrieveProductByCategory() {
        ProductCategory category = ProductCategory.ELECTRONICS;
        List<Product> productList = Arrays.asList(new Product(), new Product());

        when(productRepository.findByCategory(category)).thenReturn(productList);

        List<Product> retrievedProducts = productService.retrieveProductByCategory(category);

        assertEquals(productList, retrievedProducts);
    }

    @Test
    public void testDeleteProduct() {
        Long productId = 1L;

        productService.deleteProduct(productId);

        // Verify that the delete method of the repository was called
        verify(productRepository).deleteById(productId);
    }

    @Test
    public void testRetrieveProductStock() {
        Long stockId = 1L;
        List<Product> productList = Arrays.asList(new Product(), new Product());

        when(productRepository.findByStockIdStock(stockId)).thenReturn(productList);

        List<Product> retrievedProducts = productService.retreiveProductStock(stockId);

        assertEquals(productList, retrievedProducts);
    }
}
