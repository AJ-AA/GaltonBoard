import controller.GaltonBoardController;
import model.Model;
import view.View;

import javax.swing.*;


//NP:141350
//Antonio Jose Arenal Armesto
//Feedback2 Programacion Concurrente

public class Main {
    public static void createAndShowGUI() {
        Model model = new Model();
        View view = new View(model);
        GaltonBoardController controller = new GaltonBoardController(model, view);

        JFrame frame = new JFrame("Falling Balls Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(view);
        frame.setSize(model.panelWidth, model.panelHeight);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        controller.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }
}
