package tn.esprit.devops_project;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.controllers.SupplierController;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SupplierTest {

    @InjectMocks
    private SupplierController supplierController;

    @Mock
    private ISupplierService supplierService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSuppliers() {
        // Arrange
        List<Supplier> suppliers = new ArrayList<>();
        suppliers.add(new Supplier()); // Use the default constructor
        suppliers.add(new Supplier());

        when(supplierService.retrieveAllSuppliers()).thenReturn(suppliers);

        // Act
        List<Supplier> result = supplierController.getSuppliers();

        // Assert
        assertEquals(suppliers, result);
    }

    @Test
    public void testRetrieveSupplier() {
        // Arrange
        Long supplierId = 1L;
        Supplier supplier = new Supplier(); // Use the default constructor
        supplier.setIdSupplier(supplierId); // Set the ID

        when(supplierService.retrieveSupplier(supplierId)).thenReturn(supplier);

        // Act
        Supplier result = supplierController.retrieveSupplier(supplierId);

        // Assert
        assertEquals(supplier, result);
    }

    @Test
    public void testAddSupplier() {
        // Arrange
        Supplier supplier = new Supplier(); // Use the default constructor

        when(supplierService.addSupplier(supplier)).thenReturn(supplier);

        // Act
        Supplier result = supplierController.addSupplier(supplier);

        // Assert
        assertEquals(supplier, result);
    }

    @Test
    public void testRemoveSupplier() {
        // Arrange
        Long supplierId = 1L;

        // Act
        supplierController.removeFournisseur(supplierId);

        // Assert
        verify(supplierService).deleteSupplier(supplierId);
    }

    @Test
    public void testModifySupplier() {
        // Arrange
        Supplier supplier = new Supplier(); // Use the default constructor

        when(supplierService.updateSupplier(supplier)).thenReturn(supplier);

        // Act
        Supplier result = supplierController.modifyFournisseur(supplier);

        // Assert
        assertEquals(supplier, result);
    }
}
