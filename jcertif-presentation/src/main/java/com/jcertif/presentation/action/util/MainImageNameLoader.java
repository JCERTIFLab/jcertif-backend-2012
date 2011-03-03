/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.action.util;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Douneg
 */
public class MainImageNameLoader extends ImageNameLoader {

    private ArrayList<String> allImageName;

    @Override
    public String getApplicationAbsolutePath() {
        return applicationAbsolutePath;
    }

    @Override
    public void setApplicationAbsolutePath(String applicationAbsolutePath) {
        this.applicationAbsolutePath = applicationAbsolutePath;
    }
    private String applicationAbsolutePath;

    @Override
    public ArrayList<String> getAllImageName() {
        if (allImageName == null || allImageName.isEmpty()) {
            allImageName = getImageName();
        }
        return allImageName;
    }

    private ArrayList<String> getImageName() {
        ArrayList<String> imageNames = new ArrayList<String>();
        File mainDir = new File(getApplicationAbsolutePath(), "pages");
        File baseDirectory = new File(mainDir, "mainslide_images");
        File[] listOfFiles = baseDirectory.listFiles();
        for (File file : listOfFiles) {
            imageNames.add(file.getName());
        }
        return imageNames;
    }
}
