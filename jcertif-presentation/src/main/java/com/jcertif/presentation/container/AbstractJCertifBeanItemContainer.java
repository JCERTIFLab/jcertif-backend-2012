/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.container;

import com.jcertif.bo.AbstractBO;
import com.vaadin.data.util.BeanItemContainer;
import java.io.Serializable;

/**
 *
 * @author Douneg
 */
public abstract class AbstractJCertifBeanItemContainer extends BeanItemContainer<AbstractBO> implements Serializable {

    public static String[] COL_HEADERS_ENGLISH;
    public static Object[] NATURAL_COL_ORDER;

    public AbstractJCertifBeanItemContainer(Class<? extends AbstractBO> type) {
        super(type);
    }

}
