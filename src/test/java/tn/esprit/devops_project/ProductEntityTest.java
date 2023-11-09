package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class ProductEntityTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testProductEntity() {
        // Create a Product entity and persist it to the in-memory database
        Product product = new Product();
        product.setTitle("Sample Product");
        product.setPrice(10.0f);
        product.setQuantity(5);
        product.setCategory(ProductCategory.BOOKS); // Replace with the actual category

        Product savedProduct = entityManager.persist(product);
        entityManager.flush();

        // Retrieve the saved Product entity from the database
        Product retrievedProduct = entityManager.find(Product.class, savedProduct.getIdProduct());

        // Perform assertions to test if the entity is saved and retrieved correctly
        assertNotNull(retrievedProduct);
        assertEquals("Sample Product", retrievedProduct.getTitle());
        assertEquals(10.0f, retrievedProduct.getPrice());
        assertEquals(5, retrievedProduct.getQuantity());
        assertEquals(ProductCategory.BOOKS, retrievedProduct.getCategory()); // Replace with the actual category
    }
}

