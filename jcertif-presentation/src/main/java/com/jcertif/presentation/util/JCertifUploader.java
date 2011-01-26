/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.util;

import com.vaadin.ui.Upload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Douneg
 */
public abstract class JCertifUploader implements Upload.SucceededListener, Upload.FailedListener, Upload.Receiver {

    private File file;         // File to write to.

    public File getFile() {
        return file;
    }

    // Callback method to begin receiving the upload.
    @Override
    public OutputStream receiveUpload(String filename, String MIMEType) {
        FileOutputStream fos = null; // Output stream to write to
        file = new File("/tmp/uploads/" + filename);
        try {
            // Open the file for writing.
            fos = new FileOutputStream(file);
        } catch (final java.io.FileNotFoundException e) {
            return null;
        }
        return fos; // Return the output stream to write to
    }
    // This is called if the upload is finished.

    @Override
    public abstract void uploadSucceeded(Upload.SucceededEvent event);

    // This is called if the upload fails.
    @Override
    public abstract void uploadFailed(Upload.FailedEvent event);

    public static Upload createUplaod(String title, String buttonCation, JCertifUploader uploader) {
        final Upload upload = new Upload(title, uploader);
        // Use a custom button caption instead of plain "Upload".
        upload.setButtonCaption(buttonCation);
        // Listen for events regarding the success of upload.
        upload.addListener((Upload.SucceededListener) uploader);
        upload.addListener((Upload.FailedListener) uploader);
        return upload;
    }
}
