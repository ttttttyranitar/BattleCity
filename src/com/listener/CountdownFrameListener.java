package com.listener;

import com.view.GameHallFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CountdownFrameListener extends WindowAdapter implements WindowListener {
    private GameHallFrame gameHallFrame;
    public CountdownFrameListener(GameHallFrame gameHallFrame){
        super();
        this.gameHallFrame=gameHallFrame;
    }

    @Override
    public void windowClosed(WindowEvent e) {
        gameHallFrame.getCountdownFrame().setVisible(false);
    }
}
