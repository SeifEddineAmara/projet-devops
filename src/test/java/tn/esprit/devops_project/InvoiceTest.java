package tn.esprit.devops_project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.InvoiceDetail;
import tn.esprit.devops_project.entities.Supplier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class InvoiceTest {
    private Invoice invoice;
    private InvoiceDetail invoiceDetail;
    private Supplier supplier;

    @BeforeEach
    public void setUp() {
        invoice = new Invoice();
        invoice.setIdInvoice(1L);
        invoice.setAmountDiscount(10.0f);
        invoice.setAmountInvoice(100.0f);
        invoice.setDateCreationInvoice(new Date());
        invoice.setDateLastModificationInvoice(new Date());
        invoice.setArchived(false);

        supplier = new Supplier();
        supplier.setIdSupplier(1L);
        supplier.setLabel("Supplier");

        invoice.setSupplier(supplier);

        invoiceDetail = new InvoiceDetail();
        invoiceDetail.setIdInvoiceDetail(1L);
        invoiceDetail.setQuantity(10);
        invoiceDetail.setPrice(10.0f);
        invoiceDetail.setInvoice(invoice);

        Set<InvoiceDetail> invoiceDetails = new HashSet<>();
        invoiceDetails.add(invoiceDetail);

        invoice.setInvoiceDetails(invoiceDetails);
    }

    @Test
    public void testInvoice() {
        Assertions.assertEquals(1L, invoice.getIdInvoice());
        Assertions.assertEquals(10.0f, invoice.getAmountDiscount());
        Assertions.assertEquals(100.0f, invoice.getAmountInvoice());
        Assertions.assertFalse(invoice.getArchived());
        Assertions.assertEquals(supplier, invoice.getSupplier());
        Assertions.assertEquals(1, invoice.getInvoiceDetails().size());
    }
}