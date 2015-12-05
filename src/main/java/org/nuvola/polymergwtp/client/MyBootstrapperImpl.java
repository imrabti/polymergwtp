package org.nuvola.polymergwtp.client;

import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.vaadin.polymer.Polymer;
import com.vaadin.polymer.elemental.Function;

import javax.inject.Inject;
import java.util.Arrays;

public class MyBootstrapperImpl implements Bootstrapper {
    private final PlaceManager placeManager;

    @Inject
    MyBootstrapperImpl(PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    @Override
    public void onBootstrap() {
        setUpPolymer();
    }

    private void setUpPolymer() {
        Polymer.importHref(Arrays.asList(
                "paper-styles",
                "iron-icons/iron-icons.html",
                "iron-icons/communication-icons.html",
                "iron-icons/device-icons.html",
                "iron-icons/editor-icons.html",
                "iron-icons/hardware-icons.html",
                "iron-icons/maps-icons.html",
                "iron-icons/notification-icons.html",
                "iron-icons/social-icons.html",
                "iron-flex-layout/iron-flex-layout.html"
        ));

        Polymer.whenReady((Function) o -> {
            placeManager.revealDefaultPlace();
            return null;
        });
    }
}
