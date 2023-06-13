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
public class CustomerModelTest {
    
    public CustomerModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCustomerNo method, of class CustomerModel.
     */
    @Test
    public void testGetCustomerNo() {
        System.out.println("getCustomerNo");
        CustomerModel instance = new CustomerModel();
        int expResult = 0;
        int result = instance.getCustomerNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of registerCustomer method, of class CustomerModel.
     */
    @Test
    public void testRegisterCustomer() {
        System.out.println("registerCustomer");
        String customerNo = "";
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        String gender = "";
        CustomerModel instance = new CustomerModel();
        String expResult = "";
        String result = instance.registerCustomer(customerNo, name, nic, email, contactNo, address, city, distictNo, provinceNo, gender);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateCustomer method, of class CustomerModel.
     */
    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        String customerNo = "";
        String name = "";
        String nic = "";
        String email = "";
        String contactNo = "";
        String address = "";
        String city = "";
        int distictNo = 0;
        int provinceNo = 0;
        String gender = "";
        CustomerModel instance = new CustomerModel();
        String expResult = "";
        String result = instance.updateCustomer(customerNo, name, nic, email, contactNo, address, city, distictNo, provinceNo, gender);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeCustomer method, of class CustomerModel.
     */
    @Test
    public void testRemoveCustomer() {
        System.out.println("removeCustomer");
        String customerNo = "";
        CustomerModel instance = new CustomerModel();
        String expResult = "";
        String result = instance.removeCustomer(customerNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadCustomerTable method, of class CustomerModel.
     */
    @Test
    public void testLoadCustomerTable() {
        System.out.println("loadCustomerTable");
        String keyword = "";
        DefaultTableModel customerTableModel = null;
        CustomerModel instance = new CustomerModel();
        instance.loadCustomerTable(keyword, customerTableModel);
    }

    /**
     * Test of getSelectedCustomerData method, of class CustomerModel.
     */
    @Test
    public void testGetSelectedCustomerData() {
        System.out.println("getSelectedCustomerData");
        int customerNo = 0;
        CustomerModel instance = new CustomerModel();
        Object[] expResult = null;
        Object[] result = instance.getSelectedCustomerData(customerNo);
        assertArrayEquals(expResult, result);
    }
    
}
