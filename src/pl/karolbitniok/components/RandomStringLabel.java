package pl.karolbitniok.components;

import javax.swing.*;
import java.awt.*;

/**
 * Niestandardowy komponent JLabel z predefiniowanymi stylami
 * do wyświetlania losowego słowa.
 * Klasa dziedziczna po JLabel
 * @author Karol Bitniok s179949
 */
public class RandomStringLabel extends JLabel {
    /**
     * Konstruktor klasy komponentu.
     * Definiuje niestandardowe style
     */
    public RandomStringLabel() {
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setBorder(
                BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(0,4,0,0))
            );
        this.setForeground(Color.black);
        this.setOpaque(true);
        this.setFont(new Font("Arial",Font.PLAIN,30));
    }
}
