package com.view;

import com.listener.*;
import com.model.Barrier;
import com.model.bullet.Bullet;
import com.model.tank.EnemyTank;
import com.model.tank.PlayerTank;
import com.running.*;
import com.util.Util;

import javax.swing.*;
import java.util.ArrayList;

public class GameFrame extends JFrame {
    //初始化跳转页面
    protected LoadingPagePanel loadingPagePanel=new LoadingPagePanel();
    protected GamePanel gamePanel=new GamePanel(this);
    protected ScorecardPagePanel scorePanel=new ScorecardPagePanel(this);
    protected   PlayerRegisterFrame playerRegisterFrame=new PlayerRegisterFrame(this);
    protected GameHallFrame gameHallFrame;

    GameFrameListener gameFrameListener=new GameFrameListener(this);
    GameActionListener gameActionListener=new GameActionListener(this);
    KeyboardListener keyboardListener=new KeyboardListener(this);
    private PlayerRegisterListener playerRegisterListener=new PlayerRegisterListener(this);



    //线程初始化
    protected PlayerBulletThread playerBulletThread =new PlayerBulletThread(this);
    protected PlayerBulletHitMapThread playerBulletHitMapThread=new PlayerBulletHitMapThread(this);
    protected PlayerHitEnemyThread playerHitEnemyThread=new PlayerHitEnemyThread(this);
    protected BulletColideThread bulletColideThread=new BulletColideThread(this);
    protected EnemyAppearThread enemyAppearThread=new EnemyAppearThread(this);
    protected EnemyBulletHitMapThread enemyBulletHitMapThread=new EnemyBulletHitMapThread(this);
    protected EnemyBulletThread enemyBulletThread=new EnemyBulletThread(this);
    protected EnemyHitPlyaerThread enemyHitPlyaerThread=new EnemyHitPlyaerThread(this);
    protected EnemyMoveThread enemyMoveThread=new EnemyMoveThread(this);

    //创建对象集合
    private PlayerTank playerTank=new PlayerTank();
    private Barrier barrier=new Barrier(this);
    private ArrayList<Bullet> playerBulletList=new ArrayList<Bullet>();
    private ArrayList<Bullet> enemyBulletList=new ArrayList<Bullet>();
    private ArrayList<EnemyTank> enemyTankList=new ArrayList<EnemyTank>();

    // 添加顶部菜单栏
    private JMenuBar topBar = new JMenuBar();
    private JMenu gameMenu = new JMenu("Game");
    private JMenu helpMenu = new JMenu("Help");
    private JMenuItem startItem = new JMenuItem(Util.start);
    private JMenuItem restartItem = new JMenuItem(Util.restart);
    private JMenuItem userCustomizeItem = new JMenuItem(Util.userCustomize);
    private JMenuItem exitItem = new JMenuItem(Util.exit);
    private JMenuItem instructionItem = new JMenuItem(Util.instruction);
    private JMenuItem aboutItem = new JMenuItem(Util.about);


    public GameFrame(GameHallFrame gameHallFrame){
        this.setLayout(null);
        this.setTitle("Takitaki");
        this.setSize(Util.GamePanel_W+Util.GCount_W+6,Util.GamePanel_H+59);
        // 设置窗口居中显示
        this.setLocationRelativeTo(null);
        //窗口大小设为可变
        this.setResizable(true);
        //设置跳转界面

        this.gameHallFrame=gameHallFrame;
        //顶部菜单
        gameMenu.add(startItem);
        gameMenu.add(restartItem);
        restartItem.setEnabled(false);
        gameMenu.add(userCustomizeItem);
        gameMenu.add(exitItem);

        helpMenu.add(instructionItem);
        helpMenu.add(aboutItem);

        topBar.add(gameMenu);
        topBar.add(helpMenu);
        this.setJMenuBar(topBar);

        //添加面板
        this.add(loadingPagePanel);
        this.add(gamePanel);
        gamePanel.setVisible(false);
        this.add(scorePanel);
        scorePanel.setBounds(Util.GamePanel_W,0,Util.GamePanel_W,Util.GamePanel_H);
        scorePanel.setVisible(false);

        // 设置默认关闭
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);


