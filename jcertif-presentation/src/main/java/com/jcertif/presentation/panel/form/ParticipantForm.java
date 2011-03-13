package com.jcertif.presentation.panel.form;

import com.jcertif.presentation.action.ConferenceAction;
import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.action.RoleParticipantAction;
import com.jcertif.presentation.action.TypeParticipantAction;
import com.jcertif.presentation.container.ParticipantContainer;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.panel.field.AdresseField;
import com.jcertif.presentation.util.CalendarField;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import java.util.Arrays;
import java.util.List;

public class ParticipantForm extends AbstractForm<Participant, ParticipantAction> {

    private RoleParticipantAction roleParticipantAction = new RoleParticipantAction();
    private TypeParticipantAction typeParticipantAction = new TypeParticipantAction();
    private ConferenceAction conferenceAction = new ConferenceAction();
    private ComboBox role;
    private ComboBox sexe;
    private ComboBox salutation;
    private ComboBox type;
    private GridLayout ourLayout;
    private VerticalLayout vLayout;

    public ParticipantForm(ParticipantAction action) {
        super(action);
        sexe = new ComboBox();
        salutation = new ComboBox();
        sexe.addItem(Character.valueOf('M'));
        sexe.addItem(Character.valueOf('F'));
        salutation.addItem("M.");
        salutation.addItem("Mme");
        salutation.addItem("Mlle");
        // Create our layout (4x8 GridLayout)
        ourLayout = new GridLayout(4, 8);
        vLayout = new VerticalLayout();
        vLayout.setMargin(true);
        vLayout.setSpacing(true);
        //vLayout.setSizeFull();
        // Use top-left margin and spacing
        ourLayout.setMargin(true, false, false, true);
        ourLayout.setSpacing(true);
        setLayout(vLayout);


        setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {
                
                if (propertyId.equals("roleparticipant")) {
                    role = getRoleParticipantAction().createCombobox("Selectionner un role");
                    role.setCaption("Role");
                    role.setRequired(true);
                    role.setRequiredError("Veuillez choisir un role");
                    return role;
                } else if (propertyId.equals("typeParticipant")) {
                    type = getTypeParticipantAction().createCombobox("Selectionner un type");
                    type.setCaption("Type");
                    type.setRequired(true);
                    type.setRequiredError("Veuillez choisir un type pour le participant");
                    return type;
                } else if (propertyId.equals("sexe")) {
                    sexe.setCaption("Sexe");
                    sexe.setRequired(true);
                    sexe.setRequiredError("Veuillez choisir un sexe");
                    return sexe;
                } else if (propertyId.equals("salutation")) {
                    salutation.setCaption("Salutation");
                    salutation.setRequired(true);
                    salutation.setRequiredError("Veuillez choisir une salutation");
                    return salutation;
                }

                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("prenom")) {
                    TextField f = (TextField) field;
                    f.setCaption("Prenom");
                    f.setRequired(true);
                    f.setColumns(12);
                    f.setHeight("100%");
                    f.setRows(1);
                    f.setNullRepresentation("");
                    return f;
                } else if (propertyId.equals("nom")) {
                    TextField f = (TextField) field;
                    f.setCaption("Nom");
                    f.setRequired(true);
                    f.setColumns(12);
                    f.setHeight("100%");
                    f.setRows(1);
                  f.setNullRepresentation("");
                    return f;
                } else if (propertyId.equals("specialite")) {
                    TextField f = (TextField) field;
                    f.setCaption("Specialite");
                    f.setRows(2);
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                } else if (propertyId.equals("cvSoumis")) {
                    TextField f = (TextField) field;
                    f.setCaption("CV Soumis");
                    f.setRows(5);
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                } else if (propertyId.equals("compagnie")) {
                    TextField f = (TextField) field;
                    f.setCaption("Compagnie");
                    f.setColumns(12);
                    f.setNullRepresentation("");
                    return f;
                } else if (propertyId.equals("email")) {
                    TextField f = (TextField) field;
                    f.setCaption("Email");
                    f.setColumns(12);
                    /* Add a validator for email and make it required */
                    f.addValidator(new EmailValidator(
                            "L'addresse electronique doit contenir '@' et un nom de domaine complet."));
                    f.setRequired(true);
                    f.setNullRepresentation("");
                } else if ("adresse".equals(propertyId)) {

                    // create a custom field for the Address object
                    field = new AdresseField(((Participant) ((BeanItem) getItemDataSource()).getBean()).getAdresse());
                    field.setCaption("Adresse");

                } else if (propertyId.equals("details")) {
                    TextField f = (TextField) field;
                    f.setCaption("Details");
                    f.setColumns(12);
                    f.setNullRepresentation("");
                    f.setRows(2);
                } else if (propertyId.equals("website")) {
                    TextField f = (TextField) field;
                    f.setCaption("Site Web");
                    f.setColumns(12);
                    f.setNullRepresentation("");
                }

                return field;
            }
        });

    }

    @Override
    protected void attachField(Object propertyId, Field field) {
//        if (propertyId.equals("sexe")) {
//            ourLayout.addComponent(field, 1, 0, 2, 0);
//        } else if (propertyId.equals("salutation")) {
//            ourLayout.addComponent(field, 0, 1);
//        } else if (propertyId.equals("nom")) {
//            ourLayout.addComponent(field, 0, 0);
//        } else if (propertyId.equals("prenom")) {
//            ourLayout.addComponent(field, 1, 0);
//        } else if (propertyId.equals("email")) {
//            ourLayout.addComponent(field, 0, 2);
//        } else if (propertyId.equals("specialite")) {
//            ourLayout.addComponent(field, 0, 6, 2, 6);
//        } else if (propertyId.equals("website")) {
//            ourLayout.addComponent(field, 1, 2, 2, 2);
//        } else if (propertyId.equals("details")) {
//            ourLayout.addComponent(field, 0, 3, 2, 3);
//        } else if (propertyId.equals("compagnie")) {
//            ourLayout.addComponent(field, 2, 4);
//        } else if (propertyId.equals("cvSoumis")) {
//            ourLayout.addComponent(field, 0, 5, 2, 5);
//        } else if (propertyId.equals("roleparticipant")) {
//            ourLayout.addComponent(field, 0, 7);
//        } else if (propertyId.equals("typeParticipant")) {
//            ourLayout.addComponent(field, 1, 7);
//        } else if (propertyId.equals("adresse")) {
//            ourLayout.addComponent(field, 3, 0, 3, 7);
//        }
    	
    	 if (propertyId.equals("sexe")) {
             vLayout.addComponent(field);
         } else if (propertyId.equals("salutation")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("nom")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("prenom")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("email")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("specialite")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("website")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("details")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("compagnie")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("cvSoumis")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("roleparticipant")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("typeParticipant")) {
        	 vLayout.addComponent(field);
         } else if (propertyId.equals("adresse")) {
        	 vLayout.addComponent(field);
         }

    }

    @Override
    public List<Object> getColumnOrder() {
        return Arrays.asList(ParticipantContainer.NATURAL_COL_ORDER);
    }

    public ConferenceAction getConferenceAction() {
        return conferenceAction;
    }

    public void setConferenceAction(ConferenceAction conferenceAction) {
        this.conferenceAction = conferenceAction;
    }

    public RoleParticipantAction getRoleParticipantAction() {
        return roleParticipantAction;
    }

    public void setRoleParticipantAction(RoleParticipantAction roleParticipantAction) {
        this.roleParticipantAction = roleParticipantAction;
    }

    public TypeParticipantAction getTypeParticipantAction() {
        return typeParticipantAction;
    }

    public void setTypeParticipantAction(TypeParticipantAction typeParticipantAction) {
        this.typeParticipantAction = typeParticipantAction;
    }
}
