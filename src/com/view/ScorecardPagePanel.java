package com.view;

import com.util.Img;
import com.util.Util;

import javax.swing.*;
import java.awt.*;

public class ScorecardPagePanel extends JPanel {
    private GameFrame gameFrame;
    public ScorecardPagePanel(GameFrame gameFrame){
        //设置面板参数
        this.setLayout(null);
        this.setBounds(0,0, Util.GCount_W,Util.GCount_H);
        this.gameFrame=gameFrame;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(Util.level==1){
            g.drawImage(Img.FirstLevelScorecardBG,0,0,Util.GCount_W,Util.GCount_H,null);
        }
        else if(Util.level==2){
            g.drawImage(Img.SecondLevelScorecardBG,0,0,Util.GCount_W,Util.GCount_H,null);
        }
        else if(Util.level==3){
            g.drawImage(Img.ThirdLevelScorecardBG,0,0,Util.GCount_W,Util.GCount_H,null);
        }

        g.setColor(Color.ORANGE);
        //绘制出未出现坦克
        g.drawString(String.valueOf(Util.whiteTankNum),210,120);
        g.drawString(String.valueOf(Util.greenTankNum),210,170);
        g.drawString(String.valueOf(Util.pinkTankNum),210,220);
        g.drawString(String.valueOf(gameFrame.getPlayerTank().getEnergy()),210,270);

        g.setColor(Color.blue);



        g.setColor(Color.green);
        g.drawString(String.valueOf(Util.countLife),210, 500);

        g.setColor(Color.pink);
        if (Util.level == 1) {
            g.drawString(String.valueOf(Util.firstLevelHit), 160, 543);
            g.drawString(String.valueOf(Util.firstLevelScore), 160, 580);
        } else if (Util.level == 2) {
            g.drawString(String.valueOf(Util.secondLevelHit), 160, 543);
            g.drawString(String.valueOf(Util.secondLevelScore), 160, 580);
        } else if (Util.level == 3){
            g.drawString(String.valueOf(Util.thirdLevelHit), 160, 543);
            g.drawString(String.valueOf(Util.thirdLevelScore), 160, 580);
        }

        g.drawString(String.valueOf(Util.totalHit), 160, 618);
        g.drawString(String.valueOf(Util.totalScore), 160, 654);

        this.repaint();

    }


}
