/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.form;

import com.jcertif.presentation.container.ParticipantContainer;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.vaadin.data.util.BeanItem;
import java.util.Arrays;
import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.action.RoleParticipantAction;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Douneg
 */
public class ParticipantFormTest {

    public ParticipantFormTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getParticipant method, of class ParticipantForm.
     */
    @org.junit.Test
    public void testGetParticipant() {
        System.out.println("getParticipant");
        ParticipantForm instance = new ParticipantForm(new ParticipantAction()) {
        };
        Participant expResult = null;
        Participant result = instance.getAbstractBO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getColumnOrder method, of class ParticipantForm.
     */
    @Test
    public void testGetColumnOrder() {
        System.out.println("getColumnOrder");
        ParticipantForm instance = new ParticipantForm(new ParticipantAction());
        List expResult = Arrays.asList(ParticipantContainer.NATURAL_COL_ORDER);
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
        BeanItem newDataSource = new BeanItem(new Participant(Long.valueOf(34), "Mr", "Makambo", "Minene", Character.valueOf('M'), "matayo@unhcr.org", null, null));
        ParticipantForm instance = new ParticipantForm(new ParticipantAction());
        instance.setItemDataSource(newDataSource);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(((Participant) ((BeanItem) instance.getItemDataSource()).getBean()).getSalutation(), "Mr");
        assertEquals(((Participant) ((BeanItem) instance.getItemDataSource()).getBean()).getId(), Long.valueOf(34));
        assertEquals(((Participant) ((BeanItem) instance.getItemDataSource()).getBean()).getDetails(), null);
        assertEquals(((Participant) ((BeanItem) instance.getItemDataSource()).getBean()).getPrenom(), "Makambo");
        assertEquals(((Participant) ((BeanItem) instance.getItemDataSource()).getBean()).getNom(), "Minene");
        assertEquals(((Participant) ((BeanItem) instance.getItemDataSource()).getBean()).getSexe(), Character.valueOf('M'));
    }

    /**
     * Test of setBOForEdit method, of class AbstractForm.
     */
    @org.junit.Test
    public void testSetBOForEdit() {
        System.out.println("setBOForEdit");
        Participant abstractBO = new Participant(Long.valueOf(34), "Mr", "Makambo", "Minene", Character.valueOf('M'), "matayo@unhcr.org", null, null);
        boolean newBO = false;
        ParticipantForm instance = new ParticipantForm(new ParticipantAction());
        instance.setBOForEdit(abstractBO, newBO);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(abstractBO.getDetails(), instance.getAbstractBO().getDetails());
        assertEquals(abstractBO.getEmail(), instance.getAbstractBO().getEmail());
        assertEquals(abstractBO.getPrenom(), instance.getAbstractBO().getPrenom());
        assertEquals(abstractBO.getNom(), instance.getAbstractBO().getNom());
        assertEquals(abstractBO.getSalutation(), instance.getAbstractBO().getSalutation());
        assertEquals(abstractBO.getSexe(), instance.getAbstractBO().getSexe());
        assertEquals(newBO, instance.isNewContactMode());
    }

    /**
     * Test of setBOForRead method, of class AbstractForm.
     */
    @org.junit.Test
    public void testSetBOForRead() {
        System.out.println("setBOForRead");
        Participant abstractBO = new Participant(Long.valueOf(34), "Mr", "Makambo", "Minene", Character.valueOf('M'), "matayo@unhcr.org", null, null);
        ParticipantForm instance = new ParticipantForm(new ParticipantAction());
        instance.setBOForRead(abstractBO);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(abstractBO.getDetails(), instance.getAbstractBO().getDetails());
        assertEquals(abstractBO.getEmail(), instance.getAbstractBO().getEmail());
        assertEquals(abstractBO.getPrenom(), instance.getAbstractBO().getPrenom());
        assertEquals(abstractBO.getNom(), instance.getAbstractBO().getNom());
        assertEquals(abstractBO.getSalutation(), instance.getAbstractBO().getSalutation());
        assertEquals(abstractBO.getSexe(), instance.getAbstractBO().getSexe());
        assertNotNull(instance.getBeanItem());
    }
}
