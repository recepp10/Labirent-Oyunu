package labirent;

import com.sun.tools.javac.Main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Karakter {

    public ArrayList<String> cumleler = new ArrayList<String>();
    public ArrayList<String> numaralar = new ArrayList<String>();
    public static int[][] maze = new int[11][13];

    public Karakter() {
        int sayac = 0;
        try ( Scanner scanner = new Scanner(new FileReader("harita.txt"))) {

            while (scanner.hasNextLine()) {
                String kelime = scanner.nextLine();
                if (kelime.charAt(0) == '1' || kelime.charAt(0) == '0') {
                    numaralar.add(kelime);
                    sayac++;
                } else {
                    cumleler.add(kelime);

                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < 11; i++) {
            String diziSatiri = numaralar.get(i);

            for (int j = 0; j < 25; j++) {
                String dizi;
                if (j % 2 == 0) {
                    dizi = diziSatiri.substring(j, j + 1);

                    maze[i][j / 2] = Integer.valueOf(dizi);

                }

            }

        }

    }

    public ArrayList<String> getCumleler() {
        return cumleler;
    }

    public void setCumleler(ArrayList<String> cumleler) {
        this.cumleler = cumleler;
    }

    public ArrayList<String> getNumaralar() {
        return numaralar;
    }

    public void setNumaralar(ArrayList<String> numaralar) {
        this.numaralar = numaralar;
    }

    public static int[][] getMaze() {
        return maze;
    }

    public static void setMaze(int[][] maze) {
        Karakter.maze = maze;
    }

}
