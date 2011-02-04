/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.form;

import com.jcertif.presentation.data.bo.presentation.StatutApprobation;
import com.vaadin.data.util.BeanItem;
import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import java.util.Arrays;
import com.jcertif.presentation.action.CeduleParticipantAction;
import com.jcertif.presentation.container.CeduleParticipantContainer;
import com.jcertif.presentation.data.bo.cedule.StatutCedule;
import java.util.Calendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Douneg
 */
public class CeduleParticipantFormTest {

    public CeduleParticipantFormTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getCeduleParticipant method, of class CeduleParticipantForm.
     */
    @org.junit.Test
    public void testGetCeduleParticipant() {
        System.out.println("getCeduleParticipant");
        CeduleParticipantForm instance = new CeduleParticipantForm(new CeduleParticipantAction());
        CeduleParticipant expResult = null;
        CeduleParticipant result = instance.getAbstractBO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getColumnOrder method, of class CeduleParticipantForm.
     */
    @Test
    public void testGetColumnOrder() {
        System.out.println("getColumnOrder");
        CeduleParticipantForm instance = new CeduleParticipantForm(new CeduleParticipantAction());
        List expResult = Arrays.asList(CeduleParticipantContainer.NATURAL_COL_ORDER);
        List result = instance.getColumnOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setItemDataSource method, of class AbstractForm.
     */
    @org.junit.Test
    public void testSetItemDataSource() {
        System.out.println("setItemDataSource");
        Calendar calendar = Calendar.getInstance();
        StatutCedule statutCedule = new StatutCedule("B", "Build");
        BeanItem newDataSource = new BeanItem(new CeduleParticipant(Long.valueOf(34), calendar, "Oups Kin Makambo", null, null, statutCedule));
        CeduleParticipantForm instance = new CeduleParticipantForm(new CeduleParticipantAction());
        instance.setItemDataSource(newDataSource);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(((CeduleParticipant) ((BeanItem) instance.getItemDataSource()).getBean()).getDateCedule(), calendar);
        assertEquals(((CeduleParticipant) ((BeanItem) instance.getItemDataSource()).getBean()).getId(), Long.valueOf(34));
        assertEquals(((CeduleParticipant) ((BeanItem) instance.getItemDataSource()).getBean()).getDetails(), "Oups Kin Makambo");
        assertEquals(((CeduleParticipant) ((BeanItem) instance.getItemDataSource()).getBean()).getStatutCedule().getCode(), "B");
        assertEquals(((CeduleParticipant) ((BeanItem) instance.getItemDataSource()).getBean()).getStatutCedule().getDescription(), "Build");
    }

    /**
     * Test of setBOForEdit method, of class AbstractForm.
     */
    @org.junit.Test
    public void testSetBOForEdit() {
        System.out.println("setBOForEdit");
        CeduleParticipant abstractBO = new CeduleParticipant();
        boolean newBO = false;
        CeduleParticipantForm instance = new CeduleParticipantForm(new CeduleParticipantAction());
        instance.setBOForEdit(abstractBO, newBO);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setBOForRead method, of class AbstractForm.
     */
    @org.junit.Test
    public void testSetBOForRead() {
        System.out.println("setBOForRead");
        CeduleParticipant abstractBO = new CeduleParticipant();
        CeduleParticipantForm instance = new CeduleParticipantForm(new CeduleParticipantAction());
        instance.setBOForRead(abstractBO);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(abstractBO.getDetails(), instance.getAbstractBO().getDetails());
        assertEquals(abstractBO.getDateCedule(), instance.getAbstractBO().getDateCedule());
        assertNotNull(instance.getBeanItem());

    }
}
