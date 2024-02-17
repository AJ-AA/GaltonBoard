package controller;

import model.Model;
import view.View;


//NP:141350
//Antonio Jose Arenal Armesto
//Feedback2 Programacion Concurrente

public class GaltonBoardController implements Runnable {
    private Model model;
    private View view;

    public GaltonBoardController(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void run() {
        while (model.updatePositions()) {
            view.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void start() {
        new Thread(this).start();
    }
}
