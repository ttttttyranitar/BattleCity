package com.model.tank;

import java.awt.*;

public class Tank {
    protected  int x_axis;//x轴坐标
    protected int y_axis;//y轴坐标
    protected int next_x_axis;//下一次坐标
    protected int next_y_axis;
    protected int direction;//方向
    protected int speed;//速度
    protected int hp;//生命值
    protected int attack;//攻击力
    //坦克的移动
    public void moveUp(){
        this.y_axis-=this.speed;
    }

    public void moveDown(){
        this.y_axis+=this.speed;
    }

    public void moveLeft(){
        this.x_axis-=this.speed;
    }

    public void moveRight(){
        this.x_axis+=this.speed;
    }







    public int getX_axis() {
        return x_axis;
    }

    public void setX_axis(int x_axis) {
        x_axis = x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    public void setY_axis(int y_axis) {
        this.y_axis = y_axis;
    }

    public int getNext_x_axis() {
        return next_x_axis;
    }

    public void setNext_x_axis(int next_x_axis) {
        this.next_x_axis = next_x_axis;
    }

    public int getNext_y_axis() {
        return next_y_axis;
    }

    public void setNext_y_axis(int next_y_axis) {
        this.next_y_axis = next_y_axis;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }


}
