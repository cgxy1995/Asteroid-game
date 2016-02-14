package game;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.io.*;

import javax.sound.midi.Sequence;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Asteroid implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Asteroid().run();
		System.exit(0);
	}
	private static final DisplayMode MODES[] = {
        new DisplayMode(800, 600, 32, 0)
    };
	private static final AudioFormat PLAYBACK_FORMAT =
	        new AudioFormat(44100, 16, 1, true, false);
	
	private boolean running;
	//game actions
	protected GameAction forward;
    protected GameAction exit;
    protected GameAction turnLeft;
    protected GameAction turnRight;
    protected GameAction pause;
    protected GameAction fireBullet;
    protected InputManager inputManager;
    protected GameAction forward2;
    protected GameAction turnLeft2;
    protected GameAction turnRight2;
    protected GameAction fireBullet2;
    //buttons and options
    private JButton playButton;
    private JPanel playButtonSpace;
    private JButton singleButton;
    private JButton vsButton;
    private JButton settingButton;
    private JButton saveButton;
    private JButton highButton;
    private JButton returnButton1;
    private JButton yesButtonHigh;
    private JButton noButtonHigh;
    private JButton Q,W,E,R,T,Y,U,I,O,P,A,S,D,F,G,H,J,K,L,Z,X,C,V,B,N,M;
    private JButton returnButtonLetter;
    private JButton saveButtonLetter;
    private JButton clearHighButton;
    private JButton quitButton;
    private JButton loadButton;
    private JButton returnButtonLoad;
    private JButton onButtonExist;
    private JButton offButtonExist;
    private JButton onButtonShow;
    private JButton offButtonShow;
    private JButton onButtonUnlimited;
    private JButton offButtonUnlimited;
    private JButton addButtonAst;
    private JButton minusButtonAst;
    private JButton addButtonLevel;
    private JButton minusButtonLevel;
    private JButton returnButtonSetting;
    private JButton returnButtonMenu;
    private String nameString1="";
    private String nameString2="";
    private int nameLength1;
    private int nameLength2;
    //game sounds
    //private SoundManager soundManager;
    //private MidiPlayer midiPlayer;
    //private Sound bulletSound;
    public SimpleSoundPlayer bulletSound;
    public SimpleSoundPlayer explosionSound;
    public InputStream bulletStream;
    public InputStream explosionStream;
    public SimpleSoundPlayer flySound;
    public InputStream flyStream;
    public SimpleSoundPlayer bgSound;
    public InputStream bgStream;
    private long lastBgTime;
    private long nowBgTime;
    private long lastFlyTime;
    private long nowFlyTime;
    //game variables
    private boolean inWelcome;
    private int level;
    private PlayerShip playership;
    private PlayerShip playership2;
    private boolean twoPlayerMode;
    private boolean paused;
	protected ScreenManager screen;
	private Image bgImage;
	private int rocknum;
	private Rock[] rocks;
	private int bulletnum;
	private int rocksleft;
	private Bullet[] bullets; 
	private long LastBulletTime;
	private long LastBulletTime2;
	private long ThisBulletTime;
	private long ThisBulletTime2;
	private int bulletsinRow;
	private int bulletsinRow2;
	private int score;
	private int score2;
	private Alienship[] aliens;
	private int aliennum;
	private Gravobject gravObject;
	private float gravAngle;
	private boolean gravVisible;
	private int gravEnable=1;
	private Rogueship[] rogues;
	private int roguenum;
	private int enemySpawnFlag;
	private Random enemySpawnRan = new Random();
	private long enemySpawnControlTime;
	private long enemySpawnStackTime;
	private int levelTransision;
	public long levelpreTime=System.currentTimeMillis();
	public long levelcurrTime=System.currentTimeMillis();
	private int player1Life;
	private int player2Life;
	private Font scorefont= new Font("Serif",Font.BOLD, 20);
	private Font levelfont;
	static final Font overfont = new Font("Woodcut",Font.PLAIN,50);
	static final Font asterfont = new Font("Year supply of fairy cakes",Font.PLAIN,60);
	static final Font asterfont2 = new Font("Year supply of fairy cakes",Font.PLAIN,25);
	static final Font highfont = new Font("Old English Text MT",Font.PLAIN,25);
	static final Font highfont2 = new Font("Old English Text MT",Font.PLAIN,40);
	static final Font highfont3 = new Font("Serif",Font.PLAIN,35);
	static final Font namefont = new Font("Algerian",Font.PLAIN,40);
	private boolean invincible1;
	private boolean invincible2;
	private long invincibleTime1;
	private long invincibleTime2;
	private boolean gameOverFlag;
	private boolean unlimitedMode;
	private int astnum;
	//saves highscore
	private int highScore;
	private boolean showHigh=false;
	private String highNames[];
	private int highScores[];
	private boolean canSaveHigh=false;
	private int savePos=0;
	private boolean canSaveHigh2=false;
	private String highName1="";
	private String highName2="";
	private boolean enterName = false;
	private boolean enterName2 = false;
	private boolean saving = false;
	private boolean setting = false;
	private JFileChooser fc;
	public void stop(){
		running = false;
	}
	public void run() {
        try {
        	readHighScores();
            initialize();
            initSounds();
            initButtons();
            gameLoop();
        }
        finally {
            screen.restoreScreen();
        }
    }
	public void initialize(){
		screen = new ScreenManager();
		DisplayMode displayMode = screen.findFirstCompatibleMode(MODES);
		screen.setFullScreen(displayMode);
		Window window = screen.getFullScreenWindow();
		window.setFont(new Font("Dialog", Font.PLAIN,24));
		window.setBackground(Color.BLACK);
		bgImage = loadImage("../images/bg.png");
		inputManager = new InputManager(window);
		twoPlayerMode=false;
		fc = new JFileChooser();
		level=1;
		createGameActions();
		astnum=3;
		rocknum=3;
		rocksleft=3;
		rocks = new Rock[500];
		createrocks();
		bullets = new Bullet[3000];
		aliens = new Alienship[100];
		aliennum=0;
		roguenum=0;
		rogues = new Rogueship[100];
		bulletnum=0;
		ThisBulletTime=System.currentTimeMillis();
		ThisBulletTime2=System.currentTimeMillis();
		LastBulletTime=System.currentTimeMillis();
		LastBulletTime2=System.currentTimeMillis();
		bulletsinRow=0;
		score=0;		
		gravAngle=0;
		gravObject = new Gravobject();
		gravVisible=false;
		enemySpawnFlag = 0;
		enemySpawnControlTime = 0;
		enemySpawnStackTime = 0;
		levelTransision=0;
		levelfont= new Font("Terminator Two",Font.BOLD, 25);
		player1Life=3;
		player2Life=3;
		invincible1=false;
		invincible2=false;
		invincibleTime1=0;
		invincibleTime2=0;
		gameOverFlag=false;
		inWelcome=true;
		nameLength1=0;
		nameLength2=0;
		unlimitedMode=false;
		running=true;
	}
	private void restartgame(){
		createGameActions();
		rocknum=astnum*level;
		rocksleft=rocknum;
		rocks = new Rock[500*level];
		createrocks();
		bullets = new Bullet[5000*level];
		aliens = new Alienship[100*level];
		aliennum=0;
		roguenum=0;
		rogues = new Rogueship[100*level];
		bulletnum=0;
		ThisBulletTime=System.currentTimeMillis();
		ThisBulletTime2=System.currentTimeMillis();
		LastBulletTime=System.currentTimeMillis();
		LastBulletTime2=System.currentTimeMillis();
		bulletsinRow=0;
		score=0;	
		score2=0;
		gravAngle=0;
		gravObject = new Gravobject();
		enemySpawnFlag = 0;
		enemySpawnControlTime = 0;
		enemySpawnStackTime = 0;
		levelTransision=0;
		levelfont= new Font("Terminator Two",Font.BOLD, 25);
		player1Life=3;
		player2Life=3;
		invincible1=false;
		invincible2=false;
		invincibleTime1=0;
		invincibleTime2=0;
		gameOverFlag=false;
		nameString2="";
		nameString1="";
		running=true;
		nameLength1=0;
		nameLength2=0;
		enterName=false;
		enterName2=false;
		readHighScores();
		update(0);
	}
	public void uplevel(int level){
		createship();
		rocknum=astnum*level;
		rocksleft=rocknum;
		rocks = new Rock[500*level];
		createrocks();
		bullets = new Bullet[5000*level];
		aliens = new Alienship[100*level];
		aliennum=0;
		roguenum=0;
		rogues = new Rogueship[100];
		bulletnum=0;
		ThisBulletTime=System.currentTimeMillis();
		ThisBulletTime2=System.currentTimeMillis();
		LastBulletTime=System.currentTimeMillis();
		LastBulletTime2=System.currentTimeMillis();
		bulletsinRow=0;	
		enemySpawnFlag = 0;
		enemySpawnControlTime = 0;
		enemySpawnStackTime = 0;
		levelTransision=0;
		running=true;
	}
	public void initSounds() {
		//midiPlayer = new MidiPlayer();
        //soundManager = new SoundManager(PLAYBACK_FORMAT);
        bulletSound = new SimpleSoundPlayer("../sounds/bullet.wav");
        bulletStream = new ByteArrayInputStream(bulletSound.getSamples());
        explosionSound = new SimpleSoundPlayer("../sounds/explosion.wav");
        explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
        flySound = new SimpleSoundPlayer("../sounds/fly.wav");
        flyStream = new ByteArrayInputStream(flySound.getSamples());
        bgSound = new SimpleSoundPlayer("../sounds/contra.wav");
        bgStream = new ByteArrayInputStream(bgSound.getSamples());
        lastFlyTime=0;
        nowFlyTime=0;
        lastBgTime=0;
        nowBgTime=0;
        new Thread() {
            public void run() {
            	bgStream = new ByteArrayInputStream(bgSound.getSamples());
            	bgSound.play(bgStream);
            }
        }.start();
        //bulletSound = soundManager.getSound("../sounds/fly-bzz.wav");
        
	}
	public void initButtons(){
		NullRepaintManager.install();

        // create an addtional GameAction for "config"
       //configAction = new GameAction("config");
		playButton = createButton("play", "Continue");
		singleButton = createButton("Single Mode","Start Game with single player");
		vsButton = createButton("Versus Mode","Start Game with 2 players");
		settingButton = createButton("Setting","Set starting parameters");
		saveButton = createButton("Save","Save the current game");
		highButton = createButton("High Scores","See High scores");
		returnButton1 = createButton("return","Return to previous screen");
		yesButtonHigh = createButton("Yes","Save your high score");
		noButtonHigh = createButton("No","Don't Save high score");
		clearHighButton = createButton("Reset High Scores","Reset all high scores");
		quitButton = createButton("Exit Game","Exit game");
		loadButton = createButton("Load","Load game");
		returnButtonMenu = createButton("return","Return to menu");
		//playButton.BOTTOM_ALIGNMENT;
		playButton.setVisible(false);
		playButtonSpace = new JPanel();	
		//playButtonSpace.add(new JScrollPane(new JTable(new DefaultTableModel(COLS,5))),BorderLayout.CENTER);
        playButtonSpace.setOpaque(false);
        playButtonSpace.add(playButton);  
        JFrame frame = screen.getFullScreenWindow();
        Container contentPane = frame.getContentPane();

        // make sure the content pane is transparent
        if (contentPane instanceof JComponent) {
            ((JComponent)contentPane).setOpaque(false);
        }
        //contentPane.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPane.setLayout(null);    
        playButtonSpace.setBounds(20,20,100,100);
        contentPane.add(playButtonSpace);
        singleButton.setBounds(200,150,465,65);
        singleButton.setVisible(true);
        contentPane.add(singleButton);
        vsButton.setBounds(200, 200, 465, 65);
        vsButton.setVisible(true);
        contentPane.add(vsButton);
        settingButton.setBounds(200, 250, 465, 65);
        settingButton.setVisible(true);
        contentPane.add(settingButton);
        saveButton.setBounds(20, 70, 200, 65);
        saveButton.setVisible(false);
        contentPane.add(saveButton);
        
        returnButtonMenu.setBounds(40,110,64,64);
        returnButtonMenu.setVisible(false);
        contentPane.add(returnButtonMenu);
        
        highButton.setBounds(200, 300, 465, 65);
        highButton.setVisible(true);
        contentPane.add(highButton);
        
        clearHighButton.setBounds(100, 350, 588, 65);
        clearHighButton.setVisible(true);
        contentPane.add(clearHighButton);
        
        loadButton.setBounds(200, 400, 465, 65);
        loadButton.setVisible(true);
        contentPane.add(loadButton);
        
        quitButton.setBounds(300, 450, 314, 65);
        quitButton.setVisible(true);
        contentPane.add(quitButton);
        returnButton1.setBounds(600, 400, 100, 100);
        returnButton1.setVisible(false);
        contentPane.add(returnButton1);
        yesButtonHigh.setBounds(50, 450, 128, 58);
        yesButtonHigh.setVisible(false);
        contentPane.add(yesButtonHigh);
        noButtonHigh.setBounds(200, 450, 128, 58);
        noButtonHigh.setVisible(false);
        contentPane.add(noButtonHigh);
        //contentPane2.setLayout(new FlowLayout(FlowLayout.LEADING));
        //contentPane.add(gameStart);
        addLetterButtons(contentPane);
        addSettingButtons(contentPane);
        frame.validate();
	}
	public Image loadImage(String fileName){
		return new ImageIcon(fileName).getImage();
	}
	public void gameLoop(){
		long startTime = System.currentTimeMillis();
		long currTime = startTime;
		while(running){
			long elapsedTime =System.currentTimeMillis() - currTime;
			currTime += elapsedTime;
			if(!inWelcome){			
				enemySpawn(elapsedTime);
				enemyFire();
			}
				update(elapsedTime);
				bgMusic(elapsedTime);
			Graphics2D g=screen.getGraphics();
			draw(g);
			if(!inWelcome){
				delectCollision();
				cancelInvincible(elapsedTime);
				delectLevelUp(g);
			}
			g.dispose();
			screen.update();
			
		}
	}
	public boolean isPaused() {
        return paused;
    }
	public void bgMusic(long elapsedTime){
		nowBgTime+=elapsedTime;
		if(nowBgTime-lastBgTime>340000){
			lastBgTime=nowBgTime;
			new Thread() {
	            public void run() {
	            	bgStream = new ByteArrayInputStream(bgSound.getSamples());
	            	bgSound.play(bgStream);
	            }
	        }.start();
		}
	}
	public void update(long elapsedTime) {
        // check input that can happen whether paused or not
        checkSystemInput();
        if (!isPaused() && !inWelcome) {
            // check game input
        	
            checkGameInput(elapsedTime);
            // update ship
            playership.update(elapsedTime);
            if(twoPlayerMode)
            	playership2.update(elapsedTime);
            for(int i=0;i<rocknum;i++){
            	if(rocks[i]!=null){
            		rocks[i].update(elapsedTime);
            	}
            }
            for(int i=0;i<bulletnum;i++){
            	if(bullets[i]!=null){
            		bullets[i].update(elapsedTime);
            		if(bullets[i].ifOut()){
            			bullets[i]=null;
            		}
            	}
            }
            for(int i=0;i<aliennum;i++){
            	if(aliens[i]!=null){
            		aliens[i].update(elapsedTime);
            	}
            }
            for(int i=0;i<roguenum;i++){
            	if(rogues[i]!=null){
            		rogues[i].update(elapsedTime);
            	}
            }
        }
    }
	public void checkSystemInput() {
        if (pause.isPressed()) {
            setPaused(!isPaused());
        }
        if (exit.isPressed()) {
            stop();
        }
    }
	public void checkGameInput(long elapsedTime){
		float turnspeed=(float) (Math.PI/50);
		if(player1Life>0){
		if(forward.isPressed()){
			if(-playership.speed<playership.SPEED)
				playership.speed=playership.speed-playership.ACCL;
			flysound(elapsedTime);
		}
		else
			if(playership.speed<0)
				playership.speed+=playership.ACCL;
		
		if(turnLeft.isPressed()){
			if(playership.getAngle()<2*Math.PI){
				playership.setAngle(playership.getAngle()+turnspeed);
			}
			else{
				playership.setAngle((float)(playership.getAngle()-2*Math.PI));
			}
		}
		if(turnRight.isPressed()){
				playership.setAngle(playership.getAngle()-turnspeed);
				if(playership.getAngle()<0)
					playership.setAngle((float) (playership.getAngle()+2*Math.PI));
		}
		if(fireBullet.isPressed()){
			ThisBulletTime=System.currentTimeMillis();
			if(ThisBulletTime-LastBulletTime<200 && bulletsinRow<4){
				bulletsinRow++;
			}
			else if(ThisBulletTime-LastBulletTime>=200)
				bulletsinRow=0;
			if(bulletsinRow<4)
				fire(0);
		}
		}
		if(twoPlayerMode &&player2Life>0){
		if(forward2.isPressed()){
			if(-playership2.speed<playership2.SPEED)
				playership2.speed=playership2.speed-playership2.ACCL;
		}
		else
			if(playership2.speed<0)
				playership2.speed+=playership2.ACCL;
		if(turnLeft2.isPressed()){
			if(playership2.getAngle()<2*Math.PI){
				playership2.setAngle(playership2.getAngle()+turnspeed);
			}
			else{
				playership2.setAngle((float)(playership2.getAngle()-2*Math.PI));
			}
		}
		if(turnRight2.isPressed()){
			playership2.setAngle(playership2.getAngle()-turnspeed);
			if(playership2.getAngle()<0)
				playership2.setAngle((float) (playership2.getAngle()+2*Math.PI));
	}
		if(fireBullet2.isPressed()){
			ThisBulletTime2=System.currentTimeMillis();
			if(ThisBulletTime2-LastBulletTime2<200 && bulletsinRow2<4){
				bulletsinRow2++;
			}
			else if(ThisBulletTime2-LastBulletTime2>=200)
				bulletsinRow2=0;
			if(bulletsinRow2<4)
				fire2(2);
		}
		}//two player mode
		//System.out.println(playership.getAngle()+" "+Math.sin(playership.getAngle()));
        if(playership.speed>0)
        	playership.speed=0;
        
        float gravspeedx;
        float gravspeedy;
        
        if(gravObject.ifOut((int)(playership.x), (int)(playership.y))){
        	gravspeedx=(float) (Math.sin(gravObject.calcAngle(playership.x, playership.y))*Gravobject.GRAVITY)*gravEnable;
        	gravspeedy=(float) (Math.cos(gravObject.calcAngle(playership.x, playership.y))*Gravobject.GRAVITY)*gravEnable;
        }
        else{
        	gravspeedx=0;
        	gravspeedy=0;
        }
        
		playership.setVelocityX(playership.speed*(float)(Math.sin(playership.getAngle()))+gravspeedx);
		playership.setVelocityY(playership.speed*(float)(Math.cos(playership.getAngle()))+gravspeedy);
		if(twoPlayerMode){
        	if(playership2.speed>0)
        		playership2.speed=0;
        	float gravspeedx2;
            float gravspeedy2;
            if(gravObject.ifOut((int)(playership2.x), (int)(playership2.y))){
            	gravspeedx2=(float) (Math.sin(gravObject.calcAngle(playership2.x, playership2.y))*Gravobject.GRAVITY)*gravEnable;
            	gravspeedy2=(float) (Math.cos(gravObject.calcAngle(playership2.x, playership2.y))*Gravobject.GRAVITY)*gravEnable;
            }
            else{
            	gravspeedx2=0;
            	gravspeedy2=0;
            }
            playership2.setVelocityX(playership2.speed*(float)(Math.sin(playership2.getAngle()))+gravspeedx2);
    		playership2.setVelocityY(playership2.speed*(float)(Math.cos(playership2.getAngle()))+gravspeedy2);
        }
		
	}
	public void draw(Graphics2D g){
		g.setColor(Color.WHITE);
		g.drawImage(bgImage, 0, 0, null);
		if(inWelcome && !showHigh && !setting){
			JFrame frame = screen.getFullScreenWindow();			
			frame.getLayeredPane().paintComponents(g);
			g.setFont(asterfont);
			g.drawString("Asteroid", 250, 100);
			g.setFont(asterfont2);
			g.drawString("Ver 1.0", 450, 150);		
		}
		else if(showHigh){
			g.setFont(highfont2);
			g.drawString("Wall of Fame", 20, 40);
			g.setFont(highfont);
			g.drawString("Name", 20, 70);
			g.drawString("Score", 250, 70);
			for(int i=0;i<10;i++){
				g.drawString(highNames[i], 20, 105+35*i);
				g.drawString(Integer.toString(highScores[i]), 250, 105+35*i);
			}
			JFrame frame = screen.getFullScreenWindow();			
			frame.getLayeredPane().paintComponents(g);
		}
		else if(enterName){
			JFrame frame = screen.getFullScreenWindow();			
			frame.getLayeredPane().paintComponents(g);
			g.setFont(namefont);
			if(!enterName2){
				g.drawString(nameString1, 100, 450);
				g.setFont(highfont3);
				g.drawString("Player 1 please enter your name", 200, 350);
			}
			else if(twoPlayerMode && enterName2){
				g.drawString(nameString2, 100, 450);
				g.setFont(highfont3);
				g.drawString("Player 2 please enter your name", 200, 350);
			}
		}
		else if(setting){
			g.setFont(scorefont);
			g.drawString("Gravitational Object",60, 90);
			if(gravEnable==1){
				g.drawString("Show position", 60, 190);
			}
			g.drawString("Unlimited Life",60,290);
			g.drawString("# of Asteroids",60,380);
			g.drawString("Starting Level",60,480);
			g.drawString(""+astnum, 350, 390);
			g.drawString(""+level, 350, 490);
			JFrame frame = screen.getFullScreenWindow();			
			frame.getLayeredPane().paintComponents(g);
		}
		else{
			String fenshu = "Score";
			String fenshu2 = "Score";
		/*player one ship*/
		fenshu=fenshu+": "+score;
		g.setFont(scorefont);
		g.drawString("level "+level, 380, 580);
		g.drawString(fenshu, 50, 30);
		if(!gameOverFlag && player1Life>0) {
			g.drawPolygon(playership.createPolygon());//playership
			if(invincible1)
				g.drawOval((int)playership.x-13, (int)playership.y-13, 26, 26);
		}
		drawLife1(g); //draw player1 life
		/*player 2 ship*/
		if(twoPlayerMode){
			fenshu2=fenshu2+": "+score2;
			g.drawString(fenshu2, 600, 30);
			if(!gameOverFlag && player2Life>0){
				g.drawPolygon(playership2.createPolygon());//playership 2
				if(invincible2)
					g.drawOval((int)playership2.x-13, (int)playership2.y-13, 26, 26);
			}
			drawLife2(g);
		}
		if(gameOverFlag){
			g.setFont(overfont);
			g.drawString("Game Over", 200, 250);
			if(ifCanSaveHigh()){
				g.setFont(highfont3);
				g.drawString("Save High Score?", 50, 300);
				JFrame frame = screen.getFullScreenWindow();			
				frame.getLayeredPane().paintComponents(g);
			}
		}
		for(int i=0;i<rocknum;i++){
			if(rocks[i]!=null){
				g.drawPolygon(rocks[i].createPolygon());
			}
		}
		//draw bullets
		for(int i=0;i<bulletnum;i++){
			if(bullets[i]!=null){
				g.drawOval((int)bullets[i].getX(), (int)bullets[i].getY(), Bullet.RADIUS, Bullet.RADIUS);
			}		
		}
		//draw alienship
		for(int i=0;i<aliennum;i++){
        	if(aliens[i]!=null){
        		Polygon[] alienship=aliens[i].createPolygon();
        		g.drawPolygon(alienship[0]);
        		g.drawPolygon(alienship[1]);
        		g.drawPolygon(alienship[2]);
        	}
        }
		if(levelTransision==1 && !gameOverFlag){
			g.setFont(levelfont);
			g.drawString("Level"+level, 275, 260);
			g.drawString("Press ECS to continue", 300, 300);
		}
		g.setColor(Color.YELLOW);
		for(int i=0;i<roguenum;i++){
			if(rogues[i]!=null){
				g.drawPolygon(rogues[i].createPolygon());
				g.drawOval((int)(rogues[i].x-20),(int)(rogues[i].y-7),40,14);
			}
		}
		if(gravVisible)
			g.drawOval(400, 300, Gravobject.RADIUS, Gravobject.RADIUS);
		if(paused){
			JFrame frame = screen.getFullScreenWindow();			
			frame.getLayeredPane().paintComponents(g);
		}
		}
	}
	 public void createGameActions() {
		 forward = new GameAction("forward");
		 exit = new GameAction("exit", GameAction.DETECT_INITAL_PRESS_ONLY);
		 turnLeft = new GameAction("turnLeft");
		 turnRight = new GameAction("turnRight");
		 fireBullet = new GameAction("fireBullet",GameAction.DETECT_INITAL_PRESS_ONLY);
		 pause = new GameAction("pause", GameAction.DETECT_INITAL_PRESS_ONLY);
		 forward2 = new GameAction("forward2");
		 turnLeft2 = new GameAction("turnLeft2");
		 turnRight2 = new GameAction("turnRight2");
		 fireBullet2 = new GameAction("fireBullet2",GameAction.DETECT_INITAL_PRESS_ONLY);
		 inputManager.mapToKey(forward, KeyEvent.VK_UP);
		 inputManager.mapToKey(exit, KeyEvent.VK_Q);
		 inputManager.mapToKey(turnLeft, KeyEvent.VK_LEFT);
		 inputManager.mapToKey(turnRight, KeyEvent.VK_RIGHT);
		 inputManager.mapToKey(fireBullet, KeyEvent.VK_QUOTE);
		 inputManager.mapToKey(pause, KeyEvent.VK_ESCAPE);
		 inputManager.mapToKey(forward2, KeyEvent.VK_W);
		 inputManager.mapToKey(turnLeft2, KeyEvent.VK_A);
		 inputManager.mapToKey(turnRight2, KeyEvent.VK_D);
		 inputManager.mapToKey(fireBullet2, KeyEvent.VK_SPACE);
	 }
	 private void createship(){
		 playership = new PlayerShip();
		 playership.setX(300f);
		 playership.setY(250f);
		 playership.createPolygon();
		 if(twoPlayerMode){
		 playership2 = new PlayerShip();
		 playership2.setX(500f);
		 playership2.setY(250f);
		 playership.createPolygon();
		 }
	 }
	 @SuppressWarnings("deprecation")
	public void setPaused(boolean p) {
	        if (paused != p) {
	            this.paused = p;
	            inputManager.resetAllGameActions();
	        }	        
	        if(paused==false) {
	        	playButton.setVisible(false);	
	        	saveButton.setVisible(false);
	        	returnButtonMenu.setVisible(false);
	        	levelTransision=0;
	        }
	        else {
	        	playButton.setVisible(true);
	        	saveButton.setVisible(true);
	        	returnButtonMenu.setVisible(true);
	        }
	 }
	 private void createrocks(){
		 int i;
		 Random generator = new Random();
		 int pos;
		 int startx;
		 int starty;
		 float angle;
		 int shape;
		 for (i=0;i<rocknum;i++){
			 pos=generator.nextInt(2);
			 rocks[i]=new Rock();
			 shape=generator.nextInt(3)+1;
			 rocks[i].setShape(shape);			 
			 rocks[i].createPolygon();
			 if(pos==0){
				 startx=generator.nextInt(800);
				 rocks[i].setCenter(startx, -rocks[i].boundbox.height/2);
			 }
			 else{
				 starty=generator.nextInt(600);
				 rocks[i].setCenter(-rocks[i].boundbox.width/2, starty);
			 }
			 rocks[i].setSpeed(.09f);
			 angle=(float) (generator.nextFloat()*2*Math.PI);
			 rocks[i].setVelocityX(-(float) (Math.sin(angle)*rocks[i].speed));
			 rocks[i].setVelocityY(-(float) (Math.cos(angle)*rocks[i].speed));
			 rocks[i].createPolygon();
		 }
	 }
	 private void delectCollision(){
		 Random generator = new Random();
		 int shape;
		 float angle;
		 if(!inWelcome && !enterName){
		 //player ship1 collision with rocks
		 for(int i=0;i<rocknum;i++){
			 if(rocks[i]!=null && (rocks[i].rock.contains(playership.p2x, playership.p2y)||rocks[i].rock.contains(playership.p1x, playership.p1y)||rocks[i].rock.contains(playership.p3x, playership.p3y)) && rocks[i].size==3){
				 for(int k=0;k<2;k++){
			 	 rocks[rocknum] = new Rock();
			 	 rocks[rocknum].setSize(2);
			 	 shape=generator.nextInt(3)+1;
				 rocks[rocknum].setShape(shape);
				 rocks[rocknum].createPolygon();
				 if(k==0)
					 rocks[rocknum].setCenter((int)rocks[i].x-2, (int)rocks[i].y-2);
				 else
					 rocks[rocknum].setCenter((int)rocks[i].x+2, (int)rocks[i].y+2);
				 rocks[rocknum].setSpeed(.13f);
				 angle=(float) (generator.nextFloat()*2*Math.PI);
				 rocks[rocknum].setVelocityX(-(float) (Math.sin(angle)*rocks[rocknum].speed));
				 rocks[rocknum].setVelocityY(-(float) (Math.cos(angle)*rocks[rocknum].speed));
				 rocknum++;
				 }
				 rocksleft++;
				 calcScore(0);
				 if(!invincible1 && !unlimitedMode)
					 crash1();
				 rocks[i]=null;
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
			 if(rocks[i]!=null && (rocks[i].rock.contains(playership.p2x, playership.p2y)||rocks[i].rock.contains(playership.p1x, playership.p1y)||rocks[i].rock.contains(playership.p3x, playership.p3y))  && rocks[i].size==2){
				 for(int k=0;k<2;k++){
			 	 rocks[rocknum] = new Rock();
			 	 System.out.println(rocknum);
			 	 rocks[rocknum].setSize(1);
			 	 shape=generator.nextInt(3)+1;
				 rocks[rocknum].setShape(shape);
				 rocks[rocknum].createPolygon();
				 if(k==0)
					 rocks[rocknum].setCenter((int)rocks[i].x-1, (int)rocks[i].y-1);
				 else
					 rocks[rocknum].setCenter((int)rocks[i].x+1, (int)rocks[i].y+1);
				 rocks[rocknum].setSpeed(.2f);
				 angle=(float) (generator.nextFloat()*2*Math.PI);
				 rocks[rocknum].setVelocityX(-(float) (Math.sin(angle)*rocks[rocknum].speed));
				 rocks[rocknum].setVelocityY(-(float) (Math.cos(angle)*rocks[rocknum].speed));
				 rocknum++;
				 }	
				 rocksleft++;
				 rocks[i]=null;
				 calcScore(0);
				 if(!invincible1 && !unlimitedMode)
				 	crash1();
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
			 if(rocks[i]!=null && (rocks[i].rock.contains(playership.p2x, playership.p2y)||rocks[i].rock.contains(playership.p1x, playership.p1y)||rocks[i].rock.contains(playership.p3x, playership.p3y))  && rocks[i].size==1){
				 rocks[i]=null;
				 rocksleft--;
				 calcScore(0);
				 if(!invincible1 && !unlimitedMode)
					 crash1();
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
			 //player2 ship
		if(twoPlayerMode){
			 if(rocks[i]!=null && (rocks[i].rock.contains(playership2.p2x, playership2.p2y)||rocks[i].rock.contains(playership2.p1x, playership2.p1y)||rocks[i].rock.contains(playership2.p3x, playership2.p3y))  && rocks[i].size==3){
				 for(int k=0;k<2;k++){
			 	 rocks[rocknum] = new Rock();
			 	 System.out.println(rocknum);
			 	 rocks[rocknum].setSize(2);
			 	 shape=generator.nextInt(3)+1;
				 rocks[rocknum].setShape(shape);
				 rocks[rocknum].createPolygon();
				 if(k==0)
					 rocks[rocknum].setCenter((int)rocks[i].x-2, (int)rocks[i].y-2);
				 else
					 rocks[rocknum].setCenter((int)rocks[i].x+2, (int)rocks[i].y+2);
				 rocks[rocknum].setSpeed(.13f);
				 angle=(float) (generator.nextFloat()*2*Math.PI);
				 rocks[rocknum].setVelocityX(-(float) (Math.sin(angle)*rocks[rocknum].speed));
				 rocks[rocknum].setVelocityY(-(float) (Math.cos(angle)*rocks[rocknum].speed));
				 rocknum++;
				 }
				 rocksleft++;
				 calcScore(4);
				 rocks[i]=null;
				 if(!invincible2 && !unlimitedMode)
					 crash2();
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
			 if(rocks[i]!=null && (rocks[i].rock.contains(playership2.p2x, playership2.p2y)||rocks[i].rock.contains(playership2.p1x, playership2.p1y)||rocks[i].rock.contains(playership2.p3x, playership2.p3y)) && rocks[i].size==2){
				 for(int k=0;k<2;k++){
			 	 rocks[rocknum] = new Rock();
			 	 System.out.println(rocknum);
			 	 rocks[rocknum].setSize(1);
			 	 shape=generator.nextInt(3)+1;
				 rocks[rocknum].setShape(shape);
				 rocks[rocknum].createPolygon();
				 if(k==0)
					 rocks[rocknum].setCenter((int)rocks[i].x-1, (int)rocks[i].y-1);
				 else
					 rocks[rocknum].setCenter((int)rocks[i].x+1, (int)rocks[i].y+1);
				 rocks[rocknum].setSpeed(.2f);
				 angle=(float) (generator.nextFloat()*2*Math.PI);
				 rocks[rocknum].setVelocityX(-(float) (Math.sin(angle)*rocks[rocknum].speed));
				 rocks[rocknum].setVelocityY(-(float) (Math.cos(angle)*rocks[rocknum].speed));
				 rocknum++;
				 }	
				 rocksleft++;
				 rocks[i]=null;
				 calcScore(4);
				 if(!invincible2 && !unlimitedMode)
					 crash2();
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
			 if(rocks[i]!=null && (rocks[i].rock.contains(playership2.p2x, playership2.p2y)||rocks[i].rock.contains(playership2.p1x, playership2.p1y)||rocks[i].rock.contains(playership2.p3x, playership2.p3y)) && rocks[i].size==1){
				 rocks[i]=null;
				 rocksleft--;
				 calcScore(4);
				 if(!invincible2 && !unlimitedMode)
					 crash2();
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
		}
		 }
		 //aliens with rocks
		 for(int i=0;i<rocknum;i++){
			 for(int j=0;j<aliennum;j++){
			 if(rocks[i]!=null && aliens[i]!=null &&rocks[i].rock.intersects(aliens[j].x-15, aliens[j].y-12, 30, 24) && rocks[i].size==3){
				 for(int k=0;k<2;k++){
			 	 rocks[rocknum] = new Rock();
			 	 rocks[rocknum].setSize(2);
			 	 shape=generator.nextInt(3)+1;
				 rocks[rocknum].setShape(shape);
				 rocks[rocknum].createPolygon();
				 if(k==0)
					 rocks[rocknum].setCenter((int)rocks[i].x-2, (int)rocks[i].y-2);
				 else
					 rocks[rocknum].setCenter((int)rocks[i].x+2, (int)rocks[i].y+2);
				 rocks[rocknum].setSpeed(.13f);
				 angle=(float) (generator.nextFloat()*2*Math.PI);
				 rocks[rocknum].setVelocityX(-(float) (Math.sin(angle)*rocks[rocknum].speed));
				 rocks[rocknum].setVelocityY(-(float) (Math.cos(angle)*rocks[rocknum].speed));
				 rocknum++;
				 }
				 rocksleft++;
				 rocks[i]=null;
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
			 if(rocks[i]!=null && aliens[i]!=null &&rocks[i].rock.intersects(aliens[j].x-15, aliens[j].y-12, 30, 24) && rocks[i].size==2){
				 for(int k=0;k<2;k++){
			 	 rocks[rocknum] = new Rock();
			 	 System.out.println(rocknum);
			 	 rocks[rocknum].setSize(1);
			 	 shape=generator.nextInt(3)+1;
				 rocks[rocknum].setShape(shape);
				 rocks[rocknum].createPolygon();
				 if(k==0)
					 rocks[rocknum].setCenter((int)rocks[i].x-1, (int)rocks[i].y-1);
				 else
					 rocks[rocknum].setCenter((int)rocks[i].x+1, (int)rocks[i].y+1);
				 rocks[rocknum].setSpeed(.2f);
				 angle=(float) (generator.nextFloat()*2*Math.PI);
				 rocks[rocknum].setVelocityX(-(float) (Math.sin(angle)*rocks[rocknum].speed));
				 rocks[rocknum].setVelocityY(-(float) (Math.cos(angle)*rocks[rocknum].speed));
				 rocknum++;
				 }	
				 rocksleft++;
				 rocks[i]=null;
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
			 if(rocks[i]!=null && aliens[i]!=null && rocks[i].rock.intersects(aliens[j].x-15, aliens[j].y-12, 30, 24) && rocks[i].size==1){
				 rocks[i]=null;
				 rocksleft--;
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
			 }
		 }
		 //bullets collision 
		 for(int i=0;i<bulletnum;i++){
			 //with players
			 if(bullets[i]!=null && player1Life>0 && playership.ship.contains(bullets[i].x, bullets[i].y)&&bullets[i].owner!=0){
				 if(!invincible1 && !unlimitedMode)
					 crash1();
				 if(bullets[i].owner==2 && player1Life>0)
					 calcScore(6);
				 bullets[i]=null;	
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();
			 }
			 if(twoPlayerMode){
				 if(bullets[i]!=null && player2Life>0 && playership2.ship.contains(bullets[i].x, bullets[i].y)&&bullets[i].owner!=2){
					 if(!invincible2 && !unlimitedMode)
						 crash2();
					 if(bullets[i].owner==0 &&player2Life>0)
						 calcScore(2);
					 bullets[i]=null;	
					 new Thread() {
				            public void run() {
				            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
				            	explosionSound.play(explosionStream);
				            }
				        }.start();
				 }
			 }
			 for(int j=0;j<rocknum;j++){				 
				 //with rocks
				 if(rocks[j]!=null && bullets[i]!=null &&rocks[j].rock.contains(bullets[i].x, bullets[i].y) && rocks[j].size==3){
					 for(int k=0;k<2;k++){
					 	 rocks[rocknum] = new Rock();
					 	 rocks[rocknum].setSize(2);
					 	 shape=generator.nextInt(3)+1;
						 rocks[rocknum].setShape(shape);
						 rocks[rocknum].createPolygon();
						 if(k==0)
							 rocks[rocknum].setCenter((int)rocks[j].x-2, (int)rocks[j].y-2);
						 else
							 rocks[rocknum].setCenter((int)rocks[j].x+2, (int)rocks[j].y+2);
						 rocks[rocknum].setSpeed(.13f);
						 angle=(float) (generator.nextFloat()*2*Math.PI);
						 rocks[rocknum].setVelocityX(-(float) (Math.sin(angle)*rocks[rocknum].speed));
						 rocks[rocknum].setVelocityY(-(float) (Math.cos(angle)*rocks[rocknum].speed));
						 rocknum++;
						 }
					 rocksleft++;
					 rocks[j]=null;
					 if(bullets[i].owner==0)
						 calcScore(0);
					 else if(bullets[i].owner==2)
						 calcScore(2);
					 bullets[i]=null;
					 new Thread() {
				            public void run() {
				            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
				            	explosionSound.play(explosionStream);
				            }
				        }.start();
					 
				 }
				 if(rocks[j]!=null && bullets[i]!=null &&rocks[j].rock.contains(bullets[i].x, bullets[i].y) && rocks[j].size==2){
					 for(int k=0;k<2;k++){
				 	 rocks[rocknum] = new Rock();
				 	 System.out.println(rocknum);
				 	 rocks[rocknum].setSize(1);
				 	 shape=generator.nextInt(3)+1;
					 rocks[rocknum].setShape(shape);
					 rocks[rocknum].createPolygon();
					 if(k==0)
						 rocks[rocknum].setCenter((int)rocks[j].x-1, (int)rocks[j].y-1);
					 else
						 rocks[rocknum].setCenter((int)rocks[j].x+1, (int)rocks[j].y+1);
					 rocks[rocknum].setSpeed(.2f);
					 angle=(float) (generator.nextFloat()*2*Math.PI);
					 rocks[rocknum].setVelocityX(-(float) (Math.sin(angle)*rocks[rocknum].speed));
					 rocks[rocknum].setVelocityY(-(float) (Math.cos(angle)*rocks[rocknum].speed));
					 rocknum++;
					 }	
					 rocksleft++;
					 rocks[j]=null;
					 if(bullets[i].owner==0)
						 calcScore(0);
					 else if(bullets[i].owner==2)
						 calcScore(4);
					 bullets[i]=null;	
					 new Thread() {
				            public void run() {
				            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
				            	explosionSound.play(explosionStream);
				            }
				        }.start();
				 }
				 if(rocks[j]!=null && bullets[i]!=null &&rocks[j].rock.contains(bullets[i].x, bullets[i].y) && rocks[j].size==1){
					 if(bullets[i].owner==0)
						 calcScore(0);
					 else if(bullets[i].owner==2)
						 calcScore(4);
					 rocksleft--;
					 System.out.println("rocks:"+rocksleft);
					 rocks[j]=null;		
					 new Thread() {
				            public void run() {
				            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
				            	explosionSound.play(explosionStream);
				            }
				        }.start();
				 }
			 }
			 //bullets with alien ships
			 for(int j=0;j<aliennum;j++){
				 if(aliens[j]!=null && bullets[i]!=null &&aliens[j].boundbox.contains(bullets[i].x, bullets[i].y) && (bullets[i].owner==0||bullets[i].owner==2)){
					 if(aliens[j].getHit())
						 aliens[j]=null;
					 if(bullets[i].owner==0)
					 	calcScore(1);
					 else
						 calcScore(5);
					 bullets[i]=null;
					 new Thread() {
				            public void run() {
				            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
				            	explosionSound.play(explosionStream);
				            }
				        }.start();
				 }
			 }
			 for(int j=0;j<roguenum;j++){
				 if(rogues[j]!=null && bullets[i]!=null &&rogues[j].boundbox.contains(bullets[i].x, bullets[i].y) && (bullets[i].owner==0||bullets[i].owner==2)){
					 if(rogues[j].getHit())
						 rogues[j]=null;
					 if(bullets[i].owner==0)
					 	calcScore(1);
					 else
						 calcScore(5);
					 bullets[i]=null;
					 new Thread() {
				            public void run() {
				            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
				            	explosionSound.play(explosionStream);
				            }
				        }.start();
				 }
			 }
		 }
		 for(int i=0;i<aliennum;i++){
			 if(aliens[i]!=null && player1Life>0 && (aliens[i].boundbox.contains(playership.p2x, playership.p2y)||aliens[i].boundbox.contains(playership.p1x, playership.p1y)||aliens[i].boundbox.contains(playership.p3x, playership.p3y))){
				 if(aliens[i].getHit())
					 aliens[i]=null;
				 calcScore(1);
				 if(!invincible1 && !unlimitedMode)
					 crash1();
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();				 
			 }
			 if(twoPlayerMode && player2Life>0){
			 if(aliens[i]!=null && (aliens[i].boundbox.contains(playership2.p2x, playership2.p2y)||aliens[i].boundbox.contains(playership2.p1x, playership2.p1y)||aliens[i].boundbox.contains(playership2.p3x, playership2.p3y))){
				 if(aliens[i].getHit())
					 aliens[i]=null;
				 calcScore(5);
				 if(!invincible2 && !unlimitedMode)
					 crash2();
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();				 
			 }
			 }
		 }
		 for(int i=0;i<roguenum;i++){
			 if(rogues[i]!=null && player1Life>0 && (rogues[i].boundbox.contains(playership.p2x, playership.p2y)||rogues[i].boundbox.contains(playership.p1x, playership.p1y)||rogues[i].boundbox.contains(playership.p3x, playership.p3y))){
				 if(rogues[i].getHit())
					 rogues[i]=null;
				 calcScore(1);
				 if(!invincible1 && !unlimitedMode)
					 crash1();
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();				 
			 }
			 if(twoPlayerMode && player2Life>0){
			 if(rogues[i]!=null && (rogues[i].boundbox.contains(playership2.p2x, playership2.p2y)||rogues[i].boundbox.contains(playership2.p1x, playership2.p1y)||rogues[i].boundbox.contains(playership2.p3x, playership2.p3y))){
				 if(rogues[i].getHit())
					 rogues[i]=null;
				 calcScore(5);
				 if(!invincible2 && !unlimitedMode)
					 crash2();
				 new Thread() {
			            public void run() {
			            	explosionStream = new ByteArrayInputStream(explosionSound.getSamples());
			            	explosionSound.play(explosionStream);
			            }
			        }.start();				 
			 }
			 }
		 }
		}
	 }
	 private void fire(int owner){
		 Bullet bullet = new Bullet();
		 bullet.setOwner(owner);
		 bullet.setX(playership.p2x);
		 bullet.setY(playership.p2y);
		 bullet.setAngle(playership.getAngle());
		 bullet.setVelocityX(-(float) Math.sin(bullet.angle)*bullet.SPEED);
		 bullet.setVelocityY(-(float) Math.cos(bullet.angle)*bullet.SPEED);
		 bullets[bulletnum++]=bullet;	
		 LastBulletTime=System.currentTimeMillis();
		 new Thread() {
	            public void run() {
	            	bulletStream = new ByteArrayInputStream(bulletSound.getSamples());
	                bulletSound.play(bulletStream);
	            }
	        }.start();
	 }
	 private void fire2(int owner){
		 Bullet bullet = new Bullet();
		 bullet.setOwner(owner);
		 bullet.setX(playership2.p2x);
		 bullet.setY(playership2.p2y);
		 bullet.setAngle(playership2.getAngle());
		 bullet.setVelocityX(-(float) Math.sin(bullet.angle)*bullet.SPEED);
		 bullet.setVelocityY(-(float) Math.cos(bullet.angle)*bullet.SPEED);
		 bullets[bulletnum++]=bullet;	
		 LastBulletTime2=System.currentTimeMillis();
		 new Thread() {
	            public void run() {
	            	bulletStream = new ByteArrayInputStream(bulletSound.getSamples());
	                bulletSound.play(bulletStream);
	            }
	        }.start();
	 }
	 private void calcScore(int type){
		 //type
		 //0=asteroid, 1=alien ship, 2=player ship, 3=new level ,4-7=player 2
		 if(type==0&&player1Life>0)
			 score+=5;
		 else if(type==1&&player1Life>0)
			 score+=100;
		 else if(type==2&&player1Life>0)
			 score+=100;
		 else if(type==3&&player1Life>0)
			 score+=100;
		 else if(type==4&&player2Life>0)
			 score2+=5;
		 else if(type==5&&player2Life>0)
			 score2+=100;
		 else if(type==6&&player2Life>0)
			 score2+=100;
		 else if(type==7&&player2Life>0)
			 score2+=100;
	 }
	 private void createAlienShips(){
		 Alienship alien = new Alienship();
		 alien.setCenter(50, 300);
		 aliens[aliennum++]=alien;		 
	 }
	 private void createRogueShips(){
		 Rogueship rogue = new Rogueship();
		 rogue.setCenter(50, 100);
		 rogues[roguenum++]=rogue;		 
	 }
	 private void enemyFire(){
		 Random generator = new Random();
		 float ranAngle;
		 int target;
		 for(int i=0;i<aliennum;i++){
			 if(aliens[i]!=null){
				 if(aliens[i].nowTime-aliens[i].lastFireTime>1000){
					 Bullet bullet = new Bullet();
					 bullet.setOwner(1);
					 bullet.setX(aliens[i].x);
					 bullet.setY(aliens[i].y-14);
					 target=generator.nextInt(2);
					 if(twoPlayerMode){
					 if(target==0){
						 if(playership.y>aliens[i].y)
							 bullet.setAngle((float) (Math.atan((playership.x-aliens[i].x)/(playership.y-aliens[i].y))+Math.PI));
						 else
							 bullet.setAngle((float) (Math.atan((playership.x-aliens[i].x)/(playership.y-aliens[i].y))));						 
					 }
					 else{
						 if(playership2.y>aliens[i].y)
							 bullet.setAngle((float) (Math.atan((playership2.x-aliens[i].x)/(playership2.y-aliens[i].y))+Math.PI));
						 else
							 bullet.setAngle((float) (Math.atan((playership2.x-aliens[i].x)/(playership2.y-aliens[i].y))));
					 }
					 }
					 else{
						 if(playership.y>aliens[i].y)
							 bullet.setAngle((float) (Math.atan((playership.x-aliens[i].x)/(playership.y-aliens[i].y))+Math.PI));
						 else
							 bullet.setAngle((float) (Math.atan((playership.x-aliens[i].x)/(playership.y-aliens[i].y))));
					 }
						 
					 bullet.setVelocityX(-(float) Math.sin(bullet.angle)*bullet.SPEED);
					 bullet.setVelocityY(-(float) Math.cos(bullet.angle)*bullet.SPEED);
					 bullets[bulletnum++]=bullet;
					 aliens[i].lastFireTime=aliens[i].nowTime;
				 }
			 }
		 }		 
		 for(int i=0;i<roguenum;i++){
			 if(rogues[i]!=null){
				 if(rogues[i].nowTime-rogues[i].lastFireTime>1000){
					 Bullet bullet = new Bullet();
					 bullet.setOwner(1);
					 bullet.setX(rogues[i].x);
					 bullet.setY(rogues[i].y-12);
					 ranAngle = (float) (generator.nextFloat()*Math.PI);
					 bullet.setAngle(ranAngle);
					 bullet.setVelocityX(-(float) Math.sin(bullet.angle)*bullet.SPEED);
					 bullet.setVelocityY(-(float) Math.cos(bullet.angle)*bullet.SPEED);
					 bullets[bulletnum++]=bullet;
					 rogues[i].lastFireTime=rogues[i].nowTime;
				 }
			 }
		 }
	 }
	 private void enemySpawn(long elapsedTime){
		 if(!paused){
		 enemySpawnStackTime += elapsedTime;
		 if(enemySpawnFlag==0){
			 enemySpawnControlTime = enemySpawnRan.nextInt(4000)+13000;
		 }
		 if(enemySpawnStackTime>enemySpawnControlTime){
			 enemySpawnStackTime=0;
			 if(enemySpawnRan.nextInt(2)==1){
				 createAlienShips();
			 }
			 else
				 createRogueShips();
		 }
		 }
	 }
	 private void flysound(long elapsedTime){
		 nowFlyTime+=elapsedTime;
		 if(nowFlyTime-lastFlyTime>400){
			 lastFlyTime=nowFlyTime;
			 new Thread() {
	            public void run() {
	            	flyStream = new ByteArrayInputStream(flySound.getSamples());
	                flySound.play(flyStream);
	            }
	        }.start();
		 }
	 }
	 private void delectLevelUp(Graphics2D g){
			 if(rocksleft==0 && !gameOverFlag){
				 level+=1;
				 uplevel(level);
				 setPaused(!isPaused());
				 levelTransision=1;	
				 calcScore(3);
				 if(twoPlayerMode)
					 calcScore(7);
		 }
	 }
	 public JButton createButton(String name, String toolTip) {

	        // load the image
	        String imagePath = "../images/menu/" + name + ".png";
	        ImageIcon iconRollover = new ImageIcon(imagePath);
	        int w = iconRollover.getIconWidth();
	        int h = iconRollover.getIconHeight();

	        // get the cursor for this button
	        Cursor cursor =
	            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

	        // make translucent default image
	        Image image = screen.createCompatibleImage(w, h,
	            Transparency.TRANSLUCENT);
	        Graphics2D g = (Graphics2D)image.getGraphics();
	        Composite alpha = AlphaComposite.getInstance(
	            AlphaComposite.SRC_OVER, .5f);
	        g.setComposite(alpha);
	        g.drawImage(iconRollover.getImage(), 0, 0, null);
	        g.dispose();
	        ImageIcon iconDefault = new ImageIcon(image);

	        // make a pressed iamge
	        image = screen.createCompatibleImage(w, h,
	            Transparency.TRANSLUCENT);
	        g = (Graphics2D)image.getGraphics();
	        g.drawImage(iconRollover.getImage(), 2, 2, null);
	        g.dispose();
	        ImageIcon iconPressed = new ImageIcon(image);

	        // create the button
	        JButton button = new JButton();
	        button.addActionListener(this);
	        button.setIgnoreRepaint(true);
	        button.setFocusable(false);
	        button.setToolTipText(toolTip);
	        button.setBorder(null);
	        button.setContentAreaFilled(false);
	        button.setCursor(cursor);
	        button.setIcon(iconDefault);
	        button.setRolloverIcon(iconRollover);
	        button.setPressedIcon(iconPressed);
	        return button;
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		type(src);
		handleSettings(src);
		if (src == playButton) {
            // fire the "pause" gameAction
            pause.tap();
        }
		if(src == singleButton){
			twoPlayerMode=false;
			paused=false;
			createship();
			playership.setPoints(400, 400, 400, 400, 400, 400);
			cancelButtons();
			inWelcome=false;
			System.out.println(inWelcome);
			restartgame();
			update(0);
		}
		if(src == vsButton){
			twoPlayerMode=true;	
			paused=false;
			createship();				
			playership.setPoints(400, 400, 400, 400, 400, 400);
			playership2.setPoints(400, 400, 400, 400, 400, 400);
			update(0);
			cancelButtons();
			inWelcome=false;
			restartgame();			
		}
		if(src == highButton){
			showHigh=true;
			returnButton1.setVisible(true);
			cancelButtons();
		}
		if(src == returnButton1){
			returnButton1.setVisible(false);
			showHigh=false;
			enableButtons();
		}
		if(src == yesButtonHigh){
			if(ifCanSaveHigh())
				enterName=true;
			else if(twoPlayerMode && ifCanSaveHigh2())
				enterName2=true;
			yesButtonHigh.setVisible(false);
			noButtonHigh.setVisible(false);
			playButton.setVisible(false);
			returnButtonMenu.setVisible(false);
			saveButton.setVisible(false);
			enableLetter();
		}
		if(src == returnButtonLetter){
			inWelcome=true;
			showHigh=false;
			enterName=false;
			enableButtons();
			disableLetter();
			restartgame();
		}
		if(src == saveButtonLetter){
			if(enterName && !enterName2){
				saveHigh();
				if(ifCanSaveHigh2())
					enterName2=true;
			}
			else if(twoPlayerMode && enterName2)
				saveHigh2();
		}
		if(src == quitButton){
			stop();
		}
		if(src == clearHighButton)
			resetHigh();
		if(src == saveButton){
			saveGame();
		}
		if(src == settingButton){
			cancelButtons();
			enableSetting();
			setting=true;
		}
		if(src == returnButtonSetting){
			enableButtons();
			disableSetting();
			setting=false;
		}
		if(src == returnButtonMenu){
			if(ifCanSaveHigh()){
				gameOverFlag=true;
				yesButtonHigh.setVisible(true);
				noButtonHigh.setVisible(true);
			}
			else if(twoPlayerMode && ifCanSaveHigh2()){
				gameOverFlag=true;
				yesButtonHigh.setVisible(true);
				noButtonHigh.setVisible(true);
			}
			else{
			enableButtons();
			setPaused(!isPaused());
			inWelcome=true;
			}
		}
		if(src == loadButton){
			try {
				loadGame();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(src == noButtonHigh){
			inWelcome=true;
			yesButtonHigh.setVisible(false);
			noButtonHigh.setVisible(false);
			playButton.setVisible(false);
			returnButtonMenu.setVisible(false);
			saveButton.setVisible(false);
			enableButtons();
		}
	}
	private void drawLife1(Graphics2D g){
		int x1[]={15,23,31,23};
		int y1[]={590,565,590,585};
		int x2[]={45,53,61,53};
		int x3[]={75,83,91,83};
		if(player1Life>=3){
			g.drawPolygon(x1, y1, 4);
			g.drawPolygon(x2,y1,4);
			g.drawPolygon(x3,y1,4);
		}
		else if(player1Life==2){
			g.drawPolygon(x1, y1, 4);
			g.drawPolygon(x2,y1,4);
		}
		else if(player1Life==1){
			g.drawPolygon(x1, y1, 4);
		}			
	}
	private void drawLife2(Graphics2D g){
		int x1[]={715,723,731,723};
		int y1[]={590,565,590,585};
		int x2[]={745,753,761,753};
		int x3[]={775,783,791,783};
		if(player2Life>=3){
			g.drawPolygon(x1, y1, 4);
			g.drawPolygon(x2,y1,4);
			g.drawPolygon(x3,y1,4);
		}
		else if(player2Life==2){
			g.drawPolygon(x1, y1, 4);
			g.drawPolygon(x2,y1,4);
		}
		else if(player2Life==1){
			g.drawPolygon(x1, y1, 4);
		}			
	}
	private void crash1(){
		player1Life-=1;
		System.out.println(player1Life+","+player2Life);
		if(twoPlayerMode){
			if(player1Life<=0 && player2Life<=0 && !gameOverFlag)
				gameover();
		}
		else{
			if(player1Life<=0 && !gameOverFlag)
				gameover();
		}
		playership.setX(300f);
		playership.setY(250f);
		invincible1=true;
	}
	private void crash2(){
		player2Life-=1;
		if(twoPlayerMode){
			if(player1Life<=0 && player2Life<=0 && !gameOverFlag)
				gameover();
		}
		playership2.setX(500f);
		playership2.setY(250f);
		invincible2=true;
	}
	private void cancelInvincible(long elapsedTime){
		if(invincible1==true){
			invincibleTime1+=elapsedTime;
			if(invincibleTime1>1000){
				invincibleTime1=0;
				invincible1=false;
			}
		}
		if(twoPlayerMode){
			if(invincible2==true){
				invincibleTime2+=elapsedTime;
				if(invincibleTime2>1000){
					invincibleTime2=0;
					invincible2=false;
				}
			}
		}
		
	}
	private void gameover(){
		gameOverFlag=true;
		level=1;
		if(ifCanSaveHigh()){
			yesButtonHigh.setVisible(true);
			noButtonHigh.setVisible(true);
		}
		else if(twoPlayerMode && ifCanSaveHigh2()){
			yesButtonHigh.setVisible(true);
			noButtonHigh.setVisible(true);
		}
		//saveHigh();
	}
	private void cancelButtons(){
		vsButton.setVisible(false);
		settingButton.setVisible(false);
		singleButton.setVisible(false);
		highButton.setVisible(false);
		quitButton.setVisible(false);
		clearHighButton.setVisible(false);
		loadButton.setVisible(false);
	}
	private void enableButtons(){
		vsButton.setVisible(true);
		settingButton.setVisible(true);
		singleButton.setVisible(true);
		highButton.setVisible(true);
		quitButton.setVisible(true);
		clearHighButton.setVisible(true);
		loadButton.setVisible(true);
	}
	private void readHighScores(){
		int loadcount=0;
		highScores = new int[10];
		highNames = new String[10];
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader("../highscore/highscore.txt"));
	        //StringBuilder sb = new StringBuilder();
	        String line = br.readLine();
	        while (line != null) {
	        	String parts[] = new String[2];
	        	parts = line.split(",");
	        	highNames[loadcount]=parts[0];
	        	highScores[loadcount++]=Integer.parseInt(parts[1]);
	            line = br.readLine();
	        }
	        for(int i=loadcount;i<10;i++){
	        	highNames[i]="Unknown";
	        	highScores[i]=900-100*i;
	        }
	        br.close();
	    }
	    catch(Exception e){
	    }
	}
	private boolean ifCanSaveHigh(){
		savePos=0;
		for(int i=0;i<10;i++){
			if(score>highScores[i]){
				savePos=i;
				return true;
			}
		}
		return false;
	}
	private boolean ifCanSaveHigh2(){
	  if(twoPlayerMode){
		savePos=0;
		for(int i=0;i<10;i++){
			if(score2>highScores[i]){
				savePos=i;
				return true;
			}
		}
		return false;
	  }
	  return false;
	}
	private void saveHigh(){
		if(ifCanSaveHigh()){
			highScores[savePos]=score;
			if(!nameString1.equals(""))
				highNames[savePos]=nameString1;
			else
				highNames[savePos]="anonymous";
			File file = new File("../highscore/highscore.txt");
			FileWriter fw;
			try {
				fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				for(int i=0;i<10;i++){
					bw.write(highNames[i]+","+highScores[i]);
					if(i<9)
						bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	private void saveHigh2(){
		if(ifCanSaveHigh2()){
			highScores[savePos]=score2;
			if(!nameString2.equals(""))
				highNames[savePos]=nameString2;
			else
				highNames[savePos]="anonymous";
			File file = new File("../highscore/highscore.txt");
			FileWriter fw;
			try {
				fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				for(int i=0;i<10;i++){
					bw.write(highNames[i]+","+highScores[i]);
					if(i<9)
						bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	private void addLetterButtons(Container c){
		A = createButton("A","");
		B = createButton("B","");
		C = createButton("C","");
		D = createButton("D","");
		E = createButton("E","");
		F = createButton("F","");
		G = createButton("G","");
		H = createButton("H","");
		I = createButton("I","");
		J = createButton("J","");
		K = createButton("K","");
		L = createButton("L","");
		M = createButton("M","");
		N = createButton("N","");
		O = createButton("O","");
		P = createButton("P","");
		Q = createButton("Q","");
		R = createButton("R","");
		S = createButton("S","");
		T = createButton("T","");
		U = createButton("U","");
		V = createButton("V","");
		W = createButton("W","");
		X = createButton("X","");
		Y = createButton("Y","");
		Z = createButton("Z","");
		returnButtonLetter = createButton("return","Return to main menu");
		saveButtonLetter = createButton("Save","Save high score");
		A.setBounds(10, 50, 70, 80);
		B.setBounds(90, 50, 70, 80);
		C.setBounds(170, 50, 70, 80);
		D.setBounds(250, 50, 70, 80);
		E.setBounds(330, 50, 70, 80);
		F.setBounds(410, 50, 70, 80);
		G.setBounds(490, 50, 70, 80);
		H.setBounds(570, 50, 70, 80);
		I.setBounds(10, 140, 70, 80);
		J.setBounds(90, 140, 70, 80);
		K.setBounds(170, 140, 70, 80);
		L.setBounds(250, 140, 70, 80);
		M.setBounds(330, 140, 70, 80);
		N.setBounds(410, 140, 70, 80);
		O.setBounds(490, 140, 70, 80);
		P.setBounds(570, 140, 70, 80);
		Q.setBounds(10, 230, 70, 80);
		R.setBounds(90, 230, 70, 80);
		S.setBounds(170, 230, 70, 80);
		T.setBounds(250, 230, 70, 80);
		U.setBounds(330, 230, 70, 80);
		V.setBounds(410, 230, 70, 80);
		W.setBounds(490, 230, 70, 85);
		X.setBounds(570, 230, 70, 80);
		Y.setBounds(10, 320, 70, 80);
		Z.setBounds(90, 320, 70, 80);
		returnButtonLetter.setBounds(450, 400, 64, 64);
		saveButtonLetter.setBounds(100, 450, 145, 61);
		A.setVisible(false);
		B.setVisible(false);
		C.setVisible(false);
		D.setVisible(false);
		E.setVisible(false);
		F.setVisible(false);
		G.setVisible(false);
		H.setVisible(false);
		I.setVisible(false);
		J.setVisible(false);
		K.setVisible(false);
		L.setVisible(false);
		M.setVisible(false);
		N.setVisible(false);
		O.setVisible(false);
		P.setVisible(false);
		Q.setVisible(false);
		R.setVisible(false);
		S.setVisible(false);
		T.setVisible(false);
		U.setVisible(false);
		V.setVisible(false);
		W.setVisible(false);
		X.setVisible(false);
		Y.setVisible(false);
		Z.setVisible(false);
		returnButtonLetter.setVisible(false);
		saveButtonLetter.setVisible(false);
		c.add(A);
		c.add(B);
		c.add(C);
		c.add(D);
		c.add(E);
		c.add(F);
		c.add(G);
		c.add(H);
		c.add(I);
		c.add(J);
		c.add(K);
		c.add(L);
		c.add(M);
		c.add(N);
		c.add(O);
		c.add(P);
		c.add(Q);
		c.add(R);
		c.add(S);
		c.add(T);
		c.add(U);
		c.add(V);
		c.add(W);
		c.add(X);
		c.add(Y);
		c.add(X);	
		c.add(Z);
		c.add(returnButtonLetter);
		c.add(saveButtonLetter);
	}
	private void addSettingButtons(Container c){
		onButtonExist = createButton("On","Turn on gravitational object");
		onButtonExist.setVisible(false);
		onButtonExist.setBounds(300, 60, 50, 45);
		c.add(onButtonExist);
		
		offButtonExist = createButton("Off","Turn off gravitational object");
		offButtonExist.setVisible(false);
		offButtonExist.setBounds(400, 60, 70, 45);
		c.add(offButtonExist);
		
		onButtonShow = createButton("On","Show gravitational object");
		onButtonShow.setVisible(false);
		onButtonShow.setBounds(300, 160, 50, 45);
		c.add(onButtonShow);
		
		offButtonShow = createButton("Off","Don't show gravitational object");
		offButtonShow.setVisible(false);
		offButtonShow.setBounds(400, 160, 70, 45);
		c.add(offButtonShow);
		
		onButtonUnlimited = createButton("On","Turn on unlimited Life");
		onButtonUnlimited.setVisible(false);
		onButtonUnlimited.setBounds(300, 260, 50, 45);
		c.add(onButtonUnlimited);
		
		offButtonUnlimited = createButton("Off","Don't show gravitational object");
		offButtonUnlimited.setVisible(false);
		offButtonUnlimited.setBounds(400, 260, 70, 45);
		c.add(offButtonUnlimited);
		
		addButtonAst = createButton("+","Add 1");
		addButtonAst.setVisible(false);
		addButtonAst.setBounds(300, 360, 28, 32);
		c.add(addButtonAst);
		
		minusButtonAst = createButton("-","Subtract 1");
		minusButtonAst.setVisible(false);
		minusButtonAst.setBounds(400, 360, 28, 32);
		c.add(minusButtonAst);
		
		addButtonLevel = createButton("+","Add 1");
		addButtonLevel.setVisible(false);
		addButtonLevel.setBounds(300, 460, 28, 32);
		c.add(addButtonLevel);
		
		minusButtonLevel = createButton("-","Subtract 1");
		minusButtonLevel.setVisible(false);
		minusButtonLevel.setBounds(400, 460, 28, 32);
		c.add(minusButtonLevel);
		
		returnButtonSetting = createButton("return","Return to previous page");
		returnButtonSetting.setVisible(false);
		returnButtonSetting.setBounds(600, 450, 64, 64);
		c.add(returnButtonSetting);
	}
	private void enableSetting(){
		 onButtonExist.setVisible(true);
	     offButtonExist.setVisible(true);
	     onButtonShow.setVisible(true);
	     offButtonShow.setVisible(true);
	     onButtonUnlimited.setVisible(true);
	     offButtonUnlimited.setVisible(true);
	     addButtonAst.setVisible(true);
	     minusButtonAst.setVisible(true);
	     addButtonLevel.setVisible(true);
	     minusButtonLevel.setVisible(true);
	     returnButtonSetting.setVisible(true);
	}
	private void disableSetting(){
		 onButtonExist.setVisible(false);
	     offButtonExist.setVisible(false);
	     onButtonShow.setVisible(false);
	     offButtonShow.setVisible(false);
	     onButtonUnlimited.setVisible(false);
	     offButtonUnlimited.setVisible(false);
	     addButtonAst.setVisible(false);
	     minusButtonAst.setVisible(false);
	     addButtonLevel.setVisible(false);
	     minusButtonLevel.setVisible(false);
	     returnButtonSetting.setVisible(false);
	}
	private void handleSettings(Object src){
		if(src == onButtonExist){
			gravEnable=1;
			onButtonShow.setVisible(true);
			offButtonShow.setVisible(true);
		}
		if(src == offButtonExist){
			gravEnable=0;
			onButtonShow.setVisible(false);
			offButtonShow.setVisible(false);
		}
		if(src == onButtonShow)
			gravVisible=true;
		if(src == offButtonShow)
			gravVisible=false;
		if(src == onButtonUnlimited)
			unlimitedMode=true;
		if(src == offButtonUnlimited)
			unlimitedMode=false;
		if(src == addButtonAst)
			astnum++;
		if(src == minusButtonAst && astnum>1)
			astnum--;
		if(src == addButtonLevel)
			level++;
		if(src == minusButtonLevel && level>1)
			level--;
		
	}
	private void disableLetter(){
		A.setVisible(false);
		B.setVisible(false);
		C.setVisible(false);
		D.setVisible(false);
		E.setVisible(false);
		F.setVisible(false);
		G.setVisible(false);
		H.setVisible(false);
		I.setVisible(false);
		J.setVisible(false);
		K.setVisible(false);
		L.setVisible(false);
		M.setVisible(false);
		N.setVisible(false);
		O.setVisible(false);
		P.setVisible(false);
		Q.setVisible(false);
		R.setVisible(false);
		S.setVisible(false);
		T.setVisible(false);
		U.setVisible(false);
		V.setVisible(false);
		W.setVisible(false);
		X.setVisible(false);
		Y.setVisible(false);
		Z.setVisible(false);
		returnButtonLetter.setVisible(false);
		saveButtonLetter.setVisible(false);
	}
    private void enableLetter(){
    	A.setVisible(true);
		B.setVisible(true);
		C.setVisible(true);
		D.setVisible(true);
		E.setVisible(true);
		F.setVisible(true);
		G.setVisible(true);
		H.setVisible(true);
		I.setVisible(true);
		J.setVisible(true);
		K.setVisible(true);
		L.setVisible(true);
		M.setVisible(true);
		N.setVisible(true);
		O.setVisible(true);
		P.setVisible(true);
		Q.setVisible(true);
		R.setVisible(true);
		S.setVisible(true);
		T.setVisible(true);
		U.setVisible(true);
		V.setVisible(true);
		W.setVisible(true);
		X.setVisible(true);
		Y.setVisible(true);
		Z.setVisible(true);
		returnButtonLetter.setVisible(true);
		saveButtonLetter.setVisible(true);
    }
    private void type(Object src){
    	if(nameLength1<5 && enterName && !enterName2){
    		if(src==A){
    			nameString1+="A";
    			nameLength1++;
    		}
    		else if(src==B){
    			nameString1+="B";
    			nameLength1++;
    		}
    		else if(src==C){
    			nameString1+="C";
    			nameLength1++;
    		}
    		else if(src==D){
    			nameString1+="D";
    			nameLength1++;
    		}
    		else if(src==E){
    			nameString1+="E";
    			nameLength1++;
    		}
    		else if(src==F){
    			nameString1+="F";
    			nameLength1++;
    		}
    		else if(src==G){
    			nameString1+="G";
    			nameLength1++;
    		}
    		else if(src==H){
    			nameString1+="H";
    			nameLength1++;
    		}
    		else if(src==I){
    			nameString1+="I";
    			nameLength1++;
    		}
    		else if(src==J){
    			nameString1+="J";
    			nameLength1++;
    		}
    		else if(src==K){
    			nameString1+="K";
    			nameLength1++;
    		}
    		else if(src==L){
    			nameString1+="L";
    			nameLength1++;
    		}
    		else if(src==M){
    			nameString1+="M";
    			nameLength1++;
    		}
    		else if(src==N){
    			nameString1+="N";
    			nameLength1++;
    		}
    		else if(src==O){
    			nameString1+="O";
    			nameLength1++;
    		}
    		else if(src==P){
    			nameString1+="P";
    			nameLength1++;
    		}
    		else if(src==Q){
    			nameString1+="Q";
    			nameLength1++;
    		}
    		else if(src==R){
    			nameString1+="R";
    			nameLength1++;
    		}
    		else if(src==S){
    			nameString1+="S";
    			nameLength1++;
    		}
    		else if(src==T){
    			nameString1+="T";
    			nameLength1++;
    		}
    		else if(src==U){
    			nameString1+="U";
    			nameLength1++;
    		}
    		else if(src==V){
    			nameString1+="V";
    			nameLength1++;
    		}
    		else if(src==W){
    			nameString1+="W";
    			nameLength1++;
    		}
    		else if(src==X){
    			nameString1+="X";
    			nameLength1++;
    		}
    		else if(src==Y){
    			nameString1+="Y";
    			nameLength1++;
    		}
    		else if(src==Z){
    			nameString1+="Z";
    			nameLength1++;
    		}
    	}
    	if(nameLength2<5 && enterName2){
    		if(src==A){
    			nameString1+="A";
    			nameLength2++;
    		}
    		else if(src==B){
    			nameString2+="B";
    			nameLength2++;
    		}
    		else if(src==C){
    			nameString2+="C";
    			nameLength2++;
    		}
    		else if(src==D){
    			nameString2+="D";
    			nameLength2++;
    		}
    		else if(src==E){
    			nameString2+="E";
    			nameLength2++;
    		}
    		else if(src==F){
    			nameString2+="F";
    			nameLength2++;
    		}
    		else if(src==G){
    			nameString2+="G";
    			nameLength2++;
    		}
    		else if(src==H){
    			nameString2+="H";
    			nameLength2++;
    		}
    		else if(src==I){
    			nameString2+="I";
    			nameLength2++;
    		}
    		else if(src==J){
    			nameString2+="J";
    			nameLength2++;
    		}
    		else if(src==K){
    			nameString2+="K";
    			nameLength2++;
    		}
    		else if(src==L){
    			nameString2+="L";
    			nameLength2++;
    		}
    		else if(src==M){
    			nameString2+="M";
    			nameLength2++;
    		}
    		else if(src==N){
    			nameString2+="N";
    			nameLength2++;
    		}
    		else if(src==O){
    			nameString2+="O";
    			nameLength2++;
    		}
    		else if(src==P){
    			nameString2+="P";
    			nameLength2++;
    		}
    		else if(src==Q){
    			nameString2+="Q";
    			nameLength2++;
    		}
    		else if(src==R){
    			nameString2+="R";
    			nameLength2++;
    		}
    		else if(src==S){
    			nameString2+="S";
    			nameLength2++;
    		}
    		else if(src==T){
    			nameString2+="T";
    			nameLength2++;
    		}
    		else if(src==U){
    			nameString2+="U";
    			nameLength2++;
    		}
    		else if(src==V){
    			nameString2+="V";
    			nameLength2++;
    		}
    		else if(src==W){
    			nameString2+="W";
    			nameLength2++;
    		}
    		else if(src==X){
    			nameString2+="X";
    			nameLength2++;
    		}
    		else if(src==Y){
    			nameString2+="Y";
    			nameLength2++;
    		}
    		else if(src==Z){
    			nameString2+="Z";
    			nameLength2++;
    		}
    	}
    }
    private void resetHigh(){
    	for(int i=0;i<10;i++){
        	highNames[i]="Unknown";
        	highScores[i]=900-100*i;
        }
    	File file = new File("../highscore/highscore.txt");
		FileWriter fw;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<10;i++){
				bw.write(highNames[i]+","+highScores[i]);
				if(i<9)
					bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void saveGame(){
    	int bulletleft=0;
    	int alienleft=0;
    	int rogueleft=0;
    	fc.setFileFilter(new FileNameExtensionFilter("Asteroid save file","atr"));
    	int returnVal = fc.showSaveDialog(null);
    	if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String name = file.toString();
			if(!name.endsWith(".atr")){
				name+=".atr";
				file = new File(name);
			}
            //This is where a real application would save the file.
            try {
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("twoPlayerMode:"+twoPlayerMode);bw.newLine();
				bw.write("level:"+level);bw.newLine();
				bw.write("Player1");bw.newLine();
				bw.write("score:"+score);bw.newLine();
				bw.write("player1Life:"+player1Life);bw.newLine();
				bw.write(playership.x+","+playership.y);bw.newLine();
				bw.write(playership.dx+","+playership.dy);bw.newLine();
				bw.write(""+playership.getAngle());bw.newLine();
				if(twoPlayerMode){
					bw.write("Player2");bw.newLine();
					bw.write("score:"+score2);bw.newLine();
					bw.write("player2Life:"+player2Life);bw.newLine();
					bw.write(playership2.x+","+playership2.y);bw.newLine();
					bw.write(playership2.dx+","+playership2.dy);bw.newLine();
					bw.write(""+playership2.getAngle());bw.newLine();
				}
				bw.write("rocknum:"+rocksleft);bw.newLine();
				int ct=0;
				for(int i=0;i<rocknum;i++){
					if(rocks[i]!=null){
						bw.write(rocks[i].x+","+rocks[i].y);bw.newLine();
						bw.write(rocks[i].dx+","+rocks[i].dy);bw.newLine();
						bw.write(""+rocks[i].shape);bw.newLine();
						bw.write(""+rocks[i].size);bw.newLine();
					}
				}
				for(int i=0;i<bulletnum;i++){
					if(bullets[i]!=null)
						bulletleft++;
				}
				ct=0;
				bw.write("Bulletnum:"+bulletleft);bw.newLine();
				for(int i=0;i<bulletnum;i++){
					if(bullets[i]!=null){
						bw.write(bullets[i].x+","+bullets[i].y);bw.newLine();
						bw.write(bullets[i].dx+","+bullets[i].dy);bw.newLine();
						bw.write(""+bullets[i].owner);bw.newLine();
					}
				}
				for(int i=0;i<aliennum;i++){
					if(aliens[i]!=null)
						alienleft++;
				}
				ct=0;
				bw.write("aliennum:"+alienleft);bw.newLine();
				for(int i=0;i<aliennum;i++){
					if(aliens[i]!=null){
						bw.write(aliens[i].x+","+aliens[i].y);bw.newLine();
						bw.write(aliens[i].dx+","+aliens[i].dy);bw.newLine();
					}
				}
				for(int i=0;i<roguenum;i++){
					if(rogues[i]!=null)
						rogueleft++;
				}
				ct=0;
				bw.write("roguenum:"+roguenum);bw.newLine();
				for(int i=0;i<rogueleft;i++){
					if(rogues[i]!=null){
						bw.write(rogues[i].x+","+rogues[i].y);bw.newLine();
						bw.write(rogues[i].dx+","+rogues[i].dy);bw.newLine();
					}
				}
				bw.write("gravEnable:"+gravEnable);bw.newLine();
				bw.write("gravVisible:"+gravVisible);bw.newLine();
				bw.write("unlimitedMode:"+unlimitedMode);
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
    }
    private void loadGame() throws IOException{
    	fc.setFileFilter(new FileNameExtensionFilter("Asteroid save file","atr"));
    	int returnVal = fc.showOpenDialog(null);
    	String parts[] = new String[2];
    	if (returnVal == JFileChooser.APPROVE_OPTION) {
	        //StringBuilder sb = new StringBuilder();
    		File file = fc.getSelectedFile();
    		String name = file.toString();
			if(!name.endsWith(".atr")){
				name+=".atr";
				file = new File(name);
			}
    		FileReader fr;
    		String line;
			fr = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fr); 
			line = br.readLine();
			parts = line.split(":");
			if(parts[1].equals("true"))
				twoPlayerMode=true;
			else
				twoPlayerMode=false;
			line = br.readLine();
			parts = line.split(":");
			level=Integer.parseInt(parts[1]);
			line = br.readLine();
			line = br.readLine();
			parts = line.split(":");
			score=Integer.parseInt(parts[1]);
			line = br.readLine();
			parts = line.split(":");
			player1Life=Integer.parseInt(parts[1]);
			createship();
			line = br.readLine();
			parts = line.split(",");
			playership.setX(Float.parseFloat(parts[0]));
			playership.setY(Float.parseFloat(parts[1]));
			line = br.readLine();
			parts = line.split(",");
			playership.setVelocityX(Float.parseFloat(parts[0]));
			playership.setVelocityY(Float.parseFloat(parts[1]));
			line = br.readLine();
			playership.setAngle(Float.parseFloat(line));
			playership.createPolygon();
			if(twoPlayerMode){
				line = br.readLine();
				line = br.readLine();
				parts = line.split(":");
				score2=Integer.parseInt(parts[1]);
				line = br.readLine();
				parts = line.split(":");
				player2Life=Integer.parseInt(parts[1]);
				line = br.readLine();
				parts = line.split(",");
				playership2.setX(Float.parseFloat(parts[0]));
				playership2.setY(Float.parseFloat(parts[1]));
				line = br.readLine();
				parts = line.split(",");
				playership2.setVelocityX(Float.parseFloat(parts[0]));
				playership2.setVelocityY(Float.parseFloat(parts[1]));
				line = br.readLine();
				playership2.setAngle(Float.parseFloat(line));
				playership2.createPolygon();
			}
			line = br.readLine();
			parts = line.split(":");
			rocknum=Integer.parseInt(parts[1]);
			rocks=new Rock[500*level];
			for(int i=0;i<rocknum;i++){
				rocks[i]=new Rock();
				line = br.readLine();
				parts = line.split(",");
				rocks[i].setX(Float.parseFloat(parts[0]));
				rocks[i].setY(Float.parseFloat(parts[1]));
				line = br.readLine();
				parts = line.split(",");
				rocks[i].setVelocityX(Float.parseFloat(parts[0]));
				rocks[i].setVelocityY(Float.parseFloat(parts[1]));
				line = br.readLine();
				rocks[i].setShape(Integer.parseInt(line));
				line = br.readLine();
				rocks[i].setSize(Integer.parseInt(line));
				rocks[i].createPolygon();
				rocks[i].update(0);
			}
			line = br.readLine();
			parts = line.split(":");
			bulletnum=Integer.parseInt(parts[1]);
			bullets=new Bullet[5000*level];
			for(int i=0;i<bulletnum;i++){
				bullets[i]=new Bullet();
				line = br.readLine();
				parts = line.split(",");
				bullets[i].setX(Float.parseFloat(parts[0]));
				bullets[i].setY(Float.parseFloat(parts[1]));
				line = br.readLine();
				parts = line.split(",");
				bullets[i].setVelocityX(Float.parseFloat(parts[0]));
				bullets[i].setVelocityY(Float.parseFloat(parts[1]));
				line = br.readLine();
				bullets[i].setOwner(Integer.parseInt(line));
				bullets[i].update(0);
			}
			line = br.readLine();
			parts = line.split(":");
		    aliennum=Integer.parseInt(parts[1]);
		    aliens=new Alienship[100*level];
		    for(int i=0;i<aliennum;i++){
		    	aliens[i]=new Alienship();
		    	line = br.readLine();
				parts = line.split(",");
				aliens[i].setX(Float.parseFloat(parts[0]));
				aliens[i].setY(Float.parseFloat(parts[1]));
				line = br.readLine();
				parts = line.split(",");
				aliens[i].setVelocityX(Float.parseFloat(parts[0]));
				aliens[i].setVelocityY(Float.parseFloat(parts[1]));
				aliens[i].createPolygon();
				aliens[i].update(0);
		    }
		    line = br.readLine();
			parts = line.split(":");
		    roguenum=Integer.parseInt(parts[1]);
		    rogues=new Rogueship[100*level];
		    for(int i=0;i<roguenum;i++){
		    	rogues[i]=new Rogueship();
		    	line = br.readLine();
				parts = line.split(",");
				rogues[i].setX(Float.parseFloat(parts[0]));
				rogues[i].setY(Float.parseFloat(parts[1]));
				line = br.readLine();
				parts = line.split(",");
				rogues[i].setVelocityX(Float.parseFloat(parts[0]));
				rogues[i].setVelocityY(Float.parseFloat(parts[1]));
				rogues[i].createPolygon();
				rogues[i].update(0);
		    }
		    line = br.readLine();
			parts = line.split(":");
		    gravEnable = Integer.parseInt(parts[1]);
		    line = br.readLine();
			parts = line.split(":");
		    gravVisible = Boolean.parseBoolean(parts[1]);
		    line = br.readLine();
			parts = line.split(":");
			unlimitedMode = Boolean.parseBoolean(parts[1]);
            cancelButtons();
            ThisBulletTime=System.currentTimeMillis();
    		ThisBulletTime2=System.currentTimeMillis();
    		LastBulletTime=System.currentTimeMillis();
    		LastBulletTime2=System.currentTimeMillis();
    		enemySpawnFlag = 0;
    		enemySpawnControlTime = 0;
    		enemySpawnStackTime = 0;
    		levelTransision=0;
    		enterName=false;
    		enterName2=false;
    		readHighScores();
    		setPaused(true);
    		inWelcome=false;
    		System.out.println("done");
    		
        }
    }
}
