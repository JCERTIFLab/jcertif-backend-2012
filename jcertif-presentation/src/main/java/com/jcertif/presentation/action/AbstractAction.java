/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.action;

import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.wsClient.AbstractJCertWebServiceClient;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Douneg
 */
public class AbstractAction<PC extends Container, BO extends AbstractBO, WS extends AbstractJCertWebServiceClient> {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private PC principalContainer;
    private WS webServiceClient;

    public WS getWebServiceClient() {
        return webServiceClient;
    }
    public static final String PROP_PRINCIPALCONTAINER = "principalContainec";

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    /**
     * Get the value of principalContainec
     *
     * @return the value of principalContainec
     */
    public PC getPrincipalContainer() {
        return principalContainer;
    }

    public Item addItem(BO bo) throws UnsupportedOperationException {
        // bo = (BO) webServiceClient.create_XML(bo);
        return getPrincipalContainer().addItem(bo);
    }

    public void updateItem(BO bo) throws UnsupportedOperationException {
      //  bo = (BO) webServiceClient.update_XML(bo);
    }

    /**
     * Set the value of principalContainec
     *
     * @param pc new value of principalContainec
     */
    public void setPrincipalContainer(PC pc) {
        PC oldPC = this.principalContainer;
        this.principalContainer = pc;
        getPropertyChangeSupport().firePropertyChange(PROP_PRINCIPALCONTAINER, oldPC, pc);
    }

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
