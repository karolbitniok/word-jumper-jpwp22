package pl.karolbitniok.components.alerts;

import javax.swing.*;
import java.awt.*;

/**
 * Niestandardowy komponent JLabel z predefiniowanymi stylami
 * do wyświetlania tytułu alertu.
 * Klasa dziedziczna po JLabel
 * @author Karol Bitniok s179949
 */
public class AlertMainLabel extends JLabel {
    /**
     * Konstruktor klasy komponentu.
     * Definiuje niestandardowe style
     * @param text treść do wyświetlenia
     * @param color kolor tekstu
     */
    public AlertMainLabel(String text, Color color) {
        this.setText(text);
        this.setForeground(color);
        this.setPreferredSize(new Dimension(500, 80));
        this.setFont(new Font("Arial",Font.BOLD,40));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
