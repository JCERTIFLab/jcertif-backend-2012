package com.jcertif.presentation.ui.propositionPresentation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.conference.Conference;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.data.bo.presentation.Sujet;
import com.jcertif.presentation.ui.util.UIConst;
import com.jcertif.presentation.wsClient.ConferenceClient;
import com.jcertif.presentation.wsClient.ParticipantClient;
import com.jcertif.presentation.wsClient.PropositionPresentationClient;
import com.jcertif.presentation.wsClient.SujetClient;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;

/**
 * Formulation de proposition de sujet de présentation.
 * 
 * @author max
 * 
 */

public class PropositionPresentationForm extends Form {

	private static final Object[] VISIBLE_PROPERTIES = new Object[] { "titre", "description",
			"sujetStringList", "sommaire", "besoinsSpecifiques", "motCle" };
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(PropositionPresentationForm.class);
	private String emailParticipant;
	private String contextPath;

	public PropositionPresentationForm() {
		super();
		init();
	}

	private void init() {
		// this.setLayout(new VerticalLayout());
		this.getLayout().setMargin(true);
		setFormFieldFactory(new PropositionPresentationFieldFactory());

		intBeanProposition();

		// Footer avec le bouton enregistrer
		Button saveProposition = new Button("Enregistrer", this, "commit");
		HorizontalLayout layoutFooter = new HorizontalLayout();
		layoutFooter.addComponent(saveProposition);
		this.setFooter(layoutFooter);

		this.setCaption("Proposer une présentation à JCERTIF 2011");
		this.setDescription(""); // Veuillez remplir ce formulaire afin de
									// proposer une présentation

	}

	/**
	 * 
	 */
	private void intBeanProposition() {
		PropositionPresentationBean bean = new PropositionPresentationBean();

		// Initialisation de la conférence
		List<Conference> conferences = ConferenceClient.getInstance().findAllXML();

		if (conferences == null || conferences.isEmpty()) {
			LOGGER.error("Aucune conférence n'est présente côté facade");
		} else {
			// TODO définir avec Max une clé fonctionnelle pour la conférence à
			// choisir
			bean.setConference(conferences.iterator().next());
		}

		// Mapping BO Bean Form
		BeanItem<PropositionPresentationBean> item = new BeanItem<PropositionPresentationBean>(bean);
		this.setItemDataSource(item);
		this.setVisibleItemProperties(VISIBLE_PROPERTIES);
	}

	/**
	 * @see com.vaadin.ui.Form#commit()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void commit() throws SourceException {
		super.commit();
		try {
			PropositionPresentationBean bean = ((BeanItem<PropositionPresentationBean>) this
					.getItemDataSource()).getBean();
			PropositionPresentation propo = new PropositionPresentation();
			BeanUtils.copyProperties(propo, bean);
			List<Sujet> sujetList = SujetClient.getInstance().findAllXML();
			List<Sujet> sujetParticipantList = new ArrayList<Sujet>();
			for (String sujString : bean.getSujetStringList()) {

				for (Sujet sujet : sujetList) {
					if (sujet.getLibelle().equals(sujString)) {
						sujetParticipantList.add(sujet);
					}
				}
			}
			propo.setSujetsInternal(sujetParticipantList);

			Participant participant = ParticipantClient.getInstance().findByEmail(emailParticipant);
			Set<Participant> partiList = new HashSet<Participant>();
			partiList.add(participant);
			propo.setParticipants(partiList);

			PropositionPresentationClient.getInstance().create_XML(propo);

			intBeanProposition();

			ExternalResource res = new ExternalResource(contextPath + UIConst.CONFIRMATION_VIEW);
			getApplication().getMainWindow().open(res);

		} catch (UniformInterfaceException e) {
			getApplication().getMainWindow().showNotification("Email incorrect");
			// TODO Gestion de l'exception
			e.getResponse();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param contextPath
	 *            the contextPath to set
	 */
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	/**
	 * @param emailParticipant
	 *            the emailParticipant to set
	 */
	public void setEmailParticipant(String emailParticipant) {
		this.emailParticipant = emailParticipant;
	}

}
