package com.model.tank;

import com.util.Img;
import com.util.Util;

import java.awt.*;

public class GreenEnemyTank extends EnemyTank{


    public GreenEnemyTank(int x_axis, int y_axis, int direction){
        this.x_axis=x_axis;
        this.y_axis=y_axis;
        this.direction=direction;
        this.hp=Util.greenTankHp;
        this.point=Util.greenTankPoint;
        this.attack=Util.greenTankAtk;
        this.speed=Util.greenTankSpeed;
    }

    public void drawTankImage(Graphics g){
        while(true){
            if(getDirection()==0){
                g.drawImage(Img.greenEnemy_Up,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }else if(getDirection()==1){
                g.drawImage(Img.greenEnemy_Down,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }else if(getDirection()==2){
                g.drawImage(Img.greenEnemy_Left,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }else if(getDirection()==3){
                g.drawImage(Img.greenEnemy_Left,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }

        }

    }

    // 画敌人血条的方法
    public void drawHpBar(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(this.getX_axis(), this.getY_axis() - 21, 47, 10);
        if (hp == 2) {
            g.setColor(Color.green);
            g.fillRect(this.x_axis + 1, this.y_axis - 20, 45, 8);
            g.setColor(Color.BLACK);
            g.drawLine(this.getX_axis() + 23, this.getY_axis() - 20, this.getX_axis() + 23, this.getY_axis() - 8);
        } else if (hp == 1) {
            g.setColor(Color.RED);
            g.fillRect(this.x_axis + 1, this.y_axis - 20, 23, 8);
        }
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getMoveTime() {
        return moveTime;
    }

    public void setMoveTime(int moveTime) {
        this.moveTime = moveTime;
    }
}
