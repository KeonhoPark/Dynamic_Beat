package dynamic_beat_10;

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
    private ImageIcon easyButtonImage = new ImageIcon(Main.class.getResource("../images/easy_button.png"));
    private ImageIcon easyButtonClickedImage = new ImageIcon(Main.class.getResource("../images/easy_button_clicked.png"));
    private ImageIcon hardButtonImage = new ImageIcon(Main.class.getResource("../images/hard_button.png"));
    private ImageIcon hardButtonClickedImage = new ImageIcon(Main.class.getResource("../images/hard_button_clicked.png"));
    private ImageIcon backButtonImage = new ImageIcon(Main.class.getResource("../images/back_button.png"));
    private ImageIcon backButtonClickedImage = new ImageIcon(Main.class.getResource("../images/back_button_clicked.png"));

    private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/game_info.png")).getImage();
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgement_line.png")).getImage();
    private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/note_route.png")).getImage();
    private Image noteRouteLine = new ImageIcon(Main.class.getResource("../images/note_route_line.png")).getImage();
    private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/note_basic.png")).getImage();
    private Image background = new ImageIcon(Main.class.getResource("../images/intro_bg.jpg")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menu_bar.png")));

    private JButton exitButton = new JButton(exitButtonImage);
    private JButton startButton = new JButton(startButtonImage);
    private JButton leftButton = new JButton(leftButtonImage);
    private JButton rightButton = new JButton(rightButtonImage);
    private JButton easyButton = new JButton(easyButtonImage);
    private JButton hardButton = new JButton(hardButtonImage);
    private JButton backButton = new JButton(backButtonImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;
    private boolean isGameScreen = false;

    ArrayList<Track> trackList = new ArrayList<Track>();

    private Image titleImage;
    private Image selectedImage;
    private Music selectedMusic;
    private Music introMusic = new Music("intro_music.mp3", true);
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
                enterMain();
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

        //easy 버튼
        easyButton.setVisible(false);
        easyButton.setBounds(375,580,250,150);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                easyButton.setIcon(easyButtonClickedImage);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("exitEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                easyButton.setIcon(easyButtonImage);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("pressMusic.mp3", false);
                buttonEnteredMusic.start();
                gameStart(nowSelected, "easy");
            }
        });
        add(easyButton);

        //hard 버튼
        hardButton.setVisible(false);
        hardButton.setBounds(600,580,250,150);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                hardButton.setIcon(hardButtonClickedImage);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("exitEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                hardButton.setIcon(hardButtonImage);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("pressMusic.mp3", false);
                buttonEnteredMusic.start();
                gameStart(nowSelected, "hard");
            }
        });
        add(hardButton);

        //뒤로가기 버튼
        backButton.setVisible(false);
        backButton.setBounds(60,0,35,30);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e){
                backButton.setIcon(backButtonClickedImage);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                Music buttonEnteredMusic = new Music("exitEnteredMusic.mp3", false);
                buttonEnteredMusic.start();
            }
            @Override
            public void mouseExited(MouseEvent e){
                backButton.setIcon(backButtonImage);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonEnteredMusic = new Music("pressMusic.mp3", false);
                buttonEnteredMusic.start();
                backMain();
            }
        });
        add(backButton);

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
        screenDraw((Graphics2D) screenGraphic);
        g.drawImage(screenImage,0,0,null);
    }

    public void screenDraw(Graphics2D g){
        g.drawImage(background,0,0,null);
        if(isMainScreen){
            g.drawImage(selectedImage,340,100,null);
            g.drawImage(titleImage,340,70,null);
        }
        if(isGameScreen){
            g.drawImage(noteRouteImage,228,30,null);
            g.drawImage(noteRouteImage,332,30,null);
            g.drawImage(noteRouteImage,436,30,null);
            g.drawImage(noteRouteImage,540,30,null);
            g.drawImage(noteRouteImage,640,30,null);
            g.drawImage(noteRouteImage,744,30,null);
            g.drawImage(noteRouteImage,848,30,null);
            g.drawImage(noteRouteImage,952,30,null);
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
            g.drawString("Joakim Karud - Mighty Love", 20,702);
            g.drawString("Easy",1190,702);
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

    public void gameStart(int nowSelected, String difficulty){
        if(selectedMusic != null)
            selectedMusic.close();
        isMainScreen = false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        backButton.setVisible(true);
        background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
        isGameScreen = true;
    }

    public void backMain(){
        isMainScreen = true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        background = new ImageIcon(Main.class.getResource("../images/main_bg.jpg")).getImage();
        backButton.setVisible(false);
        selectTrack(nowSelected);
        isGameScreen= false;
    }

    public void enterMain(){
        startButton.setVisible(false);
        background = new ImageIcon(Main.class.getResource("../images/main_bg.jpg")).getImage();
        isMainScreen = true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        introMusic.close();
        selectTrack(0);
    }
}
