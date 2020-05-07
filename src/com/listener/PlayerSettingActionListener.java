package com.listener;

import com.util.Util;
import com.view.PlayererSettingFrame;
import com.view.PlayerSettingPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerSettingActionListener implements ActionListener {
    private PlayererSettingFrame frame;

    public PlayerSettingActionListener(PlayererSettingFrame frame){
        super();
        this.frame=frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //获取动作指令
        String comm=e.getActionCommand();
        //获取单选框，下拉框
        PlayerSettingPanel panel=frame.getPlayerserSettingPanel();
        JRadioButton normal_btn=panel.getNormal();
        JRadioButton customize_btn=panel.getCustomize();
        JComboBox<String> levelComboBox=panel.getLevelComboBox();
        JComboBox<String> speedComboBox=panel.getMoveSpeedComboBox();
        JComboBox<String> bulletSpeedComboBox=panel.getBulletSpeedComboBox();
        JTextField enemyMountTF=panel.getEnemyMountField();

        if(normal_btn.isSelected()){
            //如果选中正常游戏，combobox不可使用
            levelComboBox.setEnabled(false);
            bulletSpeedComboBox.setEnabled(false);
            enemyMountTF.setEnabled(false);
        }else if(customize_btn.isSelected()){
            levelComboBox.setEnabled(true);
            speedComboBox.setEnabled(true);
            bulletSpeedComboBox.setEnabled(true);
            enemyMountTF.setEnabled(true);
        }

        if(customize_btn.isSelected()&&comm.equals(Util.confirm)){
            Util.level=Integer.parseInt((String)levelComboBox.getSelectedItem());
            Util.playerMoveSpeed=Integer.parseInt((String)speedComboBox.getSelectedItem());
            Util.bulletSpeed =Integer.parseInt((String) bulletSpeedComboBox.getSelectedItem());
            //按照格式取自定义敌方坦克数，如果输入错误则设定为默认值
            try {
                if(Integer.parseInt(enemyMountTF.getText())<101&&Integer.parseInt(enemyMountTF.getText())>=5){
                    Util.enemyTankNum=Integer.parseInt(enemyMountTF.getText());
                }else {
                    Util.enemyTankNum=20;
                }

            }catch (Exception exception){
                Util.enemyTankNum=20;
            }

            //关闭当前窗口
            this.frame.setVisible(false);
        }else if(normal_btn.isSelected()&&comm.equals(Util.confirm)){
            //设置为默认值
            Util.level=1;
            Util.bulletSpeed=35;
            Util.enemyTankNum=20;

            this.frame.setVisible(false);
            //窗口暂停结束
            Util.window_pause=false;
        }else if(comm.equals(Util.cancel)){
            //隐藏当前窗口
            this.frame.setVisible(false);
            Util.window_pause=false;
        }

    }
}
