package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100;
    private float yDelta = 100;
    private float xDir = 1f;
    private float yDir = 1f;
    private Color color = Color.red;
    private Random random;

    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXDelta(int value) {
        this.xDelta +=value;
    }

    public void changeYDelta(int value) {
        this.yDelta +=value;
    }

    public void setRectPos (int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateRectangle();
        g.setColor(color);
        g.fillRect((int)xDelta, (int)yDelta, 50, 50);

    }

    private void updateRectangle() {
        xDelta+= xDir;
        if(xDelta > 500 || xDelta < 0) {
            xDir*=-1;
            color = getRandomColor();
        }

        yDelta+= yDir;
        if(yDelta > 500 || yDelta < 0) {
            yDir*=-1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return new Color(red, green, blue);
    }
}
