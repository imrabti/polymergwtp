package org.nuvola.polymergwtp.client.application.registration;

import javax.inject.Inject;

import org.nuvola.polymergwtp.client.application.registration.RegistrationPresenter.MyView;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;


public class RegistrationView extends ViewWithUiHandlers<RegistrationUiHandlers> implements MyView {
    interface Binder extends UiBinder<Widget, RegistrationView> {
    }

    @Inject
    RegistrationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
