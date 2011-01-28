/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.container;

import com.jcertif.presentation.action.AbstractAction;
import com.jcertif.presentation.data.bo.AbstractBO;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Douneg
 */
public abstract class AbstractJCertifBeanItemContainer<T extends AbstractBO> extends BeanItemContainer<AbstractBO> implements Serializable {

    public AbstractJCertifBeanItemContainer(Class<? extends AbstractBO> type) {
        super(type);
    }

    public abstract void loadData(List<T> datas);
}
