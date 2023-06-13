/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EZIO AUDITORY
 */
public class StockModelTest {
    
    public StockModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadStockTable method, of class StockModel.
     */
    @Test
    public void testLoadStockTable() {
        System.out.println("loadStockTable");
        String keyword = "";
        DefaultTableModel stockTableModel = null;
        StockModel instance = new StockModel();
        instance.loadStockTable(keyword, stockTableModel);
    }

    /**
     * Test of getSelectedStockData method, of class StockModel.
     */
    @Test
    public void testGetSelectedStockData() {
        System.out.println("getSelectedStockData");
        int stockNo = 0;
        StockModel instance = new StockModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedStockData(stockNo);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of loadStockTableMain method, of class StockModel.
     */
    @Test
    public void testLoadStockTableMain() {
        System.out.println("loadStockTableMain");
        String keyword = "";
        DefaultTableModel stockTableModel = null;
        StockModel instance = new StockModel();
        instance.loadStockTableMain(keyword, stockTableModel);
    }
    
}
