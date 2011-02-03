/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.cedule.TypeEvenement;

/**
 *
 * @author UNHCRUser
 */
public class TypeEvenementClient extends AbstractJCertWebServiceClient<TypeEvenement, Long> {

    /**
     * The unique instance.
     */
    private TypeEvenementClient() {
        super("typeevenement");
    }
    private static TypeEvenementClient instance;

    public static synchronized TypeEvenementClient getInstance() {
        if (instance == null) {
            instance = new TypeEvenementClient();
        }
        return instance;
    }
}
