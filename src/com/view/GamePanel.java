package com.view;

import com.model.tank.EnemyTank;
import com.util.Img;
import com.util.Util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GamePanel extends JPanel {
    protected GameFrame gameFrame;
    //初始化panel中的按钮
    private JButton gameover_btn=new JButton(Util.playAgain);
    private JButton next_level_btn=new JButton("next level");
    private JButton exit_btn=new JButton(Util.exit);
    private JButton confirm_btn=new JButton(Util.confirm);
    //用于播放音乐
    File bgm=new File("music/gameBGM.wav");
    AudioInputStream audioInputStream;
    Clip clip;


    public GamePanel(GameFrame gameFrame){
        this.gameFrame=gameFrame;

        //初始化界面布局

        this.setLayout(null);
        this.setBounds(0,0,Util.GamePanel_W,Util.GamePanel_H);
        this.setBackground(new Color(0, 0, 0)); // 设置面板背景色

        this.add(gameover_btn); // 游戏重新开始按钮
        gameover_btn.setBounds(Util.GH_W / 2 - 240, Util.GH_H - 170, 120, 40);
        gameover_btn.setFont(new java.awt.Font("华文行楷", 1, 15));
        gameover_btn.setBackground(Color.ORANGE);
        gameover_btn.setVisible(false);

        this.add(exit_btn); // 退出游戏按钮
        exit_btn.setBounds(Util.GH_W / 2 - 100, Util.GH_H - 170, 120, 40);
        exit_btn.setFont(new java.awt.Font("华文行楷", 1, 15));
        exit_btn.setBackground(Color.ORANGE);
        exit_btn.setVisible(false);

        this.add(next_level_btn); // 游戏下一关按钮
        next_level_btn.setBounds(Util.GH_W / 2 - 240, Util.GH_H - 170, 120, 40);
        next_level_btn.setFont(new java.awt.Font("华文行楷", 1, 15));
        next_level_btn.setBackground(Color.ORANGE);
        next_level_btn.setVisible(false);

        this.add(confirm_btn); // 游戏说明确定按钮
        confirm_btn.setBounds(Util.GH_W / 2 - 170, Util.GH_H - 70, 120, 40);
        confirm_btn.setFont(new java.awt.Font("华文行楷", 1, 15));
        confirm_btn.setBackground(Color.ORANGE);
        confirm_btn.setVisible(false);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //绘制游戏地图
        this.gameFrame.getBarrier().drawBarrier(g);
        //绘制玩家坦克
        this.gameFrame.getPlayerTank().drawTankImage(g);
        this.gameFrame.getPlayerTank().drawHpBar(g);
        // 画敌人
        for (int i = 0; i < gameFrame.getEnemyTankList().size(); i++) {
            EnemyTank en = gameFrame.getEnemyTankList().get(i);
            en.drawTankImage(g);
        }

        for (int i = 0; i < gameFrame.getEnemyTankList().size(); i++) {
            EnemyTank en = gameFrame.getEnemyTankList().get(i);
            en.drawHpBar(g);
        }


        // 画子弹集合
        for (int i = 0; i < gameFrame.getPlayerBulletList().size(); i++) {
            gameFrame.getPlayerBulletList().get(i).draw(g);
        }

        // 画敌人子弹集合
        for (int i = 0; i < gameFrame.getEnemyBulletList().size(); i++) {
            try {
                gameFrame.getEnemyBulletList().get(i).draw(g);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        // 暂停
        if (Util.on_off == false) {
            g.drawImage(Img.pause, 0, 0, Util.GamePanel_W, Util.GamePanel_H, null);
        }
        // 游戏失败,弹出图片
        if (Util.game_over) {
            g.drawImage(Img.GameOver, 0, 0, Util.GamePanel_W, Util.GamePanel_H, null);
        }
        // 玩家通当前关卡，弹窗
        if (Util.completed_current_level) {
            g.setColor(Color.WHITE);

            g.drawImage(Img.skipmatch, 0, 0, Util.GamePanel_W, Util.GamePanel_H, null);

            g.drawString(String.valueOf(Util.whiteTankNum * 100), 510, 245);
            g.drawString(String.valueOf(Util.greenTankNum* 200), 510, 320);
            g.drawString(String.valueOf(Util.pinkTankNum * 500), 510, 390);
            if (Util.level == 1) {
                g.drawString(String.valueOf(Util.firstLevelScore), 300, 450);
            } else if (Util.level == 2) {
                g.drawString(String.valueOf(Util.secondLevelScore), 300, 450);
            } else if (Util.level == 3) {
                g.drawString(String.valueOf(Util.thirdLevelScore), 300, 450);
            }
            g.drawString(String.valueOf(Util.totalScore), 510, 450);
        }
        // 如果游戏通关，则显示弹窗
        if (Util.game_clearance) {
            g.drawImage(Img.clearance, 0, 0, Util.GamePanel_W, Util.GamePanel_H, null);
        }
        // 游戏说明
        if (Util.showGameHelp) {
            g.drawImage(Img.help, 0, 0, Util.GamePanel_W,  Util.GamePanel_H, null);
        }


        this.repaint();
    }

    //播放音乐
    public void playMusic(){
        try{
            audioInputStream=AudioSystem.getAudioInputStream(bgm);
            clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (Exception e){

        }
    }

    //停止播放
    public void pauseMusic(){
        try{
            clip.close();

        }catch (Exception e){

        }
    }





    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public JButton getGameover_btn() {
        return gameover_btn;
    }

    public void setGameover_btn(JButton gameover_btn) {
        this.gameover_btn = gameover_btn;
    }

    public JButton getNext_level_btn() {
        return next_level_btn;
    }

    public void setNext_level_btn(JButton next_level_btn) {
        this.next_level_btn = next_level_btn;
    }

    public JButton getExit_btn() {
        return exit_btn;
    }

    public void setExit_btn(JButton exit_btn) {
        this.exit_btn = exit_btn;
    }

    public JButton getConfirm_btn() {
        return confirm_btn;
    }

    public void setConfirm_btn(JButton confirm_btn) {
        this.confirm_btn = confirm_btn;
    }

}
