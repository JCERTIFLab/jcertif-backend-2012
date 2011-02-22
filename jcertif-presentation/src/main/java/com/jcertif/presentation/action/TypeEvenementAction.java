package com.jcertif.presentation.action;

import com.jcertif.presentation.container.TypeEvenementContainer;
import com.jcertif.presentation.data.bo.cedule.TypeEvenement;
import com.jcertif.presentation.wsClient.TypeEvenementClient;

/**
 *
 * @author Douneg
 */
public class TypeEvenementAction extends AbstractAction<TypeEvenementContainer, TypeEvenement, TypeEvenementClient> {

    private TypeEvenementContainer typeEvenementContainer;

    public TypeEvenementAction() {
        super();
        typeEvenementContainer = new TypeEvenementContainer();
    }

    @Override
    public TypeEvenementClient getWebServiceClient() {
        return TypeEvenementClient.getInstance();
    }

    @Override
    public TypeEvenementContainer getPrincipalContainer() {
        return typeEvenementContainer;
    }
}
