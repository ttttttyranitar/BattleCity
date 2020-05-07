package com.running;

import com.model.Map;
import com.model.bullet.Bullet;
import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.util.Util;
import com.view.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class EnemyBulletHitMapThread extends Thread{
    private GameFrame gameFrame;
    private boolean pause=true;

    public EnemyBulletHitMapThread(GameFrame gameFrame){
        super();
        this.gameFrame=gameFrame;
    }

    @Override
    public void run() {

        ArrayList<Bullet> enemyBulletList=gameFrame.getEnemyBulletList();
        int[][]map=Map.gameMap;
        while(true){
            while (pause){
                try{
                    sleep(Util.threadSleepMillis);

                }catch (Exception e){

                }

            }
            for(int i=0;i<enemyBulletList.size();i++){
                for(int j=0;j<map.length;j++){
                    for (int k=0;k<map[j].length;k++){
                        try {
                            Bullet enemyBullet=enemyBulletList.get(i);
                            Rectangle bulletRect=new Rectangle(enemyBullet.getX_axis(),enemyBullet.getY_axis(),Util.bulletPixel,Util.bulletPixel);
                            int condition=map[j][k];
                            Rectangle mapRect=new Rectangle(k*Util.imagePixel,j*Util.imagePixel,
                                    Util.imagePixel,Util.imagePixel);

                            if(condition==Util.brick){
                                if(bulletRect.intersects(mapRect)){
                                    map[j][k]=0;
                                    enemyBulletList.remove(enemyBullet);
                                }
                            }
                            else if(condition==Util.iron){
                                if(bulletRect.intersects(mapRect)){
                                    enemyBulletList.remove(enemyBullet);

                                }

                            }
                            if(condition==Util.base1||condition==Util.base2||condition==Util.base3||condition==Util.base4){
                                if(bulletRect.intersects(mapRect)){
                                    enemyBulletList.remove(enemyBullet);
                                    File music= new File("music/gameover.wav");
                                    try {
                                        AudioInputStream audio = AudioSystem.getAudioInputStream(music);
                                        Clip clip = AudioSystem.getClip();
                                        clip.open(audio);
                                        clip.start(); // 开始播放
                                    } catch (Exception e1) {

                                    } // 音效
                                    //Jpanel显示失败界面
                                    Util.game_over=true;
                                    Util.game_is_running=false;
                                    //显示退回主菜单和重玩按钮
                                    gameFrame.getGamePanel().getExit_btn().setVisible(true);
                                    gameFrame.getGamePanel().getGameover_btn().setVisible(true);

                                    break;
                                }

                            }

                        }catch (Exception e){

                        }
                    }
                }
            }
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
