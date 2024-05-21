import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class DrawPanel extends JPanel implements MouseListener {

    private BufferedImage showing;
    private int x;
    private int y;


public DrawPanel() {
    this.addMouseListener(this);
}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            showing = ImageIO.read(new File("images/.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(showing, 0 , 0, null);
    }


    //EVERYTHING MOUSE - PRESS GOES HERE
    public void mousePressed(MouseEvent e) {
        Point clicked = e.getPoint();

        if (e.getButton() == 1) { // IF LEFT MOUSE BUTTON

        }

        if (e.getButton() == 3) { // IF RIGHT MOUSE BUTTON

        }
    }













    // USELESS ZONE ---------------------------
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseClicked(MouseEvent e) { }
}