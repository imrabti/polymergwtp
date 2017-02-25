package org.nuvola.polymergwtp.client.application;

import javax.inject.Inject;

import org.nuvola.polymergwtp.client.NameTokens;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;


public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

    @UiField
    HTMLPanel content;

    private final PlaceManager placeManager;

    @Inject
    ApplicationView(Binder uiBinder,
                    PlaceManager placeManager) {
        this.placeManager = placeManager;
        initWidget(uiBinder.createAndBindUi(this));

        bindSlot(ApplicationPresenter.SLOT_CONTENT, content);
    }

    @UiHandler("registration")
    void onRegistrationClicked(ClickEvent event) {
        revealPlace(NameTokens.getRegistration());
    }

    private void revealPlace(String nameToken) {
        PlaceRequest placeRequest = new PlaceRequest.Builder()
                .nameToken(nameToken)
                .build();
        placeManager.revealPlace(placeRequest);
    }
}
