/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.action;

import com.jcertif.presentation.container.AbstractJCertifBeanItemContainer;
import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.principal.JCertifVaadinApplication;
import com.jcertif.presentation.wsClient.AbstractJCertWebServiceClient;
import com.sun.jersey.api.client.ClientResponse;
import com.vaadin.data.Item;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.ComboBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.jmx.LoggerDynamicMBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Douneg
 * Classe permettant de faire la liaison entre une interface et un container
 * Elle permet aussi de faire la liaison entre l'interfae le container et le client du service web
 * permettant d'attaquer la couche metier
 */
public abstract class AbstractAction<PC extends AbstractJCertifBeanItemContainer, BO extends AbstractBO, WS extends AbstractJCertWebServiceClient> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAction.class);

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private boolean alreadyMakeFirstLoad = false;
    private Class<BO> responseType;

    public AbstractAction() {
        final ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.responseType = (Class<BO>) type.getActualTypeArguments()[1];
    }

    public boolean isAlreadyMakeFirstLoad() {
        return alreadyMakeFirstLoad;
    }

    public abstract WS getWebServiceClient();
    public static final String PROP_PRINCIPALCONTAINER = "principalContainer";

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    /**
     * Get the value of principalContainec
     *
     * @return the value of principalContainec
     */
    public abstract PC getPrincipalContainer();

    public Item addItem(BO bo) throws UnsupportedOperationException {
        ClientResponse status = getWebServiceClient().checkConnection();
        if (status.getStatus() < 400) {
            bo = (BO) getWebServiceClient().create_XML(bo);
            return getPrincipalContainer().addItem(bo);
        }
        String clazz = bo.getClass().getSimpleName();
        String description = "Echec d'ajout de " + clazz;
        JCertifVaadinApplication.showError(status, description);

        return null;
    }

    public boolean updateItem(BO bo) throws UnsupportedOperationException {
        ClientResponse status = getWebServiceClient().checkConnection();
        
        if (status.getStatus() < 400) {
			LOGGER.warn(
					"Entity={0} Statut={1} .Le statut de la r�ponse lors du test de connexion a retourn� une r�ponse < 400, il se peut donc que les donn�es ne soient pas r�cup�r�es",
					responseType.getSimpleName(), status.getStatus());
		}
        if (status.getStatus() < 400) {
            bo = (BO) getWebServiceClient().update_XML(bo);
            return true;
        }
        String clazz = bo.getClass().getSimpleName();
        String description = "Echec de mise a jour de " + clazz;
        JCertifVaadinApplication.showError(status, description);

        return false;
    }

    public void refreshContainer() {
        ClientResponse status = getWebServiceClient().checkConnection();
        Collection<BO> all = new ArrayList<BO>();
        all = getWebServiceClient().findAll_XML();
        getPrincipalContainer().loadData(all);
        
		if (status.getStatus() < 400) {
			LOGGER.warn(
					"Entity={0} Statut={1} .Le statut de la r�ponse lors du test de connexion a retourn� une r�ponse < 400, il se peut donc que les donn�es ne soient pas r�cup�r�es",
					responseType.getSimpleName(), status.getStatus());
		}

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
