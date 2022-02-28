package dynamic_beat_12;

import javax.swing.*;
import java.awt.*;

public class Game extends Thread{
    private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/note_basic.png")).getImage();
    private Image noteRouteLine = new ImageIcon(Main.class.getResource("../images/note_route_line.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgement_line.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/game_info.png")).getImage();
    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();

    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    public Game(String titleName, String difficulty, String musicTitle){
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);
        gameMusic.start();
    }

    public void screenDraw(Graphics2D g){
        g.drawImage(noteRouteSImage,228,30,null);
        g.drawImage(noteRouteDImage,332,30,null);
        g.drawImage(noteRouteFImage,436,30,null);
        g.drawImage(noteRouteSpace1Image,540,30,null);
        g.drawImage(noteRouteSpace2Image,640,30,null);
        g.drawImage(noteRouteJImage,744,30,null);
        g.drawImage(noteRouteKImage,848,30,null);
        g.drawImage(noteRouteLImage,952,30,null);
        g.drawImage(noteRouteLine,224,30,null);
        g.drawImage(noteRouteLine,328,30,null);
        g.drawImage(noteRouteLine,432,30,null);
        g.drawImage(noteRouteLine,536,30,null);
        g.drawImage(noteRouteLine,740,30,null);
        g.drawImage(noteRouteLine,844,30,null);
        g.drawImage(noteRouteLine,948,30,null);
        g.drawImage(noteRouteLine,1052,30,null);
        g.drawImage(gameInfoImage,0,660,null);
        g.drawImage(judgementLineImage,0,580,null);
        g.drawImage(noteBasicImage,228,120,null);
        g.drawImage(noteBasicImage,332,580,null);
        g.drawImage(noteBasicImage,436,500,null);
        g.drawImage(noteBasicImage,540,340,null);
        g.drawImage(noteBasicImage,640,340,null);
        g.drawImage(noteBasicImage,744,325,null);
        g.drawImage(noteBasicImage,848,305,null);
        g.drawImage(noteBasicImage,952,305,null);
        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName,20,702);
        g.drawString(difficulty,1190,702);
        g.setFont(new Font("Arial",Font.BOLD,26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S",270,609);
        g.drawString("D",374,609);
        g.drawString("F",478,609);
        g.drawString("Space Bar",580,609);
        g.drawString("J",784,609);
        g.drawString("K",889,609);
        g.drawString("L",993,609);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant",Font.BOLD,30));
        g.drawString("000000",565,702);
    }

    public void pressS(){
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/note_route_pressed.png")).getImage();
        new Music("drum_small_1.mp3",false).start();
    }

    public void releaseS(){
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    }

    public void pressD(){
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/note_route_pressed.png")).getImage();
        new Music("drum_small_2.mp3",false).start();
    }

    public void releaseD(){
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    }

    public void pressF(){
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/note_route_pressed.png")).getImage();
        new Music("drum_small_3.mp3",false).start();
    }

    public void releaseF(){
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    }

    public void pressSpace(){
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/note_route_pressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/note_route_pressed.png")).getImage();
        new Music("drum_space.mp3",false).start();
    }

    public void releaseSpace(){
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    }

    public void pressJ(){
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/note_route_pressed.png")).getImage();
        new Music("drum_big_1.mp3",false).start();
    }

    public void releaseJ(){
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    }

    public void pressK(){
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/note_route_pressed.png")).getImage();
        new Music("drum_big_2.mp3",false).start();
    }

    public void releaseK(){
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    }

    public void pressL(){
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/note_route_pressed.png")).getImage();
        new Music("drum_big_3.mp3",false).start();
    }

    public void releaseL(){
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    }

    @Override
    public void run(){

    }

    public void close(){
        gameMusic.close();
        this.interrupt();
    }
}
