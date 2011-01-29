package com.jcertif.presentation.action;

import com.jcertif.presentation.container.ProfilUtilisateurContainer;
import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;
import com.jcertif.presentation.wsClient.ProfilUtilisateurClient;

/**
 *
 * @author Douneg
 */
public class ProfilUtilisateurAction extends AbstractAction<ProfilUtilisateurContainer, ProfilUtilisateur, ProfilUtilisateurClient> {

//    @Autowired
//   private ProfilUtilisateurClient profilUtilisateurClient;
    public ProfilUtilisateurAction() throws InstantiationException, IllegalAccessException {
        setPrincipalContainer(new ProfilUtilisateurContainer());
    }
}
