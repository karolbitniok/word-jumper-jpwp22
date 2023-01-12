package pl.karolbitniok.components;

import javax.swing.*;
import java.awt.*;

/**
 * Niestandardowy komponent JTextField z predefiniowanymi stylami
 * do wprowadzania wymaganego słowa.
 * Klasa dziedziczna po JTextField
 * @author Karol Bitniok s179949
 */
public class MainInputField extends JTextField {
    /**
     * Konstruktor klasy komponentu.
     * Definiuje niestandardowe style
     */
    public MainInputField() {
        this.setPreferredSize(new Dimension(200,50));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial",Font.PLAIN,20));
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
