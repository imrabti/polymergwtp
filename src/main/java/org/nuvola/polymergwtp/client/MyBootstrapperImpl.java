package org.nuvola.polymergwtp.client;

import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

import javax.inject.Inject;

public class MyBootstrapperImpl implements Bootstrapper {
    private final PlaceManager placeManager;

    @Inject
    MyBootstrapperImpl(PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    @Override
    public void onBootstrap() {
        placeManager.revealDefaultPlace();
    }
}
