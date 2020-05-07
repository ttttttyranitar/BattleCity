package com.model.tank;

import com.model.tank.Tank;
import com.util.Img;
import com.util.Util;

import java.awt.*;

public class PlayerTank extends Tank {
    private int life;
    private Image playerTankUp;//坦克4个方向的图片
    private Image playerTankDown;
    private Image playerTankLeft;
    private Image PlayerTankRight;
    private int energy;//玩家的能量点数


   public PlayerTank(){
        this.x_axis= Util.GamePanel_W/2+75;
        this.y_axis=Util.GamePanel_H-Util.tankPixel;
        this.hp=3;
        this.attack=1;
        this.life=3;
        this.speed=Util.playerMoveSpeed;
        this.energy=Util.playerEnergy;
        playerTankUp=Img.yellowPlayer_Up;//坦克4个方向的图片
        playerTankDown=Img.yellowPlayer_Down;
        playerTankLeft=Img.yellowPlayer_Left;
        PlayerTankRight=Img.yellowPlayer_Right;
    }



   /* public static int getTankSpeed(int tankType){
        switch (tankType){
            case 1:
                return Util.playerMoveSpeed;
            case 2:
                return Util.playerMoveSpeedType2;
            case 3:
                return Util.playerMoveSpeedType3;
            default:
                return Util.playerMoveSpeed;
        }
    }*/
    /*//按照坦克类型选择坦克的图片
    public  void setTankImage(int tankType){
        switch (tankType){
            case 1:

            case 2:

            case 3:


            default:
                this.playerTankUp= Img.yellowPlayer_Up;
                this.playerTankDown=Img.yellowPlayer_Down;
                this.playerTankLeft=Img.yellowPlayer_Left;
                this.PlayerTankRight=Img.yellowPlayer_Right;


        }

    }
*/



    public void drawTankImage(Graphics g){
        while(true){
            if (getDirection() == 0) { // 朝向向上
                g.drawImage(this.playerTankUp,this.x_axis,this.y_axis,null);
                break;
            } else if (getDirection() == 1) { // 朝向向下
                g.drawImage(this.playerTankDown,this.x_axis,this.y_axis,null);
                break;
            } else if (getDirection() == 2) { // 朝向向左
                g.drawImage(this.playerTankLeft,this.x_axis,this.y_axis,null);
                break;
            } else if (getDirection() == 3) { // 朝向向右
                g.drawImage(this.PlayerTankRight,this.x_axis,this.y_axis,null);
                break;
            }
        }
    }
    //绘制血条
    public void drawHpBar(Graphics g){
        g.setColor(Color.red);
        g.drawRect(this.x_axis,this.y_axis - 21, 47, 10);
        if (hp == 3) {
            g.setColor(Color.GREEN);
            g.fillRect(this.x_axis + 1, this.y_axis - 20, 45, 8);
            g.setColor(Color.BLACK);
            g.drawLine(this.x_axis + 15, this.y_axis- 20, this.x_axis + 15, this.y_axis - 8);
            g.drawLine(this.x_axis + 30, this.y_axis - 20, this.x_axis + 30, this.y_axis - 8);
        } else if (hp == 2) {
            g.setColor(Color.YELLOW);
            g.fillRect(this.x_axis + 1, this.y_axis - 20, 30, 10);
            g.setColor(Color.BLACK);
            g.drawLine(this.x_axis + 15, this.y_axis - 20, this.x_axis + 15, this.y_axis - 8);
        } else if (hp == 1) {
            g.setColor(Color.RED);
            g.fillRect(this.x_axis + 1, this.y_axis - 20, 15, 8);
        } else if (hp <= 0) {
            this.life -= 1;
            Util.countLife -= 1;
            this.hp = 3;
            this.x_axis = Util.GamePanel_W / 2 + 75;
            this.y_axis = Util.GamePanel_H - Util.tankPixel;
            direction = 0;
        }

    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public Image getPlayerTankUp() {
        return playerTankUp;
    }

    public void setPlayerTankUp(Image playerTankUp) {
        this.playerTankUp = playerTankUp;
    }

    public Image getPlayerTankDown() {
        return playerTankDown;
    }

    public void setPlayerTankDown(Image playerTankDown) {
        this.playerTankDown = playerTankDown;
    }

    public Image getPlayerTankLeft() {
        return playerTankLeft;
    }

    public void setPlayerTankLeft(Image playerTankLeft) {
        this.playerTankLeft = playerTankLeft;
    }

    public Image getPlayerTankRight() {
        return PlayerTankRight;
    }

    public void setPlayerTankRight(Image playerTankRight) {
        PlayerTankRight = playerTankRight;
    }

    public void initPlayerEnergy(){
       this.energy=Util.playerEnergy;
    }



    //用于初始化玩家坦克在地图上的位置
    public void initPlayerTank(){
       this.setHp(3);
       this.x_axis= Util.GamePanel_W/2+75;
       this.y_axis=Util.GamePanel_H-Util.tankPixel;
       this.setDirection(0);
       //初始化能量
       initPlayerEnergy();

    }
}
