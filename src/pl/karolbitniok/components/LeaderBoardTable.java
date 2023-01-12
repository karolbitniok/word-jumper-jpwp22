package pl.karolbitniok.components;

import pl.karolbitniok.utils.AppProperties;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Niestandardowy komponent JTable z predefiniowanymi stylami
 * do wyświetlania tabeli wyników.
 * Klasa dziedziczna po JTable
 * @author Karol Bitniok s179949
 */
public class LeaderBoardTable extends JTable {
    /** Rozmiar - szerokość tabeli */
    static final int TABLE_WIDTH = AppProperties.getTableWidth();
    /** Rozmiar - wysokość tabeli */
    static final int TABLE_HEIGHT = AppProperties.getTableHeight();

    /**
     * Konstruktor klasy komponentu.
     * Definiuje niestandardowe style
     */
    public LeaderBoardTable() {
        this.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        this.setOpaque(false);
        ((DefaultTableCellRenderer) this.getDefaultRenderer(Object.class)).setOpaque(false);
        this.setFont(new Font("Arial",Font.BOLD,32));
        this.setRowHeight(34);
        this.setForeground(Color.WHITE);

        this.setShowGrid(false);
    }
}
