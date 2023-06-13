/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EZIO AUDITORY
 */
public class SalesModelTest {
    
    public SalesModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInvoiceNo method, of class SalesModel.
     */
    @Test
    public void testGetInvoiceNo() {
        System.out.println("getInvoiceNo");
        SalesModel instance = new SalesModel();
        int expResult = 0;
        int result = instance.getInvoiceNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveInvoice method, of class SalesModel.
     */
    @Test
    public void testSaveInvoice() {
        System.out.println("saveInvoice");
        String invoiceNo = "";
        Date invoiceDate = null;
        int customerNo = 0;
        String itemCount = "";
        String totalDiscount = "";
        String totalTax = "";
        String totalAmount = "";
        SalesModel instance = new SalesModel();
        String expResult = "";
        String result = instance.saveInvoice(invoiceNo, invoiceDate, customerNo, itemCount, totalDiscount, totalTax, totalAmount);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveSales method, of class SalesModel.
     */
    @Test
    public void testSaveSales() {
        System.out.println("saveSales");
        int productNo = 0;
        double qty = 0.0;
        double unitSellPrice = 0.0;
        double discount = 0.0;
        double tax = 0.0;
        double amount = 0.0;
        String invoiceNo = "";
        SalesModel instance = new SalesModel();
        String expResult = "";
        String result = instance.saveSales(productNo, qty, unitSellPrice, discount, tax, amount, invoiceNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateStock method, of class SalesModel.
     */
    @Test
    public void testUpdateStock() {
        System.out.println("updateStock");
        int stockNo = 0;
        double qty = 0.0;
        Date invoiceDate = null;
        SalesModel instance = new SalesModel();
        String expResult = "";
        String result = instance.updateStock(stockNo, qty, invoiceDate);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvailableStockQty method, of class SalesModel.
     */
    @Test
    public void testGetAvailableStockQty() {
        System.out.println("getAvailableStockQty");
        String stockNo = "";
        SalesModel instance = new SalesModel();
        double expResult = 0.0;
        double result = instance.getAvailableStockQty(stockNo);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of loadInvoiceHistoryTable method, of class SalesModel.
     */
    @Test
    public void testLoadInvoiceHistoryTable() {
        System.out.println("loadInvoiceHistoryTable");
        String keyword = "";
        DefaultTableModel invoiceHistoryTableModel = null;
        SalesModel instance = new SalesModel();
        instance.loadInvoiceHistoryTable(keyword, invoiceHistoryTableModel);
    }
    
}
