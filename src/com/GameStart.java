package com;

import com.util.Util;
import com.view.GameHallFrame;

public class GameStart {
    public static void main(String[] args) {
        Util.initEnemyOriginalTankList();
        GameHallFrame gameHallFrame=new GameHallFrame();
        gameHallFrame.setVisible(true);

    }
}
