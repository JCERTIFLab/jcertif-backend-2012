package com.jcertif.presentation.principal;

import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.action.ProfilUtilisateurAction;
import com.jcertif.presentation.action.PropositionPresentationAction;
import com.jcertif.presentation.data.bo.presentation.PropositionPresentation;
import com.jcertif.presentation.panel.ParticipantForm;
import com.jcertif.presentation.panel.ProfilUtilisateurtForm;
import com.jcertif.presentation.panel.PropositionPresentationForm;
import com.jcertif.presentation.util.H1;
import com.jcertif.presentation.util.H2;
import com.jcertif.presentation.util.JCertifCalendarTest;
import com.jcertif.presentation.util.Ruler;
import com.jcertif.presentation.util.ScheduleGATracker;
import com.jcertif.presentation.util.SmallText;
import com.vaadin.Application;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
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
    private ProfilUtilisateurtForm profilUtilisateurtForm;
    private ProfilUtilisateurAction profilUtilisateurAction;
    private PropositionPresentationForm propositionPresentationForm;
    private PropositionPresentationAction propositionPresentationAction;

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
            profilUtilisateurAction = new ProfilUtilisateurAction();
            setMainWindow(mainWindow);
            buildMainView();
        } catch (InstantiationException ex) {
            getMainWindow().showNotification(ex.getLocalizedMessage(), Window.Notification.TYPE_ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            getMainWindow().showNotification(ex.getLocalizedMessage(), Window.Notification.TYPE_ERROR_MESSAGE);
        }
    }

