package pl.karolbitniok.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Rekord - odpowiada za zapis/odczyt plików
 * @author Karol Bitniok s179949
 */
public record FileAdapter(String path) {

    /**
     * Dopisz nową linię do określonego pliku.
     * @param newLine zawartość nowej linii
     */
    public void writeLine(String newLine) {
        try(BufferedWriter output = new BufferedWriter(new FileWriter(path, true))) {
            output.append(newLine);
            output.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Odczytaj wszystkie wszystkie linie
     * z określonego pliku.
     * @return tablica linii pliku
     */
    public ArrayList<String> readLines() {
        ArrayList<String> output = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while(reader.ready()) {
                output.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }

    /**
     * Odczytaj określoną linię z określonego pliku.
     * @param specificLine określona linia
     * @return zawartość określonej linii
     */
    public String readSpecificLine(int specificLine) {
        String line = "";
        Optional<String> temp;

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            temp = reader.lines().skip(specificLine).findFirst();
            line = temp.orElse("");
        } catch(IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
