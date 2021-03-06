package dynamic_beat_1;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private Image introBackground;

    public DynamicBeat(){
        setTitle("Dynamic Beat");
        setSize(dynamic_beat_1.Main.SCREEN_WIDTH, dynamic_beat_1.Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        introBackground = new ImageIcon(Objects.requireNonNull(dynamic_beat_1.Main.class.getResource("C:\\Users\\user\\IdeaProjects\\Dynamic Beat\\src\\images\\intro_bg.jpg"))).getImage();
    }

    public void paint(Graphics g){
        screenImage = createImage(dynamic_beat_1.Main.SCREEN_WIDTH, dynamic_beat_2.Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage,0,0,null);
    }

    public void screenDraw(Graphics g){
        g.drawImage(introBackground,0,0,null);
        this.repaint();
    }



}
