
package com.jcertif.presentation.action;

import com.jcertif.bo.AbstractBO;
import com.jcertif.bo.participant.ProfilUtilisateur;
import com.jcertif.presentation.container.ProfilUtilisateurContainer;
import com.vaadin.data.util.BeanItem;

/**
 *
 * @author Douneg
 */
public class ProfilUtilisateurAction {

   private ProfilUtilisateurContainer profilUtilisateurContainer;
//    @Autowired
//   private ProfilUtilisateurClient profilUtilisateurClient;

    public ProfilUtilisateurAction() throws InstantiationException, IllegalAccessException {
        this.profilUtilisateurContainer = new ProfilUtilisateurContainer();
    }

    public BeanItem<AbstractBO> addItem(ProfilUtilisateur profilUtilisateur) throws UnsupportedOperationException {
      //  profilUtilisateur = profilUtilisateurClient.create_XML(profilUtilisateur);
        return profilUtilisateurContainer.addItem(profilUtilisateur);
    }

    public ProfilUtilisateurContainer getProfilUtilisateurContainer() {
        return profilUtilisateurContainer;
    }
}
