package com.jcertif.presentation.panel.form;

import com.jcertif.presentation.action.StatutCeduleAction;
import com.jcertif.presentation.container.PropositionPresentationContainer;
import com.jcertif.presentation.container.StatutCeduleContainer;
import com.jcertif.presentation.data.bo.cedule.StatutCedule;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.TextField;
import java.util.Arrays;
import java.util.List;

public class StatutCeduleForm extends AbstractForm<StatutCedule, StatutCeduleAction> {

    private GridLayout ourLayout;

    public StatutCeduleForm(StatutCeduleAction action) {
        super(action);
        setCaption("Statut Cedule");
        // Create our layout (1x3 GridLayout)
        ourLayout = new GridLayout(1, 3);
        // Use top-left margin and spacing
        ourLayout.setMargin(false, true, true, true);
        ourLayout.setSpacing(true);
        ourLayout.setSizeFull();
        setSizeFull();
        setLayout(ourLayout);



        setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId,
                    Component uiContext) {


                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("id")) {
                    TextField f = (TextField) field;
                    f.setCaption("ID");
                    f.setWidth("100%");
                    return f;
                } else if (propertyId.equals("code")) {
                    TextField f = (TextField) field;
                    f.setCaption("Code");
                    f.setNullRepresentation("");
                    f.setWidth("100%");
                    f.setRequired(true);
                    return f;
                } else if (propertyId.equals("description")) {
                    TextField f = (TextField) field;
                    f.setCaption("Description");
                    f.setNullRepresentation("");
                    f.setRows(3);
                    f.setWidth("100%");
                    f.setRequired(true);
                    return f;
                }
                return field;
            }
        });

    }

    @Override
    protected void attachField(Object propertyId, Field field) {
        if (propertyId.equals("id")) {
            ourLayout.addComponent(field, 0, 0);
        } else if (propertyId.equals("code")) {
            ourLayout.addComponent(field, 0, 1);
        } else if (propertyId.equals("description")) {
            ourLayout.addComponent(field, 0, 2);
        }
    }

    @Override
    public List<Object> getColumnOrder() {
        return Arrays.asList(StatutCeduleContainer.NATURAL_COL_ORDER);
    }
}
