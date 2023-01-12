package pl.karolbitniok.panels;

import pl.karolbitniok.alerts.GameLostAlert;
import pl.karolbitniok.alerts.GameWonAlert;
import pl.karolbitniok.types.AlertType;
import pl.karolbitniok.utils.AppProperties;

import javax.swing.*;
import java.awt.*;

/**
 * Obszar graficzny do wyświetlania alertów.
 * Klasa dziedziczna po JPanel
 * @author Karol Bitniok s179949
 */
public class AlertsPanel extends JPanel {
    /** Alert o wygranej */
    GameWonAlert gameWonAlert;
    /** Alert o przegranej */
    GameLostAlert gameLostAlert;

    /** Rozmiar panelu - szerokość obszaru wyświetlania */
    static final int PANEL_WIDTH = AppProperties.getAppWidth();
    /** Rozmiar panelu - wysokość obszaru wyświetlania */
    static final int PANEL_HEIGHT = AppProperties.getAppHeight();
    /** Rozmiar alertu - szerokość alertu */
    static final int ALERT_WIDTH = AppProperties.getAlertWidth();
    /** Rozmiar alertu - wysokość alertu */
    static final int ALERT_HEIGHT = AppProperties.getAlertHeight();
    /** Ścieżka do pliku z tłem aplikacji */
    static final String APP_BACKGROUND = AppProperties.getAppBackground();
    /** Ścieżka do pliku z logo aplikacji */
    static final String APP_LOGO = AppProperties.getAppLogo();

    /**
     * Konstruktor klasy obszaru graficznego do wyświetlania
     * alertów.
     * Ustawia wielkość obszaru i sutala pozycje alertów.
     */
    public AlertsPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);

        gameLostAlert = new GameLostAlert();
        gameWonAlert = new GameWonAlert();

        gameLostAlert.setBounds(390, 200,ALERT_WIDTH, ALERT_HEIGHT);
        gameWonAlert.setBounds(390, 200,ALERT_WIDTH, ALERT_HEIGHT);

        this.add(gameWonAlert);
        this.add(gameLostAlert);

        gameWonAlert.setVisible(false);
        gameLostAlert.setVisible(false);
    }

    /**
     * Metoda wyświetlająca alert na podstawie jego typu.
     * @param alertType typ alertu
     */
    public void showAlert(AlertType alertType) {
        this.setVisible(true);
        if(alertType == AlertType.GAME_WON) gameWonAlert.setVisible(true);
        if(alertType == AlertType.GAME_LOST) gameLostAlert.setVisible(true);
    }

    /**
     * Metoda ukrywająca wszystkie alerty.
     */
    public void hideAlerts() {
        if(this.isVisible()) this.setVisible(false);
        if(gameWonAlert.isVisible()) gameWonAlert.setVisible(false);
        if(gameLostAlert.isVisible()) gameLostAlert.setVisible(false);
    }

    /**
     * Nadpisuje metodę odpowiedzialną za odrysowanie panelu
     * i ustawia niestandardowe tło wraz z logo
     * @param graphics obiekt graficzny do ochrony
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(new ImageIcon(APP_BACKGROUND).getImage(), 0, 0, 1280, 720, null);
        graphics2D.drawImage(new ImageIcon(APP_LOGO).getImage(), 560,0,180,180, null);
    }
}
