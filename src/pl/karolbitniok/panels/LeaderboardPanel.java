package pl.karolbitniok.panels;

import pl.karolbitniok.Application;
import pl.karolbitniok.components.AppButton;
import pl.karolbitniok.components.LeaderBoardTable;
import pl.karolbitniok.utils.AppProperties;
import pl.karolbitniok.utils.FileAdapter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Obszar graficzny prezentujący tabelę wyników.
 * Klasa dziedziczna po JPanel
 * @author Karol Bitniok s179949
 */
public class LeaderboardPanel extends JPanel {
    /** Przycisk powrotu do menu */
    static AppButton returnMenuButton;
    /** Tabela wyników */
    static LeaderBoardTable leaderBoardTable;
    /** Model tabeli wyników */
    static DefaultTableModel model;

    /** Nazwa kolumny w tabeli - nazwa użytkownika */
    static JLabel nameColumnLabel;
    /** Nazwa kolumny w tabeli - czas rozgrywki */
    static JLabel timeColumnLabel;
    /** Nazwa kolumny w tabeli - język rozgrywki */
    static JLabel langColumnLabel;

    /** Rozmiar panelu - szerokość obszaru wyświetlania */
    static final int PANEL_WIDTH = AppProperties.getAppWidth();
    /** Rozmiar panelu - wysokość obszaru wyświetlania */
    static final int PANEL_HEIGHT = AppProperties.getAppHeight();
    /** Ścieżka do pliku z tłem aplikacji */
    static final String APP_BACKGROUND = AppProperties.getAppBackground();
    /** Ścieżka do pliku z logo aplikacji */
    static final String APP_LOGO = AppProperties.getAppLogo();
    /** Ścieżka do pliku z danymi gry */
    static final String GAME_DATA_RESOURCE = AppProperties.getGameDataResourceFile();
    /** Rozmiar tabeli - szerokość */
    static final int TABLE_WIDTH = AppProperties.getTableWidth();
    /** Rozmiar tabeli - wysokość */
    static final int TABLE_HEIGHT = AppProperties.getTableHeight();
    /** Stała pomocnicza - numery id kolumn tabeli */
    static final String[] columnsIds = {"0", "1", "2"};

    /**
     * Konstruktor klasy obszaru prezentującego tabelę wyników.
     * Określa wielkość obszaru, ustawia przyciski i tabelę
     */
    public LeaderboardPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setLayout(null);

        nameColumnLabel = new JLabel("Nazwa użytkownika");
        nameColumnLabel.setForeground(Color.WHITE);
        nameColumnLabel.setFont(new Font("Arial",Font.PLAIN,24));
        nameColumnLabel.setBounds(390, 180,320,50);

        langColumnLabel = new JLabel("Język");
        langColumnLabel.setForeground(Color.WHITE);
        langColumnLabel.setFont(new Font("Arial",Font.PLAIN,24));
        langColumnLabel.setBounds(700, 180,90,50);

        timeColumnLabel = new JLabel("Czas [s]");
        timeColumnLabel.setForeground(Color.WHITE);
        timeColumnLabel.setFont(new Font("Arial",Font.PLAIN,24));
        timeColumnLabel.setBounds(800, 180,120,50);

        leaderBoardTable = new LeaderBoardTable();
        leaderBoardTable.setBounds(390,230,TABLE_WIDTH, TABLE_HEIGHT);

        model = (DefaultTableModel) leaderBoardTable.getModel();
        model.setColumnIdentifiers(columnsIds);

        leaderBoardTable.getColumnModel().getColumn(0).setMinWidth(320);

        returnMenuButton = new AppButton("Wróć do menu");
        returnMenuButton.setBounds(1060,20,200,50);
        returnMenuButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Application.returnMenu();
            }
        });

        this.add(timeColumnLabel);
        this.add(langColumnLabel);
        this.add(nameColumnLabel);
        this.add(returnMenuButton);
        this.add(leaderBoardTable);
    }

    /**
     * Metoda ustawiająca model tabeli. Odświeża dane na
     * podstawie rekordów w pliku z danymi gry.
     */
    public void setModelData() {
        model.setRowCount(0);
        ArrayList<String> gameData = new FileAdapter(GAME_DATA_RESOURCE).readLines();
        gameData.forEach(row -> model.addRow(row.split(",")));
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
        graphics2D.drawImage(new ImageIcon(APP_BACKGROUND).getImage(), 0, 0, 1280, 720, null);
        graphics2D.drawImage(new ImageIcon(APP_LOGO).getImage(), 560, 10, 180, 180, null);
    }
}