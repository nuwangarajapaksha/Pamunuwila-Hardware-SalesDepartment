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
public class SupplierModelTest {
    
    public SupplierModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSupplierNo method, of class SupplierModel.
     */
    @Test
    public void testGetSupplierNo() {
        System.out.println("getSupplierNo");
        SupplierModel instance = new SupplierModel();
        int expResult = 0;
        int result = instance.getSupplierNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerSupplier method, of class SupplierModel.
     */
    @Test
    public void testRegisterSupplier() {
        System.out.println("registerSupplier");
        String supplierNo = "";
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        String gender = "";
        SupplierModel instance = new SupplierModel();
        String expResult = "";
        String result = instance.registerSupplier(supplierNo, name, nic, email, contactNo, address, city, distictNo, provinceNo, gender);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateSupplier method, of class SupplierModel.
     */
    @Test
    public void testUpdateSupplier() {
        System.out.println("updateSupplier");
        String supplierNo = "";
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        String gender = "";
        SupplierModel instance = new SupplierModel();
        String expResult = "";
        String result = instance.updateSupplier(supplierNo, name, nic, email, contactNo, address, city, distictNo, provinceNo, gender);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeSupplier method, of class SupplierModel.
     */
    @Test
    public void testRemoveSupplier() {
        System.out.println("removeSupplier");
        String supplierNo = "";
        SupplierModel instance = new SupplierModel();
        String expResult = "";
        String result = instance.removeSupplier(supplierNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadSupplierTable method, of class SupplierModel.
     */
    @Test
    public void testLoadSupplierTable() {
        System.out.println("loadSupplierTable");
        String keyword = "";
        DefaultTableModel supplierTableModel = null;
        SupplierModel instance = new SupplierModel();
        instance.loadSupplierTable(keyword, supplierTableModel);
    }

    /**
     * Test of getSelectedSupplierData method, of class SupplierModel.
     */
    @Test
    public void testGetSelectedSupplierData() {
        System.out.println("getSelectedSupplierData");
        int supplierNo = 0;
        SupplierModel instance = new SupplierModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedSupplierData(supplierNo);
        assertArrayEquals(expResult, result);
    }
    
}
