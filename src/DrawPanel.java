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

    private BufferedImage images;
    private String fileName = "title";
    private int x;
    private int y;
    private Rectangle overworldHitbox = new Rectangle(830,240,300,200);
    private Rectangle creditsHitbox = new Rectangle(700,600,400,150);

    private ArrayList<Rectangle> buttons;
    private ArrayList<String> fileNames;


public DrawPanel() {

    this.addMouseListener(this);
    buttons = new ArrayList<Rectangle>();
    fileNames = new ArrayList<String>();
    buttons.add(overworldHitbox);
    fileNames.add("overworld");
    buttons.add(creditsHitbox);
    fileNames.add("credits");
}

public void checkButtons(Point clicked) {
    for (int i = 0; i < buttons.size(); i++) {
        if (buttons.get(i).contains(clicked)) {
            fileName = fileNames.get(i);
        }
    }
}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            images = ImageIO.read(new File("images/" + fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(images, 0 , 0, null);
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