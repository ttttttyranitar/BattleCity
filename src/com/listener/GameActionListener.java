package com.listener;

import com.util.Util;
import com.view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActionListener implements ActionListener {
    private GameFrame frame;

    public GameActionListener(GameFrame gameFrame){
        this.frame=gameFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comm=e.getActionCommand();
        if(comm.equals(Util.start)){
            //游戏JPanel显示
            frame.getGamePanel().setVisible(true);
            frame.getScorePanel().setVisible(true);
            frame.getLoadingPagePanel().setVisible(false);
            //loadingpagePanel停止播放音乐
            frame.getLoadingPagePanel().pauseMusic();
            //gamePanel开始播放界面音乐
            frame.getGamePanel().playMusic();
            //唤醒游戏线程
            wakeUpGameThreads();

            //菜单栏中start按钮注销，restart按钮生效
            frame.getStartItem().setEnabled(false);
            frame.getUserCustomizeItem().setEnabled(false);
            frame.getRestartItem().setEnabled(true);
            //地图后台生成
            Util.changeLevel(Util.level);
        }
        else if(comm.equals(Util.restart)){

            shutdownGameThreads();
            //弹出对话框
            int flag=JOptionPane.showConfirmDialog(this.frame,"restart game?","warn",JOptionPane.OK_CANCEL_OPTION);
            if(flag==JOptionPane.OK_OPTION){
                frame.restart();
                //通关标记置为false,在gamePanel中会通过判断这个标记显示通关图片
                Util.game_clearance =false;
                frame.getGamePanel().getGameover_btn().setVisible(false);
                frame.getGamePanel().getExit_btn().setVisible(false);
            }
            wakeUpGameThreads();
        }
        else if(comm.equals(Util.userCustomize)){
            Util.window_pause=true;
            frame.getGameHallFrame().getPlayerSettingFrame().setVisible(true);

        }
        else if (comm.equals(Util.exit)){
            Util.window_pause=true;
            int key = JOptionPane.showConfirmDialog(frame, "back to the gamehall?", "tip",
                    JOptionPane.OK_CANCEL_OPTION);

            if (key == JOptionPane.OK_OPTION) {


                //线程进入休眠状态
                shutdownGameThreads();
               /* //返回主菜单前，初始化Util类
                Util.initializeUtil();
                //初始化玩家能量
                frame.getPlayerTank().initPlayerTank();

                //清空集合
                frame.getPlayerBulletList().clear();
                frame.getEnemyTankList().clear();
                frame.getEnemyBulletList().clear();*/
                //按钮不可显示
                frame.getGamePanel().getGameover_btn().setVisible(false);
                frame.getGamePanel().getExit_btn().setVisible(false);
                frame.getGamePanel().getNext_level_btn().setVisible(false);
                //gamePanel停止播放音乐
                frame.getGamePanel().pauseMusic();
                frame.getPlayerRegisterFrame().setVisible(true);


                /*frame.getStartItem().setEnabled(true);
                frame.getRestartItem().setEnabled(false);
                frame.getUserCustomizeItem().setEnabled(true);
                frame.getGamePanel().setVisible(false);
                frame.getScorePanel().setVisible(false);
                frame.getLoadingPagePanel().setVisible(true);
                frame.setVisible(false);
                frame.getGameHallFrame().setVisible(true);*/

            }
            Util.window_pause = false;
        }
        else if (comm.equals(Util.instruction)) {// 游戏说明
            Util.window_pause = true;
            // 显示游戏说明图片
            Util.showGameHelp = true;
            // 显示确定按钮
            shutdownGameThreads();
            frame.getGamePanel().getConfirm_btn().setVisible(true);

        }
        else if (comm.equals(Util.about)) { // 关于
            Util.window_pause = true;
            shutdownGameThreads();
            JOptionPane.showMessageDialog(frame,"Takitaki \n\nv2.1.0","about",1);
            wakeUpGameThreads();
            Util.window_pause = false;

        }
        else if(comm.equals(Util.playAgain)){//玩家失败后，选择重玩游戏
            int flag=JOptionPane.showConfirmDialog(frame,"replay the game?",
                    "tip",JOptionPane.OK_CANCEL_OPTION);
            if(flag==JOptionPane.OK_OPTION){
                // 游戏运行状态重置为正在运行
                Util.game_is_running =true;
                //游戏结束标记置为false
                Util.game_over=false;
                //初始化玩家坦克能量
                frame.getPlayerTank().initPlayerEnergy();
                //初始化攻击模式
                Util.initAttackMode();

                //重新载入
                frame.restart();
                Util.game_clearance=false;
                //隐藏Jpanel中的按钮
                frame.getGamePanel().getGameover_btn().setVisible(false);
                frame.getGamePanel().getExit_btn().setVisible(false);

            }
        }else if(comm.equals(Util.next_level)){//玩家完成一关后，选择继续下一关
            int flag=JOptionPane.showConfirmDialog(frame,"continue the game?","tip",JOptionPane.OK_CANCEL_OPTION);
            if(flag==JOptionPane.OK_OPTION){
                Util.game_is_running=true;
                //重置通关标记
                Util.completed_current_level =false;
                //初始化玩家能量
                frame.getPlayerTank().initPlayerEnergy();
                //初始化攻击模式
                Util.initAttackMode();
                //隐藏弹窗中的按钮
                frame.getGamePanel().getNext_level_btn().setVisible(false);
                frame.getGamePanel().getExit_btn().setVisible(false);
                frame.nextLevel();
            }
        }else if(comm.equals(Util.confirm)){//关闭帮助页面
              //帮助界面隐藏
              Util.showGameHelp=false;
              //确定按钮隐藏
              frame.getGamePanel().getConfirm_btn().setVisible(false);
              //结束窗口暂停状态
              Util.window_pause=false;
              wakeUpGameThreads();
        }

    }


    private void wakeUpGameThreads(){
        frame.getPlayerBulletThread().setRun();
        frame.getPlayerBulletHitMapThread().setRun();
        frame.getPlayerHitEnemyThread().setRun();
        frame.getBulletColideThread().setRun();
        frame.getEnemyAppearThread().setRun();
        frame.getEnemyBulletHitMapThread().setRun();
        frame.getEnemyBulletThread().setRun();
        frame.getEnemyHitPlyaerThread().setRun();
        frame.getEnemyMoveThread().setRun();


    }
    //暂停游戏线程
    private  void shutdownGameThreads(){
        frame.getPlayerBulletThread().terminate();
        frame.getPlayerBulletHitMapThread().terminate();
        frame.getPlayerHitEnemyThread().terminate();
        frame.getBulletColideThread().terminate();
        frame.getEnemyAppearThread().terminate();
        frame.getEnemyBulletHitMapThread().terminate();
        frame.getEnemyBulletThread().terminate();
        frame.getEnemyHitPlyaerThread().terminate();
        frame.getEnemyMoveThread().terminate();

    }
}
