package com.running;

import com.model.tank.EnemyTank;
import com.util.Util;
import com.view.GameFrame;

import java.util.ArrayList;

public class EnemyAppearThread extends Thread {
    private GameFrame gameFrame;
    private boolean pause=true;

    public EnemyAppearThread(GameFrame gameFrame){

        this.gameFrame=gameFrame;
    }

    @Override
    public void run() {
        ArrayList<EnemyTank>originList=Util.enemyOriginalTankList;
        ArrayList<EnemyTank>enemyTankList=gameFrame.getEnemyTankList();
        while (true){
            //进入休眠状态
            while (pause){
                try{
                    sleep(Util.threadSleepMillis);

                }catch (Exception e){

                }
            }
            //如果游戏可以正常运行
            if(Util.on_off&&!Util.window_pause&&Util.game_is_running){
                if(enemyTankList.size()>3){

                }else if(originList.size()>0){
                    EnemyTank enemyTank=originList.get(0);
                    if(enemyTank.getPoint()==Util.whiteTankPoint){
                        enemyTankList.add(enemyTank);
                        Util.notExistWhiteTankNum--;
                    }else if(enemyTank.getPoint()==Util.greenTankPoint){
                        enemyTankList.add(enemyTank);
                        Util.notExistGreenTankNum--;
                    }else if(enemyTank.getPoint()==Util.pinkTankPoint){
                        enemyTankList.add(enemyTank);
                        Util.notExistPinkTankNum--;
                    }
                    originList.remove(enemyTank);

                }
            }

            try{
                sleep(Util.playerMoveSpeed);

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
