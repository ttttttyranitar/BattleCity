package com.view;

import com.listener.PlayerRegisterListener;

import javax.swing.*;

public class PlayerRegisterFrame extends JFrame {
    private  PlayerRegisterPanel playerRegisterPanel=new PlayerRegisterPanel();

    private GameFrame gameFrame;

    public  PlayerRegisterFrame(GameFrame gameFrame){
        this.setTitle("player register");
        // 设置窗口大小
        this.setSize(255, 155);
        //设置窗口大小不可变
        this.setResizable(false);
        //添加JPanel
        this.add(playerRegisterPanel);
        //设置为居中显示
        this.setLocationRelativeTo(null);
        //默认关闭
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //需要跳转回的界面
        this.gameFrame = gameFrame;
    }


    public PlayerRegisterPanel getPlayerRegisterPanel() {
        return playerRegisterPanel;
    }

    public void setPlayerRegisterPanel(PlayerRegisterPanel playerRegisterPanel) {
        this.playerRegisterPanel = playerRegisterPanel;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }




}
