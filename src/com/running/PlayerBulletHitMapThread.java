package com.running;

import com.model.Map;
import com.model.bullet.Bullet;
import com.util.Util;
import com.view.GameFrame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class PlayerBulletHitMapThread extends Thread {
    private GameFrame gameFrame;
    private boolean pause=true;

    public PlayerBulletHitMapThread(GameFrame gameFrame){
        super();
        this.gameFrame=gameFrame;
    }

    @Override
    public void run() {
        //获取玩家子弹集合
        ArrayList<Bullet> playerBulletList=this.gameFrame.getPlayerBulletList();
        int[][]map=Map.gameMap;

        while(true){
            while (pause){
                try{
                    sleep(Util.threadSleepMillis);

                }catch (Exception e){

                }

            }
            for (int i=0;i<playerBulletList.size();i++){
                for (int j=0;j<map.length;j++){
                    for (int k=0;k<map[j].length;k++){
                            try {
                            //获取一个子弹
                            Bullet playerBullet = playerBulletList.get(i);
                            //获取玩家所在的矩形
                            Rectangle bulletRect = new Rectangle(playerBullet.getX_axis(), playerBullet.getY_axis(),
                                    Util.bulletPixel, Util.bulletPixel);
                            //获取地图情况
                            int condition = map[j][k];
                            //获取地图的矩形
                            Rectangle mapBlock = new Rectangle(k * Util.imagePixel, j * Util.imagePixel, Util.imagePixel, Util.imagePixel);
                            if (condition == Util.brick ) {
                                if (bulletRect.intersects(mapBlock)) {
                                    //打中
                                    map[j][k]=0;
                                    playerBulletList.remove(playerBullet);

                                    File music = new File("music/hit.wav");
                                    try {
                                        AudioInputStream audio = AudioSystem.getAudioInputStream(music);
                                        Clip clip = AudioSystem.getClip();
                                        clip.open(audio);
                                        clip.start(); // 开始播放
                                    } catch (Exception e1) {

                                    } // 音效


                                }
                            }else if(condition==Util.iron){
                                if(bulletRect.intersects(mapBlock)){
                                    //打中铁块，子弹消失
                                    playerBulletList.remove(playerBullet);
                                    File music = new File("music/hit.wav");
                                    try {
                                        AudioInputStream audio = AudioSystem.getAudioInputStream(music);
                                        Clip clip = AudioSystem.getClip();
                                        clip.open(audio);
                                        clip.start(); // 开始播放
                                    } catch (Exception e1) {

                                    } // 音效

                                }
                            }
                            if(condition==Util.base1||condition==Util.base2||condition==Util.base3||condition==Util.base4){
                                if(bulletRect.intersects(mapBlock)){
                                    Util.game_over=true;
                                    Util.game_is_running=false;
                                    //显示退回主菜单和重玩按钮
                                    gameFrame.getGamePanel().getExit_btn().setVisible(true);
                                    gameFrame.getGamePanel().getGameover_btn().setVisible(true);
                                }
                            }
                        }catch (Exception e){

                        }

                    }
                }
            }
            //休眠
            try {
                sleep(Util.bulletSpeed);
            }catch (Exception e){

            }

        }
    }

    public void terminate(){
        this.pause=true;
    }

    public void setRun(){
        this.pause=false;
    }
}
