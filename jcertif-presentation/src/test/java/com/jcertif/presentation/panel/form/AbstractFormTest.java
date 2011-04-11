/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.jcertif.presentation.action.AbstractAction;
import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.data.bo.presentation.StatutApprobation;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

/**
 * 
 * @author UNHCRUser
 */
public class AbstractFormTest {

	public AbstractFormTest() {
	}

	@org.junit.Before
	public void setUp() throws Exception {
	}

	@org.junit.After
	public void tearDown() throws Exception {
	}

	/**
	 * Test of addInitialFooter method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testAddInitialFooter() {
		System.out.println("addInitialFooter");
		AbstractForm instance = new AbstractFormImpl();
		instance.addInitialFooter();
		assertNotNull(instance.getCancelButton());
		assertNotNull(instance.getSaveButton());
		assertNotNull(instance.getEditButton());
		assertNotNull(instance.getFooter() instanceof HorizontalLayout);
		int i = 0;
		for (Iterator it = instance.getFooter().getComponentIterator(); it.hasNext();) {
			it.next();
			i++;
		}
		assertEquals(3, i);
		// TODO review the generated test code and remove the default call to
		// fail.

	}

	/**
	 * Test of getAbstractBO method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testGetAbstractBO() {
		System.out.println("getAbstractBO");
		AbstractForm instance = new AbstractFormImpl();
		AbstractBO expResult = null;
		AbstractBO result = instance.getAbstractBO();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to
		// fail.
	}

	/**
	 * Test of getAction method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testGetAction() {
		System.out.println("getAction");
		AbstractForm instance = new AbstractFormImpl();
		AbstractAction result = instance.getAction();
		assertNull(result);
	}

	/**
	 * Test of getBeanItem method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testGetBeanItem() {
		System.out.println("getBeanItem");
		AbstractForm instance = new AbstractFormImpl();
		BeanItem result = instance.getBeanItem();
		assertNull(result);
		// TODO review the generated test code and remove the default call to
		// fail.
	}

	/**
	 * Test of isNewContactMode method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testIsNewContactMode() {
		System.out.println("isNewContactMode");
		AbstractForm instance = new AbstractFormImpl();
		boolean expResult = false;
		boolean result = instance.isNewContactMode();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to
		// fail.

	}

	/**
	 * Test of getCancelButton method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testGetCancelButton() {
		System.out.println("getCancelButton");
		AbstractForm instance = new AbstractFormImpl();
		Button result = instance.getCancelButton();
		assertNull(result);
		instance = new AbstractFormImpl();
		instance.addInitialFooter();
		result = instance.getCancelButton();
		assertNotNull(result);
		// TODO review the generated test code and remove the default call to
		// fail.
	}

	/**
	 * Test of getEditButton method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testGetEditButton() {
		System.out.println("getEditButton");
		AbstractForm instance = new AbstractFormImpl();
		Button result = instance.getEditButton();
		assertNull(result);
		instance = new AbstractFormImpl();
		instance.addInitialFooter();
		result = instance.getEditButton();
		assertNotNull(result);
		// TODO review the generated test code and remove the default call to
		// fail.

	}

	/**
	 * Test of getSaveButton method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testGetSaveButton() {
		System.out.println("getSaveButton");
		AbstractForm instance = new AbstractFormImpl();
		Button result = instance.getSaveButton();
		assertNull(result);
		instance = new AbstractFormImpl();
		instance.addInitialFooter();
		result = instance.getSaveButton();
		assertNotNull(result);
		// TODO review the generated test code and remove the default call to
		// fail.

	}

	/**
	 * Test of setNewContactMode method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testSetNewContactMode() {
		System.out.println("setNewContactMode");
		boolean newContactMode = false;
		AbstractForm instance = new AbstractFormImpl();
		instance.setNewContactMode(newContactMode);
		// TODO review the generated test code and remove the default call to
		// fail.
		assertEquals(newContactMode, instance.isNewContactMode());
	}

	/**
	 * Test of buttonClick method, of class AbstractForm.
	 */
	// @org.junit.Test
	// public void testButtonClick() {
	// System.out.println("buttonClick");
	// ClickEvent event = null;
	// AbstractForm instance = new AbstractFormImpl();
	// instance.buttonClick(event);
	// // TODO review the generated test code and remove the default call to
	// fail.
	//
	// }
	/**
	 * Test of getColumnOrder method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testGetColumnOrder() {
		System.out.println("getColumnOrder");
		AbstractForm instance = new AbstractFormImpl();
		List expResult = new ArrayList();
		expResult.add("A");
		expResult.add("B");
		expResult.add("C");
		List result = instance.getColumnOrder();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to
		// fail.

	}

	/**
	 * Test of setItemDataSource method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testSetItemDataSource() {
		System.out.println("setItemDataSource");
		BeanItem newDataSource = new BeanItem(new StatutApprobation("B", "Build"));
		AbstractForm instance = new AbstractFormImpl();
		instance.setItemDataSource(newDataSource);
		// TODO review the generated test code and remove the default call to
		// fail.
		assertEquals(
				((StatutApprobation) ((BeanItem) instance.getItemDataSource()).getBean())
						.getCodeStatut(),
				"B");
		assertEquals(
				((StatutApprobation) ((BeanItem) instance.getItemDataSource()).getBean())
						.getDescription(),
				"Build");
	}

	/**
	 * Test of setBOForEdit method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testSetBOForEdit() {
		System.out.println("setBOForEdit");
		AbstractBO abstractBO = new StatutApprobation("B", "Build");
		boolean newBO = false;
		AbstractForm instance = new AbstractFormImpl();
		instance.setBOForEdit(abstractBO, newBO);
		// TODO review the generated test code and remove the default call to
		// fail.

	}

	/**
	 * Test of setBOForRead method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testSetBOForRead() {
		System.out.println("setBOForRead");
		AbstractBO abstractBO = new StatutApprobation("ACC", "Accepte");
		AbstractForm instance = new AbstractFormImpl();
		instance.setBOForRead(abstractBO);
		// TODO review the generated test code and remove the default call to
		// fail.
		assertEquals(((StatutApprobation) abstractBO).getCodeStatut(),
				((StatutApprobation) instance.getAbstractBO()).getCodeStatut());
		assertEquals(((StatutApprobation) abstractBO).getDescription(),
				((StatutApprobation) instance.getAbstractBO()).getDescription());
		assertNotNull(instance.getBeanItem());

	}

	/**
	 * Test of setReadOnly method, of class AbstractForm.
	 */
	@org.junit.Test
	public void testSetReadOnly() {
		System.out.println("setReadOnly");
		boolean readOnly = false;
		AbstractForm instance = new AbstractFormImpl();
		instance.setReadOnly(readOnly);
		// TODO review the generated test code and remove the default call to
		// fail.
		assertEquals(readOnly, instance.isReadOnly());
		instance = new AbstractFormImpl();
		instance.addInitialFooter();
		instance.setReadOnly(readOnly);
		assertEquals(true, instance.getSaveButton().isVisible());
		assertEquals(true, instance.getCancelButton().isVisible());
		assertEquals(false, instance.getEditButton().isVisible());
	}

	public class AbstractFormImpl extends AbstractForm {

		@Override
		public List<Object> getColumnOrder() {
			Object[] list = { "A", "B", "C" };
			return Arrays.asList(list);
		}
	}
}
