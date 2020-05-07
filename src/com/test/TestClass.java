package com.test;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class TestClass extends Thread {
    File bgm=new File("music/loadingPageBGM.wav");
    AudioInputStream audioInputStream;
    Clip clip;
    volatile  boolean pause=true;

    public TestClass(){

    }

    public void  run(){
        int i=0;
        while(true){
            while (pause){
                try{
                    Thread.sleep(10);

                }catch (Exception e){

                }

            }
            try{
  /*              audioInputStream=AudioSystem.getAudioInputStream(bgm);
                clip=AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);*/
                System.out.println(i++);



            }catch (Exception e){

            }

        }




    }

    public void starUp(){
        this.pause=false;
    }
    public void terminate(){
        /*
        try{
            Thread.sleep(10000);
            clip.close();

        }catch (Exception e){

        }*/
        this.pause=true;
    }
}
