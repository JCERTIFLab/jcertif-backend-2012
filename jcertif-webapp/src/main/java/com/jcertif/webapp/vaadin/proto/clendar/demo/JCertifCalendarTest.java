package com.jcertif.webapp.vaadin.proto.clendar.demo;

import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import com.vaadin.Application;
import com.vaadin.addon.calendar.event.BasicEvent;
import com.vaadin.addon.calendar.event.BasicEventProvider;
import com.vaadin.addon.calendar.event.CalendarEvent;
import com.vaadin.addon.calendar.ui.Calendar;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.DateClickEvent;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClick;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.EventClickHandler;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.RangeSelectEvent;
import com.vaadin.addon.calendar.ui.CalendarComponentEvents.RangeSelectHandler;
import com.vaadin.addon.calendar.ui.handler.BasicDateClickHandler;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.ParameterHandler;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;

/**
 * 
 * @author badr.elhouari
 *
 */
public class JCertifCalendarTest extends Application {

	private static final long serialVersionUID = 4359010674046839181L;    

    private GregorianCalendar calendar;

    private Calendar calendarComponent;

    private final Label captionLabel = new Label("");

    private Window scheduleEventPopup;

    private final Form scheduleEventForm = new Form();

    private Button deleteEventButton;

    private Button applyEventButton;

    private BasicEventProvider dataSource;

    private Button addNewEvent;
    
    @SuppressWarnings("serial")
    @Override
    public void init() {
        Window w = new Window();
        setMainWindow(w);
        
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setMargin(true);

        w.setContent(layout);
        w.setSizeFull();
        w.addParameterHandler(new ParameterHandler() {
            public void handleParameters(Map<String, String[]> parameters) {
                if (dataSource == null) {
                    // This needs to be called only once per a session after
                    // the first Application init-method call.
                    initContent();
                }
            }
        });
    }

    public void initContent() {
        setLocale(Locale.getDefault());
        initCalendar();
        initLayoutContent();
        addInitialEvents();
    }

    private void addInitialEvents() {
        
        Date jCertifFirstDay = getJCertifDate();
        
        Date start = calendarComponent.getFirstDateForWeek(jCertifFirstDay);
        Date end = calendarComponent.getLastDateForWeek(jCertifFirstDay);

        
        calendar.add(GregorianCalendar.DATE, 0);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 8);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        end = calendar.getTime();
        JCertifCalendarEvent event = getNewEvent("Acceuil et mot du président", start, end);
        dataSource.addEvent(event);
        
