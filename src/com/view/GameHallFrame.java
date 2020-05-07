package com.view;

import com.listener.*;
import com.util.Util;


import javax.swing.*;

public class GameHallFrame extends JFrame {
    private  GameHallPanel gameHallPanel=new GameHallPanel();
    //初始化可跳转的JFrame
    private  GameFrame gameFrame=new GameFrame(this);
    protected PlayererSettingFrame playerSettingFrame =new PlayererSettingFrame(this);
    protected CountdownFrame countdownFrame=new CountdownFrame();


    //初始化监听器
    GameHallActionListener gameHallActionListener=new GameHallActionListener(this);
    GameHallFrameListener gameHallFrameListener=new GameHallFrameListener(this);
    PlayerSettingFrameListener playerSettingFrameListener=new PlayerSettingFrameListener(this.getPlayerSettingFrame());
    PlayerSettingActionListener playerSettingActionListener=new PlayerSettingActionListener(this.getPlayerSettingFrame());
    CountdownFrameListener countdownFrameListener=new CountdownFrameListener(this);

    public GameHallFrame(){
        this.setLayout(null);
        this.setTitle("Takitaki");
        this.setSize(Util.loginBG_W,Util.loginBG_H);
        this.setResizable(true);
        // 设置窗口居中显示
        this.setLocationRelativeTo(null);


        this.add(gameHallPanel);

        //组装监听器
        this.addWindowListener(gameHallFrameListener);
        gameHallPanel.getEnter_btn().setActionCommand(Util.enter);
        gameHallPanel.getEnter_btn().addActionListener(gameHallActionListener);
        gameHallPanel.getExit_btn().setActionCommand(Util.exit);
        gameHallPanel.getExit_btn().addActionListener(gameHallActionListener);
        gameHallPanel.getCountdown_btn().setActionCommand(Util.countdown);
        gameHallPanel.getCountdown_btn().addActionListener(gameHallActionListener);

        //为
        playerSettingFrame.addWindowListener(this.playerSettingFrameListener);
        playerSettingFrame.getPlayerserSettingPanel().getCancelButton().setActionCommand(Util.cancel);
        playerSettingFrame.getPlayerserSettingPanel().getCancelButton().addActionListener(this.playerSettingActionListener);
        playerSettingFrame.getPlayerserSettingPanel().getConfirmButton().setActionCommand(Util.confirm);
        playerSettingFrame.getPlayerserSettingPanel().getConfirmButton().addActionListener(this.playerSettingActionListener);
        playerSettingFrame.getPlayerserSettingPanel().getNormal().setActionCommand(Util.normal);
        playerSettingFrame.getPlayerserSettingPanel().getNormal().addActionListener(this.playerSettingActionListener);
        playerSettingFrame.getPlayerserSettingPanel().getCustomize().setActionCommand(Util.userCustomize);
        playerSettingFrame.getPlayerserSettingPanel().getCustomize().addActionListener(this.playerSettingActionListener);

        countdownFrame.addWindowListener(this.countdownFrameListener);
        countdownFrame.getCountdownPanel().getConfirm_btn().setActionCommand(Util.confirm);
        countdownFrame.getCountdownPanel().getConfirm_btn().addActionListener(this.gameHallActionListener);

    }



    public GameHallPanel getGameHallPanel() {
        return gameHallPanel;
    }

    public void setGameHallPanel(GameHallPanel gameHallPanel) {
        this.gameHallPanel = gameHallPanel;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }


    public GameHallActionListener getGameHallActionListener() {
        return gameHallActionListener;
    }

    public void setGameHallActionListener(GameHallActionListener gameHallActionListener) {
        this.gameHallActionListener = gameHallActionListener;
    }

    public GameHallFrameListener getGameHallFrameListener() {
        return gameHallFrameListener;
    }

    public void setGameHallFrameListener(GameHallFrameListener gameHallFrameListener) {
        this.gameHallFrameListener = gameHallFrameListener;
    }

    public PlayererSettingFrame getPlayerSettingFrame() {
        return playerSettingFrame;
    }

    public void setPlayerSettingFrame(PlayererSettingFrame playererSettingFrame) {
        this.playerSettingFrame = playererSettingFrame;
    }



    public PlayerSettingFrameListener getPlayerSettingFrameListener() {
        return playerSettingFrameListener;
    }

    public void setPlayerSettingFrameListener(PlayerSettingFrameListener playerSettingFrameListener) {
        this.playerSettingFrameListener = playerSettingFrameListener;
    }

    public PlayerSettingActionListener getPlayerSettingActionListener() {
        return playerSettingActionListener;
    }

    public void setPlayerSettingActionListener(PlayerSettingActionListener playerSettingActionListener) {
        this.playerSettingActionListener = playerSettingActionListener;
    }

    public CountdownFrame getCountdownFrame() {
        return countdownFrame;
    }

    public void setCountdownFrame(CountdownFrame countdownFrame) {
        this.countdownFrame = countdownFrame;
    }
}
