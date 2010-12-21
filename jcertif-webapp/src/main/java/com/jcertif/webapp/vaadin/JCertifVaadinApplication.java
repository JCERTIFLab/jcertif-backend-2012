package com.jcertif.webapp.vaadin;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

/**
 * Main Application Vaadin for JCertif.
 * 
 * @author rossi.oddet
 * 
 */
public class JCertifVaadinApplication extends Application {
	private static final long serialVersionUID = 1L;

	private Window window;

	@SuppressWarnings("serial")
	@Override
	public void init() {
		window = new Window("JCertif Application");
		setMainWindow(window);
		final TextField titleField = new TextField("Title");
		window.addComponent(titleField);
		final Button addTitle = new Button("Add title (Call a web service ArticleWS/AddTitle/XXX)");
		addTitle.addListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				// Calling web service ArticleWS/AddTitle
				JCertifWS.getInstance().addTitle(
						titleField.getValue().toString());

			}
		});
		window.addComponent(addTitle);
		final Table titleList = new Table("title List");
		titleList.addContainerProperty("index", Integer.class, null);
		titleList.addContainerProperty("title", String.class, null);
		window.addComponent(titleList);
		final Button refreshBut = new Button("Refresh title (Call a web service ArticleWS/AllTitles)");
		refreshBut.addListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				// Calling web service ArticleWS/AllTitles
				String allTitles = JCertifWS.getInstance().findAllTitles();
				titleList.removeAllItems();
				int index = 0;
				for (String title : allTitles.split(";")) {
					titleList.addItem(new Object[] { index, title }, index++);
				}

			}
		});
		window.addComponent(refreshBut);
	}

}
