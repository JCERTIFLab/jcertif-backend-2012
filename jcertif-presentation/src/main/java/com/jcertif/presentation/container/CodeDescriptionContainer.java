package com.jcertif.presentation.container;

import com.jcertif.presentation.data.bo.CodeDescription;

public class CodeDescriptionContainer extends AbstractJCertifBeanItemContainer<CodeDescription> {

    public static Object[] NATURAL_COL_ORDER = new Object[]{"id", "code",
        "description"};
    public static String[] COL_HEADERS_FRENCH = new String[]{"ID",
        "Code", "Description"};

    public CodeDescriptionContainer() {
        super(CodeDescription.class);
    }
}
