package homework_6_1;

import java.io.*;

/**
 * Created by Valeriu on 11.09.2015.
 */
public class CustomThread implements Runnable {

    Thread t;
    String threadName;

    CustomThread(String threadName) {
        this.threadName = threadName;
        if (t == null) {
            t = new Thread(this);
        }
        t.start();
    }

    @Override
    public void run() {
        add(threadName);
    }

    public synchronized void add(String threadName) {
        File f = new File(threadName + ".txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(f);
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    fw.write(threadName);
                }
                fw.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error" + e.getMessage());
        }
    }
}

