import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;


class DrawPanel extends JPanel implements MouseListener {

    private BufferedImage backdrop;
    private String fileName = "title";
    private int x;
    private int y;

    private NamedRect overworld = new NamedRect("overworld",830,240,300,200);
    private NamedRect credits = new NamedRect("credits",700,600,400,150);

    private ArrayList<NamedRect> buttons;



public DrawPanel() {

    this.addMouseListener(this);
    buttons = new ArrayList<NamedRect>();
    buttons.add(overworld);
    buttons.add(credits);
}

public void checkButtons(Point clicked) {
    for (NamedRect n : buttons) {
        if (n.contains(clicked) && n.clickable) {
            fileName = n.getName();
        }
    }
}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            backdrop = ImageIO.read(new File("images/" + fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(backdrop, 0 , 0, null);
    }


    //EVERYTHING MOUSE - PRESS GOES HERE
    public void mousePressed(MouseEvent e) {


        Point clicked = e.getPoint();
        if (e.getButton() == 1) {
          checkButtons(clicked);
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