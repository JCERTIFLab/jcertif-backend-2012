package com.jcertif.webapp.ui.principal;

import com.jcertif.webapp.action.ParticipantAction;
import com.jcertif.webapp.container.ParticipantContainer;
import com.jcertif.webapp.ui.panel.ParticipantForm;
import com.jcertif.webapp.ui.panel.ParticipantList;
import com.jcertif.webapp.utilities.H1;
import com.jcertif.webapp.utilities.H2;
import com.jcertif.webapp.utilities.Ruler;
import com.jcertif.webapp.utilities.ScheduleGATracker;
import com.jcertif.webapp.utilities.SmallText;
import com.jcertif.webapp.vaadin.proto.clendar.demo.JCertifCalendarTest;
import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Reindeer;
import org.vaadin.googleanalytics.tracking.GoogleAnalyticsTracker;

/**
 * Main Application Vaadin for JCertif.
 * 
 * @author rossi.oddet
 * 
 */
public class JCertifVaadinApplication extends Application {

    private static final long serialVersionUID = 1L;
    private Window mainWindow;
    private VerticalLayout mainLayout;
    private TabSheet tabs;
    private ParticipantAction participantAction;
    private ParticipantForm participantForm;
    private ParticipantList participantList;

    public void setMainLayout(VerticalLayout mainLayout) {
        this.mainLayout = mainLayout;
    }

