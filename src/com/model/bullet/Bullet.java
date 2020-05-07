package com.model.bullet;

import com.util.Util;

import java.awt.*;

public class Bullet {
    protected Image bulletImage;
    protected int x_axis;
    protected int y_axis;
    protected int direction;
    protected int demage;

    public Bullet(Image bulletImage, int x_axis, int y_axis, int direction) {
        this.bulletImage = bulletImage;
        this.x_axis = x_axis;
        this.y_axis = y_axis;
        this.direction = direction;
        this.demage=Util.bullet_normal_demage;
    }

    public void draw(Graphics g){
        g.drawImage(this.bulletImage,this.x_axis,this.y_axis,null);
    }

    public void moveDown(){
        this.y_axis+= Util.bulletSpeed;
    }

    public void moveUp(){ this.y_axis-=Util.bulletSpeed; }

    public void moveLeft(){
        this.x_axis-=Util.bulletSpeed;
    }

    public void moveRight(){
        this.x_axis+=Util.bulletSpeed;
    }



    public Image getBulletImage() {
        return bulletImage;
    }

    public void setBulletImage(Image bulletImage) {
        this.bulletImage = bulletImage;
    }

    public int getX_axis() {
        return x_axis;
    }

    public void setX_axis(int x_axis) {
        this.x_axis = x_axis;
    }

    public int getY_axis() {
        return y_axis;
    }

    public void setY_axis(int y_axis) {
        this.y_axis = y_axis;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDemage() {
        return demage;
    }

    public void setDemage(int demage) {
        this.demage = demage;
    }
}
