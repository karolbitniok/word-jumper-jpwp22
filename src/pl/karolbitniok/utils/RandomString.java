package pl.karolbitniok.utils;

import pl.karolbitniok.types.Language;

import java.util.Random;

/**
 * Klasa pozwalająca wygenerować losowe słowo
 * z bazy słów dostępnych w 'src/resources/languages'.
 * @author Karol Bitniok s179949
 */
public class RandomString {
    /** Zmienna przechowująca ścieżkę do pliku zasobu języka */
    private static String path;

    /**
     * Generuj losowe słowo na podstawie wybranego języka.
     * @param lang wybrany język
     * @return losowe słowo w wybranym języku
     */
    public String getRandomString(Language lang) {
        Random random = new Random();

        int randomLine = random.nextInt(200);

        switch (lang) {
            case PL -> path = AppProperties.getPolishResourceFile();
            case ENG -> path = AppProperties.getEnglishResourceFile();
            default -> { }
        }

        return new FileAdapter(path).readSpecificLine(randomLine);
    }
}
