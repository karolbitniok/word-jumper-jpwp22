package pl.karolbitniok.components.alerts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Niestandardowy komponent JTextField z predefiniowanymi stylami
 * do wpisywania nazwy użytkownika.
 * Klasa dziedziczna po JTextField
 * @author Karol Bitniok s179949
 */
public class AlertInput extends JTextField {
    /**
     * Konstruktor klasy komponentu.
     * Definiuje niestandardowe style i zarządza ich
     * ustawianiem na podstawie FocusEvent oraz placeholder
     * @param placeholder placeholder
     */
    public AlertInput(String placeholder) {
        this.setForeground(Color.GRAY);
        this.setPreferredSize(new Dimension(300, 50));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setFont(new Font("Arial",Font.PLAIN,20));
        this.setPlaceholderText(placeholder);

        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(getPlaceholderText().equals(placeholder)) {
                    setPlaceholderText("");
                    setInputForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(getPlaceholderText().isEmpty()) {
                    setInputForeground(Color.GRAY);
                    setPlaceholderText(placeholder);
                }
            }
        });
    }

    /**
     * Metoda ustawiająca kolor tekstu
     * @param color kolor
     */
    private void setInputForeground(Color color) {
        this.setForeground(color);
    }

    /**
     * Metoda ustawiająca placeholder
     * @param text treść placeholdera
     */
    private void setPlaceholderText(String text) {
        this.setText(text);
    }

    /**
     * Metoda zwracająca treść pola tekstowego
     * @return treść pola tekstowego
     */
    private String getPlaceholderText() {
        return this.getText();
    }
}
