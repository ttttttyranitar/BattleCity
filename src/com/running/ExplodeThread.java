package com.running;

import com.util.Util;
import com.view.GameFrame;

import javax.swing.*;

public class ExplodeThread extends Thread {
    private GameFrame gameFrame;
    //爆炸发生的坐标
    private int x;
    private int y;
    public ExplodeThread(GameFrame gameFrame,int x,int y){
        super();
        this.gameFrame=gameFrame;
        this.x=x;
        this.y=y;
    }

    @Override
    public void run() {
        //初始化爆炸的图像
        JLabel explodeLabel=new JLabel(new ImageIcon("img/explode.gif"));
        explodeLabel.setBounds(x,y, Util.tankPixel,Util.tankPixel);
        //添加到gamePanel中
        gameFrame.getGamePanel().add(explodeLabel);
        //爆炸的效果持续1.6s
        try{
            sleep(1600);

        }catch (Exception e){

        }
        //gamePanel中移除爆炸的效果
        gameFrame.getGamePanel().remove(explodeLabel);

    }
}
