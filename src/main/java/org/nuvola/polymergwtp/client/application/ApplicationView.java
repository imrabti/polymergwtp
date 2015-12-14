package org.nuvola.polymergwtp.client.application;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.vaadin.polymer.paper.widget.PaperDialog;
import com.vaadin.polymer.paper.widget.PaperDrawerPanel;
import com.vaadin.polymer.paper.widget.PaperInput;
import com.vaadin.polymer.paper.widget.PaperTextarea;

import javax.inject.Inject;

import org.nuvola.polymergwtp.client.application.ui.Item;


public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    PaperDrawerPanel main;
    @UiField
    PaperDialog addItemDialog;
    @UiField
    PaperInput titleInput;
    @UiField
    PaperTextarea descriptionInput;
    @UiField
    HTMLPanel content;

    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("addButton")
    protected void onAddButtonClick(ClickEvent e) {
        addItemDialog.open();
    }

    @UiHandler("confirmAddButton")
    protected void onConfirmAddButtonClick(ClickEvent e) {
        if (!titleInput.getValue().isEmpty()) {
            addItem(titleInput.getValue(), descriptionInput.getValue());
            // clear text fields
            titleInput.setValue("");
            descriptionInput.setValue("");
        }
    }

    @UiHandler("menuClearAll")
    protected void menuClearAll(ClickEvent e) {
        closeMenu();
        content.clear();
    }

    @UiHandler("menuClearDone")
    protected void menuClearDone(ClickEvent e) {
        closeMenu();
        for (int i = content.getWidgetCount() - 1; i > -1; i--) {
            Item item = (Item)content.getWidget(i);
            if (item.isDone()) {
                content.remove(item);
            }
        }
    }

    private void closeMenu() {
        if (main.getNarrow()) {
            main.closeDrawer();
        }
    }

    private void addItem(String title, String description) {
        Item item = new Item();
        item.setTitle(title);
        item.setDescription(description);
        content.add(item);
    }
}
