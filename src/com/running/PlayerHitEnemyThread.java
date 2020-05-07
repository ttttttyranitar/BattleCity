package com.running;

import com.model.bullet.Bullet;
import com.model.tank.EnemyTank;
import com.model.tank.Tank;
import com.util.Util;
import com.view.GameFrame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class PlayerHitEnemyThread extends  Thread {
    private GameFrame gameFrame;
    private boolean pause=true;

    public PlayerHitEnemyThread(GameFrame gameFrame){
        super();
        this.gameFrame=gameFrame;
    }

    @Override
    public void run() {
        ArrayList<Bullet> playerBulletList=gameFrame.getPlayerBulletList();
        ArrayList<EnemyTank> enemyTankList=gameFrame.getEnemyTankList();
        while (true){
            while (pause){
                try{
                    sleep(Util.threadSleepMillis);

                }catch (Exception e){

                }

            }
            for (int i=0;i<playerBulletList.size();i++){

                for (int j=0;j<enemyTankList.size();j++){
                    try{
                        Bullet playerBullet=playerBulletList.get(i);
                        Rectangle playerBulletRect=new Rectangle(playerBullet.getX_axis(),playerBullet.getY_axis(),
                                Util.tankPixel,Util.tankPixel);
                        EnemyTank enemyTank=enemyTankList.get(j);
                        Rectangle enemyTankRect=new Rectangle(enemyTank.getX_axis(),enemyTank.getY_axis(),
                                Util.tankPixel,Util.tankPixel);
                        if(playerBulletRect.intersects(enemyTankRect)){
                            //移除子弹
                            playerBulletList.remove(playerBullet);
                            //敌方坦克生命值-子弹的伤害
                            enemyTank.setHp(enemyTank.getHp()-playerBullet.getDemage());
                            if(enemyTank.getHp()<=0){

                               //移除子弹
                                playerBulletList.remove(playerBullet);
                                //方法中暂时保存被击中的坦克对象
                                EnemyTank tankTemp=enemyTank;
                                //先移除坦克对象
                                enemyTankList.remove(enemyTank);
                                //爆炸特效
                                new ExplodeThread(gameFrame,tankTemp.getX_axis(),tankTemp.getY_axis()).start();

                                File music = new File("music/explod.wav");
                                try {
                                    AudioInputStream audio = AudioSystem.getAudioInputStream(music);
                                    Clip clip = AudioSystem.getClip();
                                    clip.open(audio);
                                    clip.start(); // 开始播放
                                } catch (Exception e1) {

                                } // 音效

                                //得分计算
                                if(Util.level==1){
                                    Util.firstLevelHit++;
                                    Util.firstLevelScore+=tankTemp.getPoint();
                                }else  if(Util.level==2){
                                    Util.secondLevelHit++;
                                    Util.secondLevelScore+=tankTemp.getPoint();
                                }else  if(Util.level==3){
                                    Util.thirdLevelHit++;
                                    Util.thirdLevelScore+=tankTemp.getPoint();
                                }
                                // 共击毁坦克数
                                Util.totalHit = Util.firstLevelHit + Util.secondLevelHit + Util.thirdLevelHit;
                                // 总得分
                                Util.totalScore = Util.firstLevelScore + Util.secondLevelScore + Util.thirdLevelScore;
                                //如果本关卡的敌人全部被歼灭
                                if(enemyTankList.size()==0){
                                    Util.completed_current_level=true;
                                    Util.game_is_running=false;
                                    gameFrame.getGamePanel().getNext_level_btn().setVisible(true);
                                    gameFrame.getGamePanel().getExit_btn().setVisible(true);
                                }
                                //跳出enemyTankList的迭代
                                break;
                            }
                        }

                    }catch (Exception e){

                    }
                }
            }

            //休眠
            try{
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
