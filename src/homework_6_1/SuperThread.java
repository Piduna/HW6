package homework_6_1;

import java.io.*;

/**
 * Created by Valeriu on 13.09.2015.
 */
public class SuperThread implements Runnable{

    Thread t;

    SuperThread() {
        if (t == null) {
            t = new Thread(this);
        }
        t.start();
    }

    @Override
    public void run() {
        for(int i = 1;i <= 9;i++) {
            File f = new File(i + ".txt");

            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    FileWriter fw = new FileWriter("super.txt", true);
                    fw.write(line);
                    fw.write("\n");
                    fw.close();
                }
                br.close();
            } catch (Exception e){
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
