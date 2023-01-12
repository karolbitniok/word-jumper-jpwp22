package pl.karolbitniok.components;

import pl.karolbitniok.utils.AppProperties;

import javax.swing.*;
import java.awt.*;

/**
 * Niestandardowy komponent JFrame z predefiniowanymi stylami
 * do wyświetlania okna aplikacji.
 * Klasa dziedziczna po JFrame
 * @author Karol Bitniok s179949
 */
public class AppFrame extends JFrame {
    /** Rozmiar - szerokość ramki */
    final static int APP_WIDTH = AppProperties.getAppWidth();
    /** Rozmiar - wysokość ramki */
    final static int APP_HEIGHT = AppProperties.getAppHeight();

    /**
     * Konstruktor klasy komponentu.
     * Definiuje niestandardowe style i tytuł okna
     */
    public AppFrame() {
        this.setTitle("Word Jumper! - Karol Bitniok s179949");
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(APP_WIDTH, APP_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
