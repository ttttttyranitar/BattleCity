package com.listener;

import com.dataUtil.DataLoader;
import com.model.dataModel.PlayerRecord;
import com.util.Util;
import com.view.GameHallFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class GameHallActionListener implements ActionListener {
    private GameHallFrame gameHallFrame;
    DataLoader dataLoader=new DataLoader();

    public GameHallActionListener(GameHallFrame gameHallFrame){
        super();
        this.gameHallFrame=gameHallFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comm=e.getActionCommand();
        if(comm.equals(Util.enter)){
            gameHallFrame.setVisible(false);
            gameHallFrame.getGameFrame().setVisible(true);
            //loadingpagePanel开始播放音乐
            gameHallFrame.getGameFrame().getLoadingPagePanel().playMusic();

        }else if(comm.equals(Util.exit)){
            int flag=JOptionPane.showConfirmDialog(gameHallFrame,"exit the game?","message",JOptionPane.OK_CANCEL_OPTION);
            if(flag==JOptionPane.OK_OPTION){
                //退出程序
                System.exit(0);
            }

        }else if(comm.equals(Util.countdown)){
            gameHallFrame.getCountdownFrame().setVisible(true);
            //读取玩家数据至集合之中
            List<Comparable> playerRecords=dataLoader.getPlayerRecords();
            //玩家数据按得分排序
            dataLoader.sortRecords(playerRecords);
            //清空数据
            gameHallFrame.getCountdownFrame().getCountdownPanel().getModel().getDataVector().clear();
            gameHallFrame.getCountdownFrame().getCountdownPanel().getModel().fireTableDataChanged();
            gameHallFrame.getCountdownFrame().getCountdownPanel().getPlayerDataTable().updateUI();

            //添加数据
            for(int i=0;i<10;i++){
                if(i==playerRecords.size()){
                    break;
                }
                PlayerRecord playerRecord=(PlayerRecord)playerRecords.get(i);
                Vector<Object> rowData=new Vector<Object>();
                rowData.add(playerRecord.getPlayerName());
                rowData.add(playerRecord.getPlayDate());
                rowData.add(playerRecord.getTotalScore());
                gameHallFrame.getCountdownFrame().getCountdownPanel().getModel().addRow(rowData);
            }

        }else if(comm.equals(Util.confirm)){//关闭countdownFrame
            gameHallFrame.getCountdownFrame().setVisible(false);
        }

    }
}
