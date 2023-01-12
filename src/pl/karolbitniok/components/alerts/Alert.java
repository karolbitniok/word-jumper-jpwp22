package pl.karolbitniok.components.alerts;

import pl.karolbitniok.utils.AppProperties;

import javax.swing.*;
import java.awt.*;

/**
 * Komponent bazowy do budowania alertów.
 * Klasa dziedziczna po JPanel
 * @author Karol Bitniok s179949
 */
public class Alert extends JPanel {
    /** Rozmiar - szerokość alertu */
    static int ALERT_WIDTH = AppProperties.getAlertWidth();
    /** Rozmiar - wysokość alertu */
    static int ALERT_HEIGHT = AppProperties.getAlertHeight();

    /**
     * Konstruktor klasy komponentu.
     * Ustawia wymiary obszaru wyświetlania oraz jego styl.
     * @param borderColor kolor obwódki alertu
     */
    public Alert(Color borderColor) {
        this.setPreferredSize(new Dimension(ALERT_WIDTH, ALERT_HEIGHT));
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(borderColor, 3));
        this.setBackground(new Color(240,246,255));
    }
}
