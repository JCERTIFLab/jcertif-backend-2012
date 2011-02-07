/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.panel;

import com.jcertif.presentation.panel.table.CeduleParticipantTable;
import com.jcertif.presentation.panel.table.PropositionPresentationTable;
import com.jcertif.presentation.action.CeduleParticipantAction;
import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.action.PropositionPresentationAction;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.panel.form.ParticipantForm;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Layout;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Douneg
 */
public class CreationParticipantPanel extends MasterDetailsPanel<ParticipantAction> implements Button.ClickListener, Property.ValueChangeListener {

    private ParticipantForm participantForm;
    private CeduleParticipantAction ceduleParticipantAction;
    private CeduleParticipantTable ceduleParticipantTable;
    private PropositionPresentationAction propositionPresentationAction;
    private PropositionPresentationTable propositionPresentationTable;
    private Button addPropositionPresentation = new Button("+ Proposition Presentation", (Button.ClickListener) this);
    private Button addCeduleParticipant = new Button("+ Cedule Participant", (Button.ClickListener) this);
    private Button manageProfilU = new Button("Ajouter Profil Utilisateur", (Button.ClickListener) this);
    private Button detailsCedule = new Button("Details", (Button.ClickListener) this);
    private Button detailsPropositionPresentation = new Button("Details", (Button.ClickListener) this);
    private Set<Component> allDetails;
    private Set<Button> allButtons;

    public CreationParticipantPanel(ParticipantAction participantAction) {
        super(participantAction);
        participantForm = new ParticipantForm(participantAction);
        participantForm.setBOForEdit(new Participant(), true);
        participantForm.initDefaultButton(participantForm);
        addPropositionPresentation.setEnabled(false);
        ceduleParticipantAction = new CeduleParticipantAction();
        ceduleParticipantTable = new CeduleParticipantTable(ceduleParticipantAction);
        propositionPresentationAction = new PropositionPresentationAction();
        propositionPresentationTable = new PropositionPresentationTable(propositionPresentationAction);

        allDetails = new HashSet<Component>();

        allButtons = new HashSet<Button>();
        allButtons.add(detailsCedule);
        Layout detail = buildDetailPanel("Cedule", "Liste des Cedules", ceduleParticipantTable, allButtons);
        allDetails.add(detail);

        allButtons = new HashSet<Button>();
        allButtons.add(detailsPropositionPresentation);
        detail = buildDetailPanel("Proposition Presentation", "Liste des Proposition Presentations", propositionPresentationTable, allButtons);
        allDetails.add(detail);

        allButtons = new HashSet<Button>();
        allButtons.add(participantForm.getSaveButton());
        allButtons.add(addPropositionPresentation);
        allButtons.add(addCeduleParticipant);
        allButtons.add(manageProfilU);
        Layout all = buildMainPanel("Participants", "Creation d'un participant", participantForm, allButtons, allDetails);
        getContent().addComponent(all);
    }

    @Override
    public void buttonClick(ClickEvent event) {
        if (event.getButton() == addPropositionPresentation) {
        } else if (event.getButton() == addCeduleParticipant) {
        } else if (event.getButton() == manageProfilU) {
        } else if (event.getButton() == detailsCedule) {
        } else if (event.getButton() == detailsPropositionPresentation) {
        }
    }

    @Override
    public void valueChange(ValueChangeEvent event) {
        Property property = event.getProperty();
        if (property == participantForm) {
            Participant participant = (Participant) participantForm.getValue();
            // Item item = participantTable.getItem(participant);
            ceduleParticipantAction.getPrincipalContainer().loadData(participant.getCeduleparticipants());
            propositionPresentationAction.getPrincipalContainer().loadData(participant.getPresentations());
            if (participant.getProfilUtilisateur() == null) {
                manageProfilU.setCaption("Ajouter un profil utilisateur");
            } else {
                manageProfilU.setCaption("Editer le profil utilisateur");
            }
        }
    }
}
