package com.jcertif.presentation.action;

import com.jcertif.presentation.container.TypeEvenementContainer;
import com.jcertif.presentation.data.bo.cedule.TypeEvenement;
import com.jcertif.presentation.wsClient.TypeEvenementClient;

/**
 *
 * @author Douneg
 */
public class TypeEvenementAction extends AbstractAction<TypeEvenementContainer, TypeEvenement, TypeEvenementClient> {

    public TypeEvenementAction() {
        setPrincipalContainer(new TypeEvenementContainer());
    }
}
