package com.test;

import com.dataUtil.DataLoader;
import com.model.dataModel.PlayerRecord;
import com.running.BulletColideThread;
import com.view.GameFrame;
import com.view.GameHallFrame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class RunningTest extends  Thread {

    public static void main(String[] args) {
/*        DataLoader loader=new DataLoader();
        int i=0;
        PlayerRecord r=(PlayerRecord)loader.getPlayerRecords().get(i++);
        System.out.println(r.getPlayDate()+i);*/
/*
        BulletColideThread bulletColideThread = new BulletColideThread(new GameFrame(new GameHallFrame()));
        bulletColideThread.start();
        int i=0;
        try {
            while (i<=10){
                sleep(1000);

                System.out.println(i++);

        }
        bulletColideThread.terminate();


        } catch (Exception e) {
        }*/


        TestClass t=new TestClass();
        t.start();
        try{
            sleep(5000);

        }catch (Exception e){

        }
        t.starUp();
        try{
            sleep(5000);

        }catch (Exception e){

        }
        t.terminate();




    }



}
