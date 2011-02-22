package com.jcertif.presentation.action;

import com.jcertif.presentation.container.ProfilUtilisateurContainer;
import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;
import com.jcertif.presentation.wsClient.ProfilUtilisateurClient;

/**
 *
 * @author Douneg
 */
public class ProfilUtilisateurAction extends AbstractAction<ProfilUtilisateurContainer, ProfilUtilisateur, ProfilUtilisateurClient> {

    private ProfilUtilisateurContainer profilUtilisateurContainer;

//    @Autowired
//   private ProfilUtilisateurClient profilUtilisateurClient;
    public ProfilUtilisateurAction() {
        super();
        profilUtilisateurContainer = new ProfilUtilisateurContainer();
    }

    @Override
    public ProfilUtilisateurClient getWebServiceClient() {
        return ProfilUtilisateurClient.getInstance();
    }

    @Override
    public ProfilUtilisateurContainer getPrincipalContainer() {
        return profilUtilisateurContainer;
    }
}
