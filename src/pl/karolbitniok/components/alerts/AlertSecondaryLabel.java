package pl.karolbitniok.components.alerts;

import javax.swing.*;
import java.awt.*;

/**
 * Niestandardowy komponent JLabel z predefiniowanymi stylami
 * do wyświetlania podtytułu alertu.
 * Klasa dziedziczna po JLabel
 * @author Karol Bitniok s179949
 */
public class AlertSecondaryLabel extends JLabel {
    /**
     * Konstruktor klasy komponentu.
     * Definiuje niestandardowe style
     * @param text treść do wyświetlenia
     */
    public AlertSecondaryLabel(String text) {
        this.setText(text);
        this.setForeground(Color.DARK_GRAY);
        this.setPreferredSize(new Dimension(500, 80));
        this.setFont(new Font("Arial",Font.PLAIN,20));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
