package tn.esprit.devops_project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;

import java.util.HashSet;
import java.util.Set;

public class OperatorTest {
    private Operator operator;
    private Invoice invoice;

    @BeforeEach
    public void setUp() {
        operator = new Operator();
        operator.setIdOperateur(1L);
        operator.setFname("John");
        operator.setLname("Doe");
        operator.setPassword("password");

        invoice = new Invoice();
        invoice.setIdInvoice(1L);
        invoice.setAmountDiscount(10.0f);
        invoice.setAmountInvoice(100.0f);

        Set<Invoice> invoices = new HashSet<>();
        invoices.add(invoice);

        operator.setInvoices(invoices);
    }

    @Test
    public void testOperator() {
        Assertions.assertEquals(1L, operator.getIdOperateur());
        Assertions.assertEquals("John", operator.getFname());
        Assertions.assertEquals("Doe", operator.getLname());
        Assertions.assertEquals("password", operator.getPassword());
        Assertions.assertEquals(1, operator.getInvoices().size());
    }
}
