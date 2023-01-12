package pl.karolbitniok.alerts;

import pl.karolbitniok.Application;
import pl.karolbitniok.components.AppButton;
import pl.karolbitniok.components.alerts.Alert;
import pl.karolbitniok.components.alerts.AlertInput;
import pl.karolbitniok.components.alerts.AlertMainLabel;
import pl.karolbitniok.components.alerts.AlertSecondaryLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Alert informujący o wygranej.
 * Klasa dziedziczna po Alert
 * @author Karol Bitniok s179949
 */
public class GameWonAlert extends Alert {
    /** Przycisk zapisu rozgrywki */
    AppButton saveGameButton;
    /** Przycisk powrotu do menu */
    AppButton cancelButton;
    /** Tytuł alertu */
    AlertMainLabel alertMainLabel;
    /** Podtytuł alertu */
    AlertSecondaryLabel alertSecondaryLabel;
    /** Komponent wejścia - nazwa użytkownika */
    AlertInput alertInput;

    /** Stała przechowująca treść placeholdera */
    static final String placeholder = "nazwa użytkownika";

    /**
     * Konstruktor klasy ustawiający pozycje komponentów alertu oraz ich zachowanie.
     */
    public GameWonAlert() {
        super(Color.GREEN);

        alertMainLabel = new AlertMainLabel("Zwycięstwo!", new Color(13,158,54));
        alertMainLabel.setBounds(0,10,500,80);

        alertSecondaryLabel = new AlertSecondaryLabel("Zapisz swój czas");
        alertSecondaryLabel.setBounds(0,80,500,40);

        alertInput = new AlertInput(placeholder);
        alertInput.setBounds(100,120,300,50);

        saveGameButton = new AppButton("Zapisz postęp");
        saveGameButton.setBounds(20,180,200,50);
        saveGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(alertInput.getText().equals(placeholder)) {
                    alertInput.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
                    return;
                }
                Application.saveGame(alertInput.getText());
                alertInput.setText(placeholder);
            }
        });

        cancelButton = new AppButton("Wróć do menu");
        cancelButton.setBounds(280,180,200,50);
        cancelButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Application.returnMenu();
            }
        });

        this.add(alertMainLabel);
        this.add(alertSecondaryLabel);
        this.add(alertInput);
        this.add(saveGameButton);
        this.add(cancelButton);
    }
}
