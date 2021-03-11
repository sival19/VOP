package vop;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {
    @FXML
    private ImageView slot1, slot2, slot3;
    @FXML
    private Button stop1, stop2, stop3, start;
    @FXML
    private Label table;

    int count = 0;

    public synchronized void threadCounter(boolean threader){
        if (threader){
            count ++;
        } else{
            count --;
        }
        if(count == 0){
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    String id1 = slot1.getImage().getUrl();
                    String id2 = slot2.getImage().getUrl();
                    String id3 = slot3.getImage().getUrl();

                    if (id1 == id2 && id1 == id3) {
                        table.setText("YOU ARE COOOOL");

                    } else if (id1 == id2 && id1 != id3) {
                        table.setText("only 2.....");
                    } else if (id1 != id2 && id1 == id3) {
                        table.setText("only 2.....");
                    } else if (id2 == id3 && id1 != id2) {
                        table.setText("only 2.....");
                    } else {
                        table.setText("IDIOT!");
                    }

                }
            });
            System.out.println(count);
        }

    }

    private Thread thread1, thread2, thread3;
    private final Image[] images = new Image[10];

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            for (int i = 0; i < images.length; i++) {
                images[i] = new Image(getClass().getResource("fruits" + i + ".png").toURI().toString());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        slot1.setImage(images[0]);
        slot2.setImage(images[0]);
        slot3.setImage(images[0]);

    }

    @FXML
    private void stopHandler(ActionEvent event) {

        if (event.getSource() == stop1) {
            thread1.interrupt();
            stop1.setDisable(true);
            System.out.println(count);
        }
        if (event.getSource() == stop2) {
            thread2.interrupt();
            stop2.setDisable(true);
        }
        if (event.getSource() == stop3) {
            thread3.interrupt();
            stop3.setDisable(true);
        }
        if (stop1.isDisable() && stop2.isDisable() && stop3.isDisable()) {
            start.setDisable(false);
            stop1.setDisable(false);
            stop2.setDisable(false);
            stop3.setDisable(false);


        }


    }


    @FXML
    private synchronized void startHandler(ActionEvent event) {

        if (event.getSource() == start){
            BanditRunnable slotMachine1 = new BanditRunnable(1, 200, slot1);

            thread1 = new Thread(slotMachine1);
            thread1.setDaemon(true);


            BanditRunnable slotMachine2 = new BanditRunnable(1, 200, slot2);

            thread2 = new Thread(slotMachine2);
            thread2.setDaemon(true);

            BanditRunnable slotMachine3 = new BanditRunnable(1,200,slot3);

            thread3 = new Thread(slotMachine3);
            thread3.setDaemon(true);
        }

        thread1.start();
        thread2.start();
        thread3.start();

        start.setDisable(true);

    }

    public class BanditRunnable implements Runnable {

        private int i; //Index of current picture
        private final long sleepTime;
        private boolean running;
        private final ImageView iw;

        public BanditRunnable(int i, long sleepTime, ImageView iw) {
            this.i = i;
            this.sleepTime = sleepTime;
            this.iw = iw;
        }

        @Override
        public void run() {
            threadCounter(true);
            running = true;
            while (running) {
                Platform.runLater(() -> {
                    iw.setImage(images[i]);
                    i = (i + 1) % images.length;
                });
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    threadCounter(false);
                    running = false;
                    System.out.println("thread" + Thread.currentThread() + " stopped");
                }

            }
        }
    }
}

