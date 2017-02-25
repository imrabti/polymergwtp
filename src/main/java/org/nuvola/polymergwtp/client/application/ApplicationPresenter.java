package org.nuvola.polymergwtp.client.application;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import org.nuvola.polymergwtp.client.NameTokens;
import org.nuvola.polymergwtp.client.application.ApplicationPresenter.MyProxy;
import org.nuvola.polymergwtp.client.application.ApplicationPresenter.MyView;

public class ApplicationPresenter extends Presenter<MyView, MyProxy> {
    interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.home)
    interface MyProxy extends ProxyPlace<ApplicationPresenter> {
    }

    public static final NestedSlot SLOT_CONTENT = new NestedSlot();

    @Inject
    ApplicationPresenter(EventBus eventBus,
                         MyView view,
                         MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }
}
