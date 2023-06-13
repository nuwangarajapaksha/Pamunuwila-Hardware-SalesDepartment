/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JTable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EZIO AUDITORY
 */
public class StockManagerTest {
    
    public StockManagerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of stockTableSettings method, of class StockManager.
     */
    @Test
    public void testStockTableSettings() {
        System.out.println("stockTableSettings");
        JTable jtable = null;
        StockManager instance = new StockManager();
        instance.stockTableSettings(jtable);
    }

    /**
     * Test of main method, of class StockManager.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        StockManager.main(args);
    }
    
}
