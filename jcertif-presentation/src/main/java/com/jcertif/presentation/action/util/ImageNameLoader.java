/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.action.util;

import java.util.ArrayList;

/**
 *
 * @author UNHCRUser
 */
public abstract class ImageNameLoader {

    public ImageNameLoader() {
    }

    public abstract ArrayList<String> getAllImageName();

    public abstract String getApplicationAbsolutePath();

    public abstract void setApplicationAbsolutePath(String applicationAbsolutePath);
}
