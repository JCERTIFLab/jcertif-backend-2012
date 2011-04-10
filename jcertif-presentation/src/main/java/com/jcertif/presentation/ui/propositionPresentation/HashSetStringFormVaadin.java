package com.jcertif.presentation.ui.propositionPresentation;

import java.util.HashSet;

public class HashSetStringFormVaadin extends HashSet<String> {

	private static final long serialVersionUID = 1L;

	public HashSetStringFormVaadin(String e) {
		super();
		String listString = e.substring(1, e.length() - 1);
		String[] tabList = listString.split(",");
		for (String element : tabList) {
			add(element.trim());
		}

	}

}
