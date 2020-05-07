package com.running;

import com.model.bullet.Bullet;
import com.model.tank.PlayerTank;
import com.sun.org.apache.bcel.internal.generic.SWITCH;
import com.util.Img;
import com.util.Util;
import com.view.GameFrame;

import java.util.ArrayList;


public class PlayerAttackModeThread extends Thread {
    private GameFrame gameFrame;


    public PlayerAttackModeThread(GameFrame gameFrame){
        super();
        this.gameFrame=gameFrame;
    }

    @Override
    public void run() {
        //改变玩家攻击模式
        Util.changeAttackMode();
        //减少玩家的能量点数
        this.decreasePlayerEnergy();
        PlayerTank playerTank=gameFrame.getPlayerTank();
        playerTank.setPlayerTankUp(Img.whiteEnemy_Up);
        playerTank.setPlayerTankDown(Img.whiteEnemy_Down);
        playerTank.setPlayerTankLeft(Img.whiteEnemy_Left);
        playerTank.setPlayerTankRight(Img.whiteEnemy_Right);

        try {
            sleep(20000);
        }catch (Exception e){

        }

        playerTank.setPlayerTankUp(Img.yellowPlayer_Up);
        playerTank.setPlayerTankDown(Img.yellowPlayer_Down);
        playerTank.setPlayerTankLeft(Img.yellowPlayer_Left);
        playerTank.setPlayerTankRight(Img.yellowPlayer_Right);

        //线程运行完后攻击模式复原
        Util.initAttackMode();
    }

    private void decreasePlayerEnergy(){
        int currentEnergy=gameFrame.getPlayerTank().getEnergy();
        if(Util.attack_mode==1){
            gameFrame.getPlayerTank().setEnergy(currentEnergy-Util.attcack_mode1_reduce_energy);
        }else if(Util.attack_mode==2){
            gameFrame.getPlayerTank().setEnergy(currentEnergy-Util.attcack_mode2_reduce_energy);
        }else if(Util.attack_mode==3){
            gameFrame.getPlayerTank().setEnergy(currentEnergy-Util.attcack_mode3_reduce_energy);
        }

    }


}
