package com.view;

import com.util.Img;
import com.util.Util;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class LoadingPagePanel extends JPanel {
    //用于播放音乐
    private File bgm=new File("music/loadingPageBGM.wav");
    AudioInputStream audioInputStream;
    Clip clip;

    public LoadingPagePanel(){
        this.setLayout(null);
        this.setBounds(0,0, Util.GCount_W+Util.GamePanel_W,Util.GamePanel_W+Util.GCount_H);
        /*//播放音乐
        try{
            audioInputStream=AudioSystem.getAudioInputStream(bgm);
            clip=AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (Exception e){

        }*/


    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);//初始化父类画笔
        g.drawImage(Img.loadingBG, 0, 0, Util.GCount_W + Util.GamePanel_W, Util.GCount_H + Util.GCount_H, 0, 0,
                Util.GCount_W + Util.GamePanel_W, Util.GCount_H + Util.GCount_H, null);

        // 玩家名字
        g.setColor(new Color(107, 235, 232));
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

    //页面跳转时停止播放
    public void pauseMusic(){
        try{
            clip.close();

        }catch (Exception e){

        }
    }




}
