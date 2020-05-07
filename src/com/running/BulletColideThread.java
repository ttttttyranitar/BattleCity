package com.running;

import com.model.bullet.Bullet;
import com.util.Util;
import com.view.GameFrame;

import java.awt.*;
import java.security.PublicKey;
import java.util.ArrayList;

public class BulletColideThread extends Thread {
    private GameFrame gameFrame;
    private boolean pause=true;

    public BulletColideThread(GameFrame gameFrame) {
        super();
        this.gameFrame = gameFrame;
    }

    @Override
    public void run() {
        ArrayList<Bullet> playerBulletList = gameFrame.getPlayerBulletList();
        ArrayList<Bullet> enemyBulletList = gameFrame.getEnemyBulletList();
        while (true) {
            //进入休眠状态
            while (pause){
                try{
                    sleep(Util.threadSleepMillis);

                }catch (Exception e){

                }
            }
            for (int i = 0; i < playerBulletList.size(); i++) {
                for (int j = 0; j < enemyBulletList.size(); j++) {
                    try {
                        Bullet playerBullet=playerBulletList.get(i);
                        Rectangle playerBulletRect=new Rectangle(playerBullet.getX_axis(),
                                playerBullet.getY_axis(),Util.bulletPixel,Util.bulletPixel);
                        Bullet enemyBullet=enemyBulletList.get(j);
                        Rectangle enemyBulletRect=new Rectangle(enemyBullet.getX_axis(),enemyBullet.getY_axis(),
                                Util.bulletPixel,Util.bulletPixel);
                        if(playerBulletRect.intersects(enemyBulletRect)){
                            playerBulletList.remove(playerBullet);
                            enemyBulletList.remove(enemyBullet);
                        }

                    }catch (Exception e){

                    }

                }
            }
            try{
                sleep(Util.bulletSpeed);
            }catch (Exception e){

            }
        }

    }

    //唤醒休眠的线程
    public void setRun(){
        this.pause=false;
    }


    //用于使线程进入休眠状态
    public void terminate(){
        this.pause=true;
    }
}
