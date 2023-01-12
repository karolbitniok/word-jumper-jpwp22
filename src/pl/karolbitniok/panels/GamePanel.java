package pl.karolbitniok.panels;

import pl.karolbitniok.Application;
import pl.karolbitniok.components.MainInputField;
import pl.karolbitniok.components.RandomStringLabel;
import pl.karolbitniok.types.Language;
import pl.karolbitniok.utils.AppProperties;
import pl.karolbitniok.utils.RandomString;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Obszar graficzny rozgrywki.
 * Klasa dziedziczna po JPanel implementująca ActionListener.
 * @author Karol Bitniok s179949
 */
public class GamePanel extends JPanel implements ActionListener {
    /** Zmienna przechowująca ustawienia języka rozgrywki */
    public Language language;
    /** Zmienna przechowująca pozostałe iteracje logiki gry */
    public int remainingAttempts;
    /** Zmienna przechowująca poziom wody */
    public int waterLevel;
    /** Zmienna przechowująca czas rozgrywki */
    public static int gameTime;

    /** Komponent wejścia - do wprowadzania wymaganego słowa */
    static MainInputField mainInputField;
    /** Komponent do wyświetlania wylosowanego słowa */
    static RandomStringLabel randomStringLabel;
    /** Timer dla renderowania animacji poziomu wody */
    static Timer waterAnimationTimer;
    /** Timer do zliczania czasu rozgrywki */
    static Timer gameTimer;
    /** Komponent do wyświetlania na żywo czasu rozgrywki */
    static JLabel timeLabel;

    /** Rozmiar - szerokość obszaru wyświetlania */
    static final int PANEL_WIDTH = AppProperties.getAppWidth();
    /** Rozmiar - wysokość obszaru wyświetlania */
    static final int PANEL_HEIGHT = AppProperties.getAppHeight();
    /** Ścieżka do pliku z tłem aplikacji */
    static final String APP_BACKGROUND = AppProperties.getAppBackground();
    /** Ścieżka do pliku z logo aplikacji */
    static final String APP_LOGO = AppProperties.getAppLogo();
    /** Ścieżka do pliku z ikonką alarmu (timera) */
    static final String APP_ALARM = AppProperties.getAppAlarm();
    /** Ścieżka do pliku z wspinającą się postacią */
    static final String APP_CLIMBING_MAN = AppProperties.getAppClimbingMan();
    /** Ścieżka do pliku z teksturą wody */
    static final String APP_WATER = AppProperties.getAppWater();

    /**
     * Konstruktor klasy obszaru graficznego rozgrywki.
     * Określa wielkość obszaru, ustawia przyciski oraz
     * inicjalizuje timery (animacji i czasu rozgrywki).
     */
    public GamePanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);

        randomStringLabel = new RandomStringLabel();
        randomStringLabel.setBounds(490, 32, 300,50);

        mainInputField = new MainInputField();
        mainInputField.setBounds(490,596,300,50);
        mainInputField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { validateInput(mainInputField.getText()); }
            @Override
            public void removeUpdate(DocumentEvent e) { validateInput(mainInputField.getText()); }
            @Override
            public void changedUpdate(DocumentEvent e) { validateInput(mainInputField.getText()); }
        });

        timeLabel = new JLabel();
        timeLabel.setBounds(990,10,200,60);
        timeLabel.setFont(new Font("Arial",Font.BOLD,30));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        this.add(randomStringLabel);
        this.add(mainInputField);
        this.add(timeLabel);

        waterAnimationTimer = new Timer(30,this);
        gameTimer = new Timer(1000, this);
    }

    /**
     * Metoda rozpoczynająca rozgrywkę. Ustawia początkowe parametry.
     */
    public void startGame() {
        remainingAttempts = 20;
        waterLevel = 700;
        gameTime = 0;

        timeLabel.setText("Czas gry: "+ gameTime +"s");
        randomStringLabel.setText(new RandomString().getRandomString(language));
        mainInputField.requestFocus();

        waterAnimationTimer.start();
        gameTimer.start();
    }

    /**
     * Sprawdza podaną zawartość tekstową.
     * Na jej podstawie określa, czy można kontynuować rozgrywkę.
     * @param input zawartość do sprawdzenia
     */
    public void validateInput(String input) {
        Runnable handleValidation = () -> {
            if(input.equals("")) return;

            if(input.equals(randomStringLabel.getText())) {
                randomStringLabel.setText(new RandomString().getRandomString(language));
                mainInputField.setText("");
                remainingAttempts--;
                if(remainingAttempts == 0) {
                    waterAnimationTimer.stop();
                    gameTimer.stop();
                    Application.winGame();
                    return;
                }
                waterAnimationTimer.restart();
                waterLevel = 700;
                repaint();
            }
        };
        SwingUtilities.invokeLater(handleValidation);
    }

    /**
     * Ustawia wybrany język.
     * @param lang wybrany język
     */
    public void setLanguage(Language lang) {
        this.language = lang;
    }

    /**
     * Zwraca wybrany język.
     * @return wybrany język
     */
    public Language getLanguage() { return language; }

    /**
     * Zwraca aktualny czas rozgrywki.
     * @return aktualny czas rozgrywki
     */
    public int getGameTime() { return gameTime; }

    /**
     * Metoda główna klasy. Uruchamia grę.
     * @param args args
     */
    public static void main(String[] args) {
        new GamePanel();
    }

    /**
     * Nadpisuje metodę wywoływaną przez akcję.
     * Obsługuje przerysowywanie tekstury wody
     * oraz obsługuje timer (czas gry).
     * @param event akcja
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == waterAnimationTimer) {
            waterLevel--;
            repaint();
            if(waterLevel == 430) {
                waterAnimationTimer.stop();
                gameTimer.stop();
                Application.looseGame();
            }
        }
        if(event.getSource() == gameTimer) {
            gameTime++;
            timeLabel.setText("Czas gry: "+ gameTime +"s");
        }
    }

    /**
     * Nadpisuje metodę odpowiedzialną za odrysowanie panelu.
     * Ustawia niestandardowe tło wraz z logo. Dodatkowo rysuje
     * strukturę wody oraz umieszcza ikonę alarmu (timera).
     * @param graphics obiekt graficzny do ochrony
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(new ImageIcon(APP_BACKGROUND).getImage(),0,0,1280,720, null);
        graphics2D.drawImage(new ImageIcon(APP_LOGO).getImage(), 10,0,180,180,null);
        graphics2D.drawImage(new ImageIcon(APP_ALARM).getImage(),1200,10,60,60,null);
        graphics2D.drawImage(new ImageIcon(APP_CLIMBING_MAN).getImage(),560,200,170,248,null);
        graphics2D.drawImage(new ImageIcon(APP_WATER).getImage(),0,waterLevel,null);
    }
}