    @SuppressWarnings("serial")
    @Override
    public void init() {
        try {
            setTheme("reindeer");
            mainWindow = new Window("JCertif Application 2011");
            mainLayout = (VerticalLayout) mainWindow.getContent();
            mainLayout.setMargin(false);
            participantAction = new ParticipantAction();
            participantForm = new ParticipantForm(participantAction);
            participantForm.addNewParticipant();
            participantList = new ParticipantList(participantAction);
            setMainWindow(mainWindow);
            buildMainView();
        } catch (InstantiationException ex) {
            getMainWindow().showNotification(ex.getLocalizedMessage(), Window.Notification.TYPE_ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            getMainWindow().showNotification(ex.getLocalizedMessage(), Window.Notification.TYPE_ERROR_MESSAGE);
        }
    }

    public class PartenaireWindow extends Window {

        public PartenaireWindow() {
            /*
             * Make the window modal, which will disable all other components while
             * it is visible
             */
            setModal(true);
            /* Make the sub window 50% the size of the browser window */
            setWidth("50%");
            /*
             * Center the window both horizontally and vertically in the browser
             * window
             */
            center();
            setCaption("Partenaire");
            addComponent(participantForm);
        }
    }

    void buildMainView() {
        mainLayout.setSizeFull();
        mainLayout.addComponent(getTopMenu());
        mainLayout.addComponent(getHeader());
        CssLayout margin = new CssLayout();
        margin.setMargin(false, true, true, true);
        margin.setSizeFull();
        tabs = new TabSheet();
        tabs.setSizeFull();
        margin.addComponent(tabs);
        mainLayout.addComponent(margin);
        mainLayout.setExpandRatio(margin, 1);

        tabs.addComponent(buildWelcomeScreen());
        tabs.addComponent(buildAuteurs());
        tabs.addComponent(buildProgramme());
        tabs.addComponent(buildPartenaires());
//        tabs.addComponent(buildSelects());
//        tabs.addComponent(buildDateFields());
//        tabs.addComponent(buildTabSheets());
//        tabs.addComponent(buildPanels());
//        tabs.addComponent(buildTables());
//        tabs.addComponent(buildWindows());
//        tabs.addComponent(buildSplitPanels());
    }

    Layout buildWelcomeScreen() {
        VerticalLayout l = new VerticalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.setCaption("Bienvenue");
        l.setStyleName(Reindeer.LAYOUT_WHITE);
        CssLayout margin = new CssLayout();
        margin.setMargin(true);
        margin.setWidth("100%");
        l.addComponent(margin);

        H1 title = new H1("Bienvenue sur le site de JCertif 2011");
        margin.addComponent(title);

        margin.addComponent(new Ruler());

        HorizontalLayout texts = new HorizontalLayout();
        texts.setSpacing(true);
        texts.setWidth("100%");
        texts.setMargin(false, false, true, false);
        margin.addComponent(texts);

        Label text = new Label(
                "<h4>A Complete Theme</h4>"
                + "<p>The Reindeer theme is a complete, general purpose theme suitable for almost all types of applications."
                + "<p>While a general purpose theme should not try to cater for every possible need, the Reindeer theme provides a set of useful styles that you can use to make the interface a bit more lively and interesing, emphasizing different parts of the application.</p>",
                Label.CONTENT_XHTML);
        texts.addComponent(text);
        texts.setExpandRatio(text, 1);

        // Spacer
        text = new Label("");
        text.setWidth("20px");
        texts.addComponent(text);

        text = new Label(
                "<h4>Everything You Need Is Here</h4>"
                + "<p>Everything you see inside this application, all the different styles, are provided by the Reindeer theme, out-of-the-box. That means you don't necessarily need to create any custom CSS for your application: you can build a cohesive result writing plain Java code.</p>"
                + "<p>A little creativity, good organization and careful typography carries a long way.",
                Label.CONTENT_XHTML);
        texts.addComponent(text);
        texts.setExpandRatio(text, 1);

        // Spacer
        text = new Label("");
        text.setWidth("20px");
        texts.addComponent(text);

        text = new Label(
                "<h4>The Names of The Styles</h4><p>Look for a class named <code>Reindeer</code> inside the Vaadin JAR (<code>com.vaadin.ui.themes.Reindeer</code>). All the available style names are documented and available there as constants, prefixed by component names, e.g. <code>Reindeer.BUTTON_SMALL</code>.",
                Label.CONTENT_XHTML);
        texts.addComponent(text);
        texts.setExpandRatio(text, 1);

        text = new H2("One Theme &ndash; Three Styles");
        text.setContentMode(Label.CONTENT_XHTML);
        margin.addComponent(text);

        margin.addComponent(new Ruler());

        text = new Label(
                "<p>You can easily change the feel of some parts of your application by using the three layout styles provided by Reindeer: white, blue and black. The colored area contains the margins of the layout. All contained components will switch their style if an alternative style is available for that color.</p>",
                Label.CONTENT_XHTML);
        margin.addComponent(text);

        HorizontalLayout colors = new HorizontalLayout();
        colors.setWidth("100%");
        colors.setHeight("250px");
        margin.addComponent(colors);

        CssLayout color = new CssLayout();
        color.setSizeFull();
        color.setStyleName(Reindeer.LAYOUT_WHITE);
        color.setMargin(true);
        color.addComponent(new H1("White"));
        color.addComponent(new Label(
                "<p><strong><code>Reindeer.LAYOUT_WHITE</code></strong></p><p>Changes the background to white. Has no other effect on contained components, they all behave like on the default gray background.",
                Label.CONTENT_XHTML));
        colors.addComponent(color);

        color = new CssLayout();
        color.setSizeFull();
        color.setStyleName(Reindeer.LAYOUT_BLUE);
        color.setMargin(true);
        color.addComponent(new H1("Blue"));
        color.addComponent(new Label(
                "<p><strong><code>Reindeer.LAYOUT_BLUE</code></strong></p><p>Changes the background to a shade of blue. A very few components have any difference here compared to the white style.",
                Label.CONTENT_XHTML));
        colors.addComponent(color);

        color = new CssLayout();
        color.setSizeFull();
        color.setStyleName(Reindeer.LAYOUT_BLACK);
        color.setMargin(true);
        color.addComponent(new H1("Black"));
        color.addComponent(new Label(
                "<p><strong><code>Reindeer.LAYOUT_BLACK</code></strong></p><p>Reserved for small parts of the application. Or alternatively, use for the whole application.</p><p><strong>This style is non-overridable</strong>, meaning that everything you place inside it will transform to their corresponding black styles when available, excluding Labels.</p>",
                Label.CONTENT_XHTML));
        colors.addComponent(color);

        text = new Label(
                "<p>Note, that you cannot nest the layout styles infinitely inside each other. After a couple levels, the result will be undefined, due to limitations in CSS (which are in fact caused by Internet Explorer 6).</p>",
                Label.CONTENT_XHTML);
        margin.addComponent(text);

        return l;
    }

    Layout buildAuteurs() {
        VerticalLayout l = new VerticalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.setCaption("Auteurs");
        l.setStyleName(Reindeer.LAYOUT_WHITE);

        CssLayout margin = new CssLayout();
        margin.setMargin(true);
        margin.setWidth("100%");
        l.addComponent(margin);

        H1 title = new H1("Bienvenue sur le site de JCertif 2011");
        margin.addComponent(title);

        margin.addComponent(new Ruler());

        HorizontalLayout texts = new HorizontalLayout();
        texts.setSpacing(true);
        texts.setWidth("100%");
        texts.setMargin(false, false, true, false);
        margin.addComponent(texts);

        Label text = new Label(
                "<h4>A Complete Theme</h4>"
                + "<p>The Reindeer theme is a complete, general purpose theme suitable for almost all types of applications."
                + "<p>While a general purpose theme should not try to cater for every possible need, the Reindeer theme provides a set of useful styles that you can use to make the interface a bit more lively and interesing, emphasizing different parts of the application.</p>",
                Label.CONTENT_XHTML);
        texts.addComponent(text);
        texts.setExpandRatio(text, 1);

        // Spacer
        text = new Label("");
        text.setWidth("20px");
        texts.addComponent(text);

        text = new Label(
                "<h4>Everything You Need Is Here</h4>"
                + "<p>Everything you see inside this application, all the different styles, are provided by the Reindeer theme, out-of-the-box. That means you don't necessarily need to create any custom CSS for your application: you can build a cohesive result writing plain Java code.</p>"
                + "<p>A little creativity, good organization and careful typography carries a long way.",
                Label.CONTENT_XHTML);
        texts.addComponent(text);
        texts.setExpandRatio(text, 1);

        // Spacer
        text = new Label("");
        text.setWidth("20px");
        texts.addComponent(text);

        text = new Label(
                "<h4>The Names of The Styles</h4><p>Look for a class named <code>Reindeer</code> inside the Vaadin JAR (<code>com.vaadin.ui.themes.Reindeer</code>). All the available style names are documented and available there as constants, prefixed by component names, e.g. <code>Reindeer.BUTTON_SMALL</code>.",
                Label.CONTENT_XHTML);
        texts.addComponent(text);
        texts.setExpandRatio(text, 1);

        text = new H2("One Theme &ndash; Three Styles");
        text.setContentMode(Label.CONTENT_XHTML);
        margin.addComponent(text);

        margin.addComponent(new Ruler());

        text = new Label(
                "<p>You can easily change the feel of some parts of your application by using the three layout styles provided by Reindeer: white, blue and black. The colored area contains the margins of the layout. All contained components will switch their style if an alternative style is available for that color.</p>",
                Label.CONTENT_XHTML);
        margin.addComponent(text);

        HorizontalLayout colors = new HorizontalLayout();
        colors.setWidth("100%");
        colors.setHeight("250px");
        margin.addComponent(colors);

        CssLayout color = new CssLayout();
        color.setSizeFull();
        color.setStyleName(Reindeer.LAYOUT_WHITE);
        color.setMargin(true);
        color.addComponent(new H1("White"));
        color.addComponent(new Label(
                "<p><strong><code>Reindeer.LAYOUT_WHITE</code></strong></p><p>Changes the background to white. Has no other effect on contained components, they all behave like on the default gray background.",
                Label.CONTENT_XHTML));
        colors.addComponent(color);

        color = new CssLayout();
        color.setSizeFull();
        color.setStyleName(Reindeer.LAYOUT_BLUE);
        color.setMargin(true);
        color.addComponent(new H1("Blue"));
        color.addComponent(new Label(
                "<p><strong><code>Reindeer.LAYOUT_BLUE</code></strong></p><p>Changes the background to a shade of blue. A very few components have any difference here compared to the white style.",
                Label.CONTENT_XHTML));
        colors.addComponent(color);

        color = new CssLayout();
        color.setSizeFull();
        color.setStyleName(Reindeer.LAYOUT_BLACK);
        color.setMargin(true);
        color.addComponent(new H1("Black"));
        color.addComponent(new Label(
                "<p><strong><code>Reindeer.LAYOUT_BLACK</code></strong></p><p>Reserved for small parts of the application. Or alternatively, use for the whole application.</p><p><strong>This style is non-overridable</strong>, meaning that everything you place inside it will transform to their corresponding black styles when available, excluding Labels.</p>",
                Label.CONTENT_XHTML));
        colors.addComponent(color);

        text = new Label(
                "<p>Note, that you cannot nest the layout styles infinitely inside each other. After a couple levels, the result will be undefined, due to limitations in CSS (which are in fact caused by Internet Explorer 6).</p>",
                Label.CONTENT_XHTML);
        margin.addComponent(text);

        return l;
    }

    Layout buildProgramme() {
        VerticalLayout l = new VerticalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.setCaption("Progamme");
        l.setStyleName(Reindeer.LAYOUT_WHITE);

        TabSheet tabProgramme = new TabSheet();
        tabProgramme.setSizeFull();

        l.addComponent(buildCalendar());

        return l;
    }

    Layout buildPartenaires() {
        VerticalLayout l = new VerticalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.setCaption("Partenaires");
        l.setStyleName(Reindeer.LAYOUT_WHITE);

        CssLayout margin = new CssLayout();
        margin.setSizeFull();
        margin.setStyleName(Reindeer.LAYOUT_WHITE);
        margin.setMargin(true);
        l.addComponent(margin);

        H1 title = new H1("Bienvenue sur le site de JCertif 2011");
        margin.addComponent(title);

        margin.addComponent(new Ruler());

        HorizontalLayout texts = new HorizontalLayout();
        texts.setSpacing(true);
        texts.setWidth("100%");
        texts.setMargin(false, false, true, false);
        margin.addComponent(texts);

        Label text = new Label(
                "<h4>A Complete Theme</h4>"
                + "<p>The Reindeer theme is a complete, general purpose theme suitable for almost all types of applications."
                + "<p>While a general purpose theme should not try to cater for every possible need, the Reindeer theme provides a set of useful styles that you can use to make the interface a bit more lively and interesing, emphasizing different parts of the application.</p>",
                Label.CONTENT_XHTML);
        texts.addComponent(text);
        texts.setExpandRatio(text, 1);

        // Spacer
        text = new Label("");
        text.setWidth("20px");
        texts.addComponent(text);

        text = new Label(
                "<h4>Everything You Need Is Here</h4>"
                + "<p>Everything you see inside this application, all the different styles, are provided by the Reindeer theme, out-of-the-box. That means you don't necessarily need to create any custom CSS for your application: you can build a cohesive result writing plain Java code.</p>"
                + "<p>A little creativity, good organization and careful typography carries a long way.",
                Label.CONTENT_XHTML);
        texts.addComponent(text);
        texts.setExpandRatio(text, 1);

        // Spacer
        text = new Label("");
        text.setWidth("20px");
        texts.addComponent(text);

        text = new Label(
                "<h4>The Names of The Styles</h4><p>Look for a class named <code>Reindeer</code> inside the Vaadin JAR (<code>com.vaadin.ui.themes.Reindeer</code>). All the available style names are documented and available there as constants, prefixed by component names, e.g. <code>Reindeer.BUTTON_SMALL</code>.",
                Label.CONTENT_XHTML);
        texts.addComponent(text);
        texts.setExpandRatio(text, 1);

        text = new H2("One Theme &ndash; Three Styles");
        text.setContentMode(Label.CONTENT_XHTML);
        margin.addComponent(text);

        margin.addComponent(new Ruler());

        text = new Label(
                "<p>You can easily change the feel of some parts of your application by using the three layout styles provided by Reindeer: white, blue and black. The colored area contains the margins of the layout. All contained components will switch their style if an alternative style is available for that color.</p>",
                Label.CONTENT_XHTML);
        margin.addComponent(text);

        HorizontalLayout colors = new HorizontalLayout();
        colors.setWidth("100%");
        colors.setHeight("250px");
        margin.addComponent(colors);

        CssLayout color = new CssLayout();
        color.setSizeFull();
        color.setStyleName(Reindeer.LAYOUT_WHITE);
        color.setMargin(true);
        color.addComponent(new H1("White"));
        color.addComponent(new Label(
                "<p><strong><code>Reindeer.LAYOUT_WHITE</code></strong></p><p>Changes the background to white. Has no other effect on contained components, they all behave like on the default gray background.",
                Label.CONTENT_XHTML));
        colors.addComponent(color);

        color = new CssLayout();
        color.setSizeFull();
        color.setStyleName(Reindeer.LAYOUT_BLUE);
        color.setMargin(true);
        color.addComponent(new H1("Blue"));
        color.addComponent(new Label(
                "<p><strong><code>Reindeer.LAYOUT_BLUE</code></strong></p><p>Changes the background to a shade of blue. A very few components have any difference here compared to the white style.",
                Label.CONTENT_XHTML));
        colors.addComponent(color);

        color = new CssLayout();
        color.setSizeFull();
        color.setStyleName(Reindeer.LAYOUT_BLACK);
        color.setMargin(true);
        color.addComponent(new H1("Black"));
        color.addComponent(new Label(
                "<p><strong><code>Reindeer.LAYOUT_BLACK</code></strong></p><p>Reserved for small parts of the application. Or alternatively, use for the whole application.</p><p><strong>This style is non-overridable</strong>, meaning that everything you place inside it will transform to their corresponding black styles when available, excluding Labels.</p>",
                Label.CONTENT_XHTML));
        colors.addComponent(color);

        text = new Label(
                "<p>Note, that you cannot nest the layout styles infinitely inside each other. After a couple levels, the result will be undefined, due to limitations in CSS (which are in fact caused by Internet Explorer 6).</p>",
                Label.CONTENT_XHTML);
        margin.addComponent(text);

        return l;
    }

    MenuBar getTopMenu() {
        MenuBar menubar = new MenuBar();
        menubar.setWidth("100%");
        final MenuBar.MenuItem file = menubar.addItem("Nouveau Partenaire", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                PartenaireWindow partenaireWindow = new PartenaireWindow();
                mainWindow.addWindow(partenaireWindow);
            }
        });
//        final MenuBar.MenuItem newItem = file.addItem("Nouveau", null);
//        file.addItem("Open file...", null);
//        file.addSeparator();
//
//        newItem.addItem("Particiant", null);
//        newItem.addItem("Organisateur", null);
//        newItem.addItem("Project...", null);
//
//        file.addItem("Close", null);
//        file.addItem("Close All", null);
//        file.addSeparator();
//
//        file.addItem("Save", null);
//        file.addItem("Save As...", null);
//        file.addItem("Save All", null);
//
//        final MenuBar.MenuItem edit = menubar.addItem("Edit", null);
//        edit.addItem("Undo", null);
//        edit.addItem("Redo", null).setEnabled(false);
//        edit.addSeparator();
//
//        edit.addItem("Cut", null);
//        edit.addItem("Copy", null);
//        edit.addItem("Paste", null);
//        edit.addSeparator();
//
//        final MenuBar.MenuItem find = edit.addItem("Find/Replace", null);
//
//        find.addItem("Google Search", new Command() {
//
//            public void menuSelected(MenuItem selectedItem) {
//                getMainWindow().open(
//                        new ExternalResource("http://www.google.com"));
//            }
//        });
//        find.addSeparator();
//        find.addItem("Find/Replace...", null);
//        find.addItem("Find Next", null);
//        find.addItem("Find Previous", null);
//
//        final MenuBar.MenuItem view = menubar.addItem("View", null);
//        view.addItem("Show/Hide Status Bar", null);
//        view.addItem("Customize Toolbar...", null);
//        view.addSeparator();
//
//        view.addItem("Actual Size", null);
//        view.addItem("Zoom In", null);
//        view.addItem("Zoom Out", null);

