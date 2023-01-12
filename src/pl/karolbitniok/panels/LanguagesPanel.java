package pl.karolbitniok.panels;

import pl.karolbitniok.Application;
import pl.karolbitniok.components.AppButton;
import pl.karolbitniok.types.Language;
import pl.karolbitniok.utils.AppProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Obszar graficzny z wyborem języka rozgrywki.
 * Klasa dziedziczna po JPanel
 * @author Karol Bitniok s179949
 */
public class LanguagesPanel extends JPanel {
    /** Przycisk wyboru języka polskiego */
    AppButton langPolishButton;
    /** Przycisk wyboru języka angielskiego */
    AppButton langEnglishButton;
    /** Przycisk powrotu do menu */
    AppButton returnMenuButton;

    /** Rozmiar - szerokość obszaru wyświetlania */
    static final int PANEL_WIDTH = AppProperties.getAppWidth();
    /** Rozmiar - wysokość obszaru wyświetlania */
    static final int PANEL_HEIGHT = AppProperties.getAppHeight();
    /** Ścieżka do pliku z tłem aplikacji */
    static final String APP_BACKGROUND = AppProperties.getAppBackground();
    /** Ścieżka do pliku z logo aplikacji */
    static final String APP_LOGO = AppProperties.getAppLogo();

    /**
     * Konstruktor klasy obszaru graficznego z wyborem
     * języka rozgrywki.
     * Określa wielkość obszaru i ustawia przyciski
     */
    public LanguagesPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);

        langPolishButton = new AppButton("Język Polski");
        langPolishButton.setBounds(400, 400, 200, 50);
        langPolishButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Application.startGame(Language.PL);
            }
        });

        langEnglishButton = new AppButton("Język Angielski");
        langEnglishButton.setBounds(680,400,200,50);
        langEnglishButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Application.startGame(Language.ENG);
            }
        });

        returnMenuButton = new AppButton("Wróć do menu");
        returnMenuButton.setBounds(540,480,200,50);
        returnMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Application.returnMenu();
            }
        });

        this.add(langPolishButton);
        this.add(langEnglishButton);
        this.add(returnMenuButton);
    }

    /**
     * Nadpisuje metodę odpowiedzialną za odrysowanie panelu
     * i ustawia niestandardowe tło wraz z logo
     * @param graphics obiekt graficzny do ochrony
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(new ImageIcon(APP_BACKGROUND).getImage(),0,0,1280,720, null);
        graphics2D.drawImage(new ImageIcon(APP_LOGO).getImage(), 390,15, 500, 500,null);
    }
}
