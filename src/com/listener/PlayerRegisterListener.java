package com.listener;

import com.dataUtil.DataLoader;
import com.util.Util;
import com.view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerRegisterListener implements ActionListener {
    private GameFrame frame;
    //管理用户数据
    private DataLoader loader=new DataLoader();

    public PlayerRegisterListener(GameFrame frame){
        this.frame =frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String comm=e.getActionCommand();
        if(comm.equals(Util.confirm)){
            //格式检查
            checkName();
            clearTF();
/*            //保存用户数据
            loader.addRecord();
            //初始化游戏数据
            initGameData();

            frame.getStartItem().setEnabled(true);
            frame.getRestartItem().setEnabled(false);
            frame.getUserCustomizeItem().setEnabled(true);
            frame.getGamePanel().setVisible(false);
            frame.getScorePanel().setVisible(false);
            frame.getLoadingPagePanel().setVisible(true);
            //隐藏当前frame
            frame.getPlayerRegisterFrame().setVisible(false);
            //隐藏gameFrame
            frame.setVisible(false);
            //显示游戏大厅
            frame.getGameHallFrame().setVisible(true);*/
        }

    }

    //检查昵称格式
    public void checkName(){
        boolean flag=true;
        while (flag) {
            // 获取文本框输入的信息
            Util.playerName = this.frame.getPlayerRegisterFrame().getPlayerRegisterPanel().getNamedTF().getText().trim();
            if (Util.playerName.length() < 2 || Util.playerName.length() > 10) {
                // 弹出提示窗口
                JOptionPane.showMessageDialog(null, "your nickname's formation is wrong\n");
                clearTF();
                flag=false;

            }else {
                clearTF();
                //保存用户数据
                loader.addRecord();
                //初始化游戏数据
                initGameData();

                frame.getStartItem().setEnabled(true);
                frame.getRestartItem().setEnabled(false);
                frame.getUserCustomizeItem().setEnabled(true);
                frame.getGamePanel().setVisible(false);
                frame.getScorePanel().setVisible(false);
                frame.getLoadingPagePanel().setVisible(true);
                //隐藏当前frame
                frame.getPlayerRegisterFrame().setVisible(false);
                //隐藏gameFrame
                frame.setVisible(false);
                //显示游戏大厅
                frame.getGameHallFrame().setVisible(true);
                //跳出循环
                flag=false;
            }
        }

    }

    public void clearTF(){
        //清空文本框
        this.frame.getPlayerRegisterFrame().getPlayerRegisterPanel().getNamedTF().setText("");
    }

    //初始化gameFrame中的数据
    private void initGameData(){
        //返回主菜单前，初始化Util类
        Util.initializeUtil();
        //初始化玩家
        frame.getPlayerTank().initPlayerTank();
        //清空集合
        frame.getPlayerBulletList().clear();
        frame.getEnemyTankList().clear();
        frame.getEnemyBulletList().clear();


    }


}
