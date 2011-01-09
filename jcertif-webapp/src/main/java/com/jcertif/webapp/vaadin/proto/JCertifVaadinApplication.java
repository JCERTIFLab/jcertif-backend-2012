package com.jcertif.webapp.vaadin.proto;

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
		final Button addTitle = new Button("Add title (Call a web service api/article/addarticle/{title})");
		addTitle.addListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				// Calling web service ArticleWS/AddTitle
				JCertifWS.getInstance().addTitle(
						titleField.getValue().toString());
				titleField.setValue("");

			}
		});
		window.addComponent(addTitle);
		final Table titleList = new Table("Article List");
		titleList.addContainerProperty("id", Long.class, null);
		titleList.addContainerProperty("title", String.class, null);
		window.addComponent(titleList);
		final Button refreshBut = new Button("Refresh title (Call a web service ArticleWS/AllTitles)");
		refreshBut.addListener(new ClickListener() {

			public void buttonClick(ClickEvent event) {
				// Calling web service api/article/allarticles
				Articles articles = JCertifWS.getInstance().findAllTitles();
				titleList.removeAllItems();
				int index = 0;
				for (Article article : articles.getList()) {
					titleList.addItem(new Object[] { article.getId(), article.getTitle() }, index++);
				}

			}
		});
		window.addComponent(refreshBut);
	}

}
