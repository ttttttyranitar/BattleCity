package com.view;

import com.util.Img;
import com.util.Util;

import javax.swing.*;
import java.awt.*;

public class GameHallPanel extends JPanel {
    private JButton enter_btn=new JButton(Util.enter);
    private JButton countdown_btn=new JButton(Util.countdown);
    private JButton exit_btn=new JButton(Util.exit);

    public GameHallPanel(){
        this.setLayout(null);
        this.setBounds(0,0,Util.GH_W,Util.GH_H);

        //添加按钮
        this.add(enter_btn);
        enter_btn.setBounds(Util.GH_W / 2-60 , Util.GH_H - 360, 120, 40);
        enter_btn.setBackground(new Color(90, 139, 248));
        enter_btn.setFont(new java.awt.Font("华文行楷", 1, 15));

        this.add(countdown_btn);
        countdown_btn.setBounds(Util.GH_W / 2-60 , Util.GH_H - 280, 120, 40);
        countdown_btn.setBackground(new Color(90, 139, 248));
        enter_btn.setFont(new java.awt.Font("华文行楷", 1, 15));

        this.add(exit_btn); // 退出游戏按钮
        exit_btn.setBounds(Util.GH_W / 2-60 , Util.GH_H - 200, 120, 40);
        exit_btn.setBackground(new Color(90, 139, 248));
        exit_btn.setFont(new java.awt.Font("华文行楷", 1, 15));

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //绘制gameHall界面
        g.drawImage(Img.gameHall,0,0,Util.GH_W,Util.GH_H,0,0,Util.GH_W,Util.GH_H,null);
    }




    public JButton getEnter_btn() {
        return enter_btn;
    }

    public void setEnter_btn(JButton enter_btn) {
        this.enter_btn = enter_btn;
    }

    public JButton getExit_btn() {
        return exit_btn;
    }

    public void setExit_btn(JButton exit_btn) {
        this.exit_btn = exit_btn;
    }

    public JButton getCountdown_btn() {
        return countdown_btn;
    }

    public void setCountdown_btn(JButton countdown_btn) {
        this.countdown_btn = countdown_btn;
    }
}
