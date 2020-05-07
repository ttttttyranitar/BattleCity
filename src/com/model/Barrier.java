package com.model;

import com.util.Img;
import com.util.Util;
import com.view.GameFrame;

import java.awt.*;

public class Barrier {

    private GameFrame gameFrame;
    //障碍物的位置
    private int brick = 1; // 砖块
    private int iron = 2; // 铁
    private int grass = 3; // 草
    private int water = 4; // 水

    public Barrier(GameFrame gameFrame){
        super();
        this.gameFrame=gameFrame;
    }



    public void drawBarrier(Graphics g){
        int[][] gameMap=Map.gameMap;
        for (int i=0;i<gameMap.length;i++)
            for (int j=0;j<gameMap[i].length;j++){
                   int index=gameMap[i][j];
                   if(index==Util.brick){
                       g.drawImage(Img.brick,j* Util.imagePixel,i*Util.imagePixel,null);
                   }else if(index==Util.iron){
                       g.drawImage(Img.iron,j* Util.imagePixel,i*Util.imagePixel,null);
                   }else if(index==Util.grass){
                       g.drawImage(Img.grass,j* Util.imagePixel,i*Util.imagePixel,null);
                   }else if(index==Util.water){
                       g.drawImage(Img.water,j* Util.imagePixel,i*Util.imagePixel,null);
                   }
                   //画出基地
                   else if(index==Util.base1){
                       g.drawImage(Img.home1,j* Util.imagePixel,i*Util.imagePixel,null);
                   }else if(index==Util.base2){
                       g.drawImage(Img.home2,j* Util.imagePixel,i*Util.imagePixel,null);
                   }else if(index==Util.base3){
                       g.drawImage(Img.home3,j* Util.imagePixel,i*Util.imagePixel,null);
                   }else if(index==Util.base4){
                       g.drawImage(Img.home4,j* Util.imagePixel,i*Util.imagePixel,null);
                   }
            }

    }



    public int getBrick() {
        return brick;
    }

    public void setBrick(int brick) {
        this.brick = brick;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public int getGrass() {
        return grass;
    }

    public void setGrass(int grass) {
        this.grass = grass;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }


}
