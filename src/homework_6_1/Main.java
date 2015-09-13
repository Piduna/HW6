package homework_6_1;

import javafx.scene.chart.Chart;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Valeriu on 11.09.2015.
 */
public class Main {

    public static void erase () {

        for (int i = 1; i <= 9; i++) {
            File f = new File(i + ".txt");
            f.delete();
        }
        File f = new File("super.txt");
        f.delete();

    }

    public static void main(String[] args) throws IOException {

        erase();

        Thread[] thread = new Thread[2];

        for (int i = 1; i <= 9; i++) {
            new CustomThread("" + i);
        }

        SuperThread superthread = new SuperThread();

        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(superthread);
        }

    }
}