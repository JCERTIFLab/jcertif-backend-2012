package com.jcertif.presentation.ui.view;

import com.jcertif.presentation.JCertifWebApplication;
import com.jcertif.presentation.data.domain.MyScheduleUser;
import com.jcertif.presentation.data.domain.MyScheduleUser.UserFavouritesChangedListener;

import com.vaadin.Application;
import com.vaadin.Application.UserChangeEvent;
import com.vaadin.Application.UserChangeListener;
import com.vaadin.addon.calendar.ui.Calendar;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.BaseTheme;

public class UserLayout extends CssLayout implements ClickListener, UserChangeListener, UserFavouritesChangedListener {

    private static final long serialVersionUID = 7016536111338741020L;

    private final Button signInButton;
    private final Button signOutButton;
    private final Label currentUserLabel;
    private final Button calendarMode;
    private final Calendar calendar;

    public UserLayout(final Calendar calendar) {
        setStyleName("user-layout");
        setWidth("260px");

        this.calendar = calendar;
        currentUserLabel = new Label("");
        currentUserLabel.setWidth("");
        currentUserLabel.setStyleName("current-user");
        signInButton = new Button("Sign Into MySchedule", this);
        signInButton.setStyleName("sign-in-button");
        signOutButton = new Button("Sign Out", this);
        signOutButton.setStyleName(BaseTheme.BUTTON_LINK);
        signOutButton.addStyleName("sign-out-button");
        calendarMode = new Button("", this);
        calendarMode.setStyleName("calendar-mode");
        calendarMode.setData(Boolean.FALSE);
        calendarMode.setDescription("Highlight events I'm attending");
        calendarMode.setImmediate(true);

        addComponent(calendarMode);
        addComponent(currentUserLabel);
        addComponent(signInButton);
        addComponent(signOutButton);

        JCertifWebApplication.getCurrentInstance().addListener(this);

        // handle initialization of user related data
        handleUserChange();
    }

    @Override
    public void buttonClick(final ClickEvent event) {
        if (event.getButton() == signInButton) {
            getWindow().addWindow(new LoginWindow());
        } else if (event.getButton() == signOutButton) {
        	JCertifWebApplication.getCurrentInstance().doSignOut();
        } else if (event.getButton() == calendarMode) {
            final boolean currentMode = (Boolean) calendarMode.getData();
            setMyScheduleMode(!currentMode);
        }
    }

    private void setMyScheduleMode(final boolean active) {
        if (active) {
            calendar.addStyleName("my-schedule");
            calendarMode.addStyleName("my-schedule");
            calendarMode.setData(Boolean.TRUE);
        } else {
            calendar.removeStyleName("my-schedule");
            calendarMode.removeStyleName("my-schedule");
            calendarMode.setData(Boolean.FALSE);
        }
    }

    private void updateFavouriteCount() {
        final Object user = JCertifWebApplication.getCurrentInstance().getUser();
        int favouriteCount = 0;
        if (user != null && user instanceof MyScheduleUser) {
            favouriteCount = ((MyScheduleUser) user).getFavourites().size();
        }

        calendarMode.setCaption(Integer.toString(favouriteCount));
    }

    private void updateComponentVisibility() {
        final boolean userLoggedIn = JCertifWebApplication.getCurrentInstance().getUser() != null;
        calendarMode.setVisible(userLoggedIn);
        currentUserLabel.setVisible(userLoggedIn);
        signInButton.setVisible(!userLoggedIn);
        signOutButton.setVisible(userLoggedIn);
    }

    @Override
    public void applicationUserChanged(final UserChangeEvent event) {
        handleUserChange();
    }

    private void handleUserChange() {
        final Application app = JCertifWebApplication.getCurrentInstance();
        if (app.getUser() != null && app.getUser() instanceof MyScheduleUser) {
            final MyScheduleUser newUser = (MyScheduleUser) app.getUser();
            String label = newUser.getEmail();
            if (label.length() > 20) {
                label = label.substring(0, 17) + "..";
            }
            currentUserLabel.setValue(label);
            newUser.addListener(this);
        }
        setMyScheduleMode(false);
        updateComponentVisibility();
        updateFavouriteCount();
    }

    @Override
    public void favouritesChanged(final MyScheduleUser user) {
        updateFavouriteCount();
    }
}
