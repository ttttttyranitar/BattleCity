package com.model.tank;

import java.awt.*;

public abstract class EnemyTank extends Tank {
    protected int point;//分值
    protected  int moveTime;//行动时间

    //画图方法，子类override
    public abstract void drawTankImage(Graphics g);
    //绘制血条的方法,子类override
    public abstract void drawHpBar(Graphics g);

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
