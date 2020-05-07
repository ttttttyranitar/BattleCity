package com.model.tank;

import com.model.tank.Tank;
import com.util.Img;
import com.util.Util;

import java.awt.*;

public class WhiteEnemyTank extends EnemyTank {
    private int point;//分值
    private int moveTime;//行动时间

    public WhiteEnemyTank(int x_axis, int y_axis, int direction){
        this.x_axis=x_axis;
        this.y_axis=y_axis;
        this.direction=direction;
        this.hp=Util.whiteTankHp;
        this.point=Util.whiteTankPoint;
        this.attack=Util.whiteTankAtk;
        this.speed=Util.whiteTankSpeed;
    }

    public void drawTankImage(Graphics g){
        while (true){
            if(getDirection()==0){
                g.drawImage(Img.whiteEnemy_Up,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }else if(getDirection()==1){
                g.drawImage(Img.whiteEnemy_Down,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }else if(getDirection()==2){
                g.drawImage(Img.whiteEnemy_Left,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }else if(getDirection()==3){
                g.drawImage(Img.whiteEnemy_Right,this.x_axis,this.y_axis,Util.tankPixel,Util.tankPixel,null);
                break;
            }


        }

    }

    // 画敌人血条的方法
    public void drawHpBar(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(this.getX_axis(), this.getY_axis() - 21, 47, 10);
        if (this.getHp() == 1) {
            g.setColor(Color.WHITE);
            g.fillRect(this.getX_axis() + 1, this.getY_axis() - 20, 45, 8);
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
