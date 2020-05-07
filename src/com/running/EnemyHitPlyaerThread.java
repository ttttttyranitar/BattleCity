package com.running;

import com.model.bullet.Bullet;
import com.model.tank.PlayerTank;
import com.util.Util;
import com.view.GameFrame;

import java.awt.*;
import java.util.ArrayList;

public class EnemyHitPlyaerThread extends Thread {
    private GameFrame gameFrame;
    private boolean pause=true;

    public EnemyHitPlyaerThread(GameFrame gameFrame) {
        super();
        this.gameFrame = gameFrame;
    }

    @Override
    public void run() {
        ArrayList<Bullet> enemyBulletList = gameFrame.getEnemyBulletList();
        PlayerTank playerTank = gameFrame.getPlayerTank();
        while (true) {
            while (pause){
                try{
                    sleep(Util.threadSleepMillis);

                }catch (Exception e){

                }

            }
            for (int i = 0; i < enemyBulletList.size(); i++) {
                try {
                    Bullet enemyBullet=enemyBulletList.get(i);
                    Rectangle enemyBulletRect=new Rectangle(enemyBullet.getX_axis(),enemyBullet.getY_axis(),
                            Util.bulletPixel,Util.bulletPixel);
                    Rectangle playerRect=new Rectangle(playerTank.getX_axis(),
                            playerTank.getY_axis(),Util.tankPixel,Util.tankPixel);
                    if(enemyBulletRect.intersects(playerRect)){
                        enemyBulletList.remove(enemyBullet);
                        if(playerTank.getLife()>=1){
                            if(enemyBullet.getDemage()==1){
                                playerTank.setHp(playerTank.getHp()-1);
                            }else if(enemyBullet.getDemage()==2){
                                playerTank.setHp(playerTank.getHp()-2);
                            }else if(enemyBullet.getDemage()==3){
                                playerTank.setHp(playerTank.getHp()-3);
                            }

                            if(playerTank.getHp()<=0){
                                playerTank.setLife(playerTank.getLife()-1);
                                Util.countLife-=1;
                                //初始化玩家坦克在地图上的方位
                                playerTank.initPlayerTank();
                            }
                        }else if (playerTank.getLife()<1){
                            Util.game_is_running=false;
                            Util.game_over=true;
                            gameFrame.getGamePanel().getExit_btn().setVisible(true);
                            gameFrame.getGamePanel().getGameover_btn().setVisible(true);
                            break;
                        }
                    }
                } catch (Exception e) {
                  
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
