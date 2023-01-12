package pl.karolbitniok.alerts;

import pl.karolbitniok.Application;
import pl.karolbitniok.components.AppButton;
import pl.karolbitniok.components.alerts.Alert;
import pl.karolbitniok.components.alerts.AlertMainLabel;
import pl.karolbitniok.components.alerts.AlertSecondaryLabel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Alert informujący o przegranej.
 * Klasa dziedziczna po Alert
 * @author Karol Bitniok s179949
 */
public class GameLostAlert extends Alert {
    /** Przycisk ponownego uruchomienia rozgrywki */
    AppButton restartGameButton;
    /** Przycisk powrotu do menu */
    AppButton returnMenuButton;
    /** Tytuł alertu */
    AlertMainLabel alertMainLabel;
    /** Podtytuł alertu */
    AlertSecondaryLabel alertSecondaryLabel;

    /**
     * Konstruktor klasy ustawiający pozycje komponentów alertu oraz ich zachowanie.
     */
    public GameLostAlert() {
        super(Color.RED);

        alertMainLabel = new AlertMainLabel("Koniec gry!", Color.RED);
        alertMainLabel.setBounds(0,10,500,80);

        alertSecondaryLabel = new AlertSecondaryLabel("Chcesz spróbować jeszcze raz?");
        alertSecondaryLabel.setBounds(0,80,500,80);

        restartGameButton = new AppButton("Zagraj ponownie");
        restartGameButton.setBounds(20,180, 200,50);
        restartGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Application.selectLanguage();
            }
        });

        returnMenuButton = new AppButton("Wróć do menu");
        returnMenuButton.setBounds(280,180,200,50);
        returnMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Application.returnMenu();
            }
        });

        this.add(alertMainLabel);
        this.add(alertSecondaryLabel);
        this.add(restartGameButton);
        this.add(returnMenuButton);
    }
}
