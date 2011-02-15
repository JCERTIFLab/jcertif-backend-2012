/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcertif.presentation.principal;

import com.github.wolfie.refresher.Refresher;
import com.jcertif.presentation.action.AuteurAction;
import com.jcertif.presentation.action.ParticipantAction;
import com.jcertif.presentation.action.ParticulariteSalleAction;
import com.jcertif.presentation.action.ProfilUtilisateurAction;
import com.jcertif.presentation.action.PropositionPresentationAction;
import com.jcertif.presentation.action.RoleParticipantAction;
import com.jcertif.presentation.action.StatutApprobationAction;
import com.jcertif.presentation.action.StatutCeduleAction;
import com.jcertif.presentation.action.TypeEvenementAction;
import com.jcertif.presentation.action.TypeParticipantAction;
import com.jcertif.presentation.panel.AuteursPanel;
import com.jcertif.presentation.panel.CreationParticipantPanel;
import com.jcertif.presentation.panel.CreationPropositionPresentationPanel;
import com.jcertif.presentation.panel.FAQPanel;
import com.jcertif.presentation.panel.ParticipantPanel;
import com.jcertif.presentation.panel.window.ParticipantWindow;
import com.jcertif.presentation.panel.window.ParticulariteSalleWindow;
import com.jcertif.presentation.panel.window.ProfilUtilisateurWindow;
import com.jcertif.presentation.panel.window.PropositionPresentationWindow;
import com.jcertif.presentation.panel.window.RoleParticipantWindow;
import com.jcertif.presentation.panel.window.StatutApprobationWindow;
import com.jcertif.presentation.panel.window.StatutCeduleWindow;
import com.jcertif.presentation.panel.window.TypeEvenementWindow;
import com.jcertif.presentation.panel.window.TypeParticipantWindow;
import com.jcertif.presentation.util.H1;
import com.jcertif.presentation.util.H2;
import com.jcertif.presentation.util.JCertifCalendarTest;
import com.jcertif.presentation.util.Ruler;
import com.jcertif.presentation.util.ScheduleGATracker;
import com.jcertif.presentation.util.SmallText;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.Runo;
import java.io.Serializable;
import org.vaadin.googleanalytics.tracking.GoogleAnalyticsTracker;
import org.vaadin.virkki.paperstack.PaperStack;

/**
 *
 * @author Douneg
 */
public class MainWindow extends Window {

    private VerticalLayout mainLayout;
    private TabSheet tabs;
    private ParticipantAction participantAction;
    private AuteurAction auteurAction;
    private ProfilUtilisateurAction profilUtilisateurAction;
    private PropositionPresentationAction propositionPresentationAction;
    private ParticulariteSalleAction particulariteSalleAction;
    private RoleParticipantAction roleParticipantAction;
    private StatutApprobationAction statutApprobationAction;
    private StatutCeduleAction statutCeduleAction;
    private TypeEvenementAction typeEvenementAction;
    private TypeParticipantAction typeParticipantAction;

    public ParticulariteSalleAction getParticulariteSalleAction() {
        if (particulariteSalleAction == null) {
            particulariteSalleAction = new ParticulariteSalleAction();
        }
        return particulariteSalleAction;
    }

    public RoleParticipantAction getRoleParticipantAction() {
        if (roleParticipantAction == null) {
            roleParticipantAction = new RoleParticipantAction();
        }
        return roleParticipantAction;
    }

    public AuteurAction getAuteurAction() {
        if (auteurAction == null) {
            auteurAction = new AuteurAction();
        }
        return auteurAction;
    }

    public StatutApprobationAction getStatutApprobationAction() {
        if (statutApprobationAction == null) {
            statutApprobationAction = new StatutApprobationAction();
        }
        return statutApprobationAction;
    }

    public StatutCeduleAction getStatutCeduleAction() {
        if (statutCeduleAction == null) {
            statutCeduleAction = new StatutCeduleAction();
        }
        return statutCeduleAction;
    }

