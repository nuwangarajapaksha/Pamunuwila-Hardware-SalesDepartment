/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EZIO AUDITORY
 */
public class HomeModelTest {
    
    public HomeModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPurchaseAmount method, of class HomeModel.
     */
    @Test
    public void testGetPurchaseAmount() {
        System.out.println("getPurchaseAmount");
        HomeModel instance = new HomeModel();
        double expResult = 0.0;
        double result = instance.getPurchaseAmount();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSalesAmount method, of class HomeModel.
     */
    @Test
    public void testGetSalesAmount() {
        System.out.println("getSalesAmount");
        HomeModel instance = new HomeModel();
        double expResult = 0.0;
        double result = instance.getSalesAmount();
        assertEquals(expResult, result, 0.0);
    }
    
}
