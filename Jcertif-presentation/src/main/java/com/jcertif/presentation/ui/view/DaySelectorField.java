package com.jcertif.presentation.ui.view;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.jcertif.presentation.JCertifWebApplication;

import com.vaadin.data.Property;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.UriFragmentUtility;
import com.vaadin.ui.UriFragmentUtility.FragmentChangedEvent;
import com.vaadin.ui.UriFragmentUtility.FragmentChangedListener;

/**
 * CustomField for selecting days from a certain date interval given in the
 * constructor. Supports also selecting the day via an URI fragment.
 */
public class DaySelectorField extends CustomField implements Button.ClickListener, Property.ValueChangeListener,
        FragmentChangedListener {

    private static final long serialVersionUID = -4777985742354898074L;

    private final ComponentContainer layout;
    private UriFragmentUtility uriFragment;
    private final Map<String, Button> uriFragmentToButtonMap = new HashMap<String, Button>();

    public DaySelectorField(final Date firstDay, final Date lastDay, final UriFragmentUtility uriFragment) {
        layout = new CssLayout();
        setWidth("260px");
        setCompositionRoot(layout);
        setStyleName("day-selector-field");
        addListener(this);

        final Calendar javaCalendar = Calendar.getInstance();
        javaCalendar.setTime(firstDay);

        Button dayButton = null;
        while (javaCalendar.getTime().compareTo(lastDay) <= 0) {
            final String dayName = javaCalendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.US);

            final boolean first = (dayButton == null);
            dayButton = new Button(dayName, (Button.ClickListener) this);
            dayButton.setStyleName("day-button");
            if (first) {
                dayButton.addStyleName("first");
            }
            dayButton.setData(javaCalendar.getTime());
            layout.addComponent(dayButton);
            uriFragmentToButtonMap.put(dayName.toLowerCase(), dayButton);

            // next day
            javaCalendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        dayButton.addStyleName("last");

        if (uriFragment != null) {
            uriFragment.addListener(this);
            this.uriFragment = uriFragment;
        }
    }

    @Override
    public void valueChange(final com.vaadin.data.Property.ValueChangeEvent event) {
        // set the style name for selected
        for (final Map.Entry<String, Button> entry : uriFragmentToButtonMap.entrySet()) {
            final String fragment = entry.getKey();
            final Button button = entry.getValue();

            if (dayEquals((Date) button.getData(), (Date) getValue())) {
                button.addStyleName("selected");
                if (uriFragment != null) {
                    uriFragment.setFragment(fragment, false);
                }
                JCertifWebApplication.trackPageview("view/" + uriFragment.getFragment(), null);
            } else {
                button.removeStyleName("selected");
            }
        }
    }

    @Override
    public void setValue(final Object newValue) throws ReadOnlyException, ConversionException {
        if (newValue instanceof Date && !dayEquals((Date) getValue(), (Date) newValue)) {
            super.setValue(newValue);
        }
    }

    /**
     * Compares the two given dates ignoring the time of day.
     * 
     * @param first
     * @param second
     * @return true if the dates represent the same day.
     */
    private boolean dayEquals(final Date first, final Date second) {
        if (first == null || second == null) {
            return false;
        }

        final Calendar firstCal = Calendar.getInstance();
        firstCal.setTime(first);
        final Calendar secondCal = Calendar.getInstance();
        secondCal.setTime(second);

        return firstCal.get(Calendar.DAY_OF_YEAR) == secondCal.get(Calendar.DAY_OF_YEAR)
                && firstCal.get(Calendar.YEAR) == secondCal.get(Calendar.YEAR);

    }

    @Override
    public Class<?> getType() {
        return Date.class;
    }

    @Override
    public void buttonClick(final ClickEvent event) {
        final Date clickedValue = (Date) event.getButton().getData();
        setValue(clickedValue);
    }

    @Override
    public void fragmentChanged(final FragmentChangedEvent source) {
        // URI fragment changed -> see if there is a corresponding Button and
        // select that Button's value.
        final String fragment = source.getUriFragmentUtility().getFragment();
        if (uriFragmentToButtonMap.containsKey(fragment)) {
            setValue(uriFragmentToButtonMap.get(fragment).getData());
        }
    }
}
