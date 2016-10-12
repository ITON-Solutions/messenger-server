package org.iton.messenger.server.utils;

import java.util.Locale;

/**
 * Created by ITON Solutions on 9/11/16.
 */
public class Locales {

    public static Locale getLocale(String language) {
        Locale locale = new Locale("en", "US");
        switch (language) {
            case "es":
            case "es_ES":
                locale = new Locale("es", "ES");
                break;
            case "fr":
            case "fr_FR":
                locale = new Locale("fr", "FR");
                break;
            default:
        }

        return locale;
    }

}
