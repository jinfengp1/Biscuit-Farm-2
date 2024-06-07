import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;


class DrawPanel extends JPanel implements MouseListener {

    private BufferedImage backdrop;
    private BufferedImage sidebar;
    private BufferedImage textBox;
    private String fileName = "title";
    private boolean isShowingSidebar;
    private boolean isShowingTextBox;
    private ArrayList<NamedRect> screens;
    private ArrayList<NamedRect> areas;
    private ArrayList<NamedRect> subAreas;

    private NamedRect overworld = new NamedRect("overworld",830,240,300,200);
    private NamedRect cornerX= new NamedRect("overworld",1140,0,60,60);
    private NamedRect credits = new NamedRect("credits",700,600,400,150);
    private NamedRect title = new NamedRect("title",0,700,200,100);
    private NamedRect plantation = new NamedRect("Plantation","PLANTATION",650,300,100,60);
    private NamedRect biscuitown = new NamedRect("Biscuitown","BISCUITOWN",900,550,100,60);
    private NamedRect mountain = new NamedRect("Mt.Cookie","MOUNTAIN",950,180,100,60);
    private NamedRect desert = new NamedRect("Butter Desert","DESERT",660,570,100,60);
    private NamedRect forest = new NamedRect("Sugar Forest","FOREST",500,190,100,60);
    private NamedRect volcano = new NamedRect("The Oven","VOLCANO",140,520,100,60);
    private NamedRect house = new NamedRect("Strange House","HOUSE",300,10,70,40);
    private NamedRect plantationPlot1 = new NamedRect("PlotbaseBasic",30,130,100,60);
    private NamedRect plantationPlot2 = new NamedRect("PlotbaseBasic", 380,360,100,60);
    private NamedRect plantationPlot3 = new NamedRect("PlotbaseBasic", 440,100,100,60);
    private NamedRect mountainPlot1 = new NamedRect("PlotbaseMountain", 350,300,80,50);
    private NamedRect desertPlot1 = new NamedRect("PlotbaseDesert", 150,350,100,50);
    private NamedRect volcanoPlot1 = new NamedRect("PlotbaseVolcano", 300,350,100,60);
    private NamedRect forestPlot1 = new NamedRect("PlotbaseBasic", 290,250,100,60);
    private NamedRect biscuitshop = new NamedRect("shop_bb",60,300,100,60);
    private NamedRect itemshop = new NamedRect("shop_sc",540,255,80,60);
    private NamedRect pawnshop = new NamedRect("shop_ps",450,290,100,60);
    private NamedRect secretshop = new NamedRect("shop_aac",2000,2000,1,1);
    private NamedRect bakeryshop = new NamedRect("shop_bs",320,140,100,40);

    private NamedRect nextDay = new NamedRect("Day",370,720,300,80); // NOT A LOCATION
    private ArrayList<Item> testing = null;
    // --- PLACEHOLDERS ---
    private String sideName = "Jabran is Cool";
    private String textboxName = "Jabran is Cool";
    private String textboxDesc = "Thank you mr folwel";

    private Game m = new Game();

    private String[] areaDesc;
    private String[] subareaDesc;


public DrawPanel() {
// AREAS ARE THE SCREENS WITH SIDEBAR AND DIALOGUE BOX
    this.addMouseListener(this);
    screens = new ArrayList<NamedRect>();
    areas = new ArrayList<NamedRect>();
    subAreas = new ArrayList<NamedRect>();
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
    // SUBAREAS
    subAreas.add(plantationPlot1);
    subAreas.add(plantationPlot2);
    subAreas.add(plantationPlot3);
    subAreas.add(mountainPlot1);
    subAreas.add(forestPlot1);
    subAreas.add(desertPlot1);
    subAreas.add(volcanoPlot1);

    subAreas.add(secretshop);
    subAreas.add(biscuitshop);
    subAreas.add(pawnshop);
    subAreas.add(itemshop);
    subAreas.add(bakeryshop);

    isShowingSidebar = false;
    isShowingTextBox = false;
    areaDesc = new String[areas.size()];
    areaDesc[0] = "It's your plantation. It is always sunny! Perfect for growing biscuits.";
    areaDesc[1] = "A bustling city on the island. The biggest city on the continent. You can also sell your food here at your own bakery.";
    areaDesc[2] = "Mt.Cookie is the tallest mountain on the continent. It's freezing. Maybe a biscuit type can thrive here...";
    areaDesc[3] = "The blazing desert. Somehow, you can grow biscuits here... Is that a pyramid? Oh, it's the pawn shop!";
    areaDesc[4] = "Apparently an old Biscuit Farmer owned this land. The sweet dirt is perfect for growing some biscuits here.";
    areaDesc[5] = "It's impossibly hot here. You might find a biscuit type that can survive these temperatures.";
    areaDesc[6] = "What is this place?";
    subareaDesc = new String[subAreas.size()];
}

