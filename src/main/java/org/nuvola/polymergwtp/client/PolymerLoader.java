package org.nuvola.polymergwtp.client;

import com.vaadin.polymer.Polymer;

import java.util.Arrays;

public class PolymerLoader {
    public PolymerLoader() {
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
        Polymer.whenReady(arg -> null);
    }
}
