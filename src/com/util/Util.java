package com.util;

import com.model.Map;
import com.model.tank.*;

import java.util.ArrayList;
import java.util.Random;

public class Util {
    // 图片数据常量
    public static final int loginBG_W = 926; // 登录窗口图片的宽高
    public static final int loginBG_H = 672;
    public static final int GH_W = loginBG_W; // 登录面板的宽高
    public static final int GH_H = loginBG_H;
    public static final int GamePanel_W = 700; // 游戏界面面板的宽高
    public static final int GamePanel_H = 700;
    public static final int GCount_W = 300; // 游戏统计面板的宽高
    public static final int GCount_H = 700;
    public static final int threadSleepMillis=200;//线程在休眠状态的单次暂停时间

    // 文本常量
    public static final String enter = "play";
    public static final String countdown="countdown";
    public static final String start = "start";
    public static final String exit = "exit";
    public static final String restart = "play again"; // 菜单项的重新开始
    public static final String userCustomize = "customize";
    public static final String normal = "normal";
    public static final String instruction = "instructions";
    public static final String about = "about";
    public static final String playAgain = "playAgain"; // 弹窗的再玩一遍
    public static final String confirm= "confirm"; // 游戏说明弹窗的按钮
    public static final String next_level="next level";
    public static final String cancel="cancel";

    // 常量数据
    public static final int imagePixel = 25; // 素材图片的宽高
    public static final int tankPixel = 47; // 坦克图片的宽高
    public static final int bulletPixel=25;

    //敌方坦克初始集合
    public static ArrayList<EnemyTank> enemyOriginalTankList=new ArrayList<EnemyTank>();
    public static ArrayList<BossTank> bossOriginalList=new ArrayList<BossTank>();

    // 静态数据
    public static Boolean on_off = true; // PC按键开关
    public static Boolean window_pause = false; // 弹窗暂停
    public static Boolean game_over = false; // 游戏失败
    public static Boolean game_is_running = true; // 游戏运行状态
    public static Boolean showGameHelp = false; // 游戏是否进入帮助暂停
    public static Boolean completed_current_level = false; // 当前关卡通关标记
    public static Boolean game_clearance = false; // 通关标记
    public static Boolean playerSpeedIsBoosted=false;

    //玩家子弹的伤害
    public static final int bullet_normal_demage=1;
    public static final int bullet_boost_damage=2;
    public static final int bullet_super_demage=3;
    public static final int bullet_ultra_demage=5;
    //攻击模式
    public static int attack_mode=0;

    //
    public static final int playerEnergy=10;
    //
    public static final int attcack_mode1_reduce_energy=2;
    public static final int attcack_mode2_reduce_energy=4;
    public static final int attcack_mode3_reduce_energy=6;




    //障碍物类型
    public static final int ground=0;
    public static final int brick = 1; // 砖块
    public static final int iron = 2; // 铁
    public static final int grass = 3; // 草
    public static final int  water = 4; // 水
    //基地
    public static final int base1=91;
    public  static final int base2=92;
    public static final int base3=93;
    public static final int base4=94;
    //障碍物减速
    public static final int grass_reduce_speed=-2;
    public static final int water_reduce_speed=2;

    public static int bulletSpeed = 35; // 子弹飞行速度
    public static int playerMoveSpeed = 6; // 玩家移动速度
    public static int playerSpeedBoost=5;//加速键的提速
    public static int playerMoveSpeedType2=4;
    public static int playerMoveSpeedType3=6;
    public static int player_direction_Temp = 0; // 存放玩家子弹方向的临时变量
    public static int enemy_bullet_direction_Temp = 0; // 存放敌人子弹方向的临时变量
    public static int level = 1; // 默认第一关开始
    public static int enemyTankNum = 20; // 敌方坦克总数
    public static int whiteTankNum; // 本关白色坦克数
    public static int greenTankNum; // 本关绿色坦克数
    public static int pinkTankNum; // 本关粉色坦克数
    public static int whiteTankHp=1;//坦克的hp
    public static int greenTankHp=2;
    public static int pinkTankHp=3;
    public static final int whiteTankLife=1;//坦克的生命值
    public static final int greenTankLife=2;
    public static final int pinkTankLife=2;
    public static int whiteTankAtk=1;//敌方坦克的攻击力
    public static int greenTankAtk=2;
    public static int pinkTankAtk=2;
    public static int whiteTankSpeed=4;//敌方坦克的移动速度
    public static int greenTankSpeed=4;
    public static int pinkTankSpeed=3;
    public static final int whiteTankPoint=1;//击毁坦克获得的点数
    public static final int greenTankPoint=2;
    public static final int pinkTankPoint=3;
    public static int notExistWhiteTankNum; // 本关白色坦克未出现数
    public static int notExistGreenTankNum; // 本关绿色坦克未出现数
    public static int notExistPinkTankNum; // 本关粉色坦克未出现数
    public static int bossTankNum;//本关卡boss坦克数量
    public static String playerName; // 玩家昵称
    public static int countLife = 3; // 玩家生命面板显示
    public static int firstLevelHit = 0; // 第一关击毁坦克数
    public static int firstLevelScore = 0; // 第一关得分
    public static int secondLevelHit = 0; // 第二关击毁坦克数
    public static int secondLevelScore = 0; // 第二关得分
    public static int thirdLevelHit = 0; // 第三关击毁坦克数
    public static int thirdLevelScore = 0; // 第三关得分
    public static int totalHit; // 共击毁坦克数
    public static int totalScore; // 总得分