//    Layout buildParticipants() {
//        AbsoluteLayout root = new AbsoluteLayout();
//        root.setSizeFull();
//        root.setCaption("Participants");
//
//        HorizontalLayout buttons = new HorizontalLayout();
//        buttons.setSpacing(true);
//
//        Button b = new Button("+ Profil Utilisateur", new Button.ClickListener() {
//
//            public void buttonClick(ClickEvent event) {
//            }
//        });
//        b.addStyleName(Runo.BUTTON_DEFAULT);
//        buttons.addComponent(b);
//        b = new Button("Proposition Presentation", new Button.ClickListener() {
//
//            public void buttonClick(ClickEvent event) {
//            }
//        });
//        buttons.addComponent(b);
//        b = new Button("+ Cedule", new Button.ClickListener() {
//
//            public void buttonClick(ClickEvent event) {
//            }
//        });
//        buttons.addComponent(b);
//        root.addComponent(buttons, "top: 11px; right: 18px; z-index:1;");
//
//        VerticalLayout content = new VerticalLayout();
//        content.setSizeFull();
//        root.addComponent(content);
//
//        Panel top = new Panel("Liste des participants", new VerticalLayout());
//        top.setSizeFull();
//        top.addStyleName(Runo.PANEL_LIGHT);
//        top.getContent().setSizeFull();
//        content.addComponent(top);
//        content.setExpandRatio(top, 1);
//
//        Table table = new Table();
//        table.setSizeFull();
//        table.setSelectable(true);
//        table.setColumnReorderingAllowed(true);
//        table.addStyleName(Runo.TABLE_BORDERLESS);
//        top.addComponent(table);
//        table.addContainerProperty("info", Embedded.class, null);
//        table.addContainerProperty("check", CheckBox.class, null);
//        table.addContainerProperty("locked", Embedded.class, null);
//        table.addContainerProperty("hours", String.class, "00:00:00");
//        table.addContainerProperty("cost", String.class, "$0.00");
//        table.addContainerProperty("start", String.class, "00/00/0000");
//        table.addContainerProperty("end", String.class, "00/00/0000");
//        table.addContainerProperty("note", Embedded.class, new Embedded(null,
//                new ThemeResource("icons/16/note.png")));
//        table.addContainerProperty("desc", String.class, null);
//        table.setColumnHeaders(new String[]{"", "", "", "Hours", "Cost",
//                    "Start Date", "End Date", "Note", "Description"});
//        table.setColumnAlignment("info", Table.ALIGN_CENTER);
//        table.setColumnAlignment("check", Table.ALIGN_CENTER);
//        table.setColumnAlignment("note", Table.ALIGN_CENTER);
//
////        for (int j = 1; j < 6; j++) {
////            Item i = table.addItem(j);
////            i.getItemProperty("info").setValue(
////                    create16pxIcon("icons/16/attention.png"));
////            i.getItemProperty("check").setValue(new CheckBox(null, true));
////            i.getItemProperty("note").setValue(
////                    create16pxIcon("icons/16/note.png"));
////        }
//        table.select(1);
//        Item i = table.getItem(1);
//        i.getItemProperty("hours").setValue("07:02:18");
//        i.getItemProperty("cost").setValue("$703.83");
//        i.getItemProperty("start").setValue("1/17/10");
//        i.getItemProperty("end").setValue("1/17/10");
//        i.getItemProperty("desc").setValue("More revisions");
//
//        i = table.getItem(2);
//        i.getItemProperty("hours").setValue("04:00:00");
//        i.getItemProperty("cost").setValue("$360.00");
//        i.getItemProperty("start").setValue("1/14/10");
//        i.getItemProperty("end").setValue("1/14/10");
//        i.getItemProperty("desc").setValue("Algorithm selection");
//        i.getItemProperty("note").setValue(null);
//
//        i = table.getItem(3);
//        i.getItemProperty("hours").setValue("02:34:45");
//        i.getItemProperty("cost").setValue("$160.00");
//        i.getItemProperty("start").setValue("1/13/10");
//        i.getItemProperty("end").setValue("1/13/10");
//        i.getItemProperty("desc").setValue("New features implementation");
//        i.getItemProperty("note").setValue(null);
//
//        i = table.getItem(4);
//        i.getItemProperty("hours").setValue("0:14:00");
//        i.getItemProperty("cost").setValue("$60.00");
//        i.getItemProperty("start").setValue("1/6/10");
//        i.getItemProperty("end").setValue("1/6/10");
//
//        i = table.getItem(5);
//        i.getItemProperty("hours").setValue("03:07:23");
//        i.getItemProperty("cost").setValue("$560.00");
//        i.getItemProperty("start").setValue("1/5/10");
//        i.getItemProperty("end").setValue("1/5/10");
//        i.getItemProperty("desc").setValue("More revisions");
//        i.getItemProperty("note").setValue(null);
//
//        content.addComponent(new Label("<hr />", Label.CONTENT_XHTML));
//
//        VerticalLayout bottom = new VerticalLayout();
//        bottom.setMargin(true);
//        bottom.setSpacing(true);
//        bottom.addStyleName(Runo.LAYOUT_DARKER);
//        content.addComponent(bottom);
//        tabs = new TabSheet();
//        tabs.setSizeFull();
//        content.addComponent(tabs);
//        HorizontalLayout line = new HorizontalLayout() {
//
//            @Override
//            public void addComponent(Component c) {
//                super.addComponent(c);
//                setComponentAlignment(c, Alignment.MIDDLE_LEFT);
//                c.setSizeUndefined();
//            }
//        };
//        line.setWidth("100%");
//        line.setSpacing(true);
//        Label first = new Label("Item Type:");
//        line.addComponent(first);
//        first.setWidth("80px");
//        NativeSelect select = new NativeSelect();
//        select.addItem("Timed");
//        select.addItem("Not billable");
//        select.setNullSelectionAllowed(false);
//        select.select("Timed");
//        line.addComponent(select);
//        line.addComponent(new Label("Customer Hourly Rate:"));
//        TextField tf = new TextField();
//        tf.setInputPrompt("$45.00");
//        line.addComponent(tf);
//        tf.setWidth("100%");
//        line.setExpandRatio(tf, 1);
//        line.addComponent(new Button("Remove"));
//        CheckBox cb = new CheckBox("Taxable");
//        cb.setValue(true);
//        line.addComponent(cb);
//        bottom.addComponent(line);
//
//        line = new HorizontalLayout() {
//
//            @Override
//            public void addComponent(Component c) {
//                super.addComponent(c);
//                setComponentAlignment(c, Alignment.MIDDLE_LEFT);
//                c.setSizeUndefined();
//            }
//        };
//        line.setWidth("100%");
//        line.setSpacing(true);
//        first = new Label("Hours:");
//        line.addComponent(first);
//        first.setWidth("80px");
//        first = new Label("11:56:10 from 1 timing session.");
//        line.addComponent(first);
//        line.setExpandRatio(first, 1);
//        line.addComponent(new Button("Timing Sessions"));
//        line.addComponent(new Button("Quick Add"));
//        line.addComponent(new Button("Quick Modify"));
//        cb = new CheckBox("Included");
//        cb.setValue(true);
//        line.addComponent(cb);
//        bottom.addComponent(line);
//
//        line = new HorizontalLayout() {
//
//            @Override
//            public void addComponent(Component c) {
//                super.addComponent(c);
//                setComponentAlignment(c, Alignment.MIDDLE_RIGHT);
//            }
//        };
//        line.setWidth("100%");
//        line.setSpacing(true);
//        first = new Label("Description:");
//        line.addComponent(first);
//        first.setWidth("80px");
//        ComboBox combo = new ComboBox();
//        combo.setInputPrompt("Add a description");
//        combo.setNewItemsAllowed(true);
//        line.addComponent(combo);
//        combo.setWidth("100%");
//        line.setExpandRatio(combo, 1);
//        bottom.addComponent(line);
//
//        line = new HorizontalLayout() {
//
//            @Override
//            public void addComponent(Component c) {
//                super.addComponent(c);
//                setComponentAlignment(c, Alignment.TOP_RIGHT);
//            }
//        };
//        line.setWidth("100%");
//        line.setSpacing(true);
//        first = new Label("Notes:");
//        line.addComponent(first);
//        first.setWidth("80px");
//        tf = new TextField();
//        line.addComponent(tf);
//        tf.setWidth("100%");
//        tf.setHeight("4em");
//        line.setExpandRatio(tf, 1);
//        bottom.addComponent(line);
//
//        return root;
//    }
    private Component buildParticipants() {
        VerticalLayout l = new VerticalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.setCaption("Participants");
        l.setStyleName(Reindeer.LAYOUT_WHITE);
        CssLayout margin = new CssLayout();
        margin.setMargin(true);
        margin.setWidth("100%");
        l.addComponent(margin);
        H1 title = new H1("Participants a JCertif 2011");
        margin.addComponent(title);
        margin.addComponent(new Ruler());

        HorizontalLayout texts = new HorizontalLayout();
        texts.setSpacing(true);
        texts.setWidth("100%");
        texts.setMargin(false, false, true, false);
        margin.addComponent(texts);



        return l;
    }

    public class PartenaireWindow extends Window {

        public PartenaireWindow(String caption) {
            /*
             * Make the window modal, which will disable all other components while
             * it is visible
             */
            VerticalLayout layout = new VerticalLayout();
            layout.setSizeFull();
            setContent(layout);
            setModal(true);
            /* Make the sub window 70% the size of the browser window */
            setWidth("70%");
            /*
             * Center the window both horizontally and vertically in the browser
             * window
             */
            center();
            setCaption(caption);
            setScrollable(true);
            participantForm = new ParticipantForm(participantAction);
            participantForm.addNewParticipant();
            layout.addComponent(participantForm);
        }
    }

    public class ProfilUtilisateurWindow extends Window {

        public ProfilUtilisateurWindow(String caption) {
            /*
             * Make the window modal, which will disable all other components while
             * it is visible
             */
            VerticalLayout layout = new VerticalLayout();
            layout.setSizeFull();
            setContent(layout);
            setModal(true);
            /* Make the sub window 50% the size of the browser window */
            setWidth("50%");
            /*
             * Center the window both horizontally and vertically in the browser
             * window
             */
            setScrollable(true);
            center();
            setCaption(caption);
            profilUtilisateurtForm = new ProfilUtilisateurtForm(profilUtilisateurAction);
            profilUtilisateurtForm.addNewProfilUtilisateur();
            layout.addComponent(profilUtilisateurtForm);

        }
    }

    public class PropositionPresentationWindow extends Window {

        public PropositionPresentationWindow(String caption) {
            /*
             * Make the window modal, which will disable all other components while
             * it is visible
             */
            VerticalLayout layout = new VerticalLayout();
            layout.setSizeFull();
            setContent(layout);
            setModal(true);
            setScrollable(true);
            /* Make the sub window 50% the size of the browser window */
            setWidth("50%");
            /*
             * Center the window both horizontally and vertically in the browser
             * window
             */
            center();
            setCaption(caption);
            propositionPresentationForm = new PropositionPresentationForm(propositionPresentationAction);
            
            propositionPresentationForm.setBOForEdit(new PropositionPresentation(), true);
            layout.addComponent(propositionPresentationForm);

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
        tabs.addComponent(buildParticipants());
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

        H1 title = new H1("Les auteurs JCertif 2011");
        margin.addComponent(title);

        margin.addComponent(new Ruler());

        HorizontalLayout texts = new HorizontalLayout();
        texts.setSpacing(true);
        texts.setWidth("100%");
        texts.setMargin(false, false, true, false);
        margin.addComponent(texts);


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

        H1 title = new H1("Partenaires de JCertif 2011");
        margin.addComponent(title);

        margin.addComponent(new Ruler());

        HorizontalLayout texts = new HorizontalLayout();
        texts.setSpacing(true);
        texts.setWidth("100%");
        texts.setMargin(false, false, true, false);
        margin.addComponent(texts);



        return l;
    }

    MenuBar getTopMenu() {
        MenuBar menubar = new MenuBar();
        menubar.setWidth("100%");
        final MenuBar.MenuItem file = menubar.addItem("Nouveau Partenaire", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                PartenaireWindow partenaireWindow = new PartenaireWindow("Creation Participant");
                participantForm.addNewParticipant();
                partenaireWindow.getContent().setSizeFull();
                mainWindow.addWindow(partenaireWindow);

            }
        });
        final MenuBar.MenuItem profilUtilisateur = menubar.addItem("Nouveau Profil Utilisateur", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                ProfilUtilisateurWindow profilUtilisateurWindow = new ProfilUtilisateurWindow("Creation Profil Utilisateur");

                profilUtilisateurWindow.getContent().setSizeFull();
                profilUtilisateurtForm.addNewProfilUtilisateur();
                mainWindow.addWindow(profilUtilisateurWindow);

            }
        });

        final MenuBar.MenuItem propositionPresentation = menubar.addItem("Nouvelle Proposition Presentation", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                PropositionPresentationWindow propositionPresentationWindow = new PropositionPresentationWindow("Creation Proposition Presentation");
                propositionPresentationWindow.getContent().setSizeFull();

                mainWindow.addWindow(propositionPresentationWindow);

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
        H2 title = new H2("JCertif Application 2011");
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

            @Override
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
