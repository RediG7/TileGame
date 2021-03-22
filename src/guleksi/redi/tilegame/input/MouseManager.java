package guleksi.redi.tilegame.input;

import guleksi.redi.tilegame.ui.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    private UIManager uiManager;

    public MouseManager() {

    }

    public void setUIManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    // Getters

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    // Implemented methods

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) // BUTTON1 -> LEFT MOUSE BUTTON
            leftPressed = true;
        else if (e.getButton() == MouseEvent.BUTTON3) // BUTTON3 -> RIGHT MOUSE BUTTON
            rightPressed = true;
        // BUTTON2 -> IS MIDDLE MOUSE
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) // BUTTON1 -> LEFT MOUSE BUTTON
            leftPressed = false;
        else if (e.getButton() == MouseEvent.BUTTON3) // BUTTON3 -> RIGHT MOUSE BUTTON
            rightPressed = false;

        if (uiManager != null)
            uiManager.onMouseRelease(e);

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();  // getX mouse position
        mouseY = e.getY();  // getY mouse position

        if (uiManager != null)
            uiManager.onMouseMove(e);

    }


}