        //添加按钮监听器
        this.addWindowListener(this.gameFrameListener);
        this.getGamePanel().getGameover_btn().setActionCommand(Util.playAgain);
        this.getGamePanel().getGameover_btn().addActionListener(this.gameActionListener);
        this.getGamePanel().getExit_btn().setActionCommand(Util.exit);
        this.getGamePanel().getExit_btn().addActionListener(this.gameActionListener);
        this.getGamePanel().getConfirm_btn().setActionCommand(Util.confirm);
        this.getGamePanel().getConfirm_btn().addActionListener(this.gameActionListener);
        this.getGamePanel().getNext_level_btn().setActionCommand(Util.next_level);
        this.getGamePanel().getNext_level_btn().addActionListener(this.gameActionListener);
        //设置菜单监听器
        this.getStartItem().setActionCommand(Util.start);
        this.getStartItem().addActionListener(this.gameActionListener);
        this.getInstructionItem().setActionCommand(Util.instruction);
        this.getInstructionItem().addActionListener(this.gameActionListener);
        this.getAboutItem().setActionCommand(Util.about);
        this.getAboutItem().addActionListener(this.gameActionListener);
        this.getRestartItem().setActionCommand(Util.restart);
        this.getRestartItem().addActionListener(this.gameActionListener);
        this.getExitItem().setActionCommand(Util.exit);
        this.getExitItem().addActionListener(this.gameActionListener);
        this.getUserCustomizeItem().setActionCommand(Util.userCustomize);
        this.getUserCustomizeItem().addActionListener(this.gameActionListener);
        //添加键盘监听器
        this.addKeyListener(this.keyboardListener);

        //为playRegisterFrame添加监听器
        playerRegisterFrame.getPlayerRegisterPanel().getConfirm_btn().setActionCommand(Util.confirm);
        playerRegisterFrame.getPlayerRegisterPanel().getConfirm_btn().addActionListener(this.playerRegisterListener);

