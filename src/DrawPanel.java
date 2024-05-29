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

    private ArrayList<NamedRect> screens;
    private NamedRect overworld = new NamedRect("overworld",830,240,300,200);
    private NamedRect credits = new NamedRect("credits",700,600,400,150);
    private NamedRect title = new NamedRect("title",0,700,200,100);
    private NamedRect plantation = new NamedRect("PLANTATION",650,300,100,60);
    private NamedRect biscuitown = new NamedRect("BISCUITOWN",900,550,100,60);
    private NamedRect mountain = new NamedRect("MOUNTAIN",950,180,100,60);
    private NamedRect desert = new NamedRect("DESERT",660,570,100,60);
    private NamedRect forest = new NamedRect("FOREST",500,190,100,60);
    private NamedRect volcano = new NamedRect("VOLCANO",140,520,100,60);
    private NamedRect house = new NamedRect("HOUSE",300,10,70,40);


public DrawPanel() {

    this.addMouseListener(this);
    screens = new ArrayList<NamedRect>();
    screens.add(title);
    screens.add(overworld);
    screens.add(credits);
    screens.add(plantation); // overworld
    screens.add(biscuitown);
    screens.add(mountain);
    screens.add(desert);
    screens.add(forest);
    screens.add(volcano);
    screens.add(house); // end overworld
}

public void checkButtons(Point clicked) {
    for (NamedRect n : screens) {
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

    public void repositionButtons() { // RE-POSITIONS BUTTONS BASED ON CURRENT SCREEN
    String f = fileName;
    for (int i = 0; i < screens.size(); i++) { screens.get(i).setClickable(false); }
    if (f.equals("title")) {
        overworld.setClickable(true);
        credits.setClickable(true);
    } else if (f.equals("overworld")) {
        title.setClickable(true);
        for (int i = 3; i <= 9; i++) {
            screens.get(i).setClickable(true);
        }
    } else if (f.equals("credits")) {
        title.setClickable(true);
    }


}

    //EVERYTHING MOUSE - PRESS GOES HERE
    public void mousePressed(MouseEvent e) {


        Point clicked = e.getPoint();
        if (e.getButton() == 1) {
            checkButtons(clicked);
            repositionButtons();
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