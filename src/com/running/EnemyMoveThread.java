package com.running;

import com.model.Map;
import com.model.tank.EnemyTank;
import com.model.tank.PlayerTank;
import com.util.Util;
import com.view.GameFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EnemyMoveThread extends Thread {
    private GameFrame gameFrame;
    private boolean pause=true;

    public EnemyMoveThread(GameFrame gameFrame){
        super();
        this.gameFrame=gameFrame;
    }
    @Override
    public void run() {
        //获取敌方坦克集合
        ArrayList<EnemyTank> enemyTankList=gameFrame.getEnemyTankList();
        //获取玩家
        PlayerTank playerTank=gameFrame.getPlayerTank();
        Random r=new Random();
        //这个坦克移动线程还可以优化!
        while (true){
                while (pause){
                    try{
                        sleep(Util.threadSleepMillis);

                    }catch (Exception e){

                    }

                }
            for(int i=0;i<enemyTankList.size();i++){
                EnemyTank enemyTank=enemyTankList.get(i);
                if(Util.on_off&&!Util.window_pause&&Util.game_is_running){
                    try {
                        if(enemyTank.getMoveTime()==0){
                            //设定随机敌人方向
                            enemyTank.setDirection(r.nextInt(4));
                            //随机设定敌人移动次数
                            enemyTank.setMoveTime(r.nextInt(20)+5);

                        }
                        else if(enemyTank.getMoveTime()>0){
                            //敌人上移
                            if(enemyTank.getDirection()==0){
                                if(enemyTank.getY_axis()>0&&!enemyCollidePlayer()&&!enemyCollideBarrier()){
                                    //子弹方向存入缓存
                                    Util.enemy_bullet_direction_Temp=0;
                                    enemyTank.moveUp();
                                    enemyTank.setMoveTime(enemyTank.getMoveTime()-1);
                                }else if(enemyCollidePlayer()){
                                    playerTank.setHp(playerTank.getHp()-1);
                                    enemyTank.setDirection(directionGenerator(0));
                                }else {
                                    enemyTank.setDirection(directionGenerator(0));
                                }
                            }
                            else  if(enemyTank.getDirection()==1){
                                if(enemyTank.getY_axis()<Util.GamePanel_H-Util.tankPixel&&!enemyCollidePlayer()&&!enemyCollideBarrier()){
                                    Util.enemy_bullet_direction_Temp=1;
                                    enemyTank.moveDown();
                                    enemyTank.setMoveTime(enemyTank.getMoveTime()-1);
                                }else if(enemyCollidePlayer()){
                                    playerTank.setHp(playerTank.getHp()-1);
                                    enemyTank.setDirection(directionGenerator(1));
                                }else {
                                    enemyTank.setDirection(directionGenerator(1));
                                }
                            }
                            else  if(enemyTank.getDirection()==2){
                                if(enemyTank.getX_axis()>0&&!enemyCollidePlayer()&&!enemyCollideBarrier()){
                                    Util.enemy_bullet_direction_Temp=2;
                                    enemyTank.moveLeft();
                                    enemyTank.setMoveTime(enemyTank.getMoveTime()-1);
                                }else if(enemyCollidePlayer()){
                                    playerTank.setHp(playerTank.getHp()-1);
                                    enemyTank.setDirection(directionGenerator(2));
                                }else {
                                    enemyTank.setDirection(directionGenerator(2));
                                }
                            }
                            else  if(enemyTank.getDirection()==3){
                                if(enemyTank.getX_axis()<Util.GamePanel_W-Util.tankPixel&&!enemyCollidePlayer()&&!enemyCollideBarrier()){
                                    Util.enemy_bullet_direction_Temp=3;
                                    enemyTank.moveRight();
                                    enemyTank.setMoveTime(enemyTank.getMoveTime()-1);
                                }else if(enemyCollidePlayer()){
                                    playerTank.setHp(playerTank.getHp()-1);
                                    enemyTank.setDirection(directionGenerator(3));
                                }else {
                                    enemyTank.setDirection(directionGenerator(3));
                                }
                            }
                        }


                    }catch (Exception e){

                    }
                }
            }
            // 休眠，移动速度
            try {
                sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }

    //控制敌方坦克移动，并判断前进方向上是否有障碍物
    private boolean enemyCollideBarrier() {
        ArrayList<EnemyTank> enemyTankList = gameFrame.getEnemyTankList();
        int[][] map = Map.gameMap;
        for (int i = 0; i < enemyTankList.size(); i++) {
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[j].length; k++) {
                    try {
                        int condition = map[j][k];
                        Rectangle mapRect = new Rectangle(k * Util.imagePixel, j * Util.imagePixel,
                                Util.imagePixel, Util.imagePixel);
                        EnemyTank enemyTank = enemyTankList.get(i);
                        //方向向上
                        if (enemyTank.getDirection() == 0) {
                            if (condition==Util.iron||condition==Util.brick) {
                                //初始化下一个将要行驶到的坐标
                                enemyTank.setNext_y_axis(enemyTank.getY_axis() - enemyTank.getSpeed());
                                enemyTank.setNext_x_axis(enemyTank.getX_axis());
                                Rectangle enemyRect = new Rectangle(enemyTank.getNext_x_axis(), enemyTank.getNext_y_axis(),
                                        Util.tankPixel, Util.tankPixel);
                                if (enemyRect.intersects(mapRect)) {
                                    return true;
                                }
                            }
                        }
                        else if (enemyTank.getDirection() == 1) {
                            if (condition==Util.iron||condition==Util.brick) {
                                enemyTank.setNext_y_axis(enemyTank.getY_axis() + enemyTank.getSpeed());
                                enemyTank.setNext_x_axis(enemyTank.getX_axis());
                                Rectangle enemyRect = new Rectangle(enemyTank.getNext_x_axis(), enemyTank.getNext_y_axis(),
                                        Util.tankPixel, Util.tankPixel);
                                if (enemyRect.intersects(mapRect)) {
                                    return true;
                                }
                            }
                        }
                        else if (enemyTank.getDirection() == 2) {
                            if (condition==Util.iron||condition==Util.brick) {
                                enemyTank.setNext_y_axis(enemyTank.getY_axis());
                                enemyTank.setNext_x_axis(enemyTank.getX_axis() - enemyTank.getSpeed());
                                Rectangle enemyRect = new Rectangle(enemyTank.getNext_x_axis(), enemyTank.getNext_y_axis(),
                                        Util.tankPixel, Util.tankPixel);
                                if (enemyRect.intersects(mapRect)) {
                                    return true;
                                }
                            }
                        }
                        else if (enemyTank.getDirection() == 3) {
                            if (condition==Util.iron||condition==Util.brick) {
                                enemyTank.setNext_y_axis(enemyTank.getY_axis());
                                enemyTank.setNext_x_axis(enemyTank.getX_axis() + enemyTank.getSpeed());
                                Rectangle enemyRect = new Rectangle(enemyTank.getNext_x_axis(), enemyTank.getNext_y_axis(),
                                        Util.tankPixel, Util.tankPixel);
                                if (enemyRect.intersects(mapRect)) {
                                    return true;
                                }
                            }
                        }

                    } catch (Exception e) {
                        return false;

                    }
                }
            }
        }
        return false;
    }


    //判断敌人撞玩家的方法
    private boolean enemyCollidePlayer(){
        ArrayList<EnemyTank> enemyTanks=gameFrame.getEnemyTankList();
        PlayerTank playerTank=gameFrame.getPlayerTank();
        Rectangle playerRect=new Rectangle(playerTank.getX_axis(),playerTank.getY_axis(),
                Util.tankPixel,Util.tankPixel);
        for(int i=0;i<enemyTanks.size();i++){
            try{
                EnemyTank enemyTank=enemyTanks.get(i);
                if(enemyTank.getDirection()==0){
                    enemyTank.setNext_x_axis(enemyTank.getX_axis());
                    enemyTank.setNext_y_axis(enemyTank.getY_axis()-enemyTank.getSpeed());
                    Rectangle enemyRect=new Rectangle(enemyTank.getNext_x_axis(),enemyTank.getNext_y_axis(),
                            Util.tankPixel,Util.tankPixel);
                    if(enemyRect.intersects(playerRect)){
                        return true;
                    }
                }
                else if(enemyTank.getDirection()==1){
                    enemyTank.setNext_x_axis(enemyTank.getX_axis());
                    enemyTank.setNext_y_axis(enemyTank.getY_axis()+enemyTank.getSpeed());
                    Rectangle enemyRect=new Rectangle(enemyTank.getNext_x_axis(),enemyTank.getNext_y_axis(),
                            Util.tankPixel,Util.tankPixel);
                    if(enemyRect.intersects(playerRect)){
                        return true;
                    }
                }
                else if(enemyTank.getDirection()==2){
                    enemyTank.setNext_x_axis(enemyTank.getX_axis()-enemyTank.getSpeed());
                    enemyTank.setNext_y_axis(enemyTank.getY_axis());
                    Rectangle enemyRect=new Rectangle(enemyTank.getNext_x_axis(),enemyTank.getNext_y_axis(),
                            Util.tankPixel,Util.tankPixel);
                    if(enemyRect.intersects(playerRect)){
                        return true;
                    }
                }
                else if(enemyTank.getDirection()==3){
                    enemyTank.setNext_x_axis(enemyTank.getX_axis()+enemyTank.getSpeed());
                    enemyTank.setNext_y_axis(enemyTank.getY_axis());
                    Rectangle enemyRect=new Rectangle(enemyTank.getNext_x_axis(),enemyTank.getNext_y_axis(),
                            Util.tankPixel,Util.tankPixel);
                    if(enemyRect.intersects(playerRect)){
                        return true;
                    }
                }
            }catch (Exception e){
            }

        }
        return false;

    }

    // 随机传入的0-3另外三个数的方法
    public static int directionGenerator(int n) {
        Random r = new Random();

        if (n == 0) { // 1,2,3随机一个
            n = r.nextInt(3) + 1;

        } else if (n == 1) { // 0,2,3随机一个
            n = r.nextInt(3);
            if (n == 0) {
                n = 0;
            } else if (n == 1) {
                n = 2;
            } else if (n == 2) {
                n = 3;
            }

        } else if (n == 2) { // 0,1,3随机一个
            n = r.nextInt(3);
            if (n == 0) {
                n = 0;
            } else if (n == 1) {
                n = 1;
            } else if (n == 2) {
                n = 3;
            }

        } else if (n == 3) { // 0,1,2随机一个
            n = r.nextInt(3);
        }
        return n;
    }


    public void terminate(){
        this.pause=true;
    }

    public void setRun(){
        this.pause=false;
    }
}
