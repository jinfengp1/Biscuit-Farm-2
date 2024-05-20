
import javax.swing.*;


public class MainFrame extends JFrame implements Runnable {
    private TitleScreen p;
    private Thread windowThread;

    public MainFrame(String display) {
        super(display);
        int frameWidth = 1216;
        int frameHeight = 838;
        p = new TitleScreen();
        this.add(p);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameWidth, frameHeight);
        this.setLocation(0, 0);
        this.setVisible(true);
        startThread();

    }

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }

    public void run() {
        while (!p.getIgnoreRepaint()) {
            p.repaint();
        }
    }
}
