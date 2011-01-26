/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.presentation.util;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.Runo;

/**
 *
 * @author Douneg
 */
public class H1 extends Label {

        public H1(String caption) {
            super(caption);
            setSizeUndefined();
            setStyleName(Runo.LABEL_H1);
        }
    }
