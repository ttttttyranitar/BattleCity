package com.dataUtil;

import com.dataUtil.dataSort.MergSort;
import com.model.dataModel.PlayerRecord;
import com.util.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataLoader {
    private final String filePath=System.getProperty("user.dir")+"\\data\\gameData.json";

   //向json文件增加一条数据
    public boolean addRecord(){
        File file=new File(filePath);
        try {
            if(!file.exists()){
                file.createNewFile();
            }

            FileReader reader=new FileReader(filePath);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String jsonData="";
            JSONObject jsonObject=null;
            while((jsonData=bufferedReader.readLine())!=null) {
                jsonObject=JSONObject.fromObject(jsonData);
                JSONArray playerArray=jsonObject.getJSONArray("playerArray");
                //获取当前日期字符串
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //初始化playerRecord对象
                PlayerRecord playerRecord = new PlayerRecord(Util.playerName, dateFormat.format(date), Util.totalScore);
                //将新的对象加入json数据
                playerArray.add(playerRecord);
            }
            //先关闭输入流
            bufferedReader.close();
            if(jsonObject==null){
                return false;
            }
            String jsonString=jsonObject.toString();
            FileWriter writer=new FileWriter(filePath);
            BufferedWriter bufferedWriter=new BufferedWriter(writer);
            //写入文件
            bufferedWriter.write(jsonString);
            bufferedWriter.flush();
            //关闭输出流
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //获取Json文件中的玩家数据
    public List<Comparable> getPlayerRecords(){
        List<Comparable> playerRecords=null;
        try {
            FileReader reader=new FileReader(filePath);
            BufferedReader bufferedReader=new BufferedReader(reader);
            String jsonData="";
            JSONObject jsonObject=null;
            while ((jsonData=bufferedReader.readLine())!=null){
                jsonObject=JSONObject.fromObject(jsonData);
                JSONArray playerArray=jsonObject.getJSONArray("playerArray");
                //参数1为要转换的JSONArray数据，参数2为要转换的目标数据，即List盛装的数据
                playerRecords=JSONArray.toList(playerArray,new PlayerRecord(),new JsonConfig());
            }
            bufferedReader.close();

        }catch (Exception e){

        }

        return playerRecords;
    }

    public void sortRecords(List<Comparable> comparables){
        MergSort.sort(comparables);
    }
}