    public TypeEvenementAction getTypeEvenementAction() {
        if (typeEvenementAction == null) {
            typeEvenementAction = new TypeEvenementAction();
        }
        return typeEvenementAction;
    }

    public TypeParticipantAction getTypeParticipantAction() {
        if (typeParticipantAction == null) {
            typeParticipantAction = new TypeParticipantAction();
        }
        return typeParticipantAction;
    }

    public ParticipantAction getParticipantAction() {
        if (participantAction == null) {
            participantAction = new ParticipantAction();
        }
        return participantAction;
    }

    public ProfilUtilisateurAction getProfilUtilisateurAction() {
        if (profilUtilisateurAction == null) {
            profilUtilisateurAction = new ProfilUtilisateurAction();
        }
        return profilUtilisateurAction;
    }

    public PropositionPresentationAction getPropositionPresentationAction() {
        if (propositionPresentationAction == null) {
            propositionPresentationAction = new PropositionPresentationAction();
        }
        return propositionPresentationAction;
    }

    public MainWindow() {
        super("JCertif Application 2011");
        mainLayout = (VerticalLayout) this.getContent();
        mainLayout.setMargin(false);
        buildMainView();
    }

    final void buildMainView() {
        mainLayout.setSizeFull();
        mainLayout.addComponent(getTopMenu());
        mainLayout.addComponent(getHeader());
        CssLayout margin = new CssLayout();
        margin.setMargin(false, true, true, true);
        margin.setSizeFull();
        tabs = new TabSheet();
        tabs.setStyleName(Runo.TABSHEET_SMALL);
        tabs.setSizeFull();
        margin.addComponent(tabs);
        mainLayout.addComponent(margin);
        mainLayout.setExpandRatio(margin, 1);
        tabs.addComponent(buildWelcomeScreen());
        tabs.addComponent(buildCalendrier());
        tabs.addComponent(JCertifTabCreator.createPrincipalTab("Inscrivez-vous", "Inscription", new CreationParticipantPanel(getParticipantAction())));
        tabs.addComponent(JCertifTabCreator.createPrincipalTab("Proposer un sujet", "Nouveau Sujet", new CreationPropositionPresentationPanel(getPropositionPresentationAction())));
        tabs.addComponent(JCertifTabCreator.createPrincipalTab("Les présentateurs", "Présentateurs JCertif 2011", new AuteursPanel(getAuteurAction())));
        tabs.addComponent(JCertifTabCreator.createPrincipalTab("FAQ", "Foire aux Questions", new FAQPanel()));


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
        l.setStyleName(Runo.LAYOUT_DARKER);
        CssLayout margin = new CssLayout();
        margin.setMargin(true);
        margin.setWidth("100%");
        l.addComponent(margin);

        H1 title = new H1("Bienvenue sur le site de JCertif 2011");
        margin.addComponent(title);

        margin.addComponent(new Ruler());
        final Panel panel = new Panel("Nous sommes ensembles");
        final HorizontalLayout layout = new HorizontalLayout();
        final Refresher refresher = new Refresher();
        PaperStack paperStack = new PaperStack();
        final CounterThread thread = new CounterThread(paperStack);

        thread.start();
        panel.addComponent(refresher);
        layout.setSpacing(true);
        tabs.addListener(new TabSheet.SelectedTabChangeListener() {

            @Override
            public void selectedTabChange(SelectedTabChangeEvent event) {
                if (event != null && event.getTabSheet() != null) {
                    if (event.getTabSheet().getCaption() != null && event.getTabSheet().getCaption().equals("Bienvenue")) {
                        refresher.setRefreshInterval(SLEEP_TIME_IN_MILLIS);
                        thread.startCounting();
                    } else {
                        refresher.setRefreshInterval(0);
                        thread.stopCounting();
                    }
                }
            }
        });

        layout.addComponent(paperStack);

        margin.addComponent(panel);

        HorizontalLayout texts = new HorizontalLayout();
        texts.setSpacing(true);
        texts.setWidth("100%");
        texts.setMargin(false, false, true, false);
        margin.addComponent(texts);
        return l;
    }

