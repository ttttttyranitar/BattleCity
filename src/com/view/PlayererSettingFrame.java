package com.view;

import javax.swing.*;

public class PlayererSettingFrame extends JFrame {
    private PlayerSettingPanel playerserSettingPanel =new PlayerSettingPanel();
    private GameHallFrame gameHallFrame;


    public PlayererSettingFrame(GameHallFrame gameHallFrame){
        this.setTitle("Game Setting");
        this.setSize(355, 355);


        // 设置窗口不可改变大小
        this.setResizable(false);

        // 添加面板
        this.add(this.playerserSettingPanel);

        // 设置默认关闭
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        // 设置窗口居中显示
        this.setLocationRelativeTo(null);

        //需要使用的frame
        this.gameHallFrame =gameHallFrame;

    }

    public PlayerSettingPanel getPlayerserSettingPanel() {
        return playerserSettingPanel;
    }

    public void setPlayerserSettingPanel(PlayerSettingPanel playerserSettingPanel) {
        this.playerserSettingPanel = playerserSettingPanel;
    }

    public GameHallFrame getGameHallFrame() {
        return gameHallFrame;
    }

    public void setGameHallFrame(GameHallFrame gameHallFrame) {
        this.gameHallFrame = gameHallFrame;
    }
}
