/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jcertif.presentation.wsClient;

import com.jcertif.presentation.data.bo.presentation.StatutApprobation;

/**
 *
 * @author Douneg
 */
public class StatutApprobationClient extends AbstractJCertWebServiceClient<StatutApprobation, Long>{
 /**
     * The unique instance.
     */
    private StatutApprobationClient() {
        super("statutapprobation");
    }
    private static StatutApprobationClient instance;

    public static synchronized StatutApprobationClient getInstance() {
        if (instance == null) {
            instance = new StatutApprobationClient();
        }
        return instance;
    }
}
