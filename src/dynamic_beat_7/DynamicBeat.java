package dynamic_beat_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../images/exit_button.png"));
    private ImageIcon exitButtonClickedImage = new ImageIcon(Main.class.getResource("../images/exit_button_clicked.png"));
    private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/start_button.png"));
    private ImageIcon startButtonClickedImage = new ImageIcon(Main.class.getResource("../images/start_button_clicked.png"));
    private ImageIcon leftButtonImage = new ImageIcon(Main.class.getResource("../images/left_button.png"));
    private ImageIcon leftButtonClickedImage = new ImageIcon(Main.class.getResource("../images/left_button_clicked.png"));
    private ImageIcon rightButtonImage = new ImageIcon(Main.class.getResource("../images/right_button.png"));
    private ImageIcon rightButtonClickedImage = new ImageIcon(Main.class.getResource("../images/right_button_clicked.png"));

    private Image background = new ImageIcon(Main.class.getResource("../images/intro_bg.jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu_bar.png")));

    private JButton exitButton = new JButton(exitButtonImage);
    private JButton startButton = new JButton(startButtonImage);
    private JButton leftButton = new JButton(leftButtonImage);
    private JButton rightButton = new JButton(rightButtonImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;

    ArrayList<Track> trackList = new ArrayList<Track>();

    private Image titleImage;
    private Image selectedImage;
    private Music selectedMusic;
    private int nowSelected = 0;

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

        Music introMusic = new Music("intro_music.mp3", true);
        introMusic.start();

        trackList.add(new Track("mighty_love_title_image.png","mighty_love_start_image.png","mighty_love_game_image.jpg","mighty_love_selected.mp3","Joakim Karud - Mighty Love.mp3"));
        trackList.add(new Track("carib_title_image.png","carib_start_image.png","carib_game_image.jpg","carib_selected.mp3","Dizaro - Caribbean vibes.mp3"));
        trackList.add(new Track("meizong_title_image.png","meizong_start_image.png","meizong_game_image.jpg","meizong_selected.mp3","Glassette - Meizong.mp3"));


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
                introMusic.close();
                selectTrack(0);
                startButton.setVisible(false);
                leftButton.setVisible(true);
                rightButton.setVisible(true);
                background = new ImageIcon(Main.class.getResource("../images/main_bg.jpg")).getImage();
                isMainScreen = true;
            }
        });
        add(startButton);

        //left 버튼
        leftButton.setVisible(false);
        leftButton.setBounds(140,310,60,60);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                leftButton.setIcon(leftButtonClickedImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("exitEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                leftButton.setIcon(leftButtonImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("pressMusic.mp3", false);
                buttonEnteredMusic.start();
                selectLeft();
            }
        });
        add(leftButton);

        //right 버튼
        rightButton.setVisible(false);
        rightButton.setBounds(1080,310,60,60);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                rightButton.setIcon(rightButtonClickedImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("exitEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                rightButton.setIcon(rightButtonImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("pressMusic.mp3", false);
                buttonEnteredMusic.start();
                selectRight();
            }
        });
        add(rightButton);

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
    }

    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage,0,0,null);
    }

    public void screenDraw(Graphics g){
        g.drawImage(background,0,0,null);
        if(isMainScreen){
            g.drawImage(selectedImage,340,100,null);
            g.drawImage(titleImage,340,70,null);
        }
        paintComponents(g);
        this.repaint();
    }

    public void selectTrack(int nowSelected){
        if(selectedMusic != null)
            selectedMusic.close();
        titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void selectLeft(){
        if(nowSelected == 0)
            nowSelected = trackList.size() - 1;
        else
            nowSelected--;
        selectTrack(nowSelected);
    }

    public void selectRight(){
        if(nowSelected == trackList.size() - 1)
            nowSelected = 0;
        else
            nowSelected++;
        selectTrack(nowSelected);
    }
}
