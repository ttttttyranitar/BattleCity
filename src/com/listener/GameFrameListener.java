package com.listener;

import com.util.Util;
import com.view.GameFrame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameFrameListener extends WindowAdapter implements WindowListener {
    private GameFrame gameFrame;

    public GameFrameListener(GameFrame gameFrame){
        super();
        this.gameFrame=gameFrame;
    }

    public void windowClosing(WindowEvent e){
        //进入暂停状态
        Util.window_pause=true;
        int flag=JOptionPane.showConfirmDialog(gameFrame,"exit the game?","message",JOptionPane.OK_CANCEL_OPTION);
        if(flag==JOptionPane.OK_OPTION){
            //退出程序
            System.exit(0);
        }
        Util.window_pause=false;
    }

}
