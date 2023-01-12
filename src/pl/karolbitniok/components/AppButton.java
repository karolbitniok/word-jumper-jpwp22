package pl.karolbitniok.components;

import javax.swing.*;
import java.awt.*;

/**
 * Niestandardowy komponent JButton z predefiniowanymi stylami.
 * Klasa dziedziczna po JButton
 * @author Karol Bitniok s179949
 */
public class AppButton extends JButton {
    /**
     * Konstruktor klasy komponentu.
     * Definiuje niestandardowe style
     * @param title tekst przycisku
     */
    public AppButton(String title) {
        this.setText(title);
        this.setFont(new Font("Arial", Font.PLAIN, 20));
        this.setPreferredSize(new Dimension(200,50));
    }
}