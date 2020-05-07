package com.listener;

import com.util.Util;
import com.view.*;

import javax.swing.*;
import java.awt.event.*;

public class GameHallFrameListener extends WindowAdapter implements WindowListener {
    private GameHallFrame gameHallFrame;

    public GameHallFrameListener(GameHallFrame gameHallFrame){
        super();
        this.gameHallFrame=gameHallFrame;
    }

    public void windowClosing(WindowEvent e){
        //进入暂停状态
        Util.window_pause=true;
        int flag=JOptionPane.showConfirmDialog(gameHallFrame,"exit the game?","message",JOptionPane.OK_CANCEL_OPTION);
        if(flag==JOptionPane.OK_OPTION){
            //退出程序
            System.exit(0);
        }
        Util.window_pause=false;
    }

}
