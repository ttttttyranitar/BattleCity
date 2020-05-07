package com.view;

import com.util.Util;

import javax.swing.*;

public class CountdownFrame extends JFrame {
    private CountdownPanel countdownPanel=new CountdownPanel();


    public CountdownFrame(){
        this.setLayout(null);
        this.setTitle("countdown");
        this.setSize(Util.loginBG_W,Util.loginBG_H);
        this.setResizable(true);

        // 设置窗口居中显示
        this.setLocationRelativeTo(null);
        this.setContentPane(countdownPanel);


    }

    public CountdownPanel getCountdownPanel() {
        return countdownPanel;
    }

    public void setCountdownPanel(CountdownPanel countdownPanel) {
        this.countdownPanel = countdownPanel;
    }
}
