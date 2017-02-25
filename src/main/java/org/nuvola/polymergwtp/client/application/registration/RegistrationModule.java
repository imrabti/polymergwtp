package org.nuvola.polymergwtp.client.application.registration;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class RegistrationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(RegistrationPresenter.class, RegistrationPresenter.MyView.class, RegistrationView.class, RegistrationPresenter.MyProxy.class);
    }
}
