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
public class SmallText extends Label {

        public SmallText(String caption) {
            super(caption);
            setStyleName(Runo.LABEL_SMALL);
        }
    }