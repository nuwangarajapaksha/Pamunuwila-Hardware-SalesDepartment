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
public class LoadStockDialogTest {
    
    public LoadStockDialogTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of stockTableSettings method, of class LoadStockDialog.
     */
    @Test
    public void testStockTableSettings() {
        System.out.println("stockTableSettings");
        JTable jtable = null;
        LoadStockDialog instance = null;
        instance.stockTableSettings(jtable);
    }

    /**
     * Test of loadStockTable method, of class LoadStockDialog.
     */
    @Test
    public void testLoadStockTable() {
        System.out.println("loadStockTable");
        String Keyword = "";
        LoadStockDialog instance = null;
        instance.loadStockTable(Keyword);
    }

    /**
     * Test of main method, of class LoadStockDialog.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LoadStockDialog.main(args);
    }
    
}