    public static void initEnemyOriginalTankList(){
        for(int i=0;i<10;i++){
            enemyOriginalTankList.add(tankGenerator());
        }
    }

    public static EnemyTank tankGenerator(){
        Random random=new Random();
        EnemyTank enemyTank=null;
        int x_axis=0;//坦克在游戏界面的最顶端生成，这里随机生成出现的横坐标
        int position= random.nextInt(4);
        if(position==0){
            x_axis=0;
        }else if(position==1){
            x_axis=GamePanel_W/2;

        }else if(position==2){
            x_axis=GamePanel_W-tankPixel;
        }else if(position==3){
            x_axis=GamePanel_W/4-tankPixel;
        }
        //按2:1:1的比例生成三种普通坦克
        int flag=random.nextInt(8)+1;
        if(flag>0&&flag<=4){
            enemyTank=new GreenEnemyTank(x_axis,0,1);
            greenTankNum+=1;
            notExistGreenTankNum+=1;
        }else if(flag>4&&flag<=6){
            enemyTank=new WhiteEnemyTank(x_axis,0,1);
            whiteTankNum+=1;
            notExistWhiteTankNum+=1;
        }else if(flag>6&&flag<=8){
            enemyTank=new PinkEnemyTank(x_axis,0,1);
            pinkTankNum +=1;
            notExistPinkTankNum+=1;
        }

        return enemyTank;
    }

    public static  Tank bossTankGenerator(){
        return null;
    }

    // 遍历法卡地图
    public static void changeLevel(int level) {
        for (int i = 0; i < Map.gameMap.length; i++) {
            for (int j = 0; j < Map.gameMap[i].length; j++) {
                if (level == 1) {
                    Map.gameMap[i][j] = Map.firstLevel[i][j];
                } else if (level == 2) {
                    Map.gameMap[i][j] = Map.secondLevel[i][j];
                } else if (level == 3) {
                    Map.gameMap[i][j] = Map.thirdLevel[i][j];
                }
            }
        }
    }
    //改变玩家的攻击模式
    public static void changeAttackMode(){
        if(Util.totalScore>=18&&Util.totalScore<29){
            Util.attack_mode=2;
        }else if(Util.totalScore>=29){
            Util.attack_mode=3;
        }else {
            Util.attack_mode=1;
        }
    }

    //获取玩家当前能变化的攻击模式
    public static int getAttackMode(){
        if(Util.totalScore>=18&&Util.totalScore<29){
           return 2;
        }else if(Util.totalScore>=29){
            return 3;
        }else {
            return 1;
        }
    }
    //初始化玩家攻击模式
    public static void initAttackMode(){
        Util.attack_mode=0;
    }


    //初始化
    public static void initializeUtil(){
        on_off = true; // PC按键开关
        window_pause = false; // 弹窗暂停
        game_over = false; // 游戏失败
        game_is_running = true; //游戏运行状态
        completed_current_level = false; // 当前关卡通关标记
        game_clearance = false; // 通关标记
        showGameHelp = false; // 游戏说明图片
        player_direction_Temp = 0; // 存放玩家子弹方向的临时变量
        enemy_bullet_direction_Temp = 0;
        level = 1; // 默认第一关开始
        attack_mode=0;  //攻击模式
        whiteTankNum=0;//当前坦克数
        greenTankNum=0;
        pinkTankNum =0;
        notExistWhiteTankNum=0; // 本关白色坦克未出现数
        notExistGreenTankNum=0; // 本关绿色坦克未出现数
        notExistPinkTankNum=0; // 本关粉色坦克未出现数
        bossTankNum=0;//本关卡boss坦克数量
        playerName=null; // 玩家昵称
        countLife = 3; // 玩家生命面板显示
        firstLevelHit = 0; // 第一关击毁坦克数
        firstLevelScore = 0; // 第一关得分
        secondLevelHit = 0; // 第二关击毁坦克数
        secondLevelScore = 0; // 第二关得分
        thirdLevelHit = 0; // 第三关击毁坦克数
        thirdLevelScore = 0; // 第三关得分
        totalHit=0; // 共击毁坦克数
        totalScore=0; // 总得分
        //初始化坦克集合
        Util.initEnemyOriginalTankList();
        //初始化攻击模式
        Util.initAttackMode();
        //初始化地图
        changeLevel(1);
    }
}
