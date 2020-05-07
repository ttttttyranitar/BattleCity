package com.listener;

import com.model.Map;
import com.model.bullet.Bullet;
import com.model.tank.EnemyTank;
import com.model.tank.PlayerTank;
import com.running.PlayerAttackModeThread;
import com.util.Img;
import com.util.Util;
import com.view.GameFrame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

public class KeyboardListener extends KeyAdapter implements KeyListener {
    private GameFrame gameFrame;

    public KeyboardListener(GameFrame gameFrame){
        this.gameFrame=gameFrame;
    }

    private boolean playerHitBarrier(){
        PlayerTank playerTank=gameFrame.getPlayerTank();
        //得到游戏地图
        int map[][]=Map.gameMap;

        for(int i=0;i<map.length;i++){
            for (int j=0;j<map[i].length;j++){
                try{
                    //获取地图上每一个格子的
                    int condition=map[i][j];
                    Rectangle rect=new Rectangle(j*Util.imagePixel,i*Util.imagePixel,Util.imagePixel,Util.imagePixel);
                    //玩家向上移动
                    if(playerTank.getDirection()==0){
                        if(condition!=Util.ground&&condition!=Util.grass&&condition!=Util.water){
                            //玩家即将移动到的位置
                            playerTank.setNext_x_axis(playerTank.getX_axis());
                            playerTank.setNext_y_axis(playerTank.getY_axis()-playerTank.getSpeed());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                return true;
                            }
                        }
                        //如果在水上
                        else if(condition==Util.water){
                            playerTank.setNext_x_axis(playerTank.getX_axis());
                            playerTank.setNext_y_axis(playerTank.getY_axis()-playerTank.getSpeed());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                playerTank.setSpeed(Util.playerMoveSpeed+Util.water_reduce_speed);
                            }
                        }
                        //如果在草上
                        else if(condition==Util.grass){
                            playerTank.setNext_x_axis(playerTank.getX_axis());
                            playerTank.setNext_y_axis(playerTank.getY_axis()-playerTank.getSpeed());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                playerTank.setSpeed(Util.playerMoveSpeed+Util.grass_reduce_speed);
                            }
                        }
                        //如果在地面上
                        else if(condition==Util.ground){
                            playerTank.setNext_x_axis(playerTank.getX_axis());
                            playerTank.setNext_y_axis(playerTank.getY_axis()-playerTank.getSpeed());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                if(Util.playerSpeedIsBoosted){
                                    playerTank.setSpeed(Util.playerMoveSpeed+Util.playerSpeedBoost);

                                }else {
                                    playerTank.setSpeed(Util.playerMoveSpeed);

                                }
                            }
                        }
                    }
                    //玩家向下移动
                    else if(playerTank.getDirection()==1){
                        if(condition!=Util.ground&&condition!=Util.grass&&condition!=Util.water){
                            //玩家即将移动到的位置
                            playerTank.setNext_x_axis(playerTank.getX_axis());
                            playerTank.setNext_y_axis(playerTank.getY_axis()+playerTank.getSpeed());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                return true;
                            }
                        }
                        //如果在水上
                        else if(condition==Util.water){
                            playerTank.setNext_x_axis(playerTank.getX_axis());
                            playerTank.setNext_y_axis(playerTank.getY_axis()+playerTank.getSpeed());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                playerTank.setSpeed(Util.playerMoveSpeed+Util.water_reduce_speed);
                            }
                        }
                        //如果在草上
                        else if(condition==Util.grass){
                            playerTank.setNext_x_axis(playerTank.getX_axis());
                            playerTank.setNext_y_axis(playerTank.getY_axis()+playerTank.getSpeed());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                playerTank.setSpeed(Util.playerMoveSpeed+Util.grass_reduce_speed);
                            }
                        }
                        //如果在地面上
                        else if(condition==Util.ground){
                            playerTank.setNext_x_axis(playerTank.getX_axis());
                            playerTank.setNext_y_axis(playerTank.getY_axis()+playerTank.getSpeed());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                if(Util.playerSpeedIsBoosted){
                                    playerTank.setSpeed(Util.playerMoveSpeed+Util.playerSpeedBoost);

                                }else {
                                    playerTank.setSpeed(Util.playerMoveSpeed);

                                }

                            }
                        }
                    }
                    //玩家向左移动
                    else if(playerTank.getDirection()==2){
                        if(condition!=Util.ground&&condition!=Util.grass&&condition!=Util.water){
                            //玩家即将移动到的位置
                            playerTank.setNext_x_axis(playerTank.getX_axis()-playerTank.getSpeed());
                            playerTank.setNext_y_axis(playerTank.getY_axis());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                return true;
                            }
                        }
                        //如果在水上
                        else if(condition==Util.water){
                            playerTank.setNext_x_axis(playerTank.getX_axis()-playerTank.getSpeed());
                            playerTank.setNext_y_axis(playerTank.getY_axis());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                playerTank.setSpeed(Util.playerMoveSpeed+Util.water_reduce_speed);
                            }
                        }
                        //如果在草上
                        else if(condition==Util.grass){
                            playerTank.setNext_x_axis(playerTank.getX_axis()-playerTank.getSpeed());
                            playerTank.setNext_y_axis(playerTank.getY_axis());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                playerTank.setSpeed(Util.playerMoveSpeed+Util.grass_reduce_speed);
                            }
                        }
                        //如果在地面上
                        else if(condition==Util.ground){
                            playerTank.setNext_x_axis(playerTank.getX_axis()-playerTank.getSpeed());
                            playerTank.setNext_y_axis(playerTank.getY_axis());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                if(Util.playerSpeedIsBoosted){
                                    playerTank.setSpeed(Util.playerMoveSpeed+Util.playerSpeedBoost);

                                }else {
                                    playerTank.setSpeed(Util.playerMoveSpeed);

                                }

                            }
                        }
                    }
                    //玩家向右移动
                    else if(playerTank.getDirection()==3){
                        if(condition!=Util.ground&&condition!=Util.grass&&condition!=Util.water){
                            //玩家即将移动到的位置
                            playerTank.setNext_x_axis(playerTank.getX_axis()+playerTank.getSpeed());
                            playerTank.setNext_y_axis(playerTank.getY_axis());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                return true;
                            }
                        }
                        //如果在水上
                        else if(condition==Util.water){
                            playerTank.setNext_x_axis(playerTank.getX_axis()+playerTank.getSpeed());
                            playerTank.setNext_y_axis(playerTank.getY_axis());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                playerTank.setSpeed(Util.playerMoveSpeed+Util.water_reduce_speed);
                            }
                        }
                        //如果在草上
                        else if(condition==Util.grass){
                            playerTank.setNext_x_axis(playerTank.getX_axis()+playerTank.getSpeed());
                            playerTank.setNext_y_axis(playerTank.getY_axis());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                playerTank.setSpeed(Util.playerMoveSpeed+Util.grass_reduce_speed);
                            }
                        }
                        //如果在地面上
                        else if(condition==Util.ground){
                            playerTank.setNext_x_axis(playerTank.getX_axis()+playerTank.getSpeed());
                            playerTank.setNext_y_axis(playerTank.getY_axis());
                            //玩家下一步的位置矩形
                            Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),Util.tankPixel,Util.tankPixel);
                            if(playerRect.intersects(rect)){
                                if(Util.playerSpeedIsBoosted){
                                    playerTank.setSpeed(Util.playerMoveSpeed+Util.playerSpeedBoost);

                                }else {
                                    playerTank.setSpeed(Util.playerMoveSpeed);

                                }
                            }
                        }
                    }

                }catch (Exception e){
                    return false;
                }
            }
        }
        return false;

    }


    //判断装到敌人的方法
    private boolean playerHitEnemy(){
        PlayerTank playerTank=gameFrame.getPlayerTank();
        ArrayList<EnemyTank> enemyTanks=gameFrame.getEnemyTankList();
        //读取敌方坦克列表
        for(int i=0;i<enemyTanks.size();i++){
            try{
                EnemyTank enemyTank=enemyTanks.get(i);
                Rectangle enemyRect=new Rectangle(enemyTank.getX_axis(),enemyTank.getY_axis(),
                        Util.tankPixel,Util.tankPixel);
                //如果玩家向上移动
                if(playerTank.getDirection()==0){
                    playerTank.setNext_x_axis(playerTank.getX_axis());
                    playerTank.setNext_y_axis(playerTank.getY_axis()-Util.playerMoveSpeed);
                    Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),
                            Util.tankPixel,Util.tankPixel);
                    if(enemyRect.intersects(playerRect)){
                        return true;
                    }
                }
                //如果玩家向下移动
                else if(playerTank.getDirection()==1){
                        playerTank.setNext_x_axis(playerTank.getX_axis());
                        playerTank.setNext_y_axis(playerTank.getY_axis()+Util.playerMoveSpeed);
                        Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),
                                Util.tankPixel,Util.tankPixel);
                        if(enemyRect.intersects(playerRect)){
                            return true;
                        }
                    }
                //如果玩家向左移动
                else if(playerTank.getDirection()==2){
                    playerTank.setNext_x_axis(playerTank.getX_axis()-Util.playerMoveSpeed);
                    playerTank.setNext_y_axis(playerTank.getY_axis());
                    Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),
                            Util.tankPixel,Util.tankPixel);
                    if(enemyRect.intersects(playerRect)){
                        return true;
                    }
                }
                //如果玩家向右移动
                else if(playerTank.getDirection()==3){
                    playerTank.setNext_x_axis(playerTank.getX_axis()+Util.playerMoveSpeed);
                    playerTank.setNext_y_axis(playerTank.getY_axis());
                    Rectangle playerRect=new Rectangle(playerTank.getNext_x_axis(),playerTank.getNext_y_axis(),
                            Util.tankPixel,Util.tankPixel);
                    if(enemyRect.intersects(playerRect)){
                        return true;
                    }
                }

            }catch (Exception e){
                  return false;
            }
        }
        return false;
    }


    //判断玩家能否进入攻击模式
    private boolean playerChangeAttackMode(){
        int currentEnergy=gameFrame.getPlayerTank().getEnergy();
        if(Util.getAttackMode()==1){
            if (currentEnergy < Util.attcack_mode1_reduce_energy) {
                return false;
            } else {
                return true;
            }
        }
        else if(Util.getAttackMode()==2){
            if (currentEnergy- Util.attcack_mode2_reduce_energy <0) {
                return false;
            } else {
                return true;
            }
        }
        else if(Util.getAttackMode()==3){
            if (currentEnergy- Util.attcack_mode3_reduce_energy <0) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }

    }

    private void changeBulletDamage(Bullet bullet){
        if(Util.attack_mode==1){
            bullet.setDemage(Util.bullet_boost_damage);
        }else if(Util.attack_mode==2){
            bullet.setDemage(Util.bullet_super_demage);
        }else if(Util.attack_mode==3){
            bullet.setDemage(Util.bullet_ultra_demage);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode=e.getKeyCode();
        PlayerTank playerTank=gameFrame.getPlayerTank();
        //玩家移动指令
        if(keyCode==e.VK_W){
            //如果游戏正常运行
            if(Util.on_off&&!Util.window_pause&&!Util.completed_current_level&&Util.game_is_running){
                playerTank.setDirection(0);
                //键盘输入的方向存入缓存
                Util.player_direction_Temp=0;
                if(playerTank.getY_axis()>0&&!playerHitBarrier()&&!playerHitEnemy()){
                    playerTank.moveUp();
                }

            }
        }
        else  if(keyCode==e.VK_S){
            //如果游戏正常运行
            if(Util.on_off&&!Util.window_pause&&!Util.completed_current_level&&Util.game_is_running){
                playerTank.setDirection(1);
                Util.player_direction_Temp=1;
                if(playerTank.getY_axis()<Util.GamePanel_H-Util.tankPixel&&!playerHitBarrier()&&!playerHitEnemy()){
                    playerTank.moveDown();
                }

            }
        }
        else if(keyCode==e.VK_A){
            //如果游戏正常运行
            if(Util.on_off&&!Util.window_pause&&!Util.completed_current_level&&Util.game_is_running){
                playerTank.setDirection(2);
                Util.player_direction_Temp=2;
                if(playerTank.getX_axis()>0&&!playerHitBarrier()&&!playerHitEnemy()){
                    playerTank.moveLeft();
                }

            }
        }
        else  if(keyCode==e.VK_D){
            //如果游戏正常运行
            if(Util.on_off&&!Util.window_pause&&!Util.completed_current_level&&Util.game_is_running){
                playerTank.setDirection(3);
                Util.player_direction_Temp=3;
                if(playerTank.getX_axis()<Util.GamePanel_W-Util.tankPixel&&!playerHitBarrier()&&!playerHitEnemy()){
                    playerTank.moveRight();
                }

            }
        }

        //如果玩家下加速键
        else if(keyCode==e.VK_H){
            //如果游戏正常运行
            if(Util.on_off&&!Util.window_pause&&!Util.completed_current_level&&Util.game_is_running) {
                Util.playerSpeedIsBoosted=true;

            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode=e.getKeyCode();
        PlayerTank playerTank=gameFrame.getPlayerTank();
        //玩家发射子弹的对象
        Bullet playerBullet=null;
        //如果松开加速键
        if(keyCode==e.VK_H){
            //如果游戏正常运行
            if(Util.on_off&&!Util.window_pause&&!Util.completed_current_level&&Util.game_is_running) {
                Util.playerSpeedIsBoosted=false;

            }

        }
        //实现esc键暂停
        else if(keyCode==e.VK_ESCAPE){
            Util.on_off=!Util.on_off;
        }
        //玩家按下攻击键J
        else if(keyCode==e.VK_J){

            if(Util.on_off&&!Util.window_pause&&!Util.completed_current_level&&Util.game_is_running) {

                File music = new File("music/firebullet.wav");
                // 音效
                try {
                    AudioInputStream audio = AudioSystem.getAudioInputStream(music);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audio);
                    clip.start(); // 开始播放
                } catch (Exception e1) {

                }

                if(playerTank.getDirection()==0){

                    playerBullet=new Bullet(Img.bullet_Up,playerTank.getX_axis()+14,playerTank.getY_axis(),
                            Util.player_direction_Temp);


                }else if(playerTank.getDirection()==1){

                    playerBullet=new Bullet(Img.bullet_Down,playerTank.getX_axis()+12,playerTank.getY_axis()+15,
                            Util.player_direction_Temp);


                }else if(playerTank.getDirection()==2){

                    playerBullet=new Bullet(Img.bullet_Left,playerTank.getX_axis()+0,playerTank.getY_axis()+13,
                            Util.player_direction_Temp);


                }else if(playerTank.getDirection()==3){

                    playerBullet=new Bullet(Img.bullet_Right,playerTank.getX_axis()+15,playerTank.getY_axis()+14,
                            Util.player_direction_Temp);


                }

                changeBulletDamage(playerBullet);

                //将新增的玩家子弹加入集合
                gameFrame.getPlayerBulletList().add(playerBullet);

            }


        }
        //玩家按下切换攻击模式键
        else if(keyCode==e.VK_E){
            //如果游戏正常运行
            if(Util.on_off&&!Util.window_pause&&!Util.completed_current_level&&Util.game_is_running&&
                    Util.attack_mode==0&&playerChangeAttackMode()){



                    new PlayerAttackModeThread(gameFrame).start();
/*                    //减少玩家的能量点数
                    this.decreasePlayerEnergy();
                    //线程运行完后攻击模式复原
                    Util.initAttackMode();*/



            }


        }



    }





}
