/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.webapp.ui.panel;

import com.jcertif.bo.Adresse;
import com.vaadin.data.Buffered;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Form;

/**
 *
 * @author Douneg
 */
public class AddressField extends CustomField {

    private static final long serialVersionUID = -7303229471599487430L;
    private Form addressForm;

    public AddressField(Adresse address) {
        addressForm = new Form();
        addressForm.setCaption("Adresse");
        addressForm.setWriteThrough(false);
        addressForm.setFormFieldFactory(DefaultFieldFactory.get());
        if (address == null) {
            addressForm.setItemDataSource(new BeanItem<Adresse>(
                    new Adresse()));
        } else {
            addressForm.setItemDataSource(new BeanItem<Adresse>(address));
        }
        setCompositionRoot(addressForm);
        setSizeFull();
        
    }

    /**
     * commit changes of the address form
     */
    @Override
    public void commit() throws Buffered.SourceException, InvalidValueException {
        super.commit();
        addressForm.commit();
    }

    /**
     * discard changes of the address form
     */
    @Override
    public void discard() throws Buffered.SourceException {
        super.discard();
        addressForm.discard();
    }

    @Override
    public Class<?> getType() {
        return Adresse.class;
    }
}
