package com.jcertif.presentation.ui.view;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;


import com.jcertif.presentation.JCertifWebApplication;
import com.jcertif.presentation.data.domain.JCertifPresentation;
import com.jcertif.presentation.ui.FullScreenButton;
import com.jcertif.presentation.ui.calendar.CalendarComponent;
import com.jcertif.presentation.ui.calendar.CalendarEventBean;

//import com.jcertif.presentation.ui.ceduler.JCertifCeduler;
import com.jcertif.presentation.ui.calendar.CalendarEventBeanProvider;

import com.vaadin.addon.calendar.event.CalendarEvent;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClickHandler;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.terminal.DownloadStream;
import com.vaadin.terminal.URIHandler;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import com.vaadin.terminal.gwt.server.WebBrowser;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UriFragmentUtility;
import com.vaadin.ui.VerticalLayout;

/**
 * The main view of the application displaying navigation, calendar and details.
 */
public class MainView extends HorizontalLayout implements EventClickHandler, ValueChangeListener, URIHandler {

    private static final long serialVersionUID = 7622207451668068454L;

    //private JCertifCalendarEvent currentEvent;

    private CalendarComponent calendar;
    private EventDetailsPanel detailsPanel;
    private HorizontalLayout toolbar;
    private Panel detailsPanelWrapper;
    /*private DaySelectorField daySelector;
    private FullScreenButton fullScreenButton;
    private Label dayLabel;
    private UriFragmentUtility uriFragment;*/

    public MainView() {
        initUi();
    }
    private void initUi() {
        setWidth("100%");
        setHeight("100%");
        setMargin(true);
        setSpacing(true);
        
        calendar = new CalendarComponent();
        calendar.setHandler(this);
        detailsPanel = new EventDetailsPanel(null);
        
        toolbar = new HorizontalLayout();
        toolbar.setSizeFull();

        Panel calendarPanel = new Panel();
        calendarPanel.setSizeFull();
        calendarPanel.addComponent(calendar);

        detailsPanelWrapper = new Panel();
        detailsPanelWrapper.setSizeFull();
        detailsPanelWrapper.addComponent(detailsPanel);

        toolbar.addComponent(calendarPanel);
        toolbar.addComponent(detailsPanelWrapper);
        addComponent(toolbar);

        setExpandRatio(toolbar, 1.0f);
        toolbar.setExpandRatio(calendarPanel, 0.70f);
        toolbar.setExpandRatio(detailsPanelWrapper, 0.30f);    
        
    }
   
    @Override
    public void eventClick(EventClick event) {
        CalendarEvent calEvent = event.getCalendarEvent();
        if (calEvent instanceof CalendarEventBean) {
        	CalendarEventBean jCertifcalEvent = (CalendarEventBean) calEvent;
            // Replace the current detailsPanel with a new one.
            EventDetailsPanel newDetailsPanel = new EventDetailsPanel(
            		jCertifcalEvent);
            detailsPanelWrapper.replaceComponent(detailsPanel, newDetailsPanel);
            detailsPanel = newDetailsPanel;
        }
    }
	@Override
	public DownloadStream handleURI(URL context, String relativeUri) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub
		
	}   
    
  //TODO
