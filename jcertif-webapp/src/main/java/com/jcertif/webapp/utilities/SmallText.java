/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.webapp.utilities;

import com.vaadin.ui.Label;
import com.vaadin.ui.themes.Reindeer;

/**
 *
 * @author Douneg
 */
public class SmallText extends Label {

        public SmallText(String caption) {
            super(caption);
            setStyleName(Reindeer.LABEL_SMALL);
        }
    }