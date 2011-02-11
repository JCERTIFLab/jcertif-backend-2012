/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.AbstractBO;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author Douneg
 */
public abstract class AbstractJCertifBeanItemContainer<T extends AbstractBO> extends BeanItemContainer<AbstractBO> implements Serializable {

    public AbstractJCertifBeanItemContainer(Class<? extends AbstractBO> type) {
        super(type);
    }

    public void loadData(Collection<T> datas) {
        removeAllItems();
        for (Iterator<T> it = datas.iterator(); it.hasNext();) {
            AbstractBO abstractBO = it.next();
            addBean(abstractBO);
        }
        sort(new Object[]{getCaptionField()},
                new boolean[]{true});
    }

    public abstract String getCaptionField();
}
