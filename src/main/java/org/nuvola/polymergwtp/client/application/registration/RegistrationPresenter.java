package org.nuvola.polymergwtp.client.application.registration;

import org.nuvola.polymergwtp.client.NameTokens;
import org.nuvola.polymergwtp.client.application.ApplicationPresenter;
import org.nuvola.polymergwtp.client.application.registration.RegistrationPresenter.MyProxy;
import org.nuvola.polymergwtp.client.application.registration.RegistrationPresenter.MyView;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

public class RegistrationPresenter extends Presenter<MyView, MyProxy> implements RegistrationUiHandlers {
    interface MyView extends View, HasUiHandlers<RegistrationUiHandlers> {
    }

    @NameToken(NameTokens.registration)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<RegistrationPresenter> {
    }

    @Inject
    RegistrationPresenter(EventBus eventBus,
                          MyView view,
                          MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        getView().setUiHandlers(this);
    }
}
