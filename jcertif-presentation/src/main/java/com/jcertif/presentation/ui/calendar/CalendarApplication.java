package com.jcertif.presentation.ui.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.presentation.data.bo.cedule.CeduleParticipant;
import com.jcertif.presentation.data.bo.cedule.Evenement;
import com.jcertif.presentation.data.bo.participant.Participant;
import com.jcertif.presentation.ui.login.LoginForm;
import com.jcertif.presentation.ui.util.UIConst;
import com.jcertif.presentation.ui.util.UIStyle;
import com.jcertif.presentation.wsClient.CeduleParticipantClient;
import com.jcertif.presentation.wsClient.ParticipantClient;
import com.vaadin.Application;
import com.vaadin.addon.calendar.event.CalendarEvent;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClickHandler;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;

/**
 * @author rossi
 * 
 */
public class CalendarApplication extends Application implements EventClickHandler, ClickListener,
		HttpServletRequestListener {

	private static final long serialVersionUID = 1L;
	/**
	 * A Logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarApplication.class);

	/**
	 * Calendar component.
	 */
	private CalendarComponent calendarComponent;

	/**
	 * Calendar Detail Component.
	 */
	private CalendarDetailComponent detailComponent;

	/**
	 * Login Form.
	 */
	private LoginForm loginForm;

	/**
	 * Main Window.
	 */
	private Window mainWindow;

	/**
	 * Connected Participant.
	 */
	private Participant connectedPart;

	private Evenement selectedEvent;

	@Override
	public void init() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Building Calendar Application");
		}
		setTheme("jcertifruno");
		boolean init = false;
		if (mainWindow == null) {
			init = true;
			mainWindow = new Window();
			mainWindow.addStyleName("jcertif_calendar");
		}

		// Add calendar component
		mainWindow.getContent().addComponent(getCalendarComponent());

		// Update Detail Panel with first event
		CalendarEvent firstEvent = findFirstEvent();
		if (firstEvent != null) {
			updateDetailPanel((CalendarEventBean) firstEvent);
		}

		if (init) {
			setMainWindow(mainWindow);
		}

	}

	/**
	 * Find the first event.
	 * 
	 * @param events
	 *            a event list
	 * @return the first event
	 */
	private CalendarEvent findFirstEvent() {
		List<CalendarEvent> events = getCalendarEventBeans();

		CalendarEvent firstEvent = null;
		for (CalendarEvent calendarEvent : events) {
			// Setting participate style
			List<Long> eventIds = getCurrentParticipateEventIds();
			CalendarEventBean calendarEventBean = (CalendarEventBean) calendarEvent;
			if (eventIds.contains(calendarEventBean.getFacadeEvent().getId())) {
				calendarEventBean.setStyleName(UIStyle.PARTICIPATE_EVENT);
			}

			if (firstEvent == null) {
				firstEvent = calendarEvent;
			} else {
				if (firstEvent.getStart().after(calendarEvent.getStart())) {
					firstEvent = calendarEvent;
				}
			}

		}
		return firstEvent;
	}

	/**
	 * @return
	 */
	private List<CalendarEvent> getCalendarEventBeans() {
		DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH");
		Date startDate = null;
		Date endDate = null;
		try {
			endDate = dateF.parse("03/09/2011 09");
			startDate = dateF.parse("04/09/2011 21");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<CalendarEvent> events = getCalendarComponent().getEventProvider().getEvents(startDate,
				endDate);
		return events;
	}

	/**
	 * @param event
	 */
	private void updateDetailPanel(final CalendarEventBean event) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Updating Detail Panel");
		}
		selectedEvent = event.getFacadeEvent();
		updateSelectedStyle(event);

		List<Long> eventIds = getCurrentParticipateEventIds();

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Current participant has {} cedules.", eventIds.size());
		}

		// Update the panel event
		getDetailComponent().update(event.getFacadeEvent(),
				!eventIds.contains(event.getFacadeEvent().getId()));

		// Build Horizontal layout for calendar and detail panel
		final HorizontalLayout layoutH = new HorizontalLayout();
		layoutH.setSizeFull();
		layoutH.addComponent(getCalendarComponent());
		layoutH.setExpandRatio(getCalendarComponent(), 3);
		layoutH.addComponent(getDetailComponent());
		layoutH.setExpandRatio(getDetailComponent(), 1);

		// Update main window
		mainWindow.getContent().removeAllComponents();
		mainWindow.getContent().addComponent(layoutH);

	}

	private void updateSelectedStyle(final CalendarEventBean selectedEvent) {
		selectedEvent.setStyleName(UIStyle.SELECTED_EVENT);

		List<CalendarEvent> events = getCalendarEventBeans();
		for (CalendarEvent calendarEvent : events) {
			// Setting participate style
			List<Long> eventIds = getCurrentParticipateEventIds();
			CalendarEventBean calendarEventBean = (CalendarEventBean) calendarEvent;
			if (eventIds.contains(calendarEventBean.getFacadeEvent().getId())) {
				calendarEventBean.setStyleName(UIStyle.PARTICIPATE_EVENT);
			} else {
				calendarEventBean.removeStyle(UIStyle.PARTICIPATE_EVENT);
			}

			// Setting selected style
			if (selectedEvent.equals(calendarEventBean)) {
				calendarEventBean.setStyleName(UIStyle.SELECTED_EVENT);
			} else {
				calendarEventBean.removeStyle(UIStyle.SELECTED_EVENT);
			}
		}

	}

	/**
	 * @return
	 */
	private List<Long> getCurrentParticipateEventIds() {
		List<Long> eventIds = new ArrayList<Long>();

		if (connectedPart != null && connectedPart.getCeduleParticipants() != null
				&& !connectedPart.getCeduleParticipants().isEmpty()) {
			for (CeduleParticipant cedule : connectedPart.getCeduleParticipants()) {
				eventIds.add(cedule.getEvenementId());
			}
		}
		return eventIds;
	}

	@Override
	public void buttonClick(ClickEvent event) {

		if (event.getButton().equals(getLoginForm().getLoginButton())) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Event Click on logging Button");
			}

			// Validate form
			getLoginForm().commit();

			connectedPart = getLoginForm().commitAndGetParticipant();

			if (connectedPart != null) {
				addSelectedEventToCurrentUser();
			}

			// Participate button click
		} else if (event.getButton().equals(getDetailComponent().getParticipateButton())) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Event Click on participate Button");
			}
			if (connectedPart == null) {
				// Show Login
				String pathUrl = this.getURL().getPath().split("/")[1];
				ExternalResource res = new ExternalResource(this.getURL().getProtocol() + "://"
						+ this.getURL().getHost() + ":" + this.getURL().getPort() + "/" + pathUrl
						+ "/pages/" + UIConst.LOGIN_VIEW);
				this.getMainWindow().open(res);
			} else {
				addSelectedEventToCurrentUser();
			}
			// Cancel button click
		} else if (event.getButton().equals(getDetailComponent().getCancelButton())) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Event Click on cancel Button");
			}
			CeduleParticipant ceduleToBeDeleted = null;
			// Analyze if Cedule Participant already exist
			for (CeduleParticipant cedule : connectedPart.getCeduleParticipants()) {
				if (cedule.getEvenementId().equals(selectedEvent.getId())) {
					ceduleToBeDeleted = cedule;
				}
			}
			CeduleParticipantClient.getInstance().delete_XML(ceduleToBeDeleted);

			// Rechargement du participant après mise à jour de sa
			// cedule
			connectedPart = ParticipantClient.getInstance().findByEmail(connectedPart.getEmail());

			// Reinit calendar
			init();
		}

	}

	/**
	 * 
	 */
	private void addSelectedEventToCurrentUser() {
		// Analyze if Cedule Participant already exist
		boolean ceduleAlreadyExist = false;
		if (connectedPart.getCeduleParticipants() != null) {

			for (CeduleParticipant cedule : connectedPart.getCeduleParticipants()) {
				if (cedule.getEvenementId().equals(selectedEvent.getId())) {
					ceduleAlreadyExist = true;
				}
			}
		}

		if (!ceduleAlreadyExist) {
			// Create new cedule for participant
			CeduleParticipant newCedule = new CeduleParticipant();
			newCedule.setEvenementId(selectedEvent.getId());
			newCedule.setParticipantId(connectedPart.getId());
			newCedule.setDateCedule(Calendar.getInstance());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(
						"Creating cedule participant with participantId={} and evenementId={}",
						connectedPart.getId(), selectedEvent.getId());
			}
			CeduleParticipantClient.getInstance().create_XML(newCedule);

			// Rechargement du participant après mise à jour de sa
			// cedule
			connectedPart = ParticipantClient.getInstance().findByEmail(connectedPart.getEmail());
		}

		// Reinit calendar
		init();
	}

	/**
	 * @see com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClickHandler#eventClick(com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick)
	 */
	@Override
	public void eventClick(EventClick event) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Event Click on Calendar Application");
		}
		updateDetailPanel((CalendarEventBean) event.getCalendarEvent());
	}

	private CalendarComponent getCalendarComponent() {
		if (calendarComponent == null) {
			calendarComponent = new CalendarComponent();
			calendarComponent.setEventProvider(new CalendarEventBeanProvider());
			calendarComponent.addStyleName("calendar_central");
			calendarComponent.setHandler(this);
		}
		return calendarComponent;
	}

	private CalendarDetailComponent getDetailComponent() {
		if (detailComponent == null) {
			detailComponent = new CalendarDetailComponent();
			detailComponent.getParticipateButton().addListener(this);
			detailComponent.getCancelButton().addListener(this);
		}
		return detailComponent;
	}

	/**
	 * @return the loginForm
	 */
	private LoginForm getLoginForm() {
		if (loginForm == null) {
			loginForm = new LoginForm();
			loginForm.getLoginButton().addListener(this);
		}
		return loginForm;
	}

	@Override
	public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
		// If user is already connected and connectPart is null, load of user
		// profil
		if (connectedPart == null
				&& request.getSession().getAttribute(UIConst.PARAM_CONNECTED) != null
				&& request.getSession().getAttribute(UIConst.PARAM_CONNECTED).equals(Boolean.TRUE)) {
			connectedPart = ParticipantClient.getInstance().findByEmail(
					(String) request.getSession().getAttribute(UIConst.PARAM_EMAIL));
			// Reinit calendar
			init();
		}

		// logout case
		if (connectedPart != null
				&& (request.getSession().getAttribute(UIConst.PARAM_CONNECTED) == null || request
						.getSession().getAttribute(UIConst.PARAM_CONNECTED).equals(Boolean.FALSE))) {
			connectedPart = null;
			init();
		}
	}

	@Override
	public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
		// Save the login information
		if (connectedPart != null
				&& request.getSession().getAttribute(UIConst.PARAM_CONNECTED) == null) {
			request.getSession().setAttribute(UIConst.PARAM_CONNECTED, true);
			request.getSession().setAttribute(UIConst.PARAM_LASTNAME, connectedPart.getNom());
			request.getSession().setAttribute(UIConst.PARAM_FIRSTNAME, connectedPart.getPrenom());
			request.getSession().setAttribute(UIConst.PARAM_EMAIL, connectedPart.getEmail());
		}
	}

}