    private class CounterThread extends Thread implements Serializable {

        private static final long serialVersionUID = 6969871601928939400L;
        private final PaperStack paperStack;
        private boolean running = false;

        public CounterThread(final PaperStack paperStack) {
            this.paperStack = paperStack;
        }

        @Override
        public void run() {
            final long startTime = System.currentTimeMillis();
            final long lifetime = 1000 * 60 * 60; // live for one hour.

            try {
                while (System.currentTimeMillis() < startTime + lifetime) {

                    if (running) {
                        // synchronize with the application, to avoid concurrent
                        // edits on the label's value.
                        synchronized (JCertifVaadinApplication.getInstance()) {
                            paperStack.navigate(running);
                        }
                    }

                    sleep(SLEEP_TIME_IN_MILLIS);
                }
            } catch (final InterruptedException e) {
            }
        }

        public void startCounting() {
            running = true;
        }

        public void stopCounting() {
            running = false;
        }
    }
    private static final int SLEEP_TIME_IN_MILLIS = 1000 * 10; // a second

    Layout buildAuteurs() {
        VerticalLayout l = new VerticalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.setCaption("Auteurs");
        l.setStyleName(Runo.LAYOUT_DARKER);

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

    Layout buildCalendrier() {
        VerticalLayout l = new VerticalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.setCaption("Calendrier");
        l.setStyleName(Runo.LAYOUT_DARKER);
        l.addComponent(buildCalendar());
        return l;
    }

    Layout buildPartenaires() {
        VerticalLayout l = new VerticalLayout();
        l.setMargin(true);
        l.setSpacing(true);
        l.setCaption("Partenaires");
        l.setStyleName(Runo.LAYOUT_DARKER);

        CssLayout margin = new CssLayout();
        margin.setSizeFull();
        margin.setStyleName(Runo.PANEL_LIGHT);
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
        final MenuBar.MenuItem file = menubar.addItem("Nouveau Code...", null);

        final MenuBar.MenuItem addStatutCedule = file.addItem("Statut Cedule", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                StatutCeduleWindow statutCeduleWindow = new StatutCeduleWindow("Création Statut Cedule", getStatutCeduleAction());
                statutCeduleWindow.getContent().setSizeFull();
                getApplication().getMainWindow().addWindow(statutCeduleWindow);
            }
        });

