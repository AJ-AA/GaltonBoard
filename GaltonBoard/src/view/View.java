package view;

import model.Model;

import javax.swing.*;
import java.awt.*;


//NP:141350
//Antonio Jose Arenal Armesto
//Feedback2 Programacion Concurrente

public class View extends JPanel {
    private Model model;

    public View(Model model) {
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        FontMetrics fm = g.getFontMetrics();
        g.setFont(g.getFont().deriveFont(Font.BOLD));
        for (int i = 0; i < model.ballCount; i++) {
            int x = model.xPositions.get(i);
            int y = model.yPositions.get(i);
            g.setColor(Color.RED);
            g.fillOval(x, y, model.diameter, model.diameter);
            g.setColor(Color.WHITE);
            String idStr = String.valueOf(model.ballIds.get(i));
            int stringWidth = fm.stringWidth(idStr);
            int stringAscent = fm.getAscent();
            g.drawString(idStr, x + (model.diameter - stringWidth) / 2, y + (model.diameter + stringAscent) / 2 - 3);
        }
    }
}