        return menubar;
    }

    Layout getHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setWidth("100%");
        header.setMargin(true);
        header.setSpacing(true);
        // header.setStyleName(Reindeer.LAYOUT_BLACK);

        CssLayout titleLayout = new CssLayout();
        H2 title = new H2("JCertif Application 2010");
        titleLayout.addComponent(title);
        SmallText description = new SmallText(
                "Le plus grand evenement de la communaute Java en l'Afrique Centrale!");
        description.setSizeUndefined();
        titleLayout.addComponent(description);

        header.addComponent(titleLayout);
        HorizontalLayout toggles = new HorizontalLayout();
        toggles.setSpacing(true);
        Label bgColor = new Label("Couleur de fond");
        bgColor.setDescription("Changer la principale couleur du layout de notre fenetre principale:<ul><li>Default - no style</li><li>White - Reindeer.LAYOUT_WHITE</li><li>Blue - Reindeer.LAYOUT_BLUE</li><li>Black - Reindeer.LAYOUT_BLACK</li></ul>");
        toggles.addComponent(bgColor);
        NativeSelect colors = new NativeSelect();
        colors.setNullSelectionAllowed(false);
        colors.setDescription("Set the style name for the main layout of this window:<ul><li>Default - no style</li><li>White - Reindeer.LAYOUT_WHITE</li><li>Blue - Reindeer.LAYOUT_BLUE</li><li>Black - Reindeer.LAYOUT_BLACK</li></ul>");
        colors.addItem("Default");
        colors.addItem("White");
        colors.addItem("Blue");
        colors.addItem("Black");
        colors.setImmediate(true);
        colors.addListener(new ValueChangeListener() {

            public void valueChange(ValueChangeEvent event) {
                mainLayout.setStyleName(event.getProperty().getValue().toString().toLowerCase());
            }
        });
        colors.setValue("Blue");
        toggles.addComponent(colors);
        // init Google Analytics tracker
        GoogleAnalyticsTracker tracker = new ScheduleGATracker();
        toggles.addComponent(tracker);
        header.addComponent(toggles);
        header.setComponentAlignment(toggles, "middle");

        titleLayout = new CssLayout();
        Label user = new Label("Bienvenue, Invite");
        user.setSizeUndefined();
        titleLayout.addComponent(user);

        HorizontalLayout buttons = new HorizontalLayout();
        buttons.setSpacing(true);
        Button help = new Button("Aide", new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                //    openHelpWindow();
            }
        });
        help.setStyleName(Reindeer.BUTTON_SMALL);
        buttons.addComponent(help);
        buttons.setComponentAlignment(help, "middle");

        Button logout = new Button("Connection", new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                //  openLogoutWindow();
            }
        });
        logout.setStyleName(Reindeer.BUTTON_SMALL);
        buttons.addComponent(logout);
        titleLayout.addComponent(buttons);

        header.addComponent(titleLayout);
        header.setComponentAlignment(titleLayout, "right");

        return header;
    }

    Layout buildCalendar() {
        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();
        content.setMargin(true);
        content.setCaption("Calendrier");
        content.setStyleName(Reindeer.LAYOUT_BLUE);
        JCertifCalendarTest calendarTest = new JCertifCalendarTest(this);

        content.addComponent(calendarTest);
        return content;
    }
}
