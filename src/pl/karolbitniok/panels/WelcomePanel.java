package pl.karolbitniok.panels;

import pl.karolbitniok.Application;
import pl.karolbitniok.components.AppButton;
import pl.karolbitniok.utils.AppProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Początkowy obszar graficzny aplikacji.
 * Klasa dziedziczna po JPanel
 * @author Karol Bitniok s179949
 */
public class WelcomePanel extends JPanel {
    /** Przycisk rozpoczęcia rozgrywki */
    static AppButton startGameButton;
    /** Przycisk przejścia do tabeli wyników */
    static AppButton leaderboardButton;

    /** Rozmiar - szerokość obszaru wyświetlania */
    static final int PANEL_WIDTH = AppProperties.getAppWidth();
    /** Rozmiar - wysokość obszaru wyświetlania */
    static final int PANEL_HEIGHT = AppProperties.getAppHeight();
    /** Ścieżka do pliku z tłem aplikacji */
    static final String APP_BACKGROUND = AppProperties.getAppBackground();
    /** Ścieżka do pliku z logo aplikacji */
    static final String APP_LOGO = AppProperties.getAppLogo();

    /**
     * Konstruktor klasy wstępnego obszaru
     * graficznego aplikacji.
     * Określa wielkość obszaru i ustawia przyciski
     */
    public WelcomePanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);

        startGameButton = new AppButton("Rozpocznij grę");
        startGameButton.setBounds(540,400,200,50);
        startGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Application.selectLanguage();
            }
        });

        leaderboardButton = new AppButton("Tabela wyników");
        leaderboardButton.setBounds(540,465,200,50);
        leaderboardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Application.getLeaderboard();
            }
        });

        this.add(startGameButton);
        this.add(leaderboardButton);
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
