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
    private BufferedImage sidebar;
    private BufferedImage dialogBox;
    private String fileName = "title";
    private int x;
    private int y;
    private boolean isShowingSidebar;
    private boolean isShowingDialogBox;
    private ArrayList<NamedRect> screens;
    private ArrayList<NamedRect> areas;

    private NamedRect overworld = new NamedRect("overworld",830,240,300,200);
    private NamedRect cornerX= new NamedRect("overworld",1140,0,60,60);
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
    areas = new ArrayList<NamedRect>();
    screens.add(title);
    screens.add(overworld);
    screens.add(credits);
    screens.add(cornerX);
    areas.add(plantation);
    areas.add(biscuitown);
    areas.add(mountain);
    areas.add(desert);
    areas.add(forest);
    areas.add(volcano);
    areas.add(house);
    isShowingSidebar = false;
    isShowingDialogBox = false;
}

public void checkButtons(Point clicked) {
    for (NamedRect s : screens) { if (s.contains(clicked) && s.clickable) { fileName = s.getName(); } }
    for (NamedRect a : areas) { if (a.contains(clicked) && a.clickable) { fileName = a.getName(); } }
}

public void writeDialogue(String name, String text, Graphics g) {

}

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            backdrop = ImageIO.read(new File("images/" + fileName + ".png"));
            sidebar = ImageIO.read(new File("images/sidebar.png"));
            dialogBox = ImageIO.read(new File("images/dialogbox.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(isShowingSidebar) {
            g.drawImage(sidebar,800,0,null);
        }
        if(isShowingDialogBox) {
            g.drawImage(dialogBox,0,500,null);
        }
        g.drawImage(backdrop, 0 , 0, null);
    }

    public void disableButtons() {
        for (int i = 0; i < screens.size(); i++) { screens.get(i).setClickable(false); }
        for (int i = 0; i < areas.size(); i++) { areas.get(i).setClickable(false); }
        if (isShowingSidebar) cornerX.setClickable(true);
    }
    public void repositionButtons() { // RE-POSITIONS BUTTONS BASED ON CURRENT SCREEN
    String f = fileName;
    boolean isInArea = false;
    disableButtons();
    if (f.equals("title")) {
        overworld.setClickable(true);
        credits.setClickable(true);
    } else if (f.equals("overworld")) {
        title.setClickable(true);
        for (int i = 0; i < areas.size(); i++) {
            areas.get(i).setClickable(true);
        }
    } else if (f.equals("credits")) {
        title.setClickable(true);
    }
    for (NamedRect a : areas) { if (f.equals(a.getName())) isInArea = true; }
    if (isInArea) { // IF IN AN AREA, ALL AREA BUTTONS ARE DISABLED. ONLY SUBAREA BUTTONS ARE ENABLED AND THE OVERWORLD.
        disableButtons();
        isShowingSidebar = true;
        isShowingDialogBox = true;
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