        calendar.add(GregorianCalendar.DATE, 0);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 10);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        end = calendar.getTime();
        event = getNewEvent("Nouveauté JEE", start, end);
        dataSource.addEvent(event);
        
        calendar.add(GregorianCalendar.DATE, 0);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 10);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        end = calendar.getTime();
        event = getNewEvent("Formation SCJD", start, end);
        dataSource.addEvent(event);
        
        calendar.add(GregorianCalendar.DATE, 0);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 10);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        end = calendar.getTime();
        event = getNewEvent("Formation SCJP", start, end);
        dataSource.addEvent(event);
        
        
        calendar.add(GregorianCalendar.DATE, 0);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 14);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 2);
        end = calendar.getTime();
        event = getNewEvent("Conf ....", start, end);
        dataSource.addEvent(event);

        calendar.add(GregorianCalendar.DATE, 1);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 8);
        calendar.set(GregorianCalendar.MINUTE, 0);
        start = calendar.getTime();
        calendar.add(GregorianCalendar.HOUR_OF_DAY, 4);
        end = calendar.getTime();
        event = getNewEvent("bla bla bla ...", start, end);
        dataSource.addEvent(event);

        calendar.setTime(jCertifFirstDay);
    }

    private void initLayoutContent() {
       
        initAddNewEventButton();

        HorizontalLayout hl = new HorizontalLayout();
        hl.setWidth("100%");
        hl.setSpacing(true);
        hl.setMargin(false, false, true, false);
        hl.addComponent(captionLabel);
        
        hl.setComponentAlignment(captionLabel, Alignment.MIDDLE_CENTER);

        HorizontalLayout controlPanel = new HorizontalLayout();
        controlPanel.setSpacing(true);
        controlPanel.setMargin(false, false, true, false);
        controlPanel.setWidth("100%");
        controlPanel.addComponent(addNewEvent);
        
        controlPanel.setComponentAlignment(addNewEvent, Alignment.MIDDLE_LEFT);

        VerticalLayout layout = (VerticalLayout) getMainWindow().getContent();
        layout.addComponent(controlPanel);
        layout.addComponent(hl);
        layout.addComponent(calendarComponent);
        layout.setExpandRatio(calendarComponent, 1);
    }

    public void initAddNewEventButton() {
        addNewEvent = new Button("Ajouter un nouveau événement");
        addNewEvent.addListener(new Button.ClickListener() {

            private static final long serialVersionUID = -8307244759142541067L;

            public void buttonClick(ClickEvent event) {
                showEventPopup(createNewEvent(getJCertifDate(), getJCertifDate()), true);
            }

        });
    }

    private void initCalendar() {
        dataSource = new BasicEventProvider();

        calendarComponent = new Calendar(dataSource);
        calendarComponent.setLocale(getLocale());
        calendarComponent.setImmediate(true);
        
        calendar = new GregorianCalendar(getLocale());
        calendar.setTime(getJCertifDate());
        
        calendarComponent.setStartDate(getJCertifDate());
        
        java.util.Calendar cal=
			java.util.Calendar.getInstance();
        cal.setTime(getJCertifDate());
        cal.add(java.util.Calendar.DATE, 1);
        
        calendarComponent.setEndDate(cal.getTime());
        
        calendarComponent.setVisibleHoursOfDay(7, 21);
 
        calendarComponent.setSizeFull();
        
        updateCaptionLabel();
        addCalendarEventListeners();
    }

    private Date getJCertifDate() {
        
            GregorianCalendar testDate = new GregorianCalendar();
            testDate.set(GregorianCalendar.YEAR, 2011);
            testDate.set(GregorianCalendar.MONTH, 7);
            testDate.set(GregorianCalendar.DATE, 27);
            testDate.set(GregorianCalendar.HOUR_OF_DAY, 0);
            testDate.set(GregorianCalendar.MINUTE, 0);
            testDate.set(GregorianCalendar.SECOND, 0);
            testDate.set(GregorianCalendar.MILLISECOND, 0);
            return testDate.getTime();
        
    }

    @SuppressWarnings("serial")
    private void addCalendarEventListeners() {
        
        calendarComponent.setHandler(new EventClickHandler() {

            public void eventClick(EventClick event) {
                showEventPopup(event.getCalendarEvent(), false);
            }
        });

        calendarComponent.setHandler(new BasicDateClickHandler() {

            @Override
            public void dateClick(DateClickEvent event) {
                // let BasicDateClickHandler handle calendar dates, and update
                // only the other parts of UI here
                super.dateClick(event);
                
            }
        });

        calendarComponent.setHandler(new RangeSelectHandler() {

            public void rangeSelect(RangeSelectEvent event) {
                handleRangeSelect(event);
            }
        });
    }

    private void handleRangeSelect(RangeSelectEvent event) {
        Date start = event.getStart();
        Date end = event.getEnd();
        showEventPopup(createNewEvent(start, end), true);
    }

    private void showEventPopup(CalendarEvent event, boolean newEvent) {
        if (event == null) {
            return;
        }

        updateCalendarEventPopup(newEvent);
        updateCalendarEventForm(event);

        if (!getMainWindow().getChildWindows().contains(scheduleEventPopup)) {
            getMainWindow().addWindow(scheduleEventPopup);
        }
    }

    /* Initializes a modal window to edit schedule event. */
    private void createCalendarEventPopup() {
        VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);

        scheduleEventPopup = new Window(null, layout);
        scheduleEventPopup.setWidth("400px");
        scheduleEventPopup.setModal(true);
        scheduleEventPopup.center();

        layout.addComponent(scheduleEventForm);

        applyEventButton = new Button("Appliquer", new ClickListener() {

            private static final long serialVersionUID = 1L;

            public void buttonClick(ClickEvent event) {
                commitCalendarEvent();
            }
        });
        Button cancel = new Button("Annuler", new ClickListener() {

            private static final long serialVersionUID = 1L;

            public void buttonClick(ClickEvent event) {
                discardCalendarEvent();
            }
        });
        deleteEventButton = new Button("Supprimer", new ClickListener() {

            private static final long serialVersionUID = 1L;

            public void buttonClick(ClickEvent event) {
                deleteCalendarEvent();
            }
        });
        scheduleEventPopup.addListener(new CloseListener() {

            private static final long serialVersionUID = 1L;

            public void windowClose(CloseEvent e) {
                discardCalendarEvent();
            }
        });

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        buttons.addComponent(deleteEventButton);
        buttons.addComponent(applyEventButton);
        buttons.addComponent(cancel);
        layout.addComponent(buttons);
        layout.setComponentAlignment(buttons, Alignment.BOTTOM_RIGHT);
    }

    private void updateCalendarEventPopup(boolean newEvent) {
        if (scheduleEventPopup == null) {
            createCalendarEventPopup();
        }

        if (newEvent) {
            scheduleEventPopup.setCaption("Création d'événement");
        } else {
            scheduleEventPopup.setCaption("Edition d'événement");
        }

        deleteEventButton.setVisible(!newEvent);
        deleteEventButton.setEnabled(!calendarComponent.isReadOnly());
        applyEventButton.setEnabled(!calendarComponent.isReadOnly());
    }

    private void updateCalendarEventForm(CalendarEvent event) {
        // Lets create a CalendarEvent item and pass it to the form's data
        // source.
        BeanItem<CalendarEvent> item = new BeanItem<CalendarEvent>(event);
        scheduleEventForm.setWriteThrough(false);
        scheduleEventForm.setItemDataSource(item);
        scheduleEventForm.setFormFieldFactory(new FormFieldFactory() {

            private static final long serialVersionUID = 1L;

            public Field createField(Item item, Object propertyId,
                    Component uiContext) {
                if (propertyId.equals("caption")) {
                    TextField f = createTextField("Légende");
                    f.focus();
                    return f;

                } else if (propertyId.equals("description")) {
                    TextField f = createTextField("Description");
                    f.setRows(3);
                    return f;

                }
                else if (propertyId.equals("start")) {
                    return createDateField("Date début");

                } else if (propertyId.equals("end")) {
                    return createDateField("Date fin");
                } 
                
                return null;
            }


            private TextField createTextField(String caption) {
                TextField f = new TextField(caption);
                f.setWidth("200");
                f.setNullRepresentation("");
                return f;
            }

            private DateField createDateField(String caption) {
                DateField f = new DateField(caption);
                f.setResolution(DateField.RESOLUTION_MIN);
                return f;
            }

           
        });

        scheduleEventForm.setVisibleItemProperties(new Object[] { "start", "end",
                         "caption", "description",
                        });
    }


    private CalendarEvent createNewEvent(Date startDate, Date endDate) {

        BasicEvent event = new BasicEvent();
        event.setCaption("");
        event.setStart(startDate);
        event.setEnd(endDate);
        return event;
    }

    /* Removes the event from the data source and fires change event. */
    private void deleteCalendarEvent() {
        BasicEvent event = getFormCalendarEvent();
        if (dataSource.containsEvent(event)) {
            dataSource.removeEvent(event);
        }
        getMainWindow().removeWindow(scheduleEventPopup);
    }

    /* Adds/updates the event in the data source and fires change event. */
    private void commitCalendarEvent() {
        scheduleEventForm.commit();
        BasicEvent event = getFormCalendarEvent();
        if (!dataSource.containsEvent(event)) {
            dataSource.addEvent(event);
        }
        getMainWindow().removeWindow(scheduleEventPopup);
    }

    private void discardCalendarEvent() {
        scheduleEventForm.discard();
        getMainWindow().removeWindow(scheduleEventPopup);
    }

    @SuppressWarnings("unchecked")
    private BasicEvent getFormCalendarEvent() {
        BeanItem<CalendarEvent> item = (BeanItem<CalendarEvent>) scheduleEventForm
                .getItemDataSource();
        CalendarEvent event = item.getBean();
        return (BasicEvent) event;
    }

    private void updateCaptionLabel() {
        DateFormatSymbols s = new DateFormatSymbols(getLocale());
        String month = s.getShortMonths()[calendar.get(GregorianCalendar.MONTH)];
        captionLabel.setValue(month + " "
                + calendar.get(GregorianCalendar.YEAR));
    }

    private JCertifCalendarEvent getNewEvent(String caption, Date start, Date end) {
        JCertifCalendarEvent event = new JCertifCalendarEvent();
        event.setCaption(caption);
        event.setStart(start);
        event.setEnd(end);
        return event;
    }   
}



