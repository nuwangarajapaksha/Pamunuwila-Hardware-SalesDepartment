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
public class GrnModelTest {
    
    public GrnModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getGrnNo method, of class GrnModel.
     */
    @Test
    public void testGetGrnNo() {
        System.out.println("getGrnNo");
        GrnModel instance = new GrnModel();
        int expResult = 0;
        int result = instance.getGrnNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of saveGrn method, of class GrnModel.
     */
    @Test
    public void testSaveGrn() {
        System.out.println("saveGrn");
        String grnNo = "";
        Date grnDate = null;
        int supplierNo = 0;
        String itemCount = "";
        String totalDiscount = "";
        String totalVat = "";
        String totalAmount = "";
        GrnModel instance = new GrnModel();
        String expResult = "";
        String result = instance.saveGrn(grnNo, grnDate, supplierNo, itemCount, totalDiscount, totalVat, totalAmount);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveGrnItem method, of class GrnModel.
     */
    @Test
    public void testSaveGrnItem() {
        System.out.println("saveGrnItem");
        int productNo = 0;
        double unitSellPrice = 0.0;
        double qty = 0.0;
        double unitBuyPrice = 0.0;
        double discount = 0.0;
        double vat = 0.0;
        double amount = 0.0;
        String grnNo = "";
        GrnModel instance = new GrnModel();
        String expResult = "";
        String result = instance.saveGrnItem(productNo, unitSellPrice, qty, unitBuyPrice, discount, vat, amount, grnNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateStock method, of class GrnModel.
     */
    @Test
    public void testUpdateStock() {
        System.out.println("updateStock");
        Date grnDate = null;
        int productNo = 0;
        double qty = 0.0;
        double unitSellPrice = 0.0;
        GrnModel instance = new GrnModel();
        String expResult = "";
        String result = instance.updateStock(grnDate, productNo, qty, unitSellPrice);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadGrnHistoryTable method, of class GrnModel.
     */
    @Test
    public void testLoadGrnHistoryTable() {
        System.out.println("loadGrnHistoryTable");
        String keyword = "";
        DefaultTableModel grnHistoryTableModel = null;
        GrnModel instance = new GrnModel();
        instance.loadGrnHistoryTable(keyword, grnHistoryTableModel);
    }
    
}
