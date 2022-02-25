package dynamic_beat_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private Image background = new ImageIcon(Main.class.getResource("../images/intro_bg.jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu_bar.png")));

    private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../images/exit_button.png"));
    private ImageIcon exitButtonClickedImage = new ImageIcon(Main.class.getResource("../images/exit_button_clicked.png"));
    private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/start_button.png"));
    private ImageIcon startButtonClickedImage = new ImageIcon(Main.class.getResource("../images/start_button_clicked.png"));
    private ImageIcon quitButtonImage = new ImageIcon(Main.class.getResource("../images/quit_button.png"));
    private ImageIcon quitButtonClickedImage = new ImageIcon(Main.class.getResource("../images/quit_button_clicked.png"));

    private JButton exitButton = new JButton(exitButtonImage);
    private JButton startButton = new JButton(startButtonImage);
    private JButton quitButton = new JButton(quitButtonImage);

    private int mouseX, mouseY;

    public DynamicBeat(){
        setUndecorated(true);
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        setLayout(null);

        //게임종료 버튼
        exitButton.setBounds(1240,0,35,30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                exitButton.setIcon(exitButtonClickedImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("exitEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                exitButton.setIcon(exitButtonImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                Music buttonEnteredMusic = new Music("pressMusic.mp3", false);
                buttonEnteredMusic.start();
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
        add(exitButton);

        //게임 시작 버튼
        startButton.setBounds(60,0,35,30);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                startButton.setIcon(startButtonClickedImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("exitEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                startButton.setIcon(startButtonImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("pressMusic.mp3", false);
                buttonEnteredMusic.start();
                startButton.setVisible(false);
                background = new ImageIcon(Main.class.getResource("../images/main_bg.jpg")).getImage();
            }
        });
        add(startButton);

        //메뉴바
        menuBar.setBounds(0,0,1280,30);
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x-mouseX, y-mouseY);
            }
        });
        add(menuBar);

        Music introMusic = new Music("intro_music.mp3", true);
        introMusic.start();
    }

    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage,0,0,null);
    }

    public void screenDraw(Graphics g){
        g.drawImage(background,0,0,null);
        paintComponents(g);
        this.repaint();
    }



}