    public void checkButtons(Point clicked) {
    for (NamedRect s : screens) { if (s.contains(clicked) && s.clickable) { fileName = s.getFileName(); } }
    for (NamedRect a : areas) { if (a.contains(clicked) && a.clickable) { fileName = a.getFileName(); } }
    for (NamedRect a : subAreas) { if (a.contains(clicked) && a.clickable) { fileName = a.getFileName(); } }
    if (nextDay.contains(clicked) && nextDay.clickable) { m.day++; }
}

    public void writeDialogue(String name, String text, Graphics g) {
    int x = 10;
    int y = 570;
    g.setFont(new Font("NSimSun",Font.BOLD,30));
    g.setColor(new Color(255,255,255));
    g.drawString(name,20,540);
    g.setFont(new Font("NSimSun",Font.ROMAN_BASELINE,21));
    int b = text.length() % 60;
    int a = text.length() / 60;
    for (int i = 0; i < a; i+=60) {
        g.drawString(text.substring(i,i+60),x,y);
        y += 25; }
    g.drawString(text.substring(text.length()-b),x,y);
    }

    public void fillSidebar(String name, ArrayList<Item> stuff, Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("NSimSun", Font.BOLD, 50));
        g.drawString(name, 820, 60);
        g.drawImage(m.coinImage, 810, 735, null);
        g.setColor(new Color(255,255,0));
        g.drawString("" + m.money + "G", 880,780);
    }

    public void updateSidebar() {
    for (NamedRect a : areas) {
        if (a.getFileName().equals(fileName)) {
            sideName = a.getName();
        }
    }
    //--------------
    }

    public void updateTextbox() {
    for (int i = 0; i < areas.size(); i++ ) {
        if (areas.get(i).getFileName().equals(fileName)) {
            textboxName = areas.get(i).getName();
            textboxDesc = areaDesc[i];
        }
    }
    //--------------
        for (NamedRect s : subAreas) {
            if (s.equals(fileName)) {
                textboxName = "Plot";
            }
        }
    }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            backdrop = ImageIO.read(new File("images/" + fileName + ".png"));
            sidebar = ImageIO.read(new File("images/sidebar.png"));
            textBox = ImageIO.read(new File("images/textbox.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(isShowingSidebar) {
            g.drawImage(sidebar,800,0,null);
            fillSidebar(sideName, testing, g);
            updateSidebar();
        }
        if(isShowingTextBox) {
            g.drawImage(textBox,0,500,null);
            writeDialogue(textboxName,textboxDesc,g);
            updateTextbox();
        }
        g.drawImage(backdrop, 0 , 0, null);
        if (fileName.equals("overworld")) {
            g.setColor(new Color(0,0,0));
            g.setFont(new Font("NSimSun",Font.BOLD,70));
            g.drawString("" + m.getDay(),960,780);
        }
    }

    public void disableButtons() {
        nextDay.setClickable(false);
        for (int i = 0; i < screens.size(); i++) { screens.get(i).setClickable(false); }
        for (int i = 0; i < areas.size(); i++) { areas.get(i).setClickable(false); }
        for (int i = 0; i < subAreas.size(); i++) { subAreas.get(i).setClickable(false); }
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
        nextDay.setClickable(true);
        for (int i = 0; i < areas.size(); i++) {
            areas.get(i).setClickable(true);
        }
    } else if (f.equals("credits")) {
        title.setClickable(true);
    }
    for (NamedRect a : areas) { if (f.equals(a.getFileName())) isInArea = true; }
    if (isInArea) { // IF IN AN AREA, ALL AREA BUTTONS ARE DISABLED. ONLY SUBAREA BUTTONS ARE ENABLED AND THE OVERWORLD.
        disableButtons();
        if (f.equals("PLANTATION")) {
            plantationPlot1.setClickable(true);
            plantationPlot2.setClickable(true);
            plantationPlot3.setClickable(true);
        }
        else if (f.equals("MOUNTAIN")) {
            mountainPlot1.setClickable(true);
        }
        else if (f.equals("FOREST")) {
            forestPlot1.setClickable(true);
        }
        else if (f.equals("DESERT")) {
            desertPlot1.setClickable(true);
            pawnshop.setClickable(true);
        }
        else if (f.equals("VOLCANO")) {
            volcanoPlot1.setClickable(true);
        }
        else if (f.equals("BISCUITOWN")) {
            biscuitshop.setClickable(true);
            bakeryshop.setClickable(true);
            itemshop.setClickable(true);
        }

        isShowingSidebar = true;
        isShowingTextBox = true;
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