package pl.karolbitniok.utils;

/**
 * Klasa - kontener parametrów.
 * Zwraca podstawowe parametry aplikacji i określa zasoby.
 * @author Karol Bitniok s179949
 */
public class AppProperties {
    /**
     * Zwraca szerokość aplikacji
     * @return szerokość aplikacji
     */
    public static int getAppWidth() { return 1280; }

    /**
     * Zwraca wysokość aplikacji
     * @return wysokość aplikacji
     */
    public static int getAppHeight() { return 720; }

    /**
     * Zwraca szerokość alertu
     * @return szerokość alertu
     */
    public static int getAlertWidth() { return 500; }

    /**
     * Zwraca wysokość alertu
     * @return wysokość alertu
     */
    public static int getAlertHeight() { return 250; }

    /**
     * Zwraca szerokość tabeli
     * @return szerokość tabeli
     */
    public static int getTableWidth() { return 500; }

    /**
     * Zwraca wysokość tabeli
     * @return wysokość tabeli
     */
    public static int getTableHeight() { return 300; }

    /**
     * Zwraca ścieżkę do zasobu tła aplikacji
     * @return ścieżka do zasobu tła aplikacji
     */
    public static String getAppBackground() {
        return "src/resources/images/background_texture.png";
    }

    /**
     * Zwraca ścieżkę do zasobu logo aplikacji
     * @return ścieżka do zasobu logo aplikacji
     */
    public static String getAppLogo() {
        return "src/resources/images/app_logo.png";
    }

    /**
     * Zwraca ścieżkę do zasobu ikony alarmu
     * @return ścieżka do zasobu ikony alarmu
     */
    public static String getAppAlarm() {
        return "src/resources/images/alarm.png";
    }

    /**
     * Zwraca ścieżkę do zasobu wspinającej się postaci
     * @return ścieżka do zasobu wspinającej się postaci
     */
    public static String getAppClimbingMan() {
        return "src/resources/images/person.png";
    }

    /**
     * Zwraca ścieżkę do zasobu tekstury wody
     * @return ścieżka do zasobu tekstury wodyz
     */
    public static String getAppWater() {
        return "src/resources/images/water_texture_resized.png";
    }

    /**
     * Zwraca ścieżkę do zasobu słów w języku angielskim
     * @return ścieżka do zasobu słów w języku angielskim
     */
    public static String getEnglishResourceFile() {
        return "src/resources/languages/languageEN.txt";
    }

    /**
     * Zwraca ścieżkę do zasobu słów w języku polski
     * @return ścieżka do zasobu słów w języku polskim
     */
    public static String getPolishResourceFile() {
        return "src/resources/languages/languagePL.txt";
    }

    /**
     * Zwraca ścieżkę do zasobu danych rozgrywki
     * @return ścieżka do zasobu danych rozgrywki
     */
    public static String getGameDataResourceFile() {
        return "src/resources/data/gameData.txt";
    }
}
