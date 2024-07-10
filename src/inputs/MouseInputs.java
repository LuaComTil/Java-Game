package inputs;

import main.Game;
import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener,
                                    MouseMotionListener {
    private GamePanel gamePanel;

    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel= gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Press");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Release");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Exited");

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Dragged");

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gamePanel.setRectPos(e.getX(), e.getY());
        System.out.println("Moved");
    }
}
