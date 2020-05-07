package com.running;

import com.model.bullet.Bullet;
import com.util.Util;
import com.view.GameFrame;

import java.util.ArrayList;

public class PlayerBulletThread extends Thread {
    private GameFrame gameFrame;
    private boolean pause=true;
    public PlayerBulletThread(GameFrame gameFrame){
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
            ArrayList<Bullet> playerBulletList=gameFrame.getPlayerBulletList();
            for(int i=0;i<playerBulletList.size();i++){
                try{
                    //如果游戏处于运行状态
                    if(Util.on_off&&Util.game_is_running&&!Util.window_pause){
                        Bullet bullet=playerBulletList.get(i);
                        //向上移动
                        if(bullet.getDirection()==0){
                            if (bullet.getY_axis()>-Util.bulletPixel){
                                bullet.moveUp();
                            }else {
                                playerBulletList.remove(bullet);
                            }
                        }
                        else if(bullet.getDirection()==1){
                            if (bullet.getY_axis()<Util.bulletPixel+Util.GamePanel_H){
                                bullet.moveDown();
                            }else {
                                playerBulletList.remove(bullet);
                            }
                        }
                        else if(bullet.getDirection()==2){
                            if(bullet.getX_axis()>0){
                                bullet.moveLeft();
                            }else {
                                playerBulletList.remove(bullet);
                            }
                        }
                        else if(bullet.getDirection()==3){
                            if(bullet.getX_axis()-Util.bulletPixel<Util.GamePanel_W){
                                bullet.moveRight();
                            }else{
                                playerBulletList.remove(bullet);
                            }
                        }
                    }

                }catch (Exception e){

                }

            }
            //线程暂停
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
