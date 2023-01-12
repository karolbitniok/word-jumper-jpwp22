package pl.karolbitniok;

import pl.karolbitniok.components.AppFrame;
import pl.karolbitniok.panels.*;
import pl.karolbitniok.types.AlertType;
import pl.karolbitniok.types.Language;
import pl.karolbitniok.utils.AppProperties;
import pl.karolbitniok.utils.FileAdapter;

import javax.swing.*;

/**
 * Klasa główna gry Word Jumper!.
 * Rozszerza klasę AppFrame
 * @author Karol Bitniok s179949
 */
public class Application extends AppFrame {
    /** Początkowy obszar wyświetlania aplikacji */
    static WelcomePanel welcomePanel;
    /** Obszar wyświetlania rozgrywki */
    static GamePanel gamePanel;
    /** Obszar wyświetlania menu wyboru języków */
    static LanguagesPanel languagesPanel;
    /** Obszar wyświetlania tablicy wyników */
    static LeaderboardPanel leaderboardPanel;
    /** Obszar wyświetlania alertów */
    static AlertsPanel alertsPanel;
    /** Obszar do rozmieszczenia paneli aplikacji */
    static JPanel mainPanel;

    /** Rozmiar - szerokość obszaru wyświetlania */
    static final int APP_WIDTH = AppProperties.getAppWidth();
    /** Rozmiar - wysokość obszaru wyświetlania */
    static final int APP_HEIGHT = AppProperties.getAppHeight();

    /**
     * Główny konstruktor klasy.
     * Ustawia główny panel interfejsu i zbiera wszystkie jego elementy
     */
    Application() {
        mainPanel = new JPanel();
        mainPanel.setBounds(0,0,APP_WIDTH,APP_HEIGHT);

        welcomePanel = new WelcomePanel();
        gamePanel = new GamePanel();
        languagesPanel = new LanguagesPanel();
        leaderboardPanel = new LeaderboardPanel();
        alertsPanel = new AlertsPanel();

        mainPanel.add(welcomePanel);
        mainPanel.add(gamePanel);
        mainPanel.add(languagesPanel);
        mainPanel.add(leaderboardPanel);
        mainPanel.add(alertsPanel);

        this.add(mainPanel);

        gamePanel.setVisible(false);
        languagesPanel.setVisible(false);
        leaderboardPanel.setVisible(false);
        welcomePanel.setVisible(true);
    }

    /**
     * Zamknij wszystkie widoczne panele.
     */
    private static void closePanels() {
        if(gamePanel.isVisible()) gamePanel.setVisible(false);
        if(welcomePanel.isVisible()) welcomePanel.setVisible(false);
        if(languagesPanel.isVisible()) languagesPanel.setVisible(false);
        if(leaderboardPanel.isVisible()) leaderboardPanel.setVisible(false);
    }

    /**
     * Powrót do menu głównego.
     */
    public static void returnMenu() {
        alertsPanel.hideAlerts();
        closePanels();
        welcomePanel.setVisible(true);
    }

    /**
     * Przejście do menu wyboru języka rozgrywki.
     */
    public static void selectLanguage() {
        closePanels();
        languagesPanel.setVisible(true);
    }

    /**
     * Rozpoczęcie rozgrywki
     * @param language wybrany język rozgrywki
     */
    public static void startGame(Language language) {
        alertsPanel.hideAlerts();
        closePanels();
        gamePanel.setVisible(true);
        gamePanel.setLanguage(language);
        gamePanel.startGame();
    }

    /**
     * Wyświetlenie alertu informującego o wygranej.
     */
    public static void winGame() {
        closePanels();
        alertsPanel.showAlert(AlertType.GAME_WON);
    }

    /**
     * Wyświetlenie alertu informującego o przegranej.
     */
    public static void looseGame() {
        closePanels();
        alertsPanel.showAlert(AlertType.GAME_LOST);
    }

    /**
     * Metoda zapisująca nazwę użytkownika wraz z językiem
     * gry oraz czasem rozgrywki.
     * @param username nazwa użytkownika
     */
    public static void saveGame(String username) {
        String path = AppProperties.getGameDataResourceFile();
        int time = gamePanel.getGameTime();
        String language = getLanguageCodename(gamePanel.getLanguage());

        new FileAdapter(path).writeLine(username+","+language+","+time);

        returnMenu();
    }

    /**
     * Przejście do tablicy wyników.
     */
    public static void getLeaderboard() {
        closePanels();
        leaderboardPanel.setModelData();
        leaderboardPanel.setVisible(true);
    }

    /**
     * Metoda zwracająca kod języka rozgrywki na podstawie
     * wcześniejszego wyboru.
     * @param language wybrany język rozgrywki
     * @return kod języka
     */
    private static String getLanguageCodename(Language language) {
        if(language == Language.ENG) return "EN";
        if(language == Language.PL) return "PL";

        return "";
    }

    /**
     * Metoda główna klasy - uruchamia aplikację.
     * @param args args
     */
    public static void main(String[] args) {
        new Application();
    }
}
