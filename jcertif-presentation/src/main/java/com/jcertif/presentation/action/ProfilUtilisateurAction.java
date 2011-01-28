package com.jcertif.presentation.action;

import com.jcertif.presentation.container.ProfilUtilisateurContainer;
import com.jcertif.presentation.data.bo.AbstractBO;
import com.jcertif.presentation.data.bo.participant.ProfilUtilisateur;
import com.vaadin.data.util.BeanItem;

/**
 *
 * @author Douneg
 */
public class ProfilUtilisateurAction extends AbstractAction {

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