        //初始化线程
        getPlayerBulletThread().start();
        getPlayerBulletHitMapThread().start();
        getPlayerHitEnemyThread().start();
        getBulletColideThread().start();
        getEnemyAppearThread().start();
        getEnemyBulletHitMapThread().start();
        getEnemyBulletThread().start();
        getEnemyHitPlyaerThread().start();
        getEnemyMoveThread().start();

    }

    //gameFrame数据初始化
    public void initGameFrameData(){
        Util.countLife=3;
        playerTank.setHp(3);
        playerTank.setX_axis(Util.GamePanel_W / 2 + 75);
        playerTank.setY_axis(Util.GamePanel_H-Util.tankPixel);
        playerTank.setDirection(0);
        //游戏对象初始化
        Util.whiteTankNum=0;
        Util.greenTankNum=0;
        Util.pinkTankNum =0;
        Util.bossTankNum=0;
        Util.notExistWhiteTankNum=0;
        Util.notExistGreenTankNum=0;
        Util.notExistPinkTankNum=0;
    }

    //重新开始方法
    public void restart(){
        //数据初始化
        if (Util.level == 1) {
            Util.firstLevelHit = 0; // 第一关击毁坦克数
            Util.firstLevelScore = 0; // 第一关得分
            Util.totalHit = 0;
            Util.totalScore = 0;
        } else if (Util.level == 2) {
            Util.secondLevelHit = 0; // 第二关击毁坦克数
            Util.secondLevelScore = 0; // 第二关得分
            Util.totalHit = Util.firstLevelHit;
            Util.totalScore = Util.firstLevelScore;
        } else if (Util.level == 3) {
            Util.thirdLevelHit = 0; // 第三关击毁坦克数
            Util.thirdLevelScore = 0; // 第三关得分
            Util.totalHit = Util.firstLevelHit + Util.secondLevelHit;
            Util.totalScore = Util.firstLevelScore + Util.secondLevelScore;
        } else if (Util.level > 3) {
            Util.level = 1;
            Util.firstLevelHit = 0; // 第一关击毁坦克数
            Util.firstLevelScore = 0; // 第一关得分
            Util.secondLevelHit = 0; // 第二关击毁坦克数
            Util.secondLevelScore = 0; // 第二关得分
            Util.thirdLevelHit = 0; // 第三关击毁坦克数
            Util.thirdLevelScore = 0; // 第三关得分
            Util.totalHit = 0;
            Util.totalScore = 0;
        }

        initGameFrameData();
        //清空数据集合
        Util.enemyOriginalTankList.clear();
        this.enemyBulletList.clear();
        this.playerBulletList.clear();
        this.enemyTankList.clear();
        //初始化敌人库
        Util.initEnemyOriginalTankList();
        Util.changeLevel(Util.level);

    }

    public void nextLevel(){
        if(Util.level<3){
            Util.level++;
            this.initGameFrameData();
            //清空预设源坦克库
            Util.enemyOriginalTankList.clear();
            //初始化源坦克库
            Util.initEnemyOriginalTankList();
            Util.changeLevel(Util.level);
        }else if(Util.level==3){
            Util.level++;
            Util.game_clearance =true;
            gamePanel.getExit_btn().setVisible(true);
        }
    }


    public LoadingPagePanel getLoadingPagePanel() {
        return loadingPagePanel;
    }

    public void setLoadingPagePanel(LoadingPagePanel loadingPagePanel) {
        this.loadingPagePanel = loadingPagePanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public ScorecardPagePanel getScorePanel() {
        return scorePanel;
    }

    public void setScorePanel(ScorecardPagePanel scorePanel) {
        this.scorePanel = scorePanel;
    }

    public PlayerTank getPlayerTank() {
        return playerTank;
    }

    public void setPlayerTank(PlayerTank playerTank) {
        this.playerTank = playerTank;
    }

    public Barrier getBarrier() {
        return barrier;
    }

    public void setBarrier(Barrier barrier) {
        this.barrier = barrier;
    }

    public ArrayList<Bullet> getPlayerBulletList() {
        return playerBulletList;
    }

    public void setPlayerBulletList(ArrayList<Bullet> playerBulletList) {
        this.playerBulletList = playerBulletList;
    }

    public ArrayList<Bullet> getEnemyBulletList() {
        return enemyBulletList;
    }

    public void setEnemyBulletList(ArrayList<Bullet> enemyBulletList) {
        this.enemyBulletList = enemyBulletList;
    }

    public ArrayList<EnemyTank> getEnemyTankList() {
        return enemyTankList;
    }

    public void setEnemyTankList(ArrayList<EnemyTank> enemyTankList) {
        this.enemyTankList = enemyTankList;
    }

    public JMenuBar getTopBar() {
        return topBar;
    }

    public void setTopBar(JMenuBar topBar) {
        this.topBar = topBar;
    }

    public JMenu getGameMenu() {
        return gameMenu;
    }

    public void setGameMenu(JMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public JMenu getHelpMenu() {
        return helpMenu;
    }

    public void setHelpMenu(JMenu helpMenu) {
        this.helpMenu = helpMenu;
    }

    public JMenuItem getStartItem() {
        return startItem;
    }

    public void setStartItem(JMenuItem startItem) {
        this.startItem = startItem;
    }

    public JMenuItem getRestartItem() {
        return restartItem;
    }

    public void setRestartItem(JMenuItem restartItem) {
        this.restartItem = restartItem;
    }

    public JMenuItem getUserCustomizeItem() {
        return userCustomizeItem;
    }

    public void setUserCustomizeItem(JMenuItem userCustomizeItem) {
        this.userCustomizeItem = userCustomizeItem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public void setExitItem(JMenuItem exitItem) {
        this.exitItem = exitItem;
    }

    public JMenuItem getInstructionItem() {
        return instructionItem;
    }

    public void setInstructionItem(JMenuItem instructionItem) {
        this.instructionItem = instructionItem;
    }

    public JMenuItem getAboutItem() {
        return aboutItem;
    }

    public void setAboutItem(JMenuItem aboutItem) {
        this.aboutItem = aboutItem;
    }

    public GameHallFrame getGameHallFrame() {
        return gameHallFrame;
    }


    public void setGameHallFrame(GameHallFrame gameHallFrame) {
        this.gameHallFrame = gameHallFrame;
    }



    public PlayerRegisterFrame getPlayerRegisterFrame() {
        return playerRegisterFrame;
    }

    public void setPlayerRegisterFrame(PlayerRegisterFrame playerRegisterFrame) {
        this.playerRegisterFrame = playerRegisterFrame;
    }


    public PlayerBulletThread getPlayerBulletThread() {
        return playerBulletThread;
    }

    public void setPlayerBulletThread(PlayerBulletThread playerBulletThread) {
        this.playerBulletThread = playerBulletThread;
    }

    public PlayerBulletHitMapThread getPlayerBulletHitMapThread() {
        return playerBulletHitMapThread;
    }

    public void setPlayerBulletHitMapThread(PlayerBulletHitMapThread playerBulletHitMapThread) {
        this.playerBulletHitMapThread = playerBulletHitMapThread;
    }

    public PlayerHitEnemyThread getPlayerHitEnemyThread() {
        return playerHitEnemyThread;
    }

    public void setPlayerHitEnemyThread(PlayerHitEnemyThread playerHitEnemyThread) {
        this.playerHitEnemyThread = playerHitEnemyThread;
    }

    public EnemyBulletHitMapThread getEnemyHitMapThread() {
        return enemyBulletHitMapThread;
    }

    public void setEnemyHitMapThread(EnemyBulletHitMapThread enemyHitMapThread) {
        this.enemyBulletHitMapThread = enemyHitMapThread;
    }

    public BulletColideThread getBulletColideThread() {
        return bulletColideThread;
    }

    public void setBulletColideThread(BulletColideThread bulletColideThread) {
        this.bulletColideThread = bulletColideThread;
    }

    public GameFrameListener getGameFrameListener() {
        return gameFrameListener;
    }

    public void setGameFrameListener(GameFrameListener gameFrameListener) {
        this.gameFrameListener = gameFrameListener;
    }

    public GameActionListener getGameActionListener() {
        return gameActionListener;
    }

    public void setGameActionListener(GameActionListener gameActionListener) {
        this.gameActionListener = gameActionListener;
    }

    public KeyboardListener getKeyboardListener() {
        return keyboardListener;
    }

    public void setKeyboardListener(KeyboardListener keyboardListener) {
        this.keyboardListener = keyboardListener;
    }

    public EnemyAppearThread getEnemyAppearThread() {
        return enemyAppearThread;
    }

    public void setEnemyAppearThread(EnemyAppearThread enemyAppearThread) {
        this.enemyAppearThread = enemyAppearThread;
    }

    public EnemyBulletHitMapThread getEnemyBulletHitMapThread() {
        return enemyBulletHitMapThread;
    }

    public void setEnemyBulletHitMapThread(EnemyBulletHitMapThread enemyBulletHitMapThread) {
        this.enemyBulletHitMapThread = enemyBulletHitMapThread;
    }

    public EnemyBulletThread getEnemyBulletThread() {
        return enemyBulletThread;
    }

    public void setEnemyBulletThread(EnemyBulletThread enemyBulletThread) {
        this.enemyBulletThread = enemyBulletThread;
    }

    public EnemyHitPlyaerThread getEnemyHitPlyaerThread() {
        return enemyHitPlyaerThread;
    }

    public void setEnemyHitPlyaerThread(EnemyHitPlyaerThread enemyHitPlyaerThread) {
        this.enemyHitPlyaerThread = enemyHitPlyaerThread;
    }

    public EnemyMoveThread getEnemyMoveThread() {
        return enemyMoveThread;
    }

    public void setEnemyMoveThread(EnemyMoveThread enemyMoveThread) {
        this.enemyMoveThread = enemyMoveThread;
    }






}
