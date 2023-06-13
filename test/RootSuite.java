/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author EZIO AUDITORY
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({images.ImagesSuite.class, model.ModelSuite.class, database.DatabaseSuite.class, gui.GuiSuite.class})
public class RootSuite {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
