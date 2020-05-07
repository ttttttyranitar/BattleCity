package com.model.tank;

import com.util.Img;
import com.util.Util;

import java.awt.*;

public class PinkEnemyTank extends EnemyTank{


    public PinkEnemyTank(int x_axis, int y_axis, int direction){
        this.x_axis=x_axis;
        this.y_axis=y_axis;
        this.direction=direction;
        this.hp=Util.pinkTankHp;
        this.point=Util.pinkTankPoint;
        this.attack=Util.pinkTankAtk;
        this.speed=Util.pinkTankSpeed;
    }

    @Override
    public void drawTankImage(Graphics g) {
        while (true){
            if(getDirection()==0){
                g.drawImage(Img.pinkEnemy_Up,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }else if(getDirection()==1){
                g.drawImage(Img.pinkEnemy_Down,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }else if(getDirection()==2){
                g.drawImage(Img.pinkEnemy_Left,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }else if(getDirection()==3){
                g.drawImage(Img.pinkEnemy_Right,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }

        }

    }

    //绘制血条
    @Override
    public void drawHpBar(Graphics g){
        g.setColor(Color.RED);
        g.drawRect(this.getX_axis(), this.getY_axis() - 21, 47, 10);
        if (this.getHp() == 3) {
            g.setColor(Color.GREEN);
            g.fillRect(this.getX_axis() + 1, this.getY_axis() - 20, 45, 8);
            g.setColor(Color.BLACK);
            g.drawLine(this.getX_axis() + 15, this.getY_axis() - 20, this.getX_axis() + 15, this.getY_axis() - 8);
            g.drawLine(this.getX_axis() + 30, this.getY_axis() - 20, this.getX_axis() + 30, this.getY_axis() - 8);
        } else if (this.getHp() == 2) {
            g.setColor(Color.YELLOW);
            g.fillRect(this.getX_axis() + 1, this.getY_axis() - 20, 30, 10);
            g.setColor(Color.BLACK);
            g.drawLine(this.getX_axis() + 15, this.getY_axis() - 20, this.getX_axis() + 15, this.getY_axis() - 8);
        } else if (this.getHp() == 1) {
            g.setColor(Color.RED);
            g.fillRect(this.getX_axis() + 1, this.getY_axis() - 20, 15, 8);
        }
    }
}
