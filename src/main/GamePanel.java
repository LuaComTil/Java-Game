package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private int xDelta = 100, yDelta = 100;
    private int frames = 0;
    private long lastCheck = 0;

    public GamePanel() {
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
        g.drawRect(xDelta, yDelta, 50, 50);

        frames++;
        if (System.currentTimeMillis() - lastCheck >= 1000) {
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS:" + frames);
            frames = 0;
        }
        repaint();
    }
}