/*
    private void initUi() {
        setWidth("100%");
        setHeight("100%");

        dayLabel = new Label();
        dayLabel.setStyleName("selected-day");

        calendar = new JCertifCalendar();
        calendar.setHandler(this);
        calendar.setDate(JCertifCalendar.getDefaultDate());

        uriFragment = new UriFragmentUtility();
        addComponent(uriFragment);

        daySelector = new DaySelectorField(JCertifCalendar.JCERTIF_FIRST_DAY, JCertifCalendar.JCERTIF_LAST_DAY, uriFragment);
        daySelector.addListener(this);
        daySelector.setValue(JCertifCalendar.getDefaultDate());

        toolbar = new HorizontalLayout();
        toolbar.setWidth("100%");
        toolbar.setHeight("33px");
        toolbar.setStyleName("v-toolbar");
        toolbar.addComponent(new UserLayout(calendar));
        toolbar.addComponent(daySelector);
        final Label placeHolder = new Label("");
        placeHolder.setWidth("250px");
        toolbar.addComponent(placeHolder);
        toolbar.setComponentAlignment(daySelector, Alignment.TOP_CENTER);
        toolbar.setExpandRatio(daySelector, 1.0f);

        fullScreenButton = new FullScreenButton(false);
        fullScreenButton.setVisible(!iOSUserAgent());
        final CssLayout calendarWrapper = new CssLayout();
        calendarWrapper.setMargin(true);
        calendarWrapper.setSizeFull();
        calendarWrapper.addComponent(fullScreenButton);
        calendarWrapper.addComponent(dayLabel);
        calendarWrapper.addComponent(calendar);

        final Panel calendarPanel = new Panel(new VerticalLayout());
        ((Layout) calendarPanel.getContent()).setMargin(false);
        calendarPanel.setStyleName("calendar-panel");
        calendarPanel.setSizeFull();
        calendarPanel.addComponent(toolbar);
        calendarPanel.addComponent(calendarWrapper);
        calendarPanel.addComponent(new FooterLinksLayout());
        addComponent(calendarPanel);

        detailsPanel = new EventDetailsPanel(this);
        addComponent(detailsPanel);
        detailsPanel.setVisible(false); // hide at first

        // make the calendar expand to use all available space
        setExpandRatio(calendarPanel, 1f);
    }
    
    

    private boolean iOSUserAgent() {
        if (JCertifWebApplication.getCurrentInstance().getContext() instanceof WebApplicationContext) {
            final WebBrowser browser = ((WebApplicationContext) JCertifWebApplication.getCurrentInstance().getContext())
                    .getBrowser();
            final String userAgent = browser.getBrowserApplication();

            if (userAgent.contains("iPod") || userAgent.contains("iPhone") || userAgent.contains("iPad")) {
                return true;
            }
        }
        return false;
    }

 
    public void eventClick(final EventClick eventClick) {
        if (!eventClick.getCalendarEvent().equals(currentEvent)) {
            final CalendarEvent calEvent = eventClick.getCalendarEvent();
            // Select the event without repainting the calendar as the selected
            // style name is set on the client-side when clicking an event.
            selectCalendarEvent(calEvent, false);
        }
    }

    private void selectCalendarEvent(final CalendarEvent calEvent, final boolean repaintCalendar) {
        if (calEvent instanceof JCertifCalendarEvent) {
            detailsPanel.setVisible(true);

            final JCertifCalendarEvent jcertifCalEvent = (JCertifCalendarEvent) calEvent;

            if (!fullScreenButton.isFullScreen()) {
                getWindow().scrollIntoView(toolbar);
            }

            currentEvent = jcertifCalEvent;
            calendar.setSelectedPresentation(jcertifCalEvent.getJcertifEvent());
            detailsPanel.setEvent(jcertifCalEvent);

            if (repaintCalendar) {
                calendar.requestRepaint();
            }

            JCertifWebApplication.trackPageview("view", jcertifCalEvent.getJcertifEvent());
        }
    }

 
    public void valueChange(final ValueChangeEvent event) {
        calendar.setDate((Date) daySelector.getValue());
        dayLabel.setValue(getLabelForDate((Date) daySelector.getValue()));
    }

    private String getLabelForDate(final Date value) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(value);

        switch (cal.get(Calendar.DAY_OF_WEEK)) {
        case Calendar.MONDAY:
            return "University day 1";
        case Calendar.TUESDAY:
            return "University day 2";
        case Calendar.WEDNESDAY:
            return "Conference day 1";
        case Calendar.THURSDAY:
            return "Conference day 2";
        case Calendar.FRIDAY:
            return "Conference day 3";
        }

        return "";
    }

    public void selectPresentationWithId(final int id) {
        final JCertifCalendarEvent event = (JCertifCalendarEvent) ((JCertifEventProvider) calendar.getEventProvider())
                .getEvent(id);
        if (event != null) {
            // select correct date and event
            daySelector.setValue(event.getJcertifEvent().getFromTime());
            selectCalendarEvent(event, true);
        }
    }

    public DownloadStream handleURI(final URL context, final String relativeUri) {
        if (relativeUri.startsWith("presentation/")) {
            try {
                final int id = Integer.valueOf(relativeUri.split("/")[1]);
                selectPresentationWithId(id);
            } catch (final NumberFormatException e) {
                // the id was not an integer -> simply ignore
            }
        }
        return null;
    }*/
}
