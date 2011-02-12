/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.action;

import com.jcertif.presentation.container.AbstractJCertifBeanItemContainer;
import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.wsClient.AbstractJCertWebServiceClient;
import com.vaadin.data.Item;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.ComboBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Douneg
 * Classe permettant de faire la liaison entre une interface et un container
 * Elle permet aussi de faire la liaison entre l'interfae le container et le client du service web
 * permettant d'attaquer la couche metier
 */
public class AbstractAction<PC extends AbstractJCertifBeanItemContainer, BO extends AbstractBO, WS extends AbstractJCertWebServiceClient> {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private PC principalContainer;
    private WS webServiceClient;
    private boolean alreadyMakeFirstLoad = false;

    public AbstractAction(PC principalContainer, WS webServiceClient) {
        this.principalContainer = principalContainer;
        this.webServiceClient = webServiceClient;
    }

    public boolean isAlreadyMakeFirstLoad() {
        return alreadyMakeFirstLoad;
    }

    public WS getWebServiceClient() {
        return webServiceClient;
    }
    public static final String PROP_PRINCIPALCONTAINER = "principalContainer";

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

        bo = (BO) getWebServiceClient().create_XML(bo);
        return getPrincipalContainer().addItem(bo);
    }

    public boolean updateItem(BO bo) throws UnsupportedOperationException {
        bo = (BO) getWebServiceClient().update_XML(bo);
        return true;
    }

    public boolean refreshContainer() {
        Collection<BO> all = new ArrayList<BO>();
        all = getWebServiceClient().findAll_XML();
        getPrincipalContainer().loadData(all);
        return true;
    }

    public ComboBox createCombobox(String caption) {
        // Creates a new combobox using an existing container
        if (!isAlreadyMakeFirstLoad()) {
            refreshContainer();
        }
        ComboBox l = new ComboBox(caption,
                getPrincipalContainer());

        // Sets the combobox to show a certain property as the item caption
        l.setItemCaptionPropertyId(getPrincipalContainer().getCaptionField());
        l.setItemCaptionMode(AbstractSelect.ITEM_CAPTION_MODE_PROPERTY);

        // Set the appropriate filtering mode for this example
        l.setFilteringMode(Filtering.FILTERINGMODE_STARTSWITH);
        l.setImmediate(true);

        // Disallow null selections
        l.setNullSelectionAllowed(false);
        return l;
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
