/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author EZIO AUDITORY
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({model.StockModelTest.class, model.ComboBoxLoadModelTest.class, model.SalesModelTest.class, model.CustomerModelTest.class, model.LoginFormModelTest.class, model.BackupAndRestoreModelTest.class, model.ProductModelTest.class, model.SupplierModelTest.class, model.GrnModelTest.class, model.HomeModelTest.class})
public class ModelSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
