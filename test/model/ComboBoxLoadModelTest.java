/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EZIO AUDITORY
 */
public class ComboBoxLoadModelTest {
    
    public ComboBoxLoadModelTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of districtComboBoxLoad method, of class ComboBoxLoadModel.
     */
    @Test
    public void testDistrictComboBoxLoad() {
        System.out.println("districtComboBoxLoad");
        ComboBoxLoadModel instance = new ComboBoxLoadModel();
        Vector expResult = null;
        Vector result = instance.districtComboBoxLoad();
        assertEquals(expResult, result);
    }

    /**
     * Test of provinceComboBoxLoad method, of class ComboBoxLoadModel.
     */
    @Test
    public void testProvinceComboBoxLoad() {
        System.out.println("provinceComboBoxLoad");
        ComboBoxLoadModel instance = new ComboBoxLoadModel();
        Vector expResult = null;
        Vector result = instance.provinceComboBoxLoad();
        assertEquals(expResult, result);
    }

    /**
     * Test of unitComboBoxLoad method, of class ComboBoxLoadModel.
     */
    @Test
    public void testUnitComboBoxLoad() {
        System.out.println("unitComboBoxLoad");
        ComboBoxLoadModel instance = new ComboBoxLoadModel();
        Vector expResult = null;
        Vector result = instance.unitComboBoxLoad();
        assertEquals(expResult, result);
    }
    
}
