package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


//NP:141350
//Antonio Jose Arenal Armesto
//Feedback2 Programacion Concurrente

public class Model {
    public final List<Integer> xPositions = new ArrayList<>();
    public final List<Integer> yPositions = new ArrayList<>();
    public final List<Integer> lateralMovementsLeft = new ArrayList<>();
    public final List<Integer> ballIds = new ArrayList<>();
    public final int diameter = 24;
    public final int panelWidth = 800;
    public final int panelHeight = 600;
    public final int ballCount = 150;
    public final int separation = 120;
    public final int movementSpeed = 15;
    public final int lateralMovement = 25;
    public final int maxLateralMoves = 5;
    public final Random random = new Random();

    public Model() {
        int startX = panelWidth / 2 - diameter / 2;
        for (int i = 0; i < ballCount; i++) {
            xPositions.add(startX);
            yPositions.add(-(i * separation));
            lateralMovementsLeft.add(maxLateralMoves);
            ballIds.add(i + 1);
        }
    }

    public boolean updatePositions() {
        boolean anyBallMoved = false;
        for (int i = 0; i < ballCount; i++) {
            int y = yPositions.get(i);
            int x = xPositions.get(i);
            if (y >= panelHeight - diameter) {
                continue; //
            }

            boolean collision = false;
            for (int j = 0; j < ballCount; j++) {
                if (i == j) continue;
                int otherY = yPositions.get(j);
                if (x == xPositions.get(j) && Math.abs(y - otherY) < diameter) {
                    collision = true;
                    break;
                }
            }

            if (!collision) {
                yPositions.set(i, Math.min(y + movementSpeed, panelHeight - diameter));
                anyBallMoved = true;
            }

            if (y % 100 == 0 && lateralMovementsLeft.get(i) > 0) {
                x += random.nextBoolean() ? lateralMovement : -lateralMovement;
                x = Math.max(0, Math.min(panelWidth - diameter, x));
                xPositions.set(i, x);
                lateralMovementsLeft.set(i, lateralMovementsLeft.get(i) - 1);
            }
        }
        return anyBallMoved;
    }
}
