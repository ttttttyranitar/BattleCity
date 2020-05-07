package com.running;

import com.model.bullet.Bullet;
import com.model.tank.EnemyTank;
import com.util.Img;
import com.util.Util;
import com.view.GameFrame;

import java.util.ArrayList;
import java.util.Random;

public class EnemyBulletThread extends Thread {
    private GameFrame gameFrame;
    private boolean pause=true;

    public EnemyBulletThread(GameFrame gameFrame){
        super();
        this.gameFrame=gameFrame;
    }

    @Override
    public void run() {
       while (true){
           while (pause){
               try{
                   sleep(Util.threadSleepMillis);

               }catch (Exception e){

               }

           }
           //刷新enemyBulletList
           refreshEnemyBulletList();
           ArrayList<Bullet> enemyBulletList=gameFrame.getEnemyBulletList();

           for(int i=0;i<enemyBulletList.size();i++){
               try {
                   if (Util.on_off&&!Util.window_pause&&Util.game_is_running){
                       Bullet enemyBullet=enemyBulletList.get(i);
                       //如果子弹方向向上
                       if(enemyBullet.getDirection()==0){
                           //判断是否超出上边界
                           if(enemyBullet.getY_axis()>-Util.bulletPixel){
                               enemyBullet.moveUp();

                           }else {
                               enemyBulletList.remove(enemyBullet);
                           }
                       }
                       else if(enemyBullet.getDirection()==1){
                           //判断是否超出下边界
                           if(enemyBullet.getY_axis()<Util.GamePanel_H+Util.bulletPixel){
                               enemyBullet.moveDown();

                           }else {
                               enemyBulletList.remove(enemyBullet);
                           }
                       }
                       else  if(enemyBullet.getDirection()==2){
                           //判断是否超出上边界
                           if(enemyBullet.getX_axis()>0){
                               enemyBullet.moveRight();

                           }else {
                               enemyBulletList.remove(enemyBullet);
                           }
                       }
                       else  if(enemyBullet.getDirection()==3){
                           //判断是否超出上边界
                           if(enemyBullet.getY_axis()<Util.GamePanel_W+Util.bulletPixel){
                               enemyBullet.moveLeft();

                           }else {
                               enemyBulletList.remove(enemyBullet);
                           }
                       }


                   }

               }catch (Exception e){

               }
           }
           //暂停
           try{
               sleep(Util.bulletSpeed);

           }catch (Exception e){

           }



       }

    }

    private void refreshEnemyBulletList(){
        //GameFrame中的enemyList
        ArrayList<EnemyTank>enemyTankList=gameFrame.getEnemyTankList();

        for(int i=0;i<enemyTankList.size();i++){
            EnemyTank enemyTank=enemyTankList.get(i);
            Bullet bullet=null;

            int flag=new Random().nextInt(100);
            //1/100的可能创建子弹,大概BulletSpeed ms判断一次
            if(flag==0){
                if(Util.on_off&&!Util.window_pause&&Util.game_is_running){
                    try{
                        if (enemyTank.getDirection() == 0) {

                            bullet = new Bullet(Img.bullet_Up, enemyTank.getX_axis()+14, enemyTank.getY_axis()-60,
                                    enemyTank.getDirection());

                        } else if (enemyTank.getDirection() == 1) {

                            bullet = new Bullet(Img.bullet_Down, enemyTank.getX_axis()+14, enemyTank.getY_axis(),
                                    enemyTank.getDirection());

                        } else if (enemyTank.getDirection() == 2) {

                            bullet = new Bullet(Img.bullet_Left, enemyTank.getX_axis()-30,enemyTank.getY_axis()-16,
                                    enemyTank.getDirection());

                        } else if (enemyTank.getDirection() == 3) {

                            bullet = new Bullet(Img.bullet_Right, enemyTank.getX_axis()+30, enemyTank.getY_axis()-16,
                                    enemyTank.getDirection());

                        }

                        gameFrame.getEnemyBulletList().add(bullet);

                    }catch (Exception e){

                    }
                }

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