        final MenuBar.MenuItem addTypeEvenement = file.addItem("Type Evénement ", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                TypeEvenementWindow typeEvenementWindow = new TypeEvenementWindow("Création Type Evénement ", getTypeEvenementAction());
                typeEvenementWindow.getContent().setSizeFull();
                getApplication().getMainWindow().addWindow(typeEvenementWindow);
            }
        });

        final MenuBar.MenuItem addRoleParticipant = file.addItem("Rôle Participant", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                RoleParticipantWindow roleParticipantWindow = new RoleParticipantWindow("Création Rôle Participant", getRoleParticipantAction());
                roleParticipantWindow.getContent().setSizeFull();
                getApplication().getMainWindow().addWindow(roleParticipantWindow);
            }
        });



        final MenuBar.MenuItem addTypeParticipant = file.addItem("Type Participant", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                TypeParticipantWindow typeParticipantWindow = new TypeParticipantWindow("Création Type Participant", getTypeParticipantAction());
                typeParticipantWindow.getContent().setSizeFull();
                getApplication().getMainWindow().addWindow(typeParticipantWindow);
            }
        });

        final MenuBar.MenuItem addStatutApprobation = file.addItem("Statut Approbation", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                StatutApprobationWindow statutApprobationWindow = new StatutApprobationWindow("Création Statut Approbation", getStatutApprobationAction());
                statutApprobationWindow.getContent().setSizeFull();
                getApplication().getMainWindow().addWindow(statutApprobationWindow);
            }
        });

        final MenuBar.MenuItem addParticulariteSalle = file.addItem("Particularité Salle", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                ParticulariteSalleWindow particulariteSalleWindow = new ParticulariteSalleWindow("Création Particularité Salle", getParticulariteSalleAction());
                particulariteSalleWindow.getContent().setSizeFull();
                getApplication().getMainWindow().addWindow(particulariteSalleWindow);
            }
        });

        final MenuBar.MenuItem participant = menubar.addItem("Nouveau Participant", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                ParticipantWindow participantWindow = new ParticipantWindow("Création Participant", getParticipantAction());
                participantWindow.getContent().setSizeFull();
                getApplication().getMainWindow().addWindow(participantWindow);

            }
        });

        final MenuBar.MenuItem profilUtilisateur = menubar.addItem("Nouveau Profil Utilisateur", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                ProfilUtilisateurWindow profilUtilisateurWindow = new ProfilUtilisateurWindow("Création Profil Utilisateur", getProfilUtilisateurAction());
                profilUtilisateurWindow.getContent().setSizeFull();
                getApplication().getMainWindow().addWindow(profilUtilisateurWindow);

            }
        });



        final MenuBar.MenuItem propositionPresentation = menubar.addItem("Nouvelle Proposition Presentation", new Command() {

            @Override
            public void menuSelected(MenuItem selectedItem) {
                PropositionPresentationWindow propositionPresentationWindow = new PropositionPresentationWindow("Création Proposition Presentation", getPropositionPresentationAction());
                propositionPresentationWindow.getContent().setSizeFull();
                getApplication().getMainWindow().addWindow(propositionPresentationWindow);

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
        l.setStyleName(Runo.LAYOUT_DARKER);
        l.setSizeFull();
        CssLayout margin = new CssLayout();
        margin.setMargin(false);
        margin.setWidth("100%");
        l.addComponent(margin);
        H1 title = new H1("Participants a JCertif 2011");
        margin.addComponent(title);
        margin.addComponent(new Ruler());

//        HorizontalLayout texts = new HorizontalLayout();
//        texts.setSpacing(true);
//        texts.setWidth("100%");
//        texts.setMargin(false, false, true, false);
        ParticipantPanel participantPanel = new ParticipantPanel(getParticipantAction());
        l.addComponent(participantPanel);
        l.setExpandRatio(participantPanel, 1);
        return l;
    }

    Layout getHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setWidth("100%");
        header.setMargin(true);
        header.setSpacing(false);
        Embedded em = new Embedded("", new ThemeResource("icons/logo.png"));
        header.addComponent(em);
        // header.setStyleName(Runo.LAYOUT_BLACK);
        CssLayout titleLayout = new CssLayout();

        H2 title = new H2("JCertif Application 2011");
        titleLayout.addComponent(title);
        SmallText description = new SmallText(
                "Le plus grand événement de la communauté Java en l'Afrique Centrale!");
        description.setSizeUndefined();
        titleLayout.addComponent(description);

        header.addComponent(titleLayout);
        header.setComponentAlignment(titleLayout, Alignment.BOTTOM_LEFT);
        HorizontalLayout toggles = new HorizontalLayout();
        toggles.setSpacing(true);
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
        help.setStyleName(Runo.BUTTON_SMALL);
        buttons.addComponent(help);
        buttons.setComponentAlignment(help, "middle");

        Button logout = new Button("Connection", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                //  openLogoutWindow();
            }
        });
        logout.setStyleName(Runo.BUTTON_SMALL);
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
        content.setStyleName(Runo.LAYOUT_DARKER);
        JCertifCalendarTest calendarTest = new JCertifCalendarTest(this.getApplication());
        content.addComponent(calendarTest);
        return content;
    }
}
