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
public class ProductModelTest {
    
    public ProductModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getProductNo method, of class ProductModel.
     */
    @Test
    public void testGetProductNo() {
        System.out.println("getProductNo");
        ProductModel instance = new ProductModel();
        int expResult = 0;
        int result = instance.getProductNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerProduct method, of class ProductModel.
     */
    @Test
    public void testRegisterProduct() {
        System.out.println("registerProduct");
        String productNo = "";
        String name = "";
        int unitNo = 0;
        String discount = "";
        String tax = "";
        String image = "";
        String description = "";
        ProductModel instance = new ProductModel();
        String expResult = "";
        String result = instance.registerProduct(productNo, name, unitNo, discount, tax, image, description);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateProduct method, of class ProductModel.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        String productNo = "";
        String name = "";
        int unitNo = 0;
        String discount = "";
        String tax = "";
        ProductModel instance = new ProductModel();
        String expResult = "";
        String result = instance.updateProduct(productNo, name, unitNo, discount, tax);
        assertEquals(expResult, result);
    }

    /**
     * Test of saveProduct method, of class ProductModel.
     */
    @Test
    public void testSaveProduct() {
        System.out.println("saveProduct");
        String productNo = "";
        String image = "";
        String description = "";
        ProductModel instance = new ProductModel();
        String expResult = "";
        String result = instance.saveProduct(productNo, image, description);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeProduct method, of class ProductModel.
     */
    @Test
    public void testRemoveProduct() {
        System.out.println("removeProduct");
        String productNo = "";
        ProductModel instance = new ProductModel();
        String expResult = "";
        String result = instance.removeProduct(productNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadProductTable method, of class ProductModel.
     */
    @Test
    public void testLoadProductTable() {
        System.out.println("loadProductTable");
        String keyword = "";
        DefaultTableModel productTableModel = null;
        ProductModel instance = new ProductModel();
        instance.loadProductTable(keyword, productTableModel);
    }

    /**
     * Test of getSelectedProductData method, of class ProductModel.
     */
    @Test
    public void testGetSelectedProductData() {
        System.out.println("getSelectedProductData");
        int productNo = 0;
        ProductModel instance = new ProductModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedProductData(productNo);
        assertArrayEquals(expResult, result);
    }
    
}